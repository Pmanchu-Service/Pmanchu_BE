package org.example.pmanchu.domain.user.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.user.client.GithubAccessTokenClient;
import org.example.pmanchu.domain.user.client.GithubUserInfoClient;
import org.example.pmanchu.domain.user.domain.User;
import org.example.pmanchu.domain.user.dto.request.GithubAccessTokenRequest;
import org.example.pmanchu.domain.user.dto.request.UserLoginRequest;
import org.example.pmanchu.domain.user.dto.response.GithubOauthResponse;
import org.example.pmanchu.domain.user.exception.InvalidCodeException;
import org.example.pmanchu.domain.user.repository.UserRepository;
import org.example.pmanchu.global.security.jwt.JwtProvider;
import org.example.pmanchu.global.security.jwt.dto.TokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class UserGithubSignupService {
    private final GithubAccessTokenClient githubClient;
    private final GithubUserInfoClient githubGetUser;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Value("${spring.security.oauth2.client.registration.github.client-id}")
    private String clientId;
    @Value("${spring.security.oauth2.client.registration.github.client-secret}")
    private String clientSecret;

    @Transactional
    public TokenResponse login(UserLoginRequest loginRequest) {

        try{
            GithubAccessTokenRequest codeRequest = new GithubAccessTokenRequest(clientId, clientSecret, loginRequest.getCode());
            String codeResponse = githubClient.signup(codeRequest);
            GithubOauthResponse userInfo = githubGetUser.getUser("Bearer " + changeShape(codeResponse).accessToken);
            if (!userRepository.existsByGithubId(userInfo.getId())) {
                User user = User.builder()
                        .githubId(userInfo.getId())
                        .githubUsername(userInfo.getLogin())
                        .email(userInfo.getEmail())
                        .build();

                userRepository.save(user);
            }
            User user = userRepository.findByGithubId(userInfo.getId());
            return jwtProvider.generateToken(user.getUserId().toString());

        }catch (Exception e){
            throw InvalidCodeException.EXCEPTION;
        }
    }

    GitResponse changeShape(String codeResponse){
        String[] pairs = codeResponse.split("&");
        String[] code = Arrays.stream(pairs).map(p->(p.split("=",2))[1]).toArray(String[]::new);
        return new GitResponse(code[0],Integer.parseInt(code[1]),code[2],Integer.parseInt(code[3]),code[5]);
    }

    @AllArgsConstructor
    public class GitResponse{
        private String accessToken;
        private int expiresIn;
        private String refreshToken;
        private int refreshTokenExpiresIn;
        private String tokenType;
    }

}

package org.example.pmanchu.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.auth.domain.RefreshToken;
import org.example.pmanchu.domain.auth.repository.RefreshTokenRepository;
import org.example.pmanchu.domain.user.domain.User;
import org.example.pmanchu.domain.user.repository.UserRepository;
import org.example.pmanchu.global.security.exception.InvalidTokenException;
import org.example.pmanchu.global.security.jwt.JwtProperties;
import org.example.pmanchu.global.security.jwt.JwtProvider;
import org.example.pmanchu.global.security.jwt.dto.TokenResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserReissueService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final JwtProperties jwtProperty;

    public TokenResponse reissue(String token) {
        boolean isTokenInvalid = !jwtTokenProvider.validToken(token);
        if(isTokenInvalid){
            throw InvalidTokenException.EXCEPTION;
        }
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token).orElseThrow(()->new RuntimeException("존재하지 않는 토큰"));
        User user = userRepository.findById((long) Integer.parseInt(refreshToken.getId())).orElseThrow();
        return jwtTokenProvider.generateToken(user.getUserId().toString());
    }
}

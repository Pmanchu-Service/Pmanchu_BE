package org.example.pmanchu.domain.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.user.dto.request.UserAddInfoRequest;
import org.example.pmanchu.domain.user.dto.request.UserLoginRequest;
import org.example.pmanchu.domain.user.service.UserAddInfoService;
import org.example.pmanchu.domain.user.service.UserGithubSignupService;
import org.example.pmanchu.domain.user.service.UserReissueService;
import org.example.pmanchu.global.security.jwt.dto.TokenResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserGithubSignupService userGithubSignupService;
    private final UserAddInfoService userAddInfoService;
    private final UserReissueService userReissueService;

    @PostMapping("/login")
    public TokenResponse signup(@RequestBody UserLoginRequest request) {
        return userGithubSignupService.login(request);

    }

    @Operation(summary = "토큰 재발급 api", description = "refresh-token을 헤더 key, refreshtoken(Bearer를 붙이지 않은)을 value로 해서 보내면 됩니다")
    @PostMapping("/reissue")
    public TokenResponse reissue(@RequestHeader(name = "refresh-token") String token) {
        return userReissueService.reissue(token);
    }

    @PostMapping("/update")
    public void update(@RequestBody UserAddInfoRequest request) {
        userAddInfoService.addUserInfo(request);
    }
}

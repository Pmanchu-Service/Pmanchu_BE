package org.example.pmanchu.domain.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.user.dto.request.UserAddInfoRequest;
import org.example.pmanchu.domain.user.dto.request.UserLoginRequest;
import org.example.pmanchu.domain.user.service.UserAddInfoService;
import org.example.pmanchu.domain.user.service.UserDeleteService;
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
    private final UserDeleteService userDeleteService;

    @Operation(summary = "github oauth 로그인", description = "로그인 회원가입 상관없이 jwt token 발급, github에서 받은 코드 바디에 보내기")
    @PostMapping("/login")
    public TokenResponse signup(@RequestBody UserLoginRequest request) {
        return userGithubSignupService.login(request);

    }

    @Operation(summary = "토큰 재발급 api", description = "refresh-token을 헤더의 key로, refreshtoken(Bearer를 붙이지 않은)을 헤더의 value로 해서 보내면 됩니다")
    @PostMapping("/reissue")
    public TokenResponse reissue(@RequestHeader(name = "refresh-token") String token) {
        return userReissueService.reissue(token);
    }

    @Operation(summary = "회원 탈퇴", description = "그냥 token을 담아서 delete에 요청을 보내시면 회원이 삭제됩니다")
    @DeleteMapping("/delete")
    public void delete() {
        userDeleteService.delete();
    }

    @Operation(summary = "회원가입 유저 정보 추가", description = "")
    @PostMapping("/update")
    public void update(@RequestBody UserAddInfoRequest request) {
        userAddInfoService.addUserInfo(request);
    }
}

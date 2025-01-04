package org.example.pmanchu.global.security.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenResponse {

    private final String accessToken;

    private final String refreshToken;
}

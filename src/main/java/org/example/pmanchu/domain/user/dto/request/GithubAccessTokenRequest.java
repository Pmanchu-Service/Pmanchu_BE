package org.example.pmanchu.domain.user.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GithubAccessTokenRequest {
    private String client_id;
    private String client_secret;
    private String code;
}

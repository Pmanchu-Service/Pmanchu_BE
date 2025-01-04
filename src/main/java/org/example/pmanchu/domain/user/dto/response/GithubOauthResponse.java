package org.example.pmanchu.domain.user.dto.response;

import lombok.Getter;

@Getter
public class GithubOauthResponse {
    private String login;
    private Long id;
    private String email;
}

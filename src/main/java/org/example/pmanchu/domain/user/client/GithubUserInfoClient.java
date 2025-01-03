package org.example.pmanchu.domain.user.client;

import org.example.pmanchu.domain.user.dto.response.GithubOauthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "git-user-info-client", url = "https://api.github.com/")
public interface GithubUserInfoClient {

    @GetMapping("user")
    GithubOauthResponse getUser(@RequestHeader(name = "Authorization") String token);
}

package org.example.pmanchu.domain.user.client;

import org.example.pmanchu.domain.user.dto.request.GithubAccessTokenRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "git-access-token-client", url = "https://github.com")
public interface GithubAccessTokenClient {
    @PostMapping("login/oauth/access_token")
    String signup(@RequestBody GithubAccessTokenRequest response);

}

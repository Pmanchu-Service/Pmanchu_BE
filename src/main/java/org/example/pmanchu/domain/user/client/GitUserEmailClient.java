package org.example.pmanchu.domain.user.client;

import org.example.pmanchu.domain.user.dto.response.GithubEmailResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "git-user-email-client", url = "https://api.github.com")
public interface GitUserEmailClient {

    @GetMapping("/user/emails")
    List<GithubEmailResponse> getUserEmails(@RequestHeader(name = "Authorization") String token);
}

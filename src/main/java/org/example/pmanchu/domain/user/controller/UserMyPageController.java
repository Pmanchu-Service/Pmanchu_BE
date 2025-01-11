package org.example.pmanchu.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.user.dto.response.QueryMyPageResponse;
import org.example.pmanchu.domain.user.dto.response.QueryUserMajorFilterService;
import org.example.pmanchu.domain.user.dto.response.QueryUserResponse;
import org.example.pmanchu.domain.user.service.QueryMyPageService;
import org.example.pmanchu.domain.user.service.QueryUserService;
import org.example.pmanchu.domain.userMajor.domain.Specialization;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserMyPageController {
    private final QueryMyPageService queryMyPageService;
    private final QueryUserService queryUserService;
    private final QueryUserMajorFilterService queryUserMajorFilterService;

    @GetMapping("/{user-account-id}")
    QueryMyPageResponse queryMyPageService(@PathVariable("user-account-id") Long userAccountId) {
        return queryMyPageService.queryMyPage(userAccountId);
    }

    @GetMapping("/users")
    List<QueryUserResponse> queryMyPageService() {
        return queryUserService.queryUsers();
    }

    @GetMapping("/users/filter")
    List<QueryUserResponse> queryMyPageServiceFilter(@RequestParam List<Specialization> majors) {
        System.out.println(majors);
        return queryUserMajorFilterService.queryUserMajorFilter(majors);
    }
}

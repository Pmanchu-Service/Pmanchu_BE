package org.example.pmanchu.domain.user.dto.response;

import lombok.Getter;
import org.example.pmanchu.domain.user.domain.User;

@Getter
public class QueryUserResponse {
    private String username;
    private String shortIntroduction;
    private Long userId;

    public QueryUserResponse(User user) {
        this.username = user.getUsername();
        this.shortIntroduction = user.getShortIntroduction();
        this.userId = user.getUserId();
    }
}

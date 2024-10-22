package org.example.pmanchu.domain.refreshToken.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RefreshToken {
    @Id
    private final String id;

    private String token;

    private long ttl;

}

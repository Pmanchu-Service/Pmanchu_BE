package org.example.pmanchu.domain.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_user")
@Getter
@NoArgsConstructor
public class User {
    @Id
    private Long userId;

    @Column(nullable = false)
    private String email;

    @Column(unique = true, nullable = true, name = "github_id")
    private Long githubId;

    @Column(unique = true, nullable = true, name = "github_username")
    private String githubUsername;

    @Column(nullable = false)
    private String introductoin;
}

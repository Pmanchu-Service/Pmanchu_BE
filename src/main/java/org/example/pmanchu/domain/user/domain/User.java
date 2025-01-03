package org.example.pmanchu.domain.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_user")
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column( nullable = true)
    private String email;

    @Column( name = "github_id")
    private Long githubId;

    @Column( name = "github_username")
    private String githubUsername;

    @Column( nullable = true)
    private String introduction;


    @Column( nullable = true)
    private String shortIntroduction;

    @Builder
    public User(String githubUsername, Long githubId,String email) {
        this.githubUsername = githubUsername;
        this.githubId = githubId;
        this.email = email;
    }

    public void addInfo(String introduction, String shortIntroduction) {
        this.introduction = introduction;
        this.shortIntroduction = shortIntroduction;
    }

}

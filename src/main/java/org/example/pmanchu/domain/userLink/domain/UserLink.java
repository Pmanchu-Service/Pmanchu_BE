package org.example.pmanchu.domain.userLink.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.pmanchu.domain.user.domain.User;

@Entity
@Table(name = "tbl_user_link")
@Getter
@NoArgsConstructor
public class UserLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId",  nullable = false)
    private User userId;

    @Column(nullable = false)
    private String url;

}

package org.example.pmanchu.domain.userstack.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.pmanchu.domain.user.domain.User;

@Entity
@Table(name = "tbl_user_stack")
@NoArgsConstructor
public class UserStack {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",  nullable = false)
    private User userId;

    @Column(nullable = false)
    private String stack;

    public UserStack(User user, String s) {
        this.userId = user;
        this.stack = s;
    }
}

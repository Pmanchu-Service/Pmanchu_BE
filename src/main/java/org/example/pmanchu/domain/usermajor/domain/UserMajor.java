package org.example.pmanchu.domain.usermajor.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.pmanchu.domain.user.domain.User;

@Entity
@Table(name = "user_major")
@Getter
@NoArgsConstructor
public class UserMajor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userMajorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId",  nullable = false)
    private User userId;

    private String specialization;
}

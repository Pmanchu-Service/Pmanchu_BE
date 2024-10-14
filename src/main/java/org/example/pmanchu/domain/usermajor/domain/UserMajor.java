package org.example.pmanchu.domain.usermajor.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.example.pmanchu.domain.user.domain.User;

@Entity
@Table(name = "user_major")
@NoArgsConstructor
public class UserMajor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userMajorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",  nullable = false)
    private User userId;

    @Column(nullable = false)
    private Specialization specialization;
}

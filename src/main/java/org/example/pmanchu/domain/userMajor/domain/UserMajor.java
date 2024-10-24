package org.example.pmanchu.domain.userMajor.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.example.pmanchu.domain.user.domain.User;

@Entity
@Table(name = "tbl_user_major")
@NoArgsConstructor
public class UserMajor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userMajorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",  nullable = false)
    private User userId;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;
}

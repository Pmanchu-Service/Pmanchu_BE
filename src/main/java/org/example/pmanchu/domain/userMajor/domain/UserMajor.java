package org.example.pmanchu.domain.userMajor.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.pmanchu.domain.user.domain.User;

@Entity
@Table(name = "tbl_user_major")
@Getter
@NoArgsConstructor
public class UserMajor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userMajorId;

    @ManyToOne
    @JoinColumn(name = "user_id",  nullable = false)
    private User userId;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    public UserMajor(User userId, Specialization s) {
        this.userId = userId;
        this.specialization = s;
    }
}

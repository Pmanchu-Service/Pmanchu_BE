package org.example.pmanchu.domain.projectMember.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.pmanchu.domain.project.domain.Project;
import org.example.pmanchu.domain.user.domain.User;

@Entity
@Table(name = "project_member")
@Getter
@NoArgsConstructor
public class ProjectMember {
    @Id
    @Column(insertable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectMemberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id",  nullable = false)
    private Project projectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId",  nullable = false)
    private User userId;

    @Column(nullable = false)
    private String role;
}

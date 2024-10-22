package org.example.pmanchu.domain.plan.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.pmanchu.domain.project.domain.Project;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Getter
@Table(name = "tbl_plan")
@NoArgsConstructor
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectId",  nullable = false)
    private Project projectId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
}

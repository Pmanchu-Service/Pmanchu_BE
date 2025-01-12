package org.example.pmanchu.domain.project.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_project")
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @NonNull
    @Column(nullable = false)
    private String title;

    @NonNull
    @Column(nullable = false)
    private String description;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Status status;
}

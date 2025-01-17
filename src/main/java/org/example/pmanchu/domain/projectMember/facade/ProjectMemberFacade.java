package org.example.pmanchu.domain.projectMember.facade;

import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.project.domain.Project;
import org.example.pmanchu.domain.projectMember.domain.ProjectMember;
import org.example.pmanchu.domain.projectMember.domain.ProjectMemberRole;
import org.example.pmanchu.domain.projectMember.repository.ProjectMemberRepository;
import org.example.pmanchu.domain.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class ProjectMemberFacade {

    private final ProjectMemberRepository projectMemberRepository;

    public Optional<ProjectMemberRole> getUserRoleInProject(User user, Project project) {
        return projectMemberRepository.findByProjectAndUser(project, user)
                .map(pm -> pm.getRole());
    }
}

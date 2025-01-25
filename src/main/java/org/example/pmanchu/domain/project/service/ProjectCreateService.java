package org.example.pmanchu.domain.project.service;

import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.project.domain.Project;
import org.example.pmanchu.domain.project.domain.Status;
import org.example.pmanchu.domain.project.dto.request.ProjectCreateRequest;
import org.example.pmanchu.domain.project.repository.ProjectRepository;
import org.example.pmanchu.domain.projectMember.domain.ProjectMember;
import org.example.pmanchu.domain.projectMember.domain.ProjectMemberRole;
import org.example.pmanchu.domain.projectMember.repository.ProjectMemberRepository;
import org.example.pmanchu.domain.user.domain.User;
import org.example.pmanchu.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectCreateService {
    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectRepository projectRepository;
    private final UserFacade userFacade;

    public Project execute(ProjectCreateRequest projectCreateRequest) {
        Project project = new Project(
                projectCreateRequest.getTitle(),
                projectCreateRequest.getDescription(),
                Status.NOT_STARTED
        );
        project = projectRepository.save(project);

        User currentUser = userFacade.getCurrentUser();

        ProjectMember projectMember = new ProjectMember();
        projectMember.setProjectId(project);
        projectMember.setUserId(currentUser);
        projectMember.setRole(ProjectMemberRole.LEADER);

        projectMemberRepository.save(projectMember);

        return project;
    }
}

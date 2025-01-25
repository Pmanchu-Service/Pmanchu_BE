package org.example.pmanchu.domain.project.service;

import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.project.domain.Project;
import org.example.pmanchu.domain.project.exception.NoPermissionException;
import org.example.pmanchu.domain.project.exception.ProjectNotFoundException;
import org.example.pmanchu.domain.project.exception.UserNotFoundException;
import org.example.pmanchu.domain.project.repository.ProjectRepository;
import org.example.pmanchu.domain.projectMember.domain.ProjectMember;
import org.example.pmanchu.domain.projectMember.domain.ProjectMemberRole;
import org.example.pmanchu.domain.projectMember.facade.ProjectMemberFacade;
import org.example.pmanchu.domain.projectMember.repository.ProjectMemberRepository;
import org.example.pmanchu.domain.user.domain.User;
import org.example.pmanchu.domain.user.exception.InvalidCodeException;
import org.example.pmanchu.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProjectDeleteService {

    private final ProjectRepository projectRepository;
    private final ProjectMemberFacade projectMemberFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long projectId) {
        var currentUser = userFacade.getCurrentUser();
        var project = projectRepository.findById(projectId)
                .orElseThrow(() -> ProjectNotFoundException.EXCEPTION);

        var role = projectMemberFacade.getUserRoleInProject(currentUser, project)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (role != ProjectMemberRole.LEADER) {
            throw NoPermissionException.EXCEPTION;
        }

        projectRepository.delete(project);
    }
}
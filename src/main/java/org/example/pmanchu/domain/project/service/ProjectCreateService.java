package org.example.pmanchu.domain.project.service;

import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.project.domain.Project;
import org.example.pmanchu.domain.project.domain.Status;
import org.example.pmanchu.domain.project.dto.request.ProjectCreateRequest;
import org.example.pmanchu.domain.project.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectCreateService {
    private final ProjectRepository projectRepository;

    public Project createProject(ProjectCreateRequest projectCreateRequest) {
        Project project = new Project(
                projectCreateRequest.getTitle(),
                projectCreateRequest.getDescription(),
                Status.NOT_STARTED
        );
        return projectRepository.save(project);
    }
}

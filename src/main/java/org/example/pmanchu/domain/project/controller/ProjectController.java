package org.example.pmanchu.domain.project.controller;

import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.project.domain.Project;
import org.example.pmanchu.domain.project.dto.request.ProjectCreateRequest;
import org.example.pmanchu.domain.project.service.ProjectCreateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectCreateService projectCreateService;

    @PostMapping("/generate")
    public Project ProjectCreate(@RequestBody ProjectCreateRequest projectCreateRequest) {
        return projectCreateService.execute(projectCreateRequest);
    }
}

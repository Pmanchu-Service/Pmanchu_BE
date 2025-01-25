package org.example.pmanchu.domain.project.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.project.domain.Project;
import org.example.pmanchu.domain.project.dto.request.ProjectCreateRequest;
import org.example.pmanchu.domain.project.dto.request.ProjectDeleteRequest;
import org.example.pmanchu.domain.project.service.ProjectCreateService;
import org.example.pmanchu.domain.project.service.ProjectDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectCreateService projectCreateService;
    private final ProjectDeleteService projectDeleteService;

    @Operation(summary = "프로젝트 생성", description = "프로젝트가 생성됩니다")
    @PostMapping("/generate")
    public Project ProjectCreate(@RequestBody ProjectCreateRequest projectCreateRequest) {
        return projectCreateService.execute(projectCreateRequest);
    }

    @Operation(summary = "프로젝트 삭제", description = "프로젝트가 삭제됩니다. 삭제는 LEADER만 가능합니다. 정상 삭제시 Response는 없습니다.")
    @DeleteMapping("/delete")
    public void deleteProject(@RequestBody ProjectDeleteRequest request) {
        projectDeleteService.execute(request.getProjectId());
    }

}

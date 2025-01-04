package org.example.pmanchu.domain.project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pmanchu.domain.project.domain.Status;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectCreateRequest {
    private String title;
    private String description;
    private Status status;
}

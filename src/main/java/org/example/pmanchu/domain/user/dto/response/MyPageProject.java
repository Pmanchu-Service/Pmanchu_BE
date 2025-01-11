package org.example.pmanchu.domain.user.dto.response;

import lombok.Getter;
import org.example.pmanchu.domain.project.domain.Project;
@Getter
public class MyPageProject{
    public MyPageProject(Project project){
        this.projectIntroduction = project.getDescription();
        this.projectName = project.getTitle();
    }
    String projectName;
    String projectIntroduction;
}

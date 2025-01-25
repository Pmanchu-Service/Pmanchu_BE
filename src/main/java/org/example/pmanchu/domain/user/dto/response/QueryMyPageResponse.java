package org.example.pmanchu.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.pmanchu.domain.project.domain.Project;
import org.example.pmanchu.domain.userLink.domain.UserLink;
import org.example.pmanchu.domain.userMajor.domain.Specialization;
import org.example.pmanchu.domain.userMajor.domain.UserMajor;
import org.example.pmanchu.domain.userstack.domain.UserStack;

import java.util.List;
@Getter
@Setter
public class QueryMyPageResponse {

    private String name;
    private List<Specialization> specializations;
    private List<String> stacks;
    private List<String> links;
    private String introduction;
    private List<MyPageProject> inProgressProjects;
    private List<MyPageProject> doneProjects;
    private List<MyPageProject> appliedProjects;
    private Long year;
    private boolean isMyPage;

    @Builder
    public QueryMyPageResponse(String name, List<UserMajor> specializations, List<UserStack> stacks, List<UserLink> links, String introduction, List<Project> inProgressProjects, List<Project> doneProjects, List<Project> appliedProjects, boolean isMyPage, Long year) {
        this.name = name;
        this.specializations = specializations.stream().map(UserMajor::getSpecialization).toList();
        this.stacks = stacks.stream().map(UserStack::getStack).toList();
        this.links = links.stream().map(UserLink::getUrl).toList();
        this.introduction = introduction;
        this.inProgressProjects = inProgressProjects.stream().map(MyPageProject::new).toList();
        this.doneProjects = doneProjects.stream().map(MyPageProject::new).toList();;
        this.appliedProjects = appliedProjects.stream().map(MyPageProject::new).toList();
        this.isMyPage = isMyPage;
        this.year = year;
    }
}

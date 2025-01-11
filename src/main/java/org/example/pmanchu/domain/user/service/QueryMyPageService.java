package org.example.pmanchu.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.pmanchu.domain.project.domain.Project;
import org.example.pmanchu.domain.project.domain.Status;
import org.example.pmanchu.domain.projectMember.domain.ProjectMember;
import org.example.pmanchu.domain.projectMember.repository.ProjectMemberRepository;
import org.example.pmanchu.domain.user.domain.User;
import org.example.pmanchu.domain.user.dto.response.QueryMyPageResponse;
import org.example.pmanchu.domain.user.facade.UserFacade;
import org.example.pmanchu.domain.userLink.domain.UserLink;
import org.example.pmanchu.domain.userLink.repository.UserLinkRepository;
import org.example.pmanchu.domain.userMajor.domain.UserMajor;
import org.example.pmanchu.domain.userMajor.repository.UserMajorRepository;
import org.example.pmanchu.domain.userstack.domain.UserStack;
import org.example.pmanchu.domain.userstack.repository.UserStackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class QueryMyPageService {
    private final ProjectMemberRepository projectMemberRepository;
    private final UserFacade userFacade;
    private final UserStackRepository userStackRepository;
    private final UserMajorRepository userMajorRepository;
    private final UserLinkRepository userLinkRepository;


    public QueryMyPageResponse queryMyPage(Long userId){
        User user = userFacade.getUserById(userId);
        List<ProjectMember> projectMembers = projectMemberRepository.findProjectMembersByUserId(user);
        List<Project> inProgressProjects = projectMembers.stream().map(ProjectMember::getProjectId).filter(p->p.getStatus()!= Status.FINISHED).toList();
        List<Project> doneProjects = projectMembers.stream().map(ProjectMember::getProjectId).filter(p->p.getStatus()== Status.FINISHED).toList();
        List<UserStack> userStacks = userStackRepository.findAllByUserId(user);
        List<UserMajor> userMajors = userMajorRepository.findAllByUserId(user);
        List<UserLink> userLinks = userLinkRepository.findAllByUserId(user);

        return QueryMyPageResponse.builder()
                .name(user.getUsername())
                .doneProjects(doneProjects)
                .inProgressProjects(inProgressProjects)
                .links(userLinks)
                .introduction(user.getIntroduction())
                .stacks(userStacks)
                .specializations(userMajors)
                .isMyPage(Objects.equals(user.getUserId(), userFacade.getCurrentUser().getUserId()))
                .year(user.getYear())
                .build();
    }

}

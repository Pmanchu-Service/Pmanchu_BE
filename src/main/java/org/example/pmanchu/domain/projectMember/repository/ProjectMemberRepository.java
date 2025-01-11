package org.example.pmanchu.domain.projectMember.repository;

import org.example.pmanchu.domain.projectMember.domain.ProjectMember;
import org.example.pmanchu.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectMemberRepository extends CrudRepository<ProjectMember, Long> {
    List<ProjectMember> findProjectMembersByUserId(User userId);
}

package org.example.pmanchu.domain.projectMember.repository;

import org.example.pmanchu.domain.project.domain.Project;
import org.example.pmanchu.domain.projectMember.domain.ProjectMember;
import org.example.pmanchu.domain.user.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProjectMemberRepository extends CrudRepository<ProjectMember, Long> {
    @Query("SELECT pm FROM ProjectMember pm WHERE pm.projectId = :project AND pm.userId = :user")
    Optional<ProjectMember> findByProjectAndUser(@Param("project") Project project, @Param("user") User user);
}

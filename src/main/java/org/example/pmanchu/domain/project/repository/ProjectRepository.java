package org.example.pmanchu.domain.project.repository;

import org.example.pmanchu.domain.project.domain.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}

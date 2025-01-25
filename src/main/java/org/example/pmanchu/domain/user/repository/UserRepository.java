package org.example.pmanchu.domain.user.repository;

import org.example.pmanchu.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByGithubId(Long githubId);
    User findByGithubId(Long githubId);
    List<User> findAll();
}

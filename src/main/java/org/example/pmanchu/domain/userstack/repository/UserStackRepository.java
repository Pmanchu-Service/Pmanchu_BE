package org.example.pmanchu.domain.userstack.repository;

import org.example.pmanchu.domain.user.domain.User;
import org.example.pmanchu.domain.userstack.domain.UserStack;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserStackRepository extends CrudRepository<UserStack, Long> {
    List<UserStack> findAllByUserId(User userId);
    void deleteByUserId(User userId);
}

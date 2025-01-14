package org.example.pmanchu.domain.userstack.repository;

import org.example.pmanchu.domain.user.domain.User;
import org.example.pmanchu.domain.userstack.domain.UserStack;
import org.springframework.data.repository.CrudRepository;

public interface UserStackRepository extends CrudRepository<UserStack, Long> {
    void deleteByUserId(User userId);
}

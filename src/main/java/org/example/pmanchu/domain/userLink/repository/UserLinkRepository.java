package org.example.pmanchu.domain.userLink.repository;

import org.example.pmanchu.domain.user.domain.User;
import org.example.pmanchu.domain.userLink.domain.UserLink;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserLinkRepository extends CrudRepository<UserLink, Long> {
    List<UserLink> findAllByUserId(User userId);
    void deleteByUserId(User userId);
}

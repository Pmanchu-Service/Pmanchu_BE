package org.example.pmanchu.domain.userLink.repository;

import org.example.pmanchu.domain.userLink.domain.UserLink;
import org.springframework.data.repository.CrudRepository;

public interface UserLikeRepository extends CrudRepository<UserLink, Long> {
}

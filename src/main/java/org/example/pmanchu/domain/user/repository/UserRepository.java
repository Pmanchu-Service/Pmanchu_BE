package org.example.pmanchu.domain.user.repository;

import org.example.pmanchu.domain.notification.domain.Notification;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Notification, Long> {
}

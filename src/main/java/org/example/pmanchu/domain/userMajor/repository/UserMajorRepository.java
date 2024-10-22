package org.example.pmanchu.domain.userMajor.repository;

import org.example.pmanchu.domain.notification.domain.Notification;
import org.springframework.data.repository.CrudRepository;

public interface UserMajorRepository extends CrudRepository<Notification, Long> {
}

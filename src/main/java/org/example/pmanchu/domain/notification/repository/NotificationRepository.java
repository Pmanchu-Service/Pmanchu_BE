package org.example.pmanchu.domain.notification.repository;

import org.example.pmanchu.domain.notification.domain.Notification;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<Notification, Long> {
}

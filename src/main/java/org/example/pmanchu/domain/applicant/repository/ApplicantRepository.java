package org.example.pmanchu.domain.applicant.repository;

import org.example.pmanchu.domain.applicant.domain.Applicant;
import org.example.pmanchu.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicantRepository extends CrudRepository<Applicant, Long> {
    List<Applicant> findAllByUser(User user);
}

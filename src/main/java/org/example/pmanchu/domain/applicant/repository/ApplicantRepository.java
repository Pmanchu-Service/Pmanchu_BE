package org.example.pmanchu.domain.applicant.repository;

import org.example.pmanchu.domain.applicant.domain.Applicant;
import org.springframework.data.repository.CrudRepository;

public interface ApplicantRepository extends CrudRepository<Applicant, Long> {
}

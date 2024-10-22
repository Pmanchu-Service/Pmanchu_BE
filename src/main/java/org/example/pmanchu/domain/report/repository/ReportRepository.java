package org.example.pmanchu.domain.report.repository;

import org.example.pmanchu.domain.report.domain.Report;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends CrudRepository<Report, Long> {
}

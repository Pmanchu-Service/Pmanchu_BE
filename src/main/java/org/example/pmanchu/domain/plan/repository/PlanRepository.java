package org.example.pmanchu.domain.plan.repository;

import org.example.pmanchu.domain.plan.domain.Plan;
import org.springframework.data.repository.CrudRepository;

public interface PlanRepository extends CrudRepository<Plan, Long> {
}

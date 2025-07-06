package com.br.project.myfinance.model.repository;

import com.br.project.myfinance.model.domain.PlanoConta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoContaRepository extends JpaRepository<PlanoConta, Long> {
}

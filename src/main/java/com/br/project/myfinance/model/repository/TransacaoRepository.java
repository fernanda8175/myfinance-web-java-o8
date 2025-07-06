package com.br.project.myfinance.model.repository;

import com.br.project.myfinance.model.domain.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);
}

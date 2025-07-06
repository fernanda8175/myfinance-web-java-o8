package com.br.project.myfinance.model.service;

import com.br.project.myfinance.model.domain.PlanoConta;
import com.br.project.myfinance.model.domain.Transacao;
import com.br.project.myfinance.model.repository.PlanoContaRepository;
import com.br.project.myfinance.model.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private PlanoContaRepository planoContaRepository;

    public List<Transacao> listarTodasTransacoes() {
        return transacaoRepository.findAll();
    }

    public Transacao buscarPorCodigo(Long codigo) {
        if (!transacaoRepository.existsById(codigo)) {
            throw new RuntimeException("Transação não encontrado");
        }
        return transacaoRepository.findById(codigo).get();
    }

    public Transacao salvar(Transacao transacao) {
        PlanoConta plano = planoContaRepository.findById(transacao.getPlanoConta().getCodigo()).orElseThrow();
        transacao.setPlanoConta(plano);
        return transacaoRepository.save(transacao);
    }

    public void deletar(Long codigo) {
        if (!transacaoRepository.existsById(codigo)) {
            throw new RuntimeException("Transação não encontrado para exclusão");
        }

        transacaoRepository.deleteById(codigo);
    }

    public List<Transacao> filtrarPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        List<Transacao> listaFiltro = transacaoRepository.findByDataHoraBetween(inicio, fim);
        if (listaFiltro.isEmpty()) {
            throw new RuntimeException("Não existem transações para o filtro aplicado");
        }
        return listaFiltro;
    }
}

package com.br.project.myfinance.model.service;

import com.br.project.myfinance.model.domain.PlanoConta;
import com.br.project.myfinance.model.repository.PlanoContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class PlanoContaService {

        @Autowired
        private PlanoContaRepository planoContaRepository;

        public List<PlanoConta> listarTodosPlanosContas() {
            return planoContaRepository.findAll();
        }

    public PlanoConta listarPlanoConta(Long codigo) {
        //valida se existe antes de retornar
        if (!planoContaRepository.existsById(codigo)) {
            throw new RuntimeException("Plano Conta não encontrado");
        }
        return planoContaRepository.findById(codigo).get();
    }
    public PlanoConta armazenaPlanoConta(PlanoConta planoConta) {

        return planoContaRepository.save(planoConta);

    }

    public void deletarPlanoConta(Long codigo) {
        //valida se existe antes de excluir
        if (!planoContaRepository.existsById(codigo)) {
            throw new RuntimeException("Plano Conta não encontrado para exclusão");
        }
        planoContaRepository.deleteById(codigo);
    }

    public void atualizarPlanoConta(PlanoConta planoConta) {
        //valida se existe antes de salvar
        if (!planoContaRepository.existsById(planoConta.getCodigo())) {
            throw new RuntimeException("Plano Conta não encontrado para atualização");
        }
        planoContaRepository.save(planoConta);
    }
}

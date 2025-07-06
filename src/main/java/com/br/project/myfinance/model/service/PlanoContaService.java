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

    public Optional<PlanoConta> listarPlanoConta(Long codigo) {
        return planoContaRepository.findById(codigo);
    }
    public PlanoConta armazenaPlanoConta(PlanoConta planoConta) {
        return planoContaRepository.save(planoConta);

    }
}

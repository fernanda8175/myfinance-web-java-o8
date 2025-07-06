package com.br.project.myfinance.controllers;

import com.br.project.myfinance.model.domain.PlanoConta;
import com.br.project.myfinance.model.service.PlanoContaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping("/planosContas")
public class PlanoController {

    @Autowired
    private PlanoContaService planoContaService;
    @GetMapping
    public String listarTodos(Model model)  {
        List<PlanoConta> planosContas = planoContaService.listarTodosPlanosContas();
        model.addAttribute("listaPlanosContas", planosContas);
        return "planoConta"; // Nome da view a ser renderizada (planoConta.html)
    }

    @GetMapping("/{codigo}")
    public String listarTodos(Model model, @PathVariable Long codigo)  {
        var planoConta = planoContaService.listarPlanoConta(codigo);
        model.addAttribute("mensagem", planoConta);
        return "planoConta";
    }

    // GET - exibir formulário
    @GetMapping("/novo")
    public String novoPlanoConta(Model model) {
        model.addAttribute("planoConta", new PlanoConta());
        return "adicionarPlanoConta";
    }
    @PostMapping
    public String salvarPlanoConta(@ModelAttribute PlanoConta planoConta) {
        planoContaService.armazenaPlanoConta(planoConta);
        return "redirect:/planosContas";
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> excluirPlanoConta(@PathVariable Long codigo) {
        planoContaService.deletarPlanoConta(codigo);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

}

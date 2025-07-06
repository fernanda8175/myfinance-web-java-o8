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
public class PlanoContaController {

    @Autowired
    private PlanoContaService planoContaService;
    @GetMapping
    public String listarTodos(Model model)  {
        List<PlanoConta> planosContas = planoContaService.listarTodosPlanosContas();
        model.addAttribute("listaPlanosContas", planosContas);
        return "planoConta"; // Nome da view a ser renderizada (planoConta.html)
    }

    // GET - Exibir formulário de edição preenchido
    @GetMapping("/editar/{codigo}")
    public String exibirFormularioEdicao(@PathVariable Long codigo, Model model) {
        PlanoConta planoConta = planoContaService.listarPlanoConta(codigo);
        model.addAttribute("planoConta", planoConta);
        return "editarPlanoConta"; // nova view
    }

    // POST - Atualizar plano conta
    @PostMapping("/{codigo}")
    public String atualizarPlanoConta(@PathVariable Long codigo, @ModelAttribute PlanoConta planoConta) {
        planoConta.setCodigo(codigo);
        planoContaService.atualizarPlanoConta(planoConta);
        return "redirect:/planosContas";
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

package com.br.project.myfinance.controllers;

import com.br.project.myfinance.model.domain.PlanoConta;
import com.br.project.myfinance.model.domain.Transacao;
import com.br.project.myfinance.model.entity.TipoMovimentacao;
import com.br.project.myfinance.model.service.PlanoContaService;
import com.br.project.myfinance.model.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private PlanoContaService planoContaService;

    @GetMapping
    public String listarTodas(Model model) {
        List<Transacao> transacoes = transacaoService.listarTodasTransacoes();
        model.addAttribute("listaTransacoes", transacoes);
        return "transacao";
    }

    // GET - exibir formulário
    @GetMapping("/novo")
    public String novaTransacao(Model model) {
        model.addAttribute("transacao", new Transacao());
        model.addAttribute("planosContas", planoContaService.listarTodosPlanosContas());
        return "adicionarTransacao";
    }

    @PostMapping
    public String salvarTransacao(@ModelAttribute Transacao transacao) {
        transacaoService.salvar(transacao);
        return "redirect:/transacoes";
    }

    @GetMapping("/editar/{codigo}")
    public String editarTransacao(@PathVariable Long codigo, Model model) {
        Transacao transacao = transacaoService.buscarPorCodigo(codigo);
        List<PlanoConta> planosContas = planoContaService.listarTodosPlanosContas();
        // Formatando LocalDateTime para String no padrão datetime-local
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String dataHoraFormatada = transacao.getDataHora().format(formatter);

        model.addAttribute("transacao", transacao);
        model.addAttribute("planosContas", planosContas);
        model.addAttribute("dataHoraFormatada", dataHoraFormatada);

        return "editarTransacao";
    }

    @PostMapping("/{codigo}")
    public String atualizarTransacao(@PathVariable Long codigo, @ModelAttribute Transacao transacao) {
        transacao.setCodigo(codigo);
        transacaoService.salvar(transacao);
        return "redirect:/transacoes";
    }

    @DeleteMapping("/{codigo}")
    public String deletarTransacao(@PathVariable Long codigo) {
        transacaoService.deletar(codigo);
        return "redirect:/transacoes";
    }


}

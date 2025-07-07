package com.br.project.myfinance.controllers;

import com.br.project.myfinance.model.domain.Transacao;
import com.br.project.myfinance.model.entity.TipoMovimentacao;
import com.br.project.myfinance.model.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    private TransacaoService transacaoService;

    // Exibe a tela do formulário
    @GetMapping
    public String exibirFormulario() {
        return "relatorio"; // nome do arquivo HTML no templates
    }

    // Recebe as datas filtradas no GET
    @GetMapping("/filtrar")
    public String filtrarRelatorio(
            @RequestParam("dataInicio") String dataInicioStr,
            @RequestParam("dataFim") String dataFimStr,
            Model model) {

        // Converter String para LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataInicio = LocalDate.parse(dataInicioStr, formatter);
        LocalDate dataFim = LocalDate.parse(dataFimStr, formatter);

        // Buscar transações no período
        List<Transacao> transacoes = transacaoService.filtrarPorPeriodo(dataInicio.atStartOfDay(), dataFim.atTime(23,59,59));

        // Calcular totais de receita e despesa
        BigDecimal totalReceitas = transacoes.stream()
                .filter(t -> t.getPlanoConta().getTipoMovimentacao() == TipoMovimentacao.Receita)
                .map(Transacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalDespesas = transacoes.stream()
                .filter(t -> t.getPlanoConta().getTipoMovimentacao() == TipoMovimentacao.Despesa)
                .map(Transacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        model.addAttribute("transacoes", transacoes);
        model.addAttribute("totalReceitas", totalReceitas);
        model.addAttribute("totalDespesas", totalDespesas);
        model.addAttribute("dataInicio", dataInicio);
        model.addAttribute("dataFim", dataFim);

        return "relatorioResultado";
    }
}

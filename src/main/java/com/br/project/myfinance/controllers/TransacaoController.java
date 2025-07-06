package com.br.project.myfinance.controllers;

import com.br.project.myfinance.model.entity.TransactionModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransacaoController {

    @GetMapping("/home")
    public String buscaCadastro(Model model) {
        model.addAttribute("mensagem", "Bem-vindo à página inicial!");
        return "home"; // Nome da view a ser renderizada (home.html)
    }

    @GetMapping("/cadastro/{id}")
    public String cadastroEspecifico(TransactionModel model) {
        //busca registro no bd
        //
        //retorna para view

        return "home";
    }


    @PostMapping("/cadastro/{id}")
    public String buscaCadastroEspecifico(TransactionModel model) {

        //criar metodo if(ModelState.IsValid)
        //se for, salva no bd
        //retorna valor salvo

        return "home"; // Nome da view a ser renderizada (home.html)
    }

    @PostMapping("/home")
    public String alteraCadastro(Model model) {
        model.addAttribute("mensagem", "Bem-vindo à página inicial!");
        return "home"; // Nome da view a ser renderizada (home.html)
    }
}

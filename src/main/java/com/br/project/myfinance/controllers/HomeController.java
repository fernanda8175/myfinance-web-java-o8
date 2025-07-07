package com.br.project.myfinance.controllers;

import com.br.project.myfinance.model.domain.PlanoConta;
import com.br.project.myfinance.model.service.PlanoContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String renderizarHome(Model model)  {
        return "home";
    }

}

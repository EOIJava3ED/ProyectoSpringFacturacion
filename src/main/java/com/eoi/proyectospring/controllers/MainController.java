package com.eoi.proyectospring.controllers;

import com.eoi.proyectospring.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The type Customer controller.
 */
@Controller
@Log4j2
@RequiredArgsConstructor
public class MainController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String showHome(Model model) {
        model.addAttribute("pantalla", "homeContents");
        return "home";
    }

    @GetMapping("/clientes")
    public String showClientes(Model model) {
        model.addAttribute("pantalla", "customers");
        model.addAttribute("customers", customerService.findAll());
        return "home";
    }



}

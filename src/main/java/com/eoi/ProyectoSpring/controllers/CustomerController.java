package com.eoi.ProyectoSpring.controllers;

import com.eoi.ProyectoSpring.entities.Customer;
import com.eoi.ProyectoSpring.repositories.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private final CustomerRepository customerRepository;

    @PostMapping("/addcustomer")
    public String addCustomer(@Valid Customer customer, BindingResult result,Model model) {
        if (result.hasErrors()) {
            return "add-customer";
        }
        customerRepository.save(customer);
        return "redirect:/customer/index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Customer customer) {
        return "add-customer";
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "index";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id,Model  model) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));

        model.addAttribute("customer", customer);
        return "update-customer";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable("id") Integer id, @Valid Customer customer,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            customer.setId(id);
            return "update-customer";
        }

        customerRepository.save(customer);
        return "redirect:/customer/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id, Model model) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        customerRepository.delete(customer);
        return "redirect:/customer/index";
    }


}

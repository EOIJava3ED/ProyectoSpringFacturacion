package com.eoi.proyectospring.api;

import com.eoi.proyectospring.entities.Customer;
import com.eoi.proyectospring.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * The type Customer controller.
 */
@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerAPIController {

    @Autowired
    private CustomerService customerService;

    /**
     * Add customer string.
     *
     * @param customer the customer
     * @param result   the result
     * @param model    the model
     * @return the string
     */
    @PostMapping("/add")
    public Customer addCustomer(@Valid Customer customer, Model model) {
        return customerService.add(customer);
    }

    /**
     * Update customer string.
     *
     * @param id       the id
     * @param customer the customer
     * @param result   the result
     * @param model    the model
     * @return the string
     */
    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable("id") Integer id,
                                 @Valid Customer customer,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            customer.setId(id);
            return "update-customer";
        }
        customerService.save(customer);
        return "redirect:/customer/index";
    }

    /**
     * Delete customer string.
     *
     * @param id    the id
     * @param model the model
     * @return the string
     */
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id, Model model) {
        try {
            Customer customer = (Customer) customerService.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
            customerService.deleteById(id);
            return "redirect:/customer/index";

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }

}

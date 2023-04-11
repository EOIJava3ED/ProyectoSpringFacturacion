package com.eoi.proyectospring.services;

import com.eoi.proyectospring.entities.Customer;
import com.eoi.proyectospring.repositories.CustomerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

/**
 * The type Customer controller.
 */
@Service
@Log4j2
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public ArrayList<Customer> findAll()
    {
        return (ArrayList<Customer>) customerRepository.findAll();
    }

    public Optional findById(Integer id)
    {
        return customerRepository.findById(id);
    }

    public Customer add(Customer customer)
    {
        return customerRepository.save(customer);
    }

    public Customer save(Customer customer)
    {
        return customerRepository.save(customer);
    }

    public void deleteById(Integer id)
    {
        customerRepository.deleteById(id);
    }

}

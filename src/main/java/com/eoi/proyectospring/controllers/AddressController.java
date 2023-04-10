package com.eoi.proyectospring.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Address Controller. El controlador de Address es el encargado de enrutar las peticiones de la entidad Address
 */
@RestController
@Log4j2
@RequestMapping("${url.address}")
public class AddressController {
    /**
     * List string.
     *
     * @return the string
     */
    @GetMapping("/all")
    String list() {
        return null;
    }


}



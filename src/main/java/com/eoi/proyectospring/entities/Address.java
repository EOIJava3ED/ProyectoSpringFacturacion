package com.eoi.proyectospring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Address.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String line1;
    private String line2;
    private String line3;
    private String zipCode;

    /**
     * El cliente al que está conectada esta dirección. En este caso tenemos una relacion N:1 o ManyToOne,
     *  - Varias direcciones pertenecen a un cliente
     *  - Un cliente puede tener varias direcciones
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    Customer customer;

    /**
     * Instantiates a new Address.
     *
     * @param line1   the line 1
     * @param line2   the line 2
     * @param line3   the line 3
     * @param zipCode the zip code
     */
    public Address(String line1, String line2, String line3, String zipCode) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.zipCode = zipCode;
    }
}
package com.eoi.ProyectoSpring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * The type Customer.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer {

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String name;
    private String secondName;
    private String thirdName;
    private LocalDate birthDate;
    private String email;
    private LocalDateTime registrationDateTime;

    /**
     * Instantiates a new Customer.
     *
     * @param name                 the name
     * @param secondName           the second name
     * @param thirdName            the third name
     * @param birthDate            the birth date
     * @param registrationDateTime the registration date time
     */
    public Customer(String name, String secondName, String thirdName, LocalDate birthDate, LocalDateTime registrationDateTime) {
        this.name = name;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.birthDate = birthDate;
        this.registrationDateTime = registrationDateTime;
    }


}

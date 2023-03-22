package com.eoi.ProyectoSpring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String name;
    private String secondName;
    private String thirdName;
    private LocalDate birthDate;
    private String email;
    private LocalDateTime registrationDateTime;

    public Customer(String name, String secondName, String thirdName, LocalDate birthDate, LocalDateTime registrationDateTime) {
        this.name = name;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.birthDate = birthDate;
        this.registrationDateTime = registrationDateTime;
    }


}

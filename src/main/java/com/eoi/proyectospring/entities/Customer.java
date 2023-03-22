package com.eoi.proyectospring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


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
     * El conjunto de direcciones asociadas a este customer. En este caso tenemos una relacion 1:N o OneToMany,
     *  Además, indicamos el CascadeType=ALL para borrar en cascada todas las direcciones pertenecientes a un clienteç
     *  en caso de borrar dicho cliente. De este modo, aseguramos la consistencia en la base de datos
     *  y no dejamos direcciones "huérfanas" en la base de datos, que sin cliente no tendrían sentido
     *
     */
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Address> addressSet;

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

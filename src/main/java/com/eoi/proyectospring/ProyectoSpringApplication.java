package com.eoi.proyectospring;

import com.eoi.proyectospring.entities.Address;
import com.eoi.proyectospring.entities.Customer;
import com.eoi.proyectospring.repositories.AddressRepository;
import com.eoi.proyectospring.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The type Proyecto spring application.
 */
@SpringBootApplication
public class ProyectoSpringApplication implements CommandLineRunner {

	/**
	 * The Customer repository.
	 */
	@Autowired
	CustomerRepository customerRepository;
	/**
	 * The Address repository.
	 */
	@Autowired
	AddressRepository addressRepository;


	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args)  {
		SpringApplication.run(ProyectoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer = new Customer("Pepe"
				, "lopez"
				, "alegria"
				, LocalDate.of( 1982, 5 , 9 )
				, LocalDateTime.now()
		);
		Customer customer2 = new Customer("Jebediah"
				, "Kerman"
				, "The First"
				, LocalDate.of( 1982, 5 , 9 )
				, LocalDateTime.now()
		);
		Customer customer3= new Customer("Jose Luis"
				, "Lopez"
				, "The Second"
				, LocalDate.of( 1982, 5 , 9 )
				, LocalDateTime.now()
		);

		customerRepository.save(customer);
		customerRepository.save(customer2);
		customerRepository.save(customer3);


		//CREAMOS 4 DIRECCIONES Y LAS AÑADIMOS A DOS DE LOS CUSTOMER

		Address	address = new Address("Calle Carcalacueva", "JACA", "HUESCA", "22700");
		Address	address2 = new Address("Calle Carcalacueva2", "JACA", "HUESCA", "22700");
		Address	address3 = new Address("Calle Carcalacueva3", "JACA", "HUESCA", "22700");
		Address	address4 = new Address("Calle Carcalacueva3", "JACA", "HUESCA", "22700");

		// AÑADIMOS 3 a uno de ellos y 1 a otro
		address.setCustomer(customer);
		address2.setCustomer(customer);
		address3.setCustomer(customer);
		address4.setCustomer(customer2);

		//GUARDAMOS TODAS LAS DIRECCIONES
		addressRepository.save(address);
		addressRepository.save(address2);
		addressRepository.save(address3);
		addressRepository.save(address4);


	}

}

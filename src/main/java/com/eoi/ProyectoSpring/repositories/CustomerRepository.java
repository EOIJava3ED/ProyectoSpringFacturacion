package com.eoi.ProyectoSpring.repositories;
import com.eoi.ProyectoSpring.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


/**
 * The interface Customer repository.
 */
@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends CrudRepository<Customer, Integer> {


    /**
     *
     * Tenemos la entidad Customer, y queremos generar un repositorio CRUD en la url /customer
     *  Para ello informamos el collectionResourceRel = "customer", path = "customer"
     *  Y le decimos que nuestro repositorio extiende de un CrudRepository<T,Int>
     *  CrudRepository<Customer,Integer>
     *
     *  Esto crea un mapeo de servicios REST en la url /customer
     *
     *  /customer lista todos los customer
     *  /customer/${id} detalle de un customer  -> por ejemplo, /customer/2  para el customer de id=2
     *
     */


    /**
     * Spring buscará los métodos findBy y los asociará al parámetro del mismo nombre.
     * Es decir, findByName valrá si el cliente tiene name entre sus propiedades.
     * Al igual, findByCodigoPostal valdría si el cliente tuviera "codigoPostal" entre sus propiedades.
     *
     * @param name the name
     * @return the list
     */
    List<Customer> findByName(@Param("name") String name);

    /**
     * Find bysecond name list.
     *
     * @param name the name
     * @return the list
     */
    List<Customer> findBysecondName(@Param("secondName") String name);

    /**
     * Find bythird name list.
     *
     * @param name the name
     * @return the list
     */
    List<Customer> findBythirdName(@Param("thirdName") String name);



}



package com.eoi.proyectospring.repositories;

import com.eoi.proyectospring.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * The interface Repositorio de clientes. Este es el repositorio CRUD
 * que nos proporcionará las funciones básicas para los objetos Address
 *
 */
// This will be AUTO IMPLEMENTED by Spring into a Bean called addressRepository
// CRUD refers Create, Read, Update, Delete
@RepositoryRestResource(collectionResourceRel = "address", path = "address")
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
package com.davilima.desafio.Repository;

import org.springframework.data.repository.CrudRepository;

import com.davilima.desafio.Model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String>{
    
    Cliente findByIdCliente(long id);
}

package com.davilima.desafio.Repository;

import org.springframework.data.repository.CrudRepository;

import com.davilima.desafio.Model.Cliente;
import com.davilima.desafio.Model.Conteiner;

public interface ConteinerRepository extends CrudRepository<Conteiner, String>{
    
    Iterable<Conteiner> findByCliente(Cliente cliente);
    Conteiner findByIdConteiner(long id);
}

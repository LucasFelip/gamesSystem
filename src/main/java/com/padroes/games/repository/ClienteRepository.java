package com.padroes.games.repository;

import com.padroes.games.model.Cliente;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
    Cliente findByEmail(String email);
}


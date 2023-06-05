package com.padroes.games.repository;

import com.padroes.games.model.Cliente;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository {
    private final MongoOperations mongoOperations;

    public ClienteRepository(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public Cliente save(Cliente cliente) {
        return mongoOperations.save(cliente);
    }

    public Cliente findById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoOperations.findOne(query, Cliente.class);
    }

    // Outros métodos de consulta ou manipulação de dados
}

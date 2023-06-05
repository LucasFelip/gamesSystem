package com.padroes.games.repository;

import com.padroes.games.model.Jogo;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class JogoRepository {
    private final MongoOperations mongoOperations;

    public JogoRepository(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public Jogo save(Jogo jogo) {
        return mongoOperations.save(jogo);
    }

    public Jogo findById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoOperations.findOne(query, Jogo.class);
    }

    // Outros métodos de consulta ou manipulação de dados
}

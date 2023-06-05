package com.padroes.games.repository;
import com.padroes.games.model.PromocaoDesconto;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PromocaoDescontoRepository {
    private final MongoOperations mongoOperations;

    public PromocaoDescontoRepository(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public PromocaoDesconto save(PromocaoDesconto promocaoDesconto) {
        return mongoOperations.save(promocaoDesconto);
    }

    public PromocaoDesconto findById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoOperations.findOne(query, PromocaoDesconto.class);
    }

    // Outros métodos de consulta ou manipulação de dados
}


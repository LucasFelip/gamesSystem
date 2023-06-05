package com.padroes.games.repository;
import com.padroes.games.model.Locacao;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class LocacaoRepository {
    private final MongoOperations mongoOperations;

    public LocacaoRepository(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public Locacao save(Locacao locacao) {
        return mongoOperations.save(locacao);
    }

    public Locacao findById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoOperations.findOne(query, Locacao.class);
    }

    // Outros métodos de consulta ou manipulação de dados
}


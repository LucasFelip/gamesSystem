package com.padroes.games.repository;
import com.padroes.games.model.Console;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ConsoleRepository {
    private final MongoOperations mongoOperations;

    public ConsoleRepository(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public Console save(Console console) {
        return mongoOperations.save(console);
    }

    public Console findById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoOperations.findOne(query, Console.class);
    }

    // Outros métodos de consulta ou manipulação de dados
}

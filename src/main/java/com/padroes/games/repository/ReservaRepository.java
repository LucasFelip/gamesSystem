package com.padroes.games.repository;
import com.padroes.games.model.Reserva;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ReservaRepository {
    private final MongoOperations mongoOperations;

    public ReservaRepository(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public Reserva save(Reserva reserva) {
        return mongoOperations.save(reserva);
    }

    public Reserva findById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoOperations.findOne(query, Reserva.class);
    }

    // Outros métodos de consulta ou manipulação de dados
}


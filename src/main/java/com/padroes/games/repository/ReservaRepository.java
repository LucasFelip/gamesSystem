package com.padroes.games.repository;
import com.padroes.games.model.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepository extends MongoRepository<Reserva, String> {
    List<Reserva> findByDataRetiradaAfter(Date data);
}



package com.padroes.games.repository;
import com.padroes.games.model.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservaRepository extends MongoRepository<Reserva, String> {
    // Aqui você pode adicionar métodos personalizados de consulta, se necessário
}



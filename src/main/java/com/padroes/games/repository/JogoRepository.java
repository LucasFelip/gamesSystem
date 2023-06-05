package com.padroes.games.repository;

import com.padroes.games.model.Jogo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JogoRepository extends MongoRepository<Jogo, String> {
    // Aqui você pode adicionar métodos personalizados de consulta, se necessário
}


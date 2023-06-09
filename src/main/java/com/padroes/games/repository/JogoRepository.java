package com.padroes.games.repository;

import com.padroes.games.model.Jogo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends MongoRepository<Jogo, String> {
    List<Jogo> findByTituloContainingIgnoreCase(String titulo);
    List<Jogo> findByPlataformasContainingIgnoreCase(String plataforma);
}


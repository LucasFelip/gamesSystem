package com.padroes.games.repository;
import com.padroes.games.model.Console;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsoleRepository extends MongoRepository<Console, String> {
    List<Console> findByEstoqueGreaterThan(int quantidade);
}


package com.padroes.games.repository;
import com.padroes.games.model.Console;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsoleRepository extends MongoRepository<Console, String> {
    // Aqui você pode adicionar métodos personalizados de consulta, se necessário
}


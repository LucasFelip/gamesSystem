package com.padroes.games.repository;
import com.padroes.games.model.PromocaoDesconto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PromocaoDescontoRepository extends MongoRepository<PromocaoDesconto, String> {
    // Aqui você pode adicionar métodos personalizados de consulta, se necessário
}



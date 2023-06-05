package com.padroes.games.repository;
import com.padroes.games.model.Locacao;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocacaoRepository extends MongoRepository<Locacao, String> {
    // Aqui você pode adicionar métodos personalizados de consulta, se necessário
}


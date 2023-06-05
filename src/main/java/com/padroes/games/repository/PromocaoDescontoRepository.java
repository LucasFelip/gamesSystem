package com.padroes.games.repository;
import com.padroes.games.model.PromocaoDesconto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromocaoDescontoRepository extends MongoRepository<PromocaoDesconto, String> {
    List<PromocaoDesconto> findByDescontoGreaterThan(double desconto);
}



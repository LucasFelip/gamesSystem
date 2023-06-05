package com.padroes.games.repository;
import com.padroes.games.model.Cliente;
import com.padroes.games.model.Locacao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LocacaoRepository extends MongoRepository<Locacao, String> {
    List<Locacao> findByDataLocacaoBetween(Date dataInicial, Date dataFinal);
    List<Locacao> findByCliente(Cliente cliente);
}


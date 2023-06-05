package com.padroes.games.service;

import com.padroes.games.model.Jogo;
import com.padroes.games.model.PromocaoDesconto;
import com.padroes.games.repository.PromocaoDescontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromocaoDescontoService {
    private final PromocaoDescontoRepository promocaoDescontoRepository;

    @Autowired
    public PromocaoDescontoService(PromocaoDescontoRepository promocaoDescontoRepository) {
        this.promocaoDescontoRepository = promocaoDescontoRepository;
    }

    public void adicionarJogoPromocao(PromocaoDesconto promocaoDesconto, Jogo jogo) {
        promocaoDesconto.adicionarJogoPromocao(jogo);
        promocaoDescontoRepository.save(promocaoDesconto);
    }

    // Outros métodos de serviço relacionados a promoções e descontos...
}


package com.padroes.games.service;

import com.padroes.games.model.Jogo;
import com.padroes.games.model.PromocaoDesconto;
import com.padroes.games.repository.PromocaoDescontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromocaoDescontoService {
    private final PromocaoDescontoRepository promocaoDescontoRepository;

    public PromocaoDescontoService(PromocaoDescontoRepository promocaoDescontoRepository) {
        this.promocaoDescontoRepository = promocaoDescontoRepository;
    }

    public PromocaoDesconto cadastrarPromocaoDesconto(PromocaoDesconto promocaoDesconto) {
        return promocaoDescontoRepository.save(promocaoDesconto);
    }
}



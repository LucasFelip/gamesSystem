package com.padroes.games.service;

import com.padroes.games.model.Jogo;
import com.padroes.games.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogoService {
    private final JogoRepository jogoRepository;

    @Autowired
    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public void cadastrarJogo(Jogo jogo) {
        jogoRepository.save(jogo);
    }

    public Jogo buscarJogoPorId(String id) {
        return jogoRepository.findById(id).orElse(null);
    }

    // Outros métodos de serviço relacionados a jogos...
}


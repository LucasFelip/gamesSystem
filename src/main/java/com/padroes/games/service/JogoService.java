package com.padroes.games.service;

import com.padroes.games.model.Jogo;
import com.padroes.games.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {
    private final JogoRepository jogoRepository;

    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public Jogo cadastrarJogo(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    public List<Jogo> buscarJogosPorTitulo(String titulo) {
        return jogoRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Jogo> buscarJogosPorPlataforma(String plataforma) {
        return jogoRepository.findByPlataformasContainingIgnoreCase(plataforma);
    }
}



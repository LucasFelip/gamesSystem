package com.padroes.games.service;

import com.padroes.games.model.Console;
import com.padroes.games.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsoleService {
    private final ConsoleRepository consoleRepository;

    public ConsoleService(ConsoleRepository consoleRepository) {
        this.consoleRepository = consoleRepository;
    }

    public Console cadastrarConsole(Console console) {
        return consoleRepository.save(console);
    }

    public List<Console> buscarConsolesDisponiveis(int quantidade) {
        return consoleRepository.findByEstoqueGreaterThan(quantidade);
    }
}



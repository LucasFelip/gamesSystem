package com.padroes.games.service;

import com.padroes.games.model.Console;
import com.padroes.games.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsoleService {
    private final ConsoleRepository consoleRepository;

    @Autowired
    public ConsoleService(ConsoleRepository consoleRepository) {
        this.consoleRepository = consoleRepository;
    }

    public void locarConsole(Console console) {
        consoleRepository.save(console);
    }

    // Outros métodos de serviço relacionados a consoles...
}


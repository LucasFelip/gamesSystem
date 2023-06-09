package com.padroes.games.controller;

import com.padroes.games.model.Console;
import com.padroes.games.service.ConsoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consoles")
public class ConsoleController {
    private final ConsoleService consoleService;

    public ConsoleController(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @PostMapping
    public ResponseEntity<Console> cadastrarConsole(@RequestBody Console console) {
        Console novoConsole = consoleService.cadastrarConsole(console);
        return ResponseEntity.ok(novoConsole);
    }

    @GetMapping("/disponiveis/{quantidade}")
    public ResponseEntity<List<Console>> buscarConsolesDisponiveis(@PathVariable int quantidade) {
        List<Console> consoles = consoleService.buscarConsolesDisponiveis(quantidade);
        return ResponseEntity.ok(consoles);
    }
}


package com.padroes.games.controller;

import com.padroes.games.model.Jogo;
import com.padroes.games.service.JogoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {
    private final JogoService jogoService;

    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @PostMapping
    public ResponseEntity<Jogo> cadastrarJogo(@RequestBody Jogo jogo) {
        Jogo novoJogo = jogoService.cadastrarJogo(jogo);
        return ResponseEntity.ok(novoJogo);
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Jogo>> buscarJogosPorTitulo(@PathVariable String titulo) {
        List<Jogo> jogos = jogoService.buscarJogosPorTitulo(titulo);
        return ResponseEntity.ok(jogos);
    }

    @GetMapping("/plataforma/{plataforma}")
    public ResponseEntity<List<Jogo>> buscarJogosPorPlataforma(@PathVariable String plataforma) {
        List<Jogo> jogos = jogoService.buscarJogosPorPlataforma(plataforma);
        return ResponseEntity.ok(jogos);
    }
}


package com.padroes.games.controller;

import com.padroes.games.model.Cliente;
import com.padroes.games.model.Jogo;
import com.padroes.games.model.Locacao;
import com.padroes.games.service.LocacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {
    private final LocacaoService locacaoService;

    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

//    @PostMapping
//    public ResponseEntity<Locacao> locarJogo(@RequestBody LocacaoService request) {
//        Cliente cliente = request.getCliente();
//        Jogo jogo = request.getJogo();
//        int quantidadeDias = request.getQuantidadeDias();
//
//        Locacao locacao = locacaoService.locarJogo(cliente, jogo, quantidadeDias);
//        return ResponseEntity.ok(locacao);
//    }
//
//    @GetMapping("/{id}/preco")
//    public ResponseEntity<Double> calcularPrecoLocacao(@PathVariable String id) {
//        Locacao locacao = locacaoService.buscarLocacaoPorId(id);
//        double preco = locacaoService.calcularPrecoLocacao(locacao);
//        return ResponseEntity.ok(preco);
//    }
}


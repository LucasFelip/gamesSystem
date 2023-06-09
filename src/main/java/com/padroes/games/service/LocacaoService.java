package com.padroes.games.service;

import com.padroes.games.model.Cliente;
import com.padroes.games.model.Jogo;
import com.padroes.games.model.Locacao;
import com.padroes.games.repository.JogoRepository;
import com.padroes.games.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

@Service
public class LocacaoService {
    private final LocacaoRepository locacaoRepository;
    private final JogoRepository jogoRepository;

    public LocacaoService(LocacaoRepository locacaoRepository, JogoRepository jogoRepository) {
        this.locacaoRepository = locacaoRepository;
        this.jogoRepository = jogoRepository;
    }

    public Locacao locarJogo(Cliente cliente, Jogo jogo, int quantidadeDias) {
        if (jogo.getEstoque() <= 0) {
            throw new RuntimeException("O jogo não está disponível no estoque.");
        }

        Locacao locacao = Locacao.builder()
                .cliente(cliente)
                .jogos(Collections.singletonMap(jogo, quantidadeDias))
                .dataLocacao(new Date())
                .build();

        jogo.atualizarEstoque(jogo.getEstoque() - 1);
        jogoRepository.save(jogo);

        return locacaoRepository.save(locacao);
    }

    public double calcularPrecoLocacao(Locacao locacao) {
        double precoTotal = 0.0;
        Map<Jogo, Integer> jogos = locacao.getJogos();

        for (Map.Entry<Jogo, Integer> entry : jogos.entrySet()) {
            Jogo jogo = entry.getKey();
            int quantidadeDias = entry.getValue();
            double precoDiario = jogo.getPlataformas().get(jogo.getPlataformas().keySet().iterator().next());
            double precoJogo = precoDiario * quantidadeDias;
            precoTotal += precoJogo;
        }

        return precoTotal;
    }
}



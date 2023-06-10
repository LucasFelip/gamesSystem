package com.padroes.games.serviceTest;

import com.padroes.games.model.Cliente;
import com.padroes.games.model.Jogo;
import com.padroes.games.model.Locacao;
import com.padroes.games.repository.JogoRepository;
import com.padroes.games.repository.LocacaoRepository;
import com.padroes.games.service.LocacaoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LocacaoServiceTest {

    @Test
    public void testCalcularPrecoLocacao() {
        LocacaoService locacaoService = new LocacaoService(null, null);

        Jogo jogo = Jogo.builder()
                .titulo("Red Dead Redemption 2")
                .plataformas(createPlataformasMap("PlayStation 4", 59.99))
                .estoque(1)
                .build();

        Locacao locacao = Locacao.builder()
                .jogos(Collections.singletonMap(jogo, 5))
                .build();

        double expectedPreco = 299.95;
        double calculatedPreco = locacaoService.calcularPrecoLocacao(locacao);

        Assertions.assertEquals(expectedPreco, calculatedPreco);
    }

    private Map<String, Double> createPlataformasMap(String plataforma, double preco) {
        Map<String, Double> plataformas = new HashMap<>();
        plataformas.put(plataforma, preco);
        return plataformas;
    }
}


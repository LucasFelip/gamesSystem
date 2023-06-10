package com.padroes.games.repositoryTest;

import com.padroes.games.model.Jogo;
import com.padroes.games.repository.JogoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataMongoTest
public class JogoRepositoryTest {

    @Autowired
    private JogoRepository jogoRepository;

    @Test
    public void testFindByTituloContainingIgnoreCase() {
        // Criação de jogos usando o padrão Builder
        Jogo jogo1 = Jogo.builder()
                .titulo("The Legend of Zelda: Breath of the Wild")
                .plataformas(createPlataformasMap("Nintendo Switch", 49.99))
                .estoque(10)
                .build();

        Jogo jogo2 = Jogo.builder()
                .titulo("Super Mario Odyssey")
                .plataformas(createPlataformasMap("Nintendo Switch", 39.99))
                .estoque(5)
                .build();

        jogoRepository.saveAll(Arrays.asList(jogo1, jogo2));

        // Busca de jogos pelo título (ignorando case)
        List<Jogo> jogos = jogoRepository.findByTituloContainingIgnoreCase("mario");

        // Verificando se os jogos foram encontrados corretamente
        Assertions.assertEquals(1, jogos.size());
        Assertions.assertEquals("Super Mario Odyssey", jogos.get(0).getTitulo());
    }

    @Test
    public void testFindByPlataformasContainingIgnoreCase() {
        // Criação de jogos usando o padrão Builder
        Jogo jogo1 = Jogo.builder()
                .titulo("The Legend of Zelda: Breath of the Wild")
                .plataformas(createPlataformasMap("Nintendo Switch", 49.99))
                .estoque(10)
                .build();

        Jogo jogo2 = Jogo.builder()
                .titulo("Super Mario Odyssey")
                .plataformas(createPlataformasMap("Nintendo Switch", 39.99))
                .estoque(5)
                .build();

        jogoRepository.saveAll(Arrays.asList(jogo1, jogo2));

        // Busca de jogos pelas plataformas (ignorando case)
        List<Jogo> jogos = jogoRepository.findByPlataformasContainingIgnoreCase("switch");

        // Verificando se os jogos foram encontrados corretamente
        Assertions.assertEquals(2, jogos.size());
    }

    private Map<String, Double> createPlataformasMap(String plataforma, double preco) {
        Map<String, Double> plataformas = new HashMap<>();
        plataformas.put(plataforma, preco);
        return plataformas;
    }
}


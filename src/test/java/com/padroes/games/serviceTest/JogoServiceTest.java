package com.padroes.games.serviceTest;

import com.padroes.games.model.Jogo;
import com.padroes.games.repository.JogoRepository;
import com.padroes.games.service.JogoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JogoServiceTest {

    @Test
    public void testCadastrarJogo() {
        JogoRepository jogoRepository = Mockito.mock(JogoRepository.class);

        JogoService jogoService = new JogoService(jogoRepository);

        Jogo jogo = Jogo.builder()
                .titulo("Super Mario Odyssey")
                .plataformas(createPlataformasMap("Nintendo Switch", 49.99))
                .estoque(5)
                .build();

        Jogo result = jogoService.cadastrarJogo(jogo);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(jogo, result);

        Mockito.verify(jogoRepository, Mockito.times(1)).save(jogo);
    }

    @Test
    public void testBuscarJogosPorTitulo() {
        JogoRepository jogoRepository = Mockito.mock(JogoRepository.class);

        JogoService jogoService = new JogoService(jogoRepository);

        String titulo = "The Legend of Zelda";

        List<Jogo> jogos = Arrays.asList(
                Jogo.builder()
                        .titulo("The Legend of Zelda: Breath of the Wild")
                        .plataformas(createPlataformasMap("Nintendo Switch", 49.99))
                        .estoque(5)
                        .build(),
                Jogo.builder()
                        .titulo("The Legend of Zelda: Ocarina of Time")
                        .plataformas(createPlataformasMap("Nintendo 64", 19.99))
                        .estoque(3)
                        .build()
        );

        Mockito.when(jogoRepository.findByTituloContainingIgnoreCase(titulo)).thenReturn(jogos);

        List<Jogo> result = jogoService.buscarJogosPorTitulo(titulo);

        Assertions.assertEquals(jogos, result);

        Mockito.verify(jogoRepository, Mockito.times(1)).findByTituloContainingIgnoreCase(titulo);
    }

    @Test
    public void testBuscarJogosPorPlataforma() {
        JogoRepository jogoRepository = Mockito.mock(JogoRepository.class);

        JogoService jogoService = new JogoService(jogoRepository);

        String plataforma = "PlayStation";

        List<Jogo> jogos = Arrays.asList(
                Jogo.builder()
                        .titulo("The Last of Us Part II")
                        .plataformas(createPlataformasMap("PlayStation 4", 59.99))
                        .estoque(5)
                        .build(),
                Jogo.builder()
                        .titulo("God of War")
                        .plataformas(createPlataformasMap("PlayStation 4", 49.99))
                        .estoque(3)
                        .build()
        );

        Mockito.when(jogoRepository.findByPlataformasContainingIgnoreCase(plataforma)).thenReturn(jogos);

        List<Jogo> result = jogoService.buscarJogosPorPlataforma(plataforma);

        Assertions.assertEquals(jogos, result);

        Mockito.verify(jogoRepository, Mockito.times(1)).findByPlataformasContainingIgnoreCase(plataforma);
    }

    private Map<String, Double> createPlataformasMap(String plataforma, double preco) {
        Map<String, Double> plataformas = new HashMap<>();
        plataformas.put(plataforma, preco);
        return plataformas;
    }
}


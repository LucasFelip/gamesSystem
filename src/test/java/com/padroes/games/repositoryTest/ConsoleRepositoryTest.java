package com.padroes.games.repositoryTest;

import com.padroes.games.model.Console;
import com.padroes.games.repository.ConsoleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@DataMongoTest
public class ConsoleRepositoryTest {

    @Autowired
    private ConsoleRepository consoleRepository;

    @Test
    public void testFindByEstoqueGreaterThan() {
        // Criação de consoles usando o padrão Builder
        Console console1 = Console.builder()
                .precoHora(5.0)
                .acessorios(new HashSet<>(Arrays.asList("Headphone", "Controle")))
                .estoque(10)
                .build();

        Console console2 = Console.builder()
                .precoHora(7.5)
                .acessorios(new HashSet<>(Arrays.asList("Kinect", "Controle")))
                .estoque(5)
                .build();

        consoleRepository.saveAll(Arrays.asList(console1, console2));

        // Busca de consoles com estoque maior que 5
        List<Console> consoles = consoleRepository.findByEstoqueGreaterThan(5);

        // Verificando se os consoles foram encontrados corretamente
        Assertions.assertEquals(1, consoles.size());
        Assertions.assertEquals("Kinect", consoles.get(0).getAcessorios().iterator().next());
    }
}

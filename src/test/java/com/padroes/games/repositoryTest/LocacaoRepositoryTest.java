package com.padroes.games.repositoryTest;

import com.padroes.games.model.Cliente;
import com.padroes.games.model.Locacao;
import com.padroes.games.repository.ClienteRepository;
import com.padroes.games.repository.LocacaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@DataMongoTest
public class LocacaoRepositoryTest {

    @Autowired
    private LocacaoRepository locacaoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testFindByDataLocacaoBetween() {
        // Criação de cliente usando o padrão Builder
        Cliente cliente = Cliente.builder()
                .nome("João")
                .email("joao@example.com")
                .telefone("123456789")
                .senha("senha123")
                .build();

        clienteRepository.save(cliente);

        // Criação de locações usando o padrão Builder
        Locacao locacao1 = Locacao.builder()
                .cliente(cliente)
                .dataLocacao(new Date())
                .build();

        Locacao locacao2 = Locacao.builder()
                .cliente(cliente)
                .dataLocacao(new Date())
                .build();

        locacaoRepository.saveAll(Arrays.asList(locacao1, locacao2));

        // Definição de datas para busca
        Date dataInicial = new Date(System.currentTimeMillis() - 10000);
        Date dataFinal = new Date();

        // Busca de locações dentro do intervalo de datas
        List<Locacao> locacoes = locacaoRepository.findByDataLocacaoBetween(dataInicial, dataFinal);

        // Verificando se as locações foram encontradas corretamente
        Assertions.assertEquals(2, locacoes.size());
    }

    @Test
    public void testFindByCliente() {
        // Criação de cliente usando o padrão Builder
        Cliente cliente1 = Cliente.builder()
                .nome("João")
                .email("joao@example.com")
                .telefone("123456789")
                .senha("senha123")
                .build();

        Cliente cliente2 = Cliente.builder()
                .nome("Maria")
                .email("maria@example.com")
                .telefone("987654321")
                .senha("senha456")
                .build();

        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));

        // Criação de locações usando o padrão Builder
        Locacao locacao1 = Locacao.builder()
                .cliente(cliente1)
                .dataLocacao(new Date())
                .build();

        Locacao locacao2 = Locacao.builder()
                .cliente(cliente2)
                .dataLocacao(new Date())
                .build();

        locacaoRepository.saveAll(Arrays.asList(locacao1, locacao2));

        // Busca de locações por cliente
        List<Locacao> locacoesCliente1 = locacaoRepository.findByCliente(cliente1);
        List<Locacao> locacoesCliente2 = locacaoRepository.findByCliente(cliente2);

        // Verificando se as locações foram encontradas corretamente
        Assertions.assertEquals(1, locacoesCliente1.size());
        Assertions.assertEquals(1, locacoesCliente2.size());
    }
}


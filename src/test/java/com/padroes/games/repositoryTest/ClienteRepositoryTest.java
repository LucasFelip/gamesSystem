package com.padroes.games.repositoryTest;

import com.padroes.games.model.Cliente;
import com.padroes.games.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataMongoTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testFindByEmail() {
        // Criação de um cliente usando o padrão Builder
        Cliente cliente = Cliente.builder()
                .nome("John Doe")
                .email("john@example.com")
                .telefone("123456789")
                .senha("password")
                .build();

        // Salvando o cliente no repositório
        clienteRepository.save(cliente);

        // Buscando o cliente pelo e-mail
        Cliente foundCliente = clienteRepository.findByEmail("john@example.com");

        // Verificando se o cliente foi encontrado corretamente
        Assertions.assertNotNull(foundCliente);
        Assertions.assertEquals("John Doe", foundCliente.getNome());
    }
}

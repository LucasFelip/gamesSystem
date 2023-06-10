package com.padroes.games.controllerTest;

import com.padroes.games.controller.ClienteController;
import com.padroes.games.model.Cliente;
import com.padroes.games.service.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

public class ClienteControllerTest {

    @Test
    public void testCadastrarCliente() {
        ClienteService clienteService = Mockito.mock(ClienteService.class);
        ClienteController clienteController = new ClienteController(clienteService);

        Cliente cliente = Cliente.builder()
                .nome("João")
                .email("joao@example.com")
                .build();

        Mockito.when(clienteService.cadastrarCliente(cliente)).thenReturn(cliente);

        ResponseEntity<Cliente> response = clienteController.cadastrarCliente(cliente);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(cliente, response.getBody());

        Mockito.verify(clienteService, Mockito.times(1)).cadastrarCliente(cliente);
    }

    @Test
    public void testBuscarTodosClientes() {
        ClienteService clienteService = Mockito.mock(ClienteService.class);
        ClienteController clienteController = new ClienteController(clienteService);

        List<Cliente> clientes = Arrays.asList(
                Cliente.builder()
                        .nome("João")
                        .email("joao@example.com")
                        .build(),
                Cliente.builder()
                        .nome("Maria")
                        .email("maria@example.com")
                        .build()
        );

        Mockito.when(clienteService.buscarTodosCliente()).thenReturn(clientes);

        ResponseEntity<List<Cliente>> response = clienteController.buscarTodosClientes();

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(clientes, response.getBody());

        Mockito.verify(clienteService, Mockito.times(1)).buscarTodosCliente();
    }

    @Test
    public void testBuscarClientePorEmail() {
        ClienteService clienteService = Mockito.mock(ClienteService.class);
        ClienteController clienteController = new ClienteController(clienteService);

        String email = "joao@example.com";

        Cliente cliente = Cliente.builder()
                .nome("João")
                .email(email)
                .build();

        Mockito.when(clienteService.buscarClientePorEmail(email)).thenReturn(cliente);

        ResponseEntity<Cliente> response = clienteController.buscarClientePorEmail(email);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(cliente, response.getBody());

        Mockito.verify(clienteService, Mockito.times(1)).buscarClientePorEmail(email);
    }
}


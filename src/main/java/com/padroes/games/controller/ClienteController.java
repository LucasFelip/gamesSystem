package com.padroes.games.controller;

import com.padroes.games.model.Cliente;
import com.padroes.games.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.cadastrarCliente(cliente);
        return ResponseEntity.ok(novoCliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodosClientes() {
        List<Cliente> cliente = clienteService.buscarTodosCliente();
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Cliente> buscarClientePorEmail(@PathVariable String email) {
        Cliente cliente = clienteService.buscarClientePorEmail(email);
        return ResponseEntity.ok(cliente);
    }
}

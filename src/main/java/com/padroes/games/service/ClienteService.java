package com.padroes.games.service;

import com.padroes.games.model.Cliente;
import com.padroes.games.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void cadastrarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Cliente buscarClientePorId(String id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // Outros métodos de serviço relacionados a clientes...
}


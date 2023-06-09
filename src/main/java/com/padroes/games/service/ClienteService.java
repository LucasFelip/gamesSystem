package com.padroes.games.service;

import com.padroes.games.model.Cliente;
import com.padroes.games.model.Jogo;
import com.padroes.games.model.Reserva;
import com.padroes.games.repository.ClienteRepository;
import com.padroes.games.repository.JogoRepository;
import com.padroes.games.repository.LocacaoRepository;
import com.padroes.games.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarClientePorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }
}




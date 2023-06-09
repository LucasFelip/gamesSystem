package com.padroes.games.service;

import com.padroes.games.model.Cliente;
import com.padroes.games.model.Jogo;
import com.padroes.games.model.Reserva;
import com.padroes.games.repository.JogoRepository;
import com.padroes.games.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final JogoRepository jogoRepository;

    public ReservaService(ReservaRepository reservaRepository, JogoRepository jogoRepository) {
        this.reservaRepository = reservaRepository;
        this.jogoRepository = jogoRepository;
    }

    public Reserva fazerReserva(Cliente cliente, Jogo jogo, Date dataRetirada) {
        if (jogo.getEstoque() <= 0) {
            throw new RuntimeException("O jogo não está disponível no estoque.");
        }

        Reserva reserva = Reserva.builder()
                .cliente(cliente)
                .jogo(jogo)
                .dataRetirada(dataRetirada)
                .build();

        jogo.atualizarEstoque(jogo.getEstoque() - 1);
        jogoRepository.save(jogo);

        return reservaRepository.save(reserva);
    }

    public List<Reserva> buscarReservasApósData(Date data) {
        return reservaRepository.findByDataRetiradaAfter(data);
    }
}

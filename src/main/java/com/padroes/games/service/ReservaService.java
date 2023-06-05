package com.padroes.games.service;

import com.padroes.games.model.Reserva;
import com.padroes.games.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public void fazerReserva(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    // Outros métodos de serviço relacionados a reservas...
}

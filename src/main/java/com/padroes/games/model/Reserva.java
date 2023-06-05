package com.padroes.games.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reservas")
public class Reserva {
    @Id
    private String id;
    private Cliente cliente;
    private Jogo jogo;
    private Date dataRetirada;

    public void fazerReserva() {
        // Lógica para fazer a reserva
    }
}

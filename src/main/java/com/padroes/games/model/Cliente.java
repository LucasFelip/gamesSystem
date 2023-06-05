package com.padroes.games.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clientes")
public class Cliente {
    @Id
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;

    public Cliente(String nome, String email, String telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public void cadastrarCliente() {
        // Lógica para cadastrar o cliente
    }

    public void fazerReserva() {
        // Lógica para fazer a reserva
    }
}

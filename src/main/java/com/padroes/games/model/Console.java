package com.padroes.games.model;

import java.util.Set;

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
@Document(collection = "consoles")
public class Console {
    @Id
    private String id;
    private double precoHora;
    private Set<String> acessorios;
    private int estoque;

    public void locarConsole() {
        // Lógica para locar o console
    }

    public double calcularPrecoLocacao(int horas) {
        return precoHora * horas;
    }

    public void adicionarAcessorio(String acessorio) {
        acessorios.add(acessorio);
    }

    public void atualizarEstoque(int quantidade) {
        estoque += quantidade;
    }
}

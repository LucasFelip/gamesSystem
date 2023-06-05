package com.padroes.games.model;

import java.util.Map;

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
@Document(collection = "jogos")
public class Jogo {
    @Id
    private String id;
    private String titulo;
    private Map<String, Double> plataformas; // Mapeia a plataforma para o preço de locação diário
    private int estoque;

    public Jogo(String titulo, Map<String, Double> plataformas, int estoque) {
        this.titulo = titulo;
        this.plataformas = plataformas;
        this.estoque = estoque;
    }

    public void cadastrarJogo() {
        // Lógica para cadastrar o jogo
    }

    public void adicionarPlataforma(String plataforma, double precoLocacao) {
        plataformas.put(plataforma, precoLocacao);
    }

    public void atualizarEstoque(int quantidade) {
        estoque += quantidade;
    }
}

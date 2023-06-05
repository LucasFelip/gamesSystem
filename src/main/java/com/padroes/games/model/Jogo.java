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
    private Map<String, Double> plataformas;
    private int estoque;

    public void atualizarEstoque(int i) {
        this.estoque -= i;
    }
}

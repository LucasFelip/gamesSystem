package com.padroes.games.model;

import java.util.Date;
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
@Document(collection = "locações")
public class Locacao {
    @Id
    private String id;
    private Cliente cliente;
    private Map<Jogo, Integer> jogos; // Mapeia o jogo para a quantidade de dias de locação
    private Date dataLocacao;

    public void locarJogo(Jogo jogo, int dias) {
        jogos.put(jogo, dias);
    }

    public double calcularPrecoLocacao() {
        double precoTotal = 0;
        for (Map.Entry<Jogo, Integer> entry : jogos.entrySet()) {
            Jogo jogo = entry.getKey();
            int dias = entry.getValue();
            double precoLocacao = jogo.getPlataformas().get(jogo.getPlataformas().keySet().iterator().next()); // Preço da primeira plataforma (pode ser adaptado conforme lógica de escolha da plataforma)
            precoTotal += precoLocacao * dias;
        }
        return precoTotal;
    }

    public void atualizarEstoque() {
        for (Map.Entry<Jogo, Integer> entry : jogos.entrySet()) {
            Jogo jogo = entry.getKey();
            int quantidade = entry.getValue();
            jogo.atualizarEstoque(-quantidade);
        }
    }
}

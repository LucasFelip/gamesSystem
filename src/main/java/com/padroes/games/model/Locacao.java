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
    private Map<Jogo, Integer> jogos;
    private Date dataLocacao;
}

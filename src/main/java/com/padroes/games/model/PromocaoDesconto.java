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
@Document(collection = "promocoes")
public class PromocaoDesconto {
    @Id
    private String id;
    private Set<Jogo> jogosPromocao;
    private double desconto;
}

package com.padroes.games.service;

import com.padroes.games.model.Locacao;
import com.padroes.games.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocacaoService {
    private final LocacaoRepository locacaoRepository;

    @Autowired
    public LocacaoService(LocacaoRepository locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    public void locarJogo(Locacao locacao) {
        locacaoRepository.save(locacao);
    }

    // Outros métodos de serviço relacionados a locações...
}


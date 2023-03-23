package br.com.requeijo.desafio.programas.casapopular.service;

import br.com.requeijo.desafio.programas.dto.FamiliaDTO;
import br.com.requeijo.desafio.programas.dto.PontuacaoDTO;
import br.com.requeijo.desafio.programas.entity.Familia;
import br.com.requeijo.desafio.programas.entity.Pontuacao;
import br.com.requeijo.desafio.programas.enums.CasaPopularType;

import java.util.List;

public interface CasaPopularService {
    Familia cadastrarFamilia(CasaPopularType casapopularRj, Familia toEntity);

    List<Familia> findAll(CasaPopularType casaPopular);

    List<Pontuacao> elegibilidade(CasaPopularType casaPopular);
}

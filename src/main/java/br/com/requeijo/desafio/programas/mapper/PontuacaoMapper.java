package br.com.requeijo.desafio.programas.mapper;

import br.com.requeijo.desafio.programas.entity.Pontuacao;
import br.com.requeijo.desafio.programas.dto.PontuacaoDTO;

public class PontuacaoMapper {

    public static PontuacaoDTO toModel(final Pontuacao pontuacao) {
        return PontuacaoDTO.builder()
                .pontos(pontuacao.getPontos())
                .familia(FamiliaMapper.toModel(pontuacao.getFamilia()))
                .build();
    }
}

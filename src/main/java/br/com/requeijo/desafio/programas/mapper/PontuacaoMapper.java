package br.com.requeijo.desafio.programas.mapper;

import br.com.requeijo.desafio.programas.entity.Pontuacao;
import br.com.requeijo.desafio.programas.model.PontuacaoModel;

public class PontuacaoMapper {

    public static PontuacaoModel toModel(final Pontuacao pontuacao) {
        return PontuacaoModel.builder()
                .pontos(pontuacao.getPontos())
                .familia(FamiliaMapper.toModel(pontuacao.getFamilia()))
                .build();
    }
}

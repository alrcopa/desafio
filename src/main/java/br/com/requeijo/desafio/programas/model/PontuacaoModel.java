package br.com.requeijo.desafio.programas.model;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Builder
@Value
public class PontuacaoModel {

    private Integer pontos;
    private FamiliaModel familia;
}

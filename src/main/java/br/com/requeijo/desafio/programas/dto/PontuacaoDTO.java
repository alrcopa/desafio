package br.com.requeijo.desafio.programas.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Builder
@Value
public class PontuacaoDTO {

    private Integer pontos;
    private FamiliaDTO familia;
}

package br.com.requeijo.desafio.programas.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pontuacao {
    private Integer pontos;
    private Familia familia;
}

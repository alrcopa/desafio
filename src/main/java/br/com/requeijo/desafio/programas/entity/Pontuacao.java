package br.com.requeijo.desafio.programas.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pontuacao {
    private Integer pontos;
    private Familia familia;
}

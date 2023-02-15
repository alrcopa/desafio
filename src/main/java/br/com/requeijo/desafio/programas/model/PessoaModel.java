package br.com.requeijo.desafio.programas.model;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;


@Data
@Builder
@Value
public class PessoaModel {

    Long id;
    String nome;
    Integer idade;
    BigDecimal renda;

}

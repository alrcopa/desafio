package br.com.requeijo.desafio.programas.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Builder
@Value
public class PessoaDTO {

    Long id;
    String nome;
    LocalDate dataNascimento;
    BigDecimal renda;

}

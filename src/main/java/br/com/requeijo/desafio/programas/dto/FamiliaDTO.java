package br.com.requeijo.desafio.programas.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.util.List;

@Getter
@Setter
@Builder
@Value
public class FamiliaDTO {

    Long id;
    PessoaDTO pai;
    PessoaDTO mae;
    List<PessoaDTO> dependentes;
}

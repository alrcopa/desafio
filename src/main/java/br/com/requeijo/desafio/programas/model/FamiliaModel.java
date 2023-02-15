package br.com.requeijo.desafio.programas.model;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
@Builder
@Value
public class FamiliaModel {

    Long id;
    PessoaModel pai;
    PessoaModel mae;
    List<PessoaModel> dependentes;
}

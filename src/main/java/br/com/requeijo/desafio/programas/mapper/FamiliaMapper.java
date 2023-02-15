package br.com.requeijo.desafio.programas.mapper;

import br.com.requeijo.desafio.programas.entity.Familia;
import br.com.requeijo.desafio.programas.entity.Pessoa;
import br.com.requeijo.desafio.programas.model.FamiliaModel;
import br.com.requeijo.desafio.programas.model.PessoaModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public class FamiliaMapper {

    public static FamiliaModel toModel(final Familia familia) {
        return FamiliaModel.builder()
                .id(familia.getId())
                .pai(toPessoaDomain(familia.getPai()))
                .mae(toPessoaDomain(familia.getMae()))
                .dependentes(familia.getDependentes().stream().map(FamiliaMapper::toPessoaDomain).toList())
                .build();
    }

    private static PessoaModel toPessoaDomain(final Pessoa pessoa) {
        return PessoaModel.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .idade(pessoa.getIdade())
                .renda(new BigDecimal(pessoa.getRenda().toString()))
                .build();
    }

    public static Familia toEntity(final FamiliaModel model) {
        return Familia.builder()
                .pai(toPessoaDomain(model.getPai()))
                .mae(toPessoaDomain(model.getMae()))
                .dependentes(model.getDependentes().stream().map(FamiliaMapper::toPessoaDomain).toList())
                .build();
    }

    private static Pessoa toPessoaDomain(final PessoaModel model) {
        return Pessoa.builder()
                .nome(model.getNome())
                .idade(model.getIdade())
                .renda(new BigDecimal(model.getRenda().toString()))
                .build();
    }

}

package br.com.requeijo.desafio.programas.mapper;

import br.com.requeijo.desafio.programas.entity.Familia;
import br.com.requeijo.desafio.programas.entity.Pessoa;
import br.com.requeijo.desafio.programas.dto.FamiliaDTO;
import br.com.requeijo.desafio.programas.dto.PessoaDTO;

import java.math.BigDecimal;

public class FamiliaMapper {

    public static FamiliaDTO toModel(final Familia familia) {
        return FamiliaDTO.builder()
                .id(familia.getId())
                .pai(toPessoaDomain(familia.getPai()))
                .mae(toPessoaDomain(familia.getMae()))
                .dependentes(familia.getDependentes().stream().map(FamiliaMapper::toPessoaDomain).toList())
                .build();
    }

    private static PessoaDTO toPessoaDomain(final Pessoa pessoa) {
        return PessoaDTO.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .dataNascimento(pessoa.getDataNascimento())
                .renda(new BigDecimal(pessoa.getRenda().toString()))
                .build();
    }

    public static Familia toEntity(final FamiliaDTO model) {
        return Familia.builder()
                .pai(toPessoaDomain(model.getPai()))
                .mae(toPessoaDomain(model.getMae()))
                .dependentes(model.getDependentes().stream().map(FamiliaMapper::toPessoaDomain).toList())
                .build();
    }

    private static Pessoa toPessoaDomain(final PessoaDTO model) {
        return Pessoa.builder()
                .nome(model.getNome())
                .dataNascimento(model.getDataNascimento())
                .renda(new BigDecimal(model.getRenda().toString()))
                .build();
    }

}

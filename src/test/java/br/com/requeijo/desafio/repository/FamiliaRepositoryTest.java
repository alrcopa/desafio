package br.com.requeijo.desafio.repository;

import br.com.requeijo.desafio.programas.entity.Familia;
import br.com.requeijo.desafio.programas.entity.Pessoa;
import br.com.requeijo.desafio.programas.repository.FamiliaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FamiliaRepositoryTest {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Test
    public void testCadastraFamilia() {
        familiaRepository.deleteAll();

        List<Pessoa> dependentes = null;

        Pessoa mae = Pessoa.builder().nome("Cleuza").dataNascimento(LocalDate.of(1955, 10, 15)).renda(new BigDecimal(0)).build();
        Pessoa pai = Pessoa.builder().nome("Carlos").dataNascimento(LocalDate.of(1960, 8, 2)).renda(new BigDecimal(500)).build();
        Pessoa dependente = Pessoa.builder().nome("Andre").dataNascimento(LocalDate.of(1990, 2, 5)).renda(new BigDecimal(300)).build();
        dependentes = new ArrayList<>();
        dependentes.add(dependente);

        Familia familia = Familia.builder().pai(pai).mae(mae).dependentes(dependentes).build();
        Familia resposta = familiaRepository.save(familia);

        Assertions.assertThat(resposta.getId()).isNotNull();

    }



}

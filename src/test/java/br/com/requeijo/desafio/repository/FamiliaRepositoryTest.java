package br.com.requeijo.desafio.repository;

import br.com.requeijo.desafio.programas.entity.Familia;
import br.com.requeijo.desafio.programas.entity.Pessoa;
import br.com.requeijo.desafio.programas.repository.FamiliaRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FamiliaRepositoryTest {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Test
    public void testCadastraFamilia() {
        familiaRepository.deleteAll();

        List<Pessoa> dependentes = null;

        Pessoa mae = Pessoa.builder().nome("Cleuza").idade(70).renda(new BigDecimal(0)).build();
        Pessoa pai = Pessoa.builder().nome("Carlos").idade(75).renda(new BigDecimal(500)).build();
        Pessoa dependente = Pessoa.builder().nome("Andre").idade(75).renda(new BigDecimal(300)).build();
        dependentes = new ArrayList<>();
        dependentes.add(dependente);

        Familia familia = Familia.builder().pai(pai).mae(mae).dependentes(dependentes).build();
        Familia resposta = familiaRepository.save(familia);

        Assertions.assertThat(resposta.getId()).isNotNull();


    }



}

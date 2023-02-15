package br.com.requeijo.desafio.service;


import br.com.requeijo.desafio.programas.casapopular.service.CasaPopularService;
import br.com.requeijo.desafio.programas.entity.Familia;
import br.com.requeijo.desafio.programas.entity.Pessoa;
import br.com.requeijo.desafio.programas.enums.CasaPopularType;
import br.com.requeijo.desafio.programas.model.FamiliaModel;
import br.com.requeijo.desafio.programas.repository.FamiliaRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class CasaPopularServiceTest {

    @Autowired
	private CasaPopularService casaPopularService;

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

    @Test
    void testExisteFamilia() {

		List<Pessoa> dependentes = null;

		Pessoa mae = Pessoa.builder().nome("Cleuza").idade(70).renda(new BigDecimal(0)).build();
		Pessoa pai = Pessoa.builder().nome("Carlos").idade(75).renda(new BigDecimal(500)).build();
		Pessoa dependente = Pessoa.builder().nome("Andre").idade(75).renda(new BigDecimal(300)).build();
		dependentes = new ArrayList<>();
		dependentes.add(dependente);

		Familia familia = Familia.builder().pai(pai).mae(mae).dependentes(dependentes).build();
		Familia resposta = familiaRepository.save(familia);

		List<FamiliaModel> familias = casaPopularService.list(CasaPopularType.CASAPOPULAR_RJ);
		System.out.println(familias);
		Assert.assertTrue(familias.size() > 0);

    }


}

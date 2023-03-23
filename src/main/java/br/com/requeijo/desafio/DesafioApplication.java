package br.com.requeijo.desafio;

import br.com.requeijo.desafio.programas.casapopular.service.CasaPopularServiceImpl;
import br.com.requeijo.desafio.programas.entity.Familia;
import br.com.requeijo.desafio.programas.entity.Pessoa;
import br.com.requeijo.desafio.programas.repository.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DesafioApplication {

	@Autowired
	private CasaPopularServiceImpl service;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}



//	@Bean
//	CommandLineRunner initDatabase(FamiliaRepository familiaRepository) {
//
//		return args -> {
//			familiaRepository.deleteAll();
//
//			List<Pessoa> dependentes = null;
//
//			Pessoa mae = Pessoa.builder().nome("Cleuza").idade(70).renda(new BigDecimal(0)).build();
//			Pessoa pai = Pessoa.builder().nome("Carlos").idade(75).renda(new BigDecimal(500)).build();
//			Pessoa dependente = Pessoa.builder().nome("Andre").idade(75).renda(new BigDecimal(300)).build();
//			dependentes = new ArrayList<>();
//			dependentes.add(dependente);
//
//			Familia familia = Familia.builder().pai(pai).mae(mae).dependentes(dependentes).build();
//			familiaRepository.save(familia);
//
//
//
//			mae = Pessoa.builder().nome("Maria").idade(50).renda(new BigDecimal(300)).build();
//			pai = Pessoa.builder().nome("Jose").idade(55).renda(new BigDecimal(800)).build();
//			dependentes = new ArrayList<>();
//			dependente = Pessoa.builder().nome("Julio").idade(12).renda(new BigDecimal(0)).build();
//			dependentes.add(dependente);
//			dependente = Pessoa.builder().nome("Carol").idade(17).renda(new BigDecimal(500)).build();
//			dependentes.add(dependente);
//
//			familia = Familia.builder().pai(pai).mae(mae).dependentes(dependentes).build();
//			familiaRepository.save(familia);
//
//
//		};
//	}

}

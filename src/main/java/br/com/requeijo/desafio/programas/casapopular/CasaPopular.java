package br.com.requeijo.desafio.programas.casapopular;

import br.com.requeijo.desafio.programas.entity.Familia;
import br.com.requeijo.desafio.programas.entity.Pontuacao;

import java.util.List;

public interface CasaPopular {

	Familia cadastrarFamilia(Familia familia);
	
	List<Familia> recuperarFamilias();

	List<Pontuacao> pontuarFamilias();

}

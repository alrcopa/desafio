package br.com.requeijo.desafio.programas.casapopular;

import br.com.requeijo.desafio.programas.casapopular.pontuacao.ProcessaPontuacao;
import br.com.requeijo.desafio.programas.entity.Familia;
import br.com.requeijo.desafio.programas.entity.Pontuacao;
import br.com.requeijo.desafio.programas.repository.FamiliaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FamiliaSP implements CasaPopular {

	private final String ESTADO_SIGLA = "SP";

	private final FamiliaRepository familiaRepository;

	@Autowired
	private ProcessaPontuacao regraPontuacaoCasaPopular;

	@Override
	public Familia cadastrarFamilia(Familia familia) {
		return familiaRepository.save(familia);
	}

	@Override
	public List<Familia> recuperarFamilias() {
		return familiaRepository.findAll();
	}

	@Override
	public List<Pontuacao> pontuarFamilias() {

		return regraPontuacaoCasaPopular.processar(familiaRepository.findAll());

	}

}

package br.com.requeijo.desafio.programas.casapopular.service;

import br.com.requeijo.desafio.programas.casapopular.CasaPopular;
import br.com.requeijo.desafio.programas.entity.Familia;
import br.com.requeijo.desafio.programas.entity.Pontuacao;
import br.com.requeijo.desafio.programas.enums.CasaPopularType;
import br.com.requeijo.desafio.programas.factory.AbstractFactory;
import br.com.requeijo.desafio.programas.mapper.FamiliaMapper;
import br.com.requeijo.desafio.programas.mapper.PontuacaoMapper;
import br.com.requeijo.desafio.programas.model.FamiliaModel;
import br.com.requeijo.desafio.programas.model.PontuacaoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class CasaPopularService {
	
	@Autowired
	private AbstractFactory<CasaPopular, CasaPopularType> factory;

	private CasaPopular getCriar(CasaPopularType casaPopular) {
		return factory.criar(casaPopular);
	}
	
	public FamiliaModel cadastrarFamilia(CasaPopularType casaPopular, FamiliaModel familiaModel) {

		Familia familiaEntiy = this.getCriar(casaPopular).cadastrarFamilia(FamiliaMapper.toEntity(familiaModel));
		return FamiliaMapper.toModel(familiaEntiy);

	}

	public List<FamiliaModel> list(CasaPopularType casaPopular) {

		List<FamiliaModel> lista = this.getCriar(casaPopular).recuperarFamilias()
				.stream()
				.map(FamiliaMapper::toModel)
				.collect(Collectors.toList());

		return lista;
	}

	public List<PontuacaoModel> elegibilidade(CasaPopularType casaPopular) {

		System.out.println(this.getCriar(casaPopular).recuperarFamilias());

		List<Pontuacao> pontuacoes = this.getCriar(casaPopular).pontuarFamilias();

		List<PontuacaoModel> pontuacoesPorFamilia = pontuacoes.stream()
				.sorted((o1, o2) -> o1.getPontos().compareTo(o2.getPontos()))
				.map(PontuacaoMapper::toModel)
				.toList();

		return pontuacoesPorFamilia;
	}


}

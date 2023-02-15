package br.com.requeijo.desafio.programas.factory;

import br.com.requeijo.desafio.programas.casapopular.CasaPopular;
import br.com.requeijo.desafio.programas.enums.CasaPopularType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CasaPopularFactory implements AbstractFactory<CasaPopular, CasaPopularType> {
	
	@Autowired
	private ApplicationContext context;

	@Override
	public CasaPopular criar(CasaPopularType type) {
		return context.getBean(CasaPopularType.of(type).getType());
	}
}

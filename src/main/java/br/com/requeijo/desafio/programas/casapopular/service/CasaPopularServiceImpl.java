package br.com.requeijo.desafio.programas.casapopular.service;

import br.com.requeijo.desafio.programas.casapopular.CasaPopular;
import br.com.requeijo.desafio.programas.entity.Familia;
import br.com.requeijo.desafio.programas.entity.Pontuacao;
import br.com.requeijo.desafio.programas.enums.CasaPopularType;
import br.com.requeijo.desafio.programas.factory.AbstractFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CasaPopularServiceImpl implements CasaPopularService {

    @Autowired
    private AbstractFactory<CasaPopular, CasaPopularType> factory;

    private CasaPopular getCriar(CasaPopularType casaPopular) {
        return factory.criar(casaPopular);
    }

    public Familia cadastrarFamilia(CasaPopularType casaPopular, Familia familia) {
        return this.getCriar(casaPopular).cadastrarFamilia(familia);
    }

    public List<Familia> findAll(CasaPopularType casaPopular) {
        List<Familia> lista = this.getCriar(casaPopular).recuperarFamilias();
        return lista;
    }

    public List<Pontuacao> elegibilidade(CasaPopularType casaPopular) {

        List<Pontuacao> pontuacoes = this.getCriar(casaPopular).pontuarFamilias();
        return pontuacoes;
    }


}

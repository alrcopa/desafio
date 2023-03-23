package br.com.requeijo.desafio.programas.casapopular.pontuacao;

import br.com.requeijo.desafio.programas.entity.Familia;
import br.com.requeijo.desafio.programas.entity.Pontuacao;
import br.com.requeijo.desafio.programas.strategy.RegraPontuacaoDependente;
import br.com.requeijo.desafio.programas.strategy.RegraPontuacaoRenda;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcessaPontuacao {

    public List<Pontuacao> processar(final List<Familia> familias) {
        return familias.stream().map(this::obterPontuacao).toList();
    }

    private Pontuacao obterPontuacao(final Familia familia) {

        int pontuacaoTotal = 0;
        pontuacaoTotal += RegraPontuacaoRenda.REGRA_CINCO_PONTOS.pontuar(familia);
        pontuacaoTotal += RegraPontuacaoRenda.REGRA_TRES_PONTOS.pontuar(familia);
        pontuacaoTotal += RegraPontuacaoDependente.REGRA_TRES_DEPENDENTES.pontuar(familia);
        pontuacaoTotal += RegraPontuacaoDependente.REGRA_DOIS_DEPENDENTES.pontuar(familia);



        return Pontuacao.builder()
                .pontos(pontuacaoTotal)
                .familia(familia)
                .build();
    }
}

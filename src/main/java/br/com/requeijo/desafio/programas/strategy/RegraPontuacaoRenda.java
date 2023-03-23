package br.com.requeijo.desafio.programas.strategy;

import br.com.requeijo.desafio.programas.entity.Familia;

public enum RegraPontuacaoRenda implements PontuacaoStrategy {

    REGRA_CINCO_PONTOS { @Override public int pontuar(Familia valor) {
            return (valor.getRendaTotal().floatValue() <= 900.0) ? 5 : 0;
        }
    },

    REGRA_TRES_PONTOS { @Override public int pontuar(Familia valor) {
            return (valor.getRendaTotal().floatValue() > 900.0 && valor.getRendaTotal().floatValue() <= 1500.0) ? 3 : 0;
        }
    };



}
package br.com.requeijo.desafio.programas.strategy;

import br.com.requeijo.desafio.programas.entity.Familia;

public enum RegraPontuacaoDependente implements PontuacaoStrategy {

    REGRA_TRES_DEPENDENTES { @Override public int pontuar(Familia valor) {
            return (valor.getQuantidadeDeDependentesMenoresDe18anos() >= 3) ? 3 : 0;
        }
    },

    REGRA_DOIS_DEPENDENTES { @Override public int pontuar(Familia valor) {
            return (valor.getQuantidadeDeDependentesMenoresDe18anos() == 1 || valor.getQuantidadeDeDependentesMenoresDe18anos() == 2) ? 2 : 0;
        }
    };
}

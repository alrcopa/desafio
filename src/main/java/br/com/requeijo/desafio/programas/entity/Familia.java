package br.com.requeijo.desafio.programas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mae_id")
    private Pessoa mae;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pai_id")
    private Pessoa pai;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "dependentes_id", referencedColumnName = "id")
    private List<Pessoa> dependentes = new ArrayList<>();


    public BigDecimal getRendaTotal() {
        final var rendaPai = this.pai.getRenda();
        final var rendaMae = this.mae.getRenda();
        final var rendaTotalDependentes = this.dependentes.stream().map(Pessoa::getRenda).reduce(BigDecimal.ZERO, BigDecimal::add);

        return rendaPai.add(rendaMae).add(rendaTotalDependentes);
    }

    public Long getQuantidadeDeDependentesMenoresDe18anos() {
        return this.dependentes.stream().filter(pessoa -> pessoa.getIdade() < 18).count();
    }

}

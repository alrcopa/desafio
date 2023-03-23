package br.com.requeijo.desafio.programas.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mae_id")
    @NotNull
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
       return this.dependentes.stream().filter(pessoa ->  Period.between(pessoa.getDataNascimento(), LocalDate.now()).getYears() < 18).count();
    }

}

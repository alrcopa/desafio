package br.com.requeijo.desafio.programas.controller;

import br.com.requeijo.desafio.programas.casapopular.service.CasaPopularService;

import br.com.requeijo.desafio.programas.model.FamiliaModel;
import br.com.requeijo.desafio.programas.enums.CasaPopularType;
import br.com.requeijo.desafio.programas.model.PontuacaoModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/casapopular")
@AllArgsConstructor
public class CasaPopularController {

    private final CasaPopularService casaPopularService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public FamiliaModel cadastrar(@RequestBody @Valid @NotNull FamiliaModel familiaModel) {
        System.out.println(familiaModel);
        return casaPopularService.cadastrarFamilia(CasaPopularType.CASAPOPULAR_RJ, familiaModel);
    }

//    @GetMapping
//    public @ResponseBody List<FamiliaModel> list() {
//        return casaPopularService.list(CasaPopularType.CASAPOPULAR_RJ);
//    }

    @GetMapping
    public @ResponseBody List<PontuacaoModel> pontuacao() {
        System.out.println("PONTUACAO");
        return casaPopularService.elegibilidade(CasaPopularType.CASAPOPULAR_RJ);
    }
}

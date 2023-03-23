package br.com.requeijo.desafio.programas.controller;

import br.com.requeijo.desafio.programas.casapopular.service.CasaPopularService;
import br.com.requeijo.desafio.programas.casapopular.service.CasaPopularServiceImpl;

import br.com.requeijo.desafio.programas.dto.FamiliaDTO;
import br.com.requeijo.desafio.programas.enums.CasaPopularType;
import br.com.requeijo.desafio.programas.dto.PontuacaoDTO;
import br.com.requeijo.desafio.programas.mapper.FamiliaMapper;
import br.com.requeijo.desafio.programas.mapper.PontuacaoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/RJ/casapopular")
@AllArgsConstructor
public class CasaPopularController {

    private final CasaPopularService casaPopularService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public FamiliaDTO cadastrar(@RequestBody @Valid @NotNull FamiliaDTO familiaDTO) {
        System.out.println(familiaDTO);

        return FamiliaMapper.toModel(casaPopularService.cadastrarFamilia(CasaPopularType.CASAPOPULAR_RJ, FamiliaMapper.toEntity(familiaDTO)));
    }

//    @GetMapping
//    public @ResponseBody List<FamiliaModel> list() {
//        return casaPopularService.list(CasaPopularType.CASAPOPULAR_RJ);
//    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FamiliaDTO> findAll() {
        return casaPopularService
                .findAll(CasaPopularType.CASAPOPULAR_RJ)
                .stream()
                .map(FamiliaMapper::toModel)
                .collect(Collectors.toList());
    }

    @GetMapping
    public @ResponseBody List<PontuacaoDTO> pontuacao() {
        System.out.println("PONTUACAO");
        List<PontuacaoDTO> pontuacoesPorFamilia = casaPopularService.elegibilidade(CasaPopularType.CASAPOPULAR_RJ)
                .stream()
                .sorted((o1, o2) -> o1.getPontos().compareTo(o2.getPontos()))
                .map(PontuacaoMapper::toModel)
                .toList();
        return pontuacoesPorFamilia;
    }
}

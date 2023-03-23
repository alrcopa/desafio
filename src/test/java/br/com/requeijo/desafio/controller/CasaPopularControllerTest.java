package br.com.requeijo.desafio.controller;

import br.com.requeijo.desafio.programas.casapopular.service.CasaPopularService;
import br.com.requeijo.desafio.programas.entity.Familia;
import br.com.requeijo.desafio.programas.entity.Pessoa;
import br.com.requeijo.desafio.programas.enums.CasaPopularType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Tag("integration")
@WebMvcTest(controllers = CasaPopularControllerTest.class)
class CasaPopularControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CasaPopularService service;

    @BeforeEach
    void setUp() {

        Pessoa mae = Pessoa.builder().nome("Cleuza").dataNascimento(LocalDate.of(1955, 10, 15)).renda(new BigDecimal(0)).build();
        Pessoa pai = Pessoa.builder().nome("Carlos").dataNascimento(LocalDate.of(1960, 8, 2)).renda(new BigDecimal(500)).build();
        Pessoa dependente = Pessoa.builder().nome("Andre").dataNascimento(LocalDate.of(1990, 2, 5)).renda(new BigDecimal(300)).build();
        List<Familia> familias = List.of(new Familia(1L, mae, pai, List.of(dependente)));

        when(service.findAll(CasaPopularType.CASAPOPULAR_RJ)).thenReturn(familias);
    }

    @Test
    void shouldCreateFamily() throws Exception {
        this.mockMvc.perform(
                        post("/api/RJ/casapopular")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content("{\"mae\": {\"nome\": \"Cleuza\",\"dataNascimento\": \"1955-10-15\",\"renda\": 900.0},\"pai\": {\"nome\": \"Jose\",\"dataNascimento\": \"1960-08-02\",\"renda\": 300.0},\"dependentes\": [{\"nome\": \"Andre\",\"dataNascimento\": \"1990-02-05\",\"renda\": 0.0}]}"))
                .andExpect(status().isCreated());
    }

}

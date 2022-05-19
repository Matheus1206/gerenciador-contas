package br.com.bamt.organize.controller;

import br.com.bamt.organize.controller.dto.CompraDto;
import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.model.Estabelecimento;
import br.com.bamt.organize.model.repository.CompraRepository;
import br.com.bamt.organize.service.PesquisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "pesquisa", produces = MediaType.APPLICATION_JSON_VALUE)
public class PesquisaController {

    @Autowired
    private PesquisaService pesquisaService;

    @GetMapping("/data/{data}")
    public List<CompraDto> pesquisaPorData(@PathVariable String data){
        return pesquisaService.pesquisarPorData(data);
    }

    @GetMapping("/estabelecimento/{estabelecimento}")
    public List<CompraDto> pesquisaPorEstabelecimento(@PathVariable String estabelecimento){
       return pesquisaService.pesquisarPorEstabelecimento(estabelecimento);
    }

    @GetMapping("/tipoEstabelecimento/{tipoEstabelecimento}")
    public List<CompraDto> pesquisaPorTipoEstabelecimento(@PathVariable String tipoEstabelecimento){
        return pesquisaService.pesquisarPorTipoEstabelecimento(tipoEstabelecimento);
    }

    @GetMapping("/todas")
    public List<CompraDto> pesquisaTodasCompras(){
        return pesquisaService.pesquisarTodasAsCompras();
    }
}

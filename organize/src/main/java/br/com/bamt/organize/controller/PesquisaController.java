package br.com.bamt.organize.controller;

import br.com.bamt.organize.controller.dto.CompraDto;
import br.com.bamt.organize.service.PesquisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "pesquisa", produces = MediaType.APPLICATION_JSON_VALUE)
public class PesquisaController {

    @Autowired
    private PesquisaService pesquisaService;

    @GetMapping("/data/{data}")
    public ResponseEntity<List<CompraDto>> pesquisaPorData(@PathVariable String data){
        return pesquisaService.pesquisarPorData(data);
    }

    @GetMapping("/estabelecimento/{estabelecimento}")
    public ResponseEntity<List<CompraDto>> pesquisaPorEstabelecimento(@PathVariable String estabelecimento){
       return pesquisaService.pesquisarPorEstabelecimento(estabelecimento);
    }

    @GetMapping("/tipoEstabelecimento/{tipoEstabelecimento}")
    public ResponseEntity<List<CompraDto>> pesquisaPorTipoEstabelecimento(@PathVariable String tipoEstabelecimento){
        return pesquisaService.pesquisarPorTipoEstabelecimento(tipoEstabelecimento);
    }

    @GetMapping("/todas")
    public ResponseEntity<List<CompraDto>> pesquisaTodasCompras(){
        return pesquisaService.pesquisarTodasAsCompras();
    }
}

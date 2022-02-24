package br.com.bamt.organize.controller;

import br.com.bamt.organize.controller.dto.CompraDto;
import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.model.Estabelecimento;
import br.com.bamt.organize.model.repository.CompraRepository;
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
    private CompraRepository compraRepository;

    private List<Compra> lista;

    @GetMapping("/data/{data}")
    public List<CompraDto> pesquisaPorData(@PathVariable String data){
        lista = compraRepository.findByDataDaCompra(LocalDate.parse(data));
        return lista.stream().map(CompraDto::new).collect(Collectors.toList());
    }

    @GetMapping("/estabelecimento/{estabelecimento}")
    public List<CompraDto> pesquisaPorEstabelecimento(@PathVariable String estabelecimento){
        lista = compraRepository.findByNomeEstabelecimento(estabelecimento.toLowerCase(Locale.ROOT));
        return lista.stream().map(CompraDto::new).collect(Collectors.toList());
    }

    @GetMapping("/tipoEstabelecimento/{tipoEstabelecimento}")
    public List<CompraDto> pesquisaPorTipoEstabelecimento(@PathVariable String tipoEstabelecimento){
        lista = compraRepository.findByEstabelecimento(Estabelecimento.valueOf(tipoEstabelecimento.toUpperCase(Locale.ROOT)));
        return lista.stream().map(CompraDto::new).collect(Collectors.toList());
    }

    @GetMapping("/todas")
    public List<CompraDto> pesquisaTodasCompras(){
        lista = compraRepository.findAll();
        return lista.stream().map(CompraDto::new).collect(Collectors.toList());
    }
}

package br.com.bamt.organize.controller;

import br.com.bamt.organize.controller.dto.CompraDto;
import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.model.Estabelecimento;
import br.com.bamt.organize.model.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/data")
    public List<CompraDto> pesquisaPorData(@RequestParam(name = "data") String data){
        lista = compraRepository.findByDataDaCompra(LocalDate.parse(data));
        return lista.stream().map(CompraDto::new).collect(Collectors.toList());
    }

    @GetMapping("/estabelecimento")
    public List<CompraDto> pesquisaPorEstabelecimento(@RequestParam(name = "estabelecimento") String estabelecimento){
        lista = compraRepository.findByNomeEstabelecimento(estabelecimento.toLowerCase(Locale.ROOT));
        return lista.stream().map(CompraDto::new).collect(Collectors.toList());
    }

    @GetMapping("/tipoEstabelecimento")
    public List<CompraDto> pesquisaPorTipoEstabelecimento(@RequestParam(name = "tipoEstabelecimento") String tipoEstabelecimento){
        lista = compraRepository.findByEstabelecimento(Estabelecimento.valueOf(tipoEstabelecimento.toUpperCase(Locale.ROOT)));
        return lista.stream().map(CompraDto::new).collect(Collectors.toList());
    }

    @GetMapping("/todas")
    public List<CompraDto> pesquisaTodasCompras(){
        lista = compraRepository.findAll();
        return lista.stream().map(CompraDto::new).collect(Collectors.toList());
    }
}

package br.com.bamt.organize.controller;

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

@RestController
@RequestMapping(value = "pesquisa", produces = MediaType.APPLICATION_JSON_VALUE)
public class PesquisaController {

    @Autowired
    private CompraRepository compraRepository;

    private List<Compra> lista;

    @GetMapping("/data")
    public List<Compra> pesquisaPorData(@RequestParam(name = "data") String data){
        lista = compraRepository.findByDataDaCompra(LocalDate.parse(data));
        return lista;
    }

    @GetMapping("/estabelecimento")
    public List<Compra> pesquisaPorEstabelecimento(@RequestParam(name = "estabelecimento") String estabelecimento){
        lista = compraRepository.findByNomeEstabelecimento(estabelecimento.toLowerCase(Locale.ROOT));
        return lista;
    }

    @GetMapping("/tipoEstabelecimento")
    public List<Compra> pesquisaPorTipoEstabelecimento(@RequestParam(name = "tipoEstabelecimento") String tipoEstabelecimento){
        lista = compraRepository.findByEstabelecimento(Estabelecimento.valueOf(tipoEstabelecimento.toUpperCase(Locale.ROOT)));
        return lista;
    }

    @GetMapping("/todas")
    public List<Compra> pesquisaTodasCompras(){
        lista = compraRepository.findAll();
        return lista;
    }
}

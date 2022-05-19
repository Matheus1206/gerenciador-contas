package br.com.bamt.organize.service;

import br.com.bamt.organize.controller.dto.CompraDto;
import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.model.Estabelecimento;
import br.com.bamt.organize.model.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class PesquisaService {

    @Autowired
    private CompraRepository compraRepository;

    private List<Compra> lista;

    public List<CompraDto> pesquisarPorData(String data){
        lista = compraRepository.findByDataDaCompra(LocalDate.parse(data));
        return lista.stream().map(CompraDto::new).collect(Collectors.toList());
    }

    public List<CompraDto> pesquisarPorEstabelecimento(String estabelecimento) {
        lista = compraRepository.findByNomeEstabelecimento(estabelecimento.toLowerCase(Locale.ROOT));
        return lista.stream().map(CompraDto::new).collect(Collectors.toList());
    }

    public List<CompraDto> pesquisarPorTipoEstabelecimento(String tipoEstabelecimento) {
        lista = compraRepository.findByEstabelecimento(Estabelecimento.valueOf(tipoEstabelecimento.toUpperCase(Locale.ROOT)));
        return lista.stream().map(CompraDto::new).collect(Collectors.toList());
    }

    public List<CompraDto> pesquisarTodasAsCompras() {
        lista = compraRepository.findAll();
        return lista.stream().map(CompraDto::new).collect(Collectors.toList());
    }
}

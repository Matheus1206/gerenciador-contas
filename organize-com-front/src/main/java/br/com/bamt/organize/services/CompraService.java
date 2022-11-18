package br.com.bamt.organize.services;

import br.com.bamt.organize.controller.request.NovaCompraRequest;
import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.model.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public Compra cadastraNovaCompra(NovaCompraRequest novaCompraRequest) {
        Compra compra = novaCompraRequest.toCompra();
        compraRepository.save(compra);
        return compra;
    }

    public List<Compra> retornaTodasAsCompras() {
        return compraRepository.findAll();
    }

    public void excluirCompra(Long id) {
        Optional<Compra> compra = compraRepository.findById(id);
        compraRepository.delete(compra.get());
    }

    public Compra procuraComprPeloId(Long id) {
        Optional<Compra> compra = compraRepository.findById(id);
        return compra.get();
    }

    public void editarCompra(NovaCompraRequest novaCompraRequest) {
        Long id = Long.parseLong(novaCompraRequest.getId());
        Optional<Compra> compraAntiga = compraRepository.findById(id);
        compraAntiga.get().setNomeEstabelecimentoCompra(novaCompraRequest.getNomeEstabelecimentoCompra());
        compraAntiga.get().setDataCompra(LocalDate.parse(novaCompraRequest.getDataCompra()));
        compraAntiga.get().setValorCompra(Double.parseDouble(novaCompraRequest.getValorCompra()));
        compraAntiga.get().setTipoEstabelecimentoCompra(novaCompraRequest.getTipoEstabelecimentoCompra());
        compraRepository.save(compraAntiga.get());
    }
}

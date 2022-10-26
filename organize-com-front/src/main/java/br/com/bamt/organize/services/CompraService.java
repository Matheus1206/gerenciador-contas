package br.com.bamt.organize.services;

import br.com.bamt.organize.controller.request.NovaCompraRequest;
import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.model.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

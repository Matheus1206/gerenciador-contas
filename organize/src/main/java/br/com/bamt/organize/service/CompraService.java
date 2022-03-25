package br.com.bamt.organize.service;

import br.com.bamt.organize.controller.dto.CompraDto;
import br.com.bamt.organize.controller.form.NovaContaForm;
import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.model.Estabelecimento;
import br.com.bamt.organize.model.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public CompraDto salvaCompra(NovaContaForm novaContaForm) {
        Compra compra = novaContaForm.toCompra();
        System.out.println("SALVA" + novaContaForm.toString());
        compraRepository.save(compra);
        return new CompraDto(compra);
    }

    public CompraDto editaCompra(NovaContaForm novaContaForm, Long id) {
        Optional<Compra> compra = compraRepository.findById(id);
        compra.get().setNomeEstabelecimento(novaContaForm.getNomeEstabelecimento());
        compra.get().setDataDaCompra(LocalDate.parse(novaContaForm.getDataDaCompra()));
        compra.get().setValor(novaContaForm.getValor());
        compra.get().setEstabelecimento(Estabelecimento.valueOf(novaContaForm.getEstabelecimento().toUpperCase()));
        compra.get().setParcelado(novaContaForm.getParcelado());
        System.out.println("EDITA:" + novaContaForm.toString());
        return new CompraDto(compra.get());
    }
}

package br.com.bamt.organize.service;

import br.com.bamt.organize.controller.dto.CompraDto;
import br.com.bamt.organize.controller.form.NovaContaForm;
import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.model.Estabelecimento;
import br.com.bamt.organize.model.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public ResponseEntity<CompraDto> salvaCompra(NovaContaForm novaContaForm) {
        Compra compra = novaContaForm.toCompra();
        compraRepository.save(compra);
        return ResponseEntity.ok(new CompraDto(compra));
    }

    public ResponseEntity<CompraDto> editaCompra(NovaContaForm novaContaForm, Long id) {
        Optional<Compra> compra = compraRepository.findById(id);
        compra.get().setNomeEstabelecimento(novaContaForm.getNomeEstabelecimento());
        compra.get().setDataDaCompra(LocalDate.parse(novaContaForm.getDataDaCompra()));
        compra.get().setValor(novaContaForm.getValor());
        compra.get().setEstabelecimento(Estabelecimento.valueOf(novaContaForm.getEstabelecimento().toUpperCase()));
        compra.get().setParcelado(novaContaForm.getParcelado());
        return ResponseEntity.ok(new CompraDto(compra.get()));
    }

    public ResponseEntity<Compra> deletaCompra(Long id) {
        Optional<Compra> compra = compraRepository.findById(id);
        if(compra.isPresent()){
            compraRepository.delete(compra.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

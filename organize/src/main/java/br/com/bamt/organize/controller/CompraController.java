package br.com.bamt.organize.controller;

import br.com.bamt.organize.controller.dto.CompraDto;
import br.com.bamt.organize.controller.form.NovaContaForm;
import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.model.Estabelecimento;
import br.com.bamt.organize.model.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping(value = "compra", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @PostMapping("nova")
    @Transactional
    public CompraDto novaCompra(@RequestBody @Valid NovaContaForm novaContaForm){
        Compra compra = novaContaForm.toCompra();
        compraRepository.save(compra);
        return new CompraDto(compra);
    }

    @PostMapping("edita/{id}")
    @Transactional
    public CompraDto editaCompra(@RequestBody @Valid NovaContaForm novaContaForm, @PathVariable Long id){
        CompraDto compra = novaContaForm.atualizar(id, compraRepository);
        return compra;
    }

    @PostMapping("deleta/{id}")
    @Transactional
    public String deletaCompra(@PathVariable Long id){
        Optional<Compra> compra = compraRepository.findById(id);
        String nomeDaCompra = compra.get().getNomeEstabelecimento();
        compraRepository.delete(compra.get());
        return "A compra" + nomeDaCompra + "foi excluída com sucesso";
    }

    
}
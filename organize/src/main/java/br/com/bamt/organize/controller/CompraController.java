package br.com.bamt.organize.controller;

import br.com.bamt.organize.controller.dto.CompraDto;
import br.com.bamt.organize.controller.form.NovaContaForm;
import br.com.bamt.organize.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "compra", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompraController {
    @Autowired
    private CompraService compraService;

    @PostMapping("nova")
    @Transactional
    public ResponseEntity<CompraDto> salvarCompra(@RequestBody @Valid NovaContaForm novaContaForm){
        return compraService.salvaCompra(novaContaForm);
    }

    @PostMapping("edita/{id}")
    @Transactional
    public ResponseEntity<CompraDto> editarCompra(@RequestBody @Valid NovaContaForm novaContaForm, @PathVariable Long id){
        return compraService.editaCompra(novaContaForm, id);
    }

    @PostMapping("deleta/{id}")
    @Transactional
    public ResponseEntity<?> deletaCompra(@PathVariable Long id){
        return compraService.deletaCompra(id);
    }
}
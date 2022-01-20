package br.com.bamt.organize.controller;

import br.com.bamt.organize.controller.dto.CompraDto;
import br.com.bamt.organize.controller.form.NovaContaForm;
import br.com.bamt.organize.model.Compra;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping(value = "compra", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompraController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("nova")
    @Transactional
    public CompraDto novaCompra(@RequestBody NovaContaForm novaContaForm){
        Compra compra = novaContaForm.toCompra();
        manager.persist(compra);
        return new CompraDto(compra);
    }




}

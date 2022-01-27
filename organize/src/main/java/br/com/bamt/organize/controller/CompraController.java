package br.com.bamt.organize.controller;

import br.com.bamt.organize.controller.dto.CompraDto;
import br.com.bamt.organize.controller.form.NovaContaForm;
import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.model.repository.CompraRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "compra", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @PostMapping("nova")
    public CompraDto novaCompra(@RequestBody NovaContaForm novaContaForm){
        Compra compra = novaContaForm.toCompra();
        compraRepository.save(compra);
        return new CompraDto(compra);
    }

    @GetMapping("/pesquisaData")
    public List<Compra> pesquisaPorData(@RequestParam(name = "data") String data){
        List<Compra> lista = compraRepository.findByDataDaCompra(LocalDate.parse(data));
        return lista;
    }

}

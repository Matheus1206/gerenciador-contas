package br.com.bamt.organize.controller;

import br.com.bamt.organize.controller.dto.CompraDto;
import br.com.bamt.organize.controller.form.NovaContaForm;
import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.model.Estabelecimento;
import br.com.bamt.organize.model.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public CompraDto novaCompra(@RequestBody @Valid NovaContaForm novaContaForm){
        Compra compra = novaContaForm.toCompra();
        compraRepository.save(compra);
        return new CompraDto(compra);
    }

    @PostMapping("edita")
    public CompraDto editaCompra(@RequestBody NovaContaForm novaContaForm, @RequestParam Long id){
        Optional<Compra> compra = compraRepository.findById(id);

        //NECESSITA ALTERAR COMO ESSE MÉTODO FOI FEITO, POIS ELE NÃO ESTÁ PERFOMÁTICO
        compra.get().setDataDaCompra(LocalDate.parse(novaContaForm.getDataDaCompra()));
        compra.get().setEstabelecimento(Estabelecimento.valueOf(novaContaForm.getEstabelecimento().toUpperCase(Locale.ROOT)));
        compra.get().setParcelado(novaContaForm.getParcelado());
        compra.get().setValor(novaContaForm.getValor());
        compra.get().setNomeEstabelecimento(novaContaForm.getNomeEstabelecimento());
        CompraDto compraDto = new CompraDto(compra.get());
        compraRepository.save(compra.get());
        return compraDto;
    }

    @PostMapping("deleta")
    public String deletaCompra(@RequestParam Long id){
        Optional<Compra> compra = compraRepository.findById(id);
        String nomeDaCompra = compra.get().getNomeEstabelecimento();
        compraRepository.delete(compra.get());
        return "A compra" + nomeDaCompra + "foi excluída com sucesso";
    }

    
}
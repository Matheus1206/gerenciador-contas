package br.com.bamt.organize.controller;

import br.com.bamt.organize.controller.request.NovaCompraRequest;
import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping()
    public String novaCompra(){
        return "nova-compra";
    }

    @PostMapping("save")
    public String cadastrarNovaCompra(@Valid NovaCompraRequest novaCompraRequest, Model model){
        Compra compra  = compraService.cadastraNovaCompra(novaCompraRequest);
        model.addAttribute("compras", compra);
        return "redirect:listar";
    }

    @GetMapping("listar")
    public String listarTodasAsCompras(Model model){
        List<Compra> compras = compraService.retornaTodasAsCompras();
        model.addAttribute("compras", compras);
        return "lista-compra";
    }

    @GetMapping("excluir/{id}")
    public String excluirCompra(@PathVariable String id){
        compraService.excluirCompra(Long.parseLong(id));
        return "forward:/compra/listar";

    }

    @GetMapping("editar/{id}")
    public String pegaInformacoesDaCompraParaEditar(@PathVariable String id, Model model){
        Compra compra = compraService.procuraComprPeloId(Long.parseLong(id));
        model.addAttribute(compra);
        return "editar-compra";
    }

    @PostMapping("editar")
    public String editarCompra(@Valid NovaCompraRequest novaCompraRequest, Model model){
        compraService.editarCompra(novaCompraRequest);
        return "redirect:listar";
    }



}

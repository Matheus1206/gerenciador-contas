package br.com.bamt.organize.controller;

import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CompraService compraService;

    @GetMapping()
    public String carregaComprasIniciais(Model model){
        List<Compra> compra = compraService.retornaTodasAsCompras();
        model.addAttribute("compras", compra);
        return "index";
    }

    @GetMapping("/limite")
    public String definirLimite(){
        return "limite";
    }
}

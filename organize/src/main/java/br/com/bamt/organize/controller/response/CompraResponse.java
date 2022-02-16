package br.com.bamt.organize.controller.response;

import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.model.Estabelecimento;

import java.time.LocalDate;

public class CompraResponse {

    private String nomeEstabelecimento;
    private LocalDate dataDaCompra;
    private Double valor;
    private Estabelecimento estabelecimento;

    public CompraResponse(Compra compra) {
        this.nomeEstabelecimento = compra.getNomeEstabelecimento();
        this.dataDaCompra = compra.getDataDaCompra();
        this.valor = compra.getValor();
        this.estabelecimento = compra.getEstabelecimento();
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public LocalDate getDataDaCompra() {
        return dataDaCompra;
    }

    public Double getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }
}

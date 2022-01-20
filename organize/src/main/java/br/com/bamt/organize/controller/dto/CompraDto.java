package br.com.bamt.organize.controller.dto;

import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.model.Estabelecimento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CompraDto {

    private LocalDate dataDaCompra;
    private Double valor;
    private Estabelecimento estabelecimento;

    public CompraDto(Compra compra) {
        this.dataDaCompra = compra.getDataDaCompra();
        this.valor = compra.getValor();
        this.estabelecimento = compra.getEstabelecimento();
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

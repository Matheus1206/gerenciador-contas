package br.com.bamt.organize.controller.form;

import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.model.Estabelecimento;

import java.time.LocalDate;
import java.util.Locale;

public class NovaContaForm {

    private String nomeEstabelecimento;
    private String dataDaCompra;
    private Double valor;
    private String estabelecimento;
    private Boolean parcelado;

    public NovaContaForm(String nomeEstabelecimento, String dataDaCompra, Double valor, String estabelecimento, Boolean parcelado) {
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.dataDaCompra = dataDaCompra;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.parcelado = parcelado;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public String getDataDaCompra() {
        return dataDaCompra;
    }

    public Double getValor() {
        return valor;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public Boolean getParcelado() {
        return parcelado;
    }

    public Compra toCompra() {
        return new Compra(nomeEstabelecimento.toLowerCase(Locale.ROOT), LocalDate.parse(dataDaCompra), valor, Estabelecimento.valueOf(estabelecimento.toUpperCase(Locale.ROOT)), parcelado);
    }
}

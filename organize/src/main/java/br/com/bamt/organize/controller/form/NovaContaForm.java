package br.com.bamt.organize.controller.form;

import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.model.Estabelecimento;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Locale;

public class NovaContaForm {

    @NotBlank
    private String nomeEstabelecimento;
    @NotBlank
    private String dataDaCompra;
    @NotNull
    @Min(0)
    private Double valor;
    @NotBlank
    private String estabelecimento;

    private Boolean parcelado = false;

    public NovaContaForm(@NotNull String nomeEstabelecimento, @NotNull String dataDaCompra, @NotNull @Min(0) Double valor, @NotNull String estabelecimento, Boolean parcelado) {
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

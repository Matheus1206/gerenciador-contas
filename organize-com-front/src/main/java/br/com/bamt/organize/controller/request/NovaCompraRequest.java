package br.com.bamt.organize.controller.request;

import br.com.bamt.organize.model.Compra;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class NovaCompraRequest {

    private String idCompra;

    @NotBlank
    private String nomeEstabelecimentoCompra;
    @NotBlank
    private String dataCompra;
    @NotBlank
    private String valorCompra;
    @NotBlank
    private String tipoEstabelecimentoCompra;

    public String getId() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public String getNomeEstabelecimentoCompra() {
        return nomeEstabelecimentoCompra;
    }

    public void setNomeEstabelecimentoCompra(String nomeEstabelecimentoCompra) {
        this.nomeEstabelecimentoCompra = nomeEstabelecimentoCompra;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(String valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getTipoEstabelecimentoCompra() {
        return tipoEstabelecimentoCompra;
    }

    public void setTipoEstabelecimentoCompra(String tipoEstabelecimentoCompra) {
        this.tipoEstabelecimentoCompra = tipoEstabelecimentoCompra;
    }

    @Override
    public String toString() {
        return "Nome Estabelecimento: " + this.nomeEstabelecimentoCompra + "/n" + "Data da Compra: " + this.dataCompra + "/n" + "Valor da compra: " + this.valorCompra;
    }

    public Compra toCompra() {
        Compra compra = new Compra();
        compra.setNomeEstabelecimentoCompra(this.nomeEstabelecimentoCompra);
        compra.setDataCompra(LocalDate.parse(this.dataCompra));
        compra.setValorCompra(Double.parseDouble(this.valorCompra));
        compra.setTipoEstabelecimentoCompra(this.tipoEstabelecimentoCompra);
        return compra;
    }
}

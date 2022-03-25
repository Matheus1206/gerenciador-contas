package br.com.bamt.organize.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeEstabelecimento;
    private LocalDate dataDaCompra;
    private Double valor;
    @Enumerated(EnumType.STRING)
    private Estabelecimento estabelecimento;
    private Boolean parcelado;

    @Deprecated
    public Compra(){}

    public Compra(String nomeEstabelecimento, LocalDate dataDaCompra, Double valor, Estabelecimento estabelecimento, Boolean parcelado) {
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.dataDaCompra = dataDaCompra;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.parcelado = parcelado;
    }

    public LocalDate getDataDaCompra() {
        return this.dataDaCompra;
    }

    public void setDataDaCompra(LocalDate dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Boolean getParcelado() {
        return parcelado;
    }

    public void setParcelado(Boolean parcelado) {
        this.parcelado = parcelado;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }
}

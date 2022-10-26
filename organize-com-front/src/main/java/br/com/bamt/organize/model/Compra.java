package br.com.bamt.organize.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeEstabelecimentoCompra;
    private LocalDate dataCompra;
    private Double valorCompra;
    private String tipoEstabelecimentoCompra;


    public Compra(){

    }

    public Compra(String nomeEstabelecimentoCompra, LocalDate dataCompra, Double valorCompra, String tipoEstabelecimentoCompra) {
        this.nomeEstabelecimentoCompra = nomeEstabelecimentoCompra;
        this.dataCompra = dataCompra;
        this.valorCompra = valorCompra;
        this.tipoEstabelecimentoCompra = tipoEstabelecimentoCompra;
    }

    public String getNomeEstabelecimentoCompra() {
        return nomeEstabelecimentoCompra;
    }

    public void setNomeEstabelecimentoCompra(String nomeEstabelecimentoCompra) {
        this.nomeEstabelecimentoCompra = nomeEstabelecimentoCompra;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getTipoEstabelecimentoCompra() {
        return tipoEstabelecimentoCompra;
    }

    public void setTipoEstabelecimentoCompra(String tipoEstabelecimentoCompra) {
        this.tipoEstabelecimentoCompra = tipoEstabelecimentoCompra;
    }
}

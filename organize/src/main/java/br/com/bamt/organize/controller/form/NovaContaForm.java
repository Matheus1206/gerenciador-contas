package br.com.bamt.organize.controller.form;

import br.com.bamt.organize.controller.dto.CompraDto;
import br.com.bamt.organize.model.Compra;
import br.com.bamt.organize.model.Estabelecimento;
import br.com.bamt.organize.model.repository.CompraRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;

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

    public CompraDto atualizar(Long id, CompraRepository compraRepository) {
        Optional<Compra> compra = compraRepository.findById(id);
        compra.get().setNomeEstabelecimento(this.getNomeEstabelecimento());
        compra.get().setDataDaCompra(LocalDate.parse(this.getDataDaCompra()));
        compra.get().setValor(this.getValor());
        compra.get().setEstabelecimento(Estabelecimento.valueOf(this.getEstabelecimento().toUpperCase()));
        compra.get().setParcelado(this.getParcelado());
        return new CompraDto(compra.get());
    }
}

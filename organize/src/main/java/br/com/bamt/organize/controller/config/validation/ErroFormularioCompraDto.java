package br.com.bamt.organize.controller.config.validation;

public class ErroFormularioCompraDto {

    private String nomeCampo;
    private String mensagem;

    public ErroFormularioCompraDto(String nomeCampo, String mensagem){
        this.nomeCampo = nomeCampo;
        this.mensagem = mensagem;
    }

    public String getNomeCampo() {
        return nomeCampo;
    }

    public String getMensagem() {
        return mensagem;
    }
}

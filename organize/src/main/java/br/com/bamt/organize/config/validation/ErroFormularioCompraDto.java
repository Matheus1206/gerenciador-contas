package br.com.bamt.organize.config.validation;

public class ErroFormularioCompraDto {

    private String nomeCampo;
    private String mensagem;

    public ErroFormularioCompraDto(String nomeCampo, String mensagem){
        this.nomeCampo = nomeCampo;
        this.mensagem = mensagem;
    }

    public ErroFormularioCompraDto(String mensagem){
        this.mensagem = mensagem;
    }

    public String getNomeCampo() {
        return nomeCampo;
    }

    public String getMensagem() {
        return mensagem;
    }
}

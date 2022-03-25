package br.com.bamt.organize.config.validation;

public class ErroNenhumElementoDto {

    private String mensagem;


    public ErroNenhumElementoDto(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}

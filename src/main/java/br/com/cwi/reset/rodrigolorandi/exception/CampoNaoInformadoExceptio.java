package br.com.cwi.reset.rodrigolorandi.exception;

public class CampoNaoInformadoExceptio extends Exception {
    public CampoNaoInformadoExceptio(String campo) {
        super(String.format("Campo obrigatório não informado. Favor informar o campo %s.",campo));
    }
}


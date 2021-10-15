package br.com.cwi.reset.rodrigolorandi.exception;

public class NaoCadastrarNaoNacidosException extends Exception {
    public NaoCadastrarNaoNacidosException(String profissional) {
        super(String.format("Não é possível cadastrar %s não nascidos.", profissional));
    }
}


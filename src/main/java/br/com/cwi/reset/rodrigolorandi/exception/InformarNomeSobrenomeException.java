package br.com.cwi.reset.rodrigolorandi.exception;

public class InformarNomeSobrenomeException extends Exception{
    public InformarNomeSobrenomeException(String profissional) {
        super(String.format("Deve ser informado no mínimo nome e sobrenome para o %s", profissional));
    }
}

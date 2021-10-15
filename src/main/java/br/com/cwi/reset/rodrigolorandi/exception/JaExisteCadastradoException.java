package br.com.cwi.reset.rodrigolorandi.exception;

public class JaExisteCadastradoException extends Exception{
    public JaExisteCadastradoException(String profissional) {
        super(String.format("Já existe um ator cadastrado para o nome %s.", profissional));
    }
}

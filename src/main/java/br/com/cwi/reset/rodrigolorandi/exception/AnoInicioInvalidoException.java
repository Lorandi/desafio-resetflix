package br.com.cwi.reset.rodrigolorandi.exception;

public class AnoInicioInvalidoException extends Exception{
    public AnoInicioInvalidoException(String profissional) {
        super(String.format("Ano de início de atividade inválido para o %s cadastrado.", profissional));
    }
}

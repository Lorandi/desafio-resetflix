package br.com.cwi.reset.rodrigolorandi.exception;

public class ListaVaziaException extends Exception{
    public ListaVaziaException(String profissinal, String profissionais) {
        super(String.format("Nenhum %s cadastrado, favor cadastar %s.", profissinal, profissionais));
    }
}

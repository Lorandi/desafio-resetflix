package br.com.cwi.reset.rodrigolorandi.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ListaVaziaException extends Exception{
    public ListaVaziaException(String profissinal, String profissionais) {
        super(String.format("Nenhum %s cadastrado, favor cadastar %s.", profissinal, profissionais));
    }
}

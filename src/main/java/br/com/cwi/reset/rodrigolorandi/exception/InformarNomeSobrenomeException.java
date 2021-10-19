package br.com.cwi.reset.rodrigolorandi.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InformarNomeSobrenomeException extends Exception{
    public InformarNomeSobrenomeException(String profissional) {
        super(String.format("Deve ser informado no mínimo nome e sobrenome para o %s", profissional));
    }
}

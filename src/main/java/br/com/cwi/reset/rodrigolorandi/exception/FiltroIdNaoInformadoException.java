package br.com.cwi.reset.rodrigolorandi.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FiltroIdNaoInformadoException extends CampoNaoInformadoException {
    public FiltroIdNaoInformadoException() {
        super("id");

    }
}

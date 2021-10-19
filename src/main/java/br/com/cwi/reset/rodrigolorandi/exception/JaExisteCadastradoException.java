package br.com.cwi.reset.rodrigolorandi.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class JaExisteCadastradoException extends Exception{
    public JaExisteCadastradoException(String profissional) {
        super(String.format("Já existe um ator cadastrado para o nome %s.", profissional));
    }
}

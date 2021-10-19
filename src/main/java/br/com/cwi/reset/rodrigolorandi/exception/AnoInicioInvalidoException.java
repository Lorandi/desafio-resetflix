package br.com.cwi.reset.rodrigolorandi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AnoInicioInvalidoException extends Exception{
    public AnoInicioInvalidoException(String profissional) {
        super(String.format("Ano de início de atividade inválido para o %s cadastrado.", profissional));
    }
}

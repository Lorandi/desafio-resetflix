package br.com.cwi.reset.rodrigolorandi.exception;

public class InformarPeloMenosUmGeneroException extends Exception{
    public InformarPeloMenosUmGeneroException() {
        super("Deve ser informado pelo menos um gênero para o cadastro do filme.");
    }
}

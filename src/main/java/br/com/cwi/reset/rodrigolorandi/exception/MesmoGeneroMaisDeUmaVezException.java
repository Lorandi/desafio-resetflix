package br.com.cwi.reset.rodrigolorandi.exception;

public class MesmoGeneroMaisDeUmaVezException extends Exception{
    public MesmoGeneroMaisDeUmaVezException() {
        super("Não é permitido informar o mesmo gênero mais de uma vez para o mesmo filme.");
    }
}

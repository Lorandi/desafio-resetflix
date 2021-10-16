package br.com.cwi.reset.rodrigolorandi.exception;

public class ConsultarPeloIdException extends Exception{
    public ConsultarPeloIdException(String profissional, Integer id) {
        super(String.format("Nenhum %s encontrado com o parâmetro %i, favor verifique os parâmetros informados.", profissional, id));
    }
}

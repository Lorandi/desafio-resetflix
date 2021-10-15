package br.com.cwi.reset.rodrigolorandi.exception;

public class ConsultarAtorPeloIdException extends Exception{
    public ConsultarAtorPeloIdException(String profissional, Integer id) {
        super(String.format("Nenhum %s encontrado com o parâmetro %i, favor verifique os parâmetros informados.", profissional, id));
    }
}

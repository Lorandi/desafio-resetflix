package br.com.cwi.reset.rodrigolorandi.exception;

public class AtributosNaoCadastradosExcepcion extends Exception{
    public AtributosNaoCadastradosExcepcion(String atributo, Integer id) {
        super(String.format("Nenhum %s encontrado com o parâmetro id= %d, favor verifique os parâmetros informados.", atributo, id));
    }
}

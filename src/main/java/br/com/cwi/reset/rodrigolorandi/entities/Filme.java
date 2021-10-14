package br.com.cwi.reset.rodrigolorandi.entities;

import br.com.cwi.reset.rodrigolorandi.enums.Genero;

import java.util.List;

public class Filme {
    private static Integer sequence = 0;

    private Integer id;
    private String nome;
    private Integer anoLancamento;
    private String capaFilme;
    private List<Genero> generos;
    private Diretor diretor;
    private List<PersonagemAtor> personagens;
    private String resumo;

}

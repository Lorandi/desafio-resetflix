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

    public Filme(String nome, Integer anoLancamento, String capaFilme, List<Genero> generos, Diretor diretor, List<PersonagemAtor> personagens, String resumo) {
        this.id = sequence++;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.generos = generos;
        this.diretor = diretor;
        this.personagens = personagens;
        this.resumo = resumo;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getCapaFilme() {
        return capaFilme;
    }

    public void setCapaFilme(String capaFilme) {
        this.capaFilme = capaFilme;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public List<PersonagemAtor> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<PersonagemAtor> personagens) {
        this.personagens = personagens;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", anoLancamento=" + anoLancamento +
                ", capaFilme='" + capaFilme + '\'' +
                ", generos=" + generos +
                ", diretor=" + diretor +
                ", personagens=" + personagens +
                ", resumo='" + resumo + '\'' +
                '}';
    }
}
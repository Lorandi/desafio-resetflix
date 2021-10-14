package br.com.cwi.reset.rodrigolorandi.entities;

import br.com.cwi.reset.rodrigolorandi.enums.StatusAtividade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Estudio {
    private static Integer sequence = 0;

    private Integer id;
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
    private StatusAtividade statusAtividade;
    private String anoInicioAtividade;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Estudio(String nome, String descricao, LocalDate dataCriacao, StatusAtividade statusAtividade, String anoInicioAtividade) {
        this.id = sequence++;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.statusAtividade = statusAtividade;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public static Integer getSequence() {
        return sequence;
    }

    public static void setSequence(Integer sequence) {
        Estudio.sequence = sequence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public StatusAtividade getStatusAtividade() {
        return statusAtividade;
    }

    public void setStatusAtividade(StatusAtividade statusAtividade) {
        this.statusAtividade = statusAtividade;
    }

    public String getAnoInicioAtividade() {
        return anoInicioAtividade;
    }

    public void setAnoInicioAtividade(String anoInicioAtividade) {
        this.anoInicioAtividade = anoInicioAtividade;
    }

    @Override
    public String toString() {
        return "Estudio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", statusAtividade=" + statusAtividade +
                ", anoInicioAtividade='" + anoInicioAtividade + '\'' +
                '}';
    }
}

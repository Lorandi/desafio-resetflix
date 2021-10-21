package br.com.cwi.reset.rodrigolorandi.request;

import br.com.cwi.reset.rodrigolorandi.enums.StatusAtividade;

import java.time.LocalDate;

public class EstudioReques {
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
    private StatusAtividade statusAtividade;
    private Integer anoInicioAtividade;

    public EstudioReques(String nome, String descricao, LocalDate dataCriacao, StatusAtividade statusAtividade, Integer anoInicioAtividade) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.statusAtividade = statusAtividade;
        this.anoInicioAtividade = anoInicioAtividade;
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

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }

    public void setAnoInicioAtividade(Integer anoInicioAtividade) {
        this.anoInicioAtividade = anoInicioAtividade;
    }

    @Override
    public String toString() {
        return "Estudio{" +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", statusAtividade=" + statusAtividade +
                ", anoInicioAtividade='" + anoInicioAtividade + '\'' +
                '}';
    }
}

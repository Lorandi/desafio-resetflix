package br.com.cwi.reset.rodrigolorandi.entities;

import br.com.cwi.reset.rodrigolorandi.enums.StatusCarreira;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

public class Ator {
    private static Integer sequence = 0;

    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private StatusCarreira statusCarreira;
    private Integer anoInicioAtividade;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public Ator( String nome, String dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.id = sequence++;
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento,formatter);
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public void setStatusCarreira(StatusCarreira statusCarreira) {
        this.statusCarreira = statusCarreira;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }

    public void setAnoInicioAtividade(Integer anoInicioAtividade) {
        this.anoInicioAtividade = anoInicioAtividade;
    }

    @Override
    public String toString() {
        return "Ator{" +
                "Id='" + this.id + '\'' +
                "nome='" + this.nome + '\'' +
                ", dataNascimento=" + this.dataNascimento.format(formatter) +
                ", statusCarreira=" + this.statusCarreira +
                ", anoInicioAtividade='" + this.anoInicioAtividade + '\'' +
                '}';
    }
}

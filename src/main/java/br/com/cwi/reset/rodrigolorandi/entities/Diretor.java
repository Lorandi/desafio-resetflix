package br.com.cwi.reset.rodrigolorandi.entities;

import br.com.cwi.reset.rodrigolorandi.enums.StatusCarreira;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Diretor {
    private static Integer sequence = 0;

    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private String anoInicioAtividade;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public Diretor(String nome, String dataNascimento, StatusCarreira statusCarreira, String anoInicioAtividade) {
        this.id = sequence++;
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento,formatter);
        this.anoInicioAtividade = anoInicioAtividade;
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

    public String getAnoInicioAtividade() {
        return anoInicioAtividade;
    }

    public void setAnoInicioAtividade(String anoInicioAtividade) {
        this.anoInicioAtividade = anoInicioAtividade;
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "Id='" + this.id + '\'' +
                "nome='" + this.nome + '\'' +
                ", dataNascimento=" + this.dataNascimento.format(formatter) +
                ", anoInicioAtividade='" + this.anoInicioAtividade + '\'' +
                '}';
    }
}

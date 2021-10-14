package br.com.cwi.reset.rodrigolorandi.service;

import br.com.cwi.reset.rodrigolorandi.entities.Ator;
import br.com.cwi.reset.rodrigolorandi.enums.StatusCarreira;
import br.com.cwi.reset.rodrigolorandi.request.AtorRequest;

import java.time.LocalDate;

public class AtorService {

    private String nome;
    private LocalDate dataNascimento;
    private StatusCarreira statusCarreira;
    private Integer anoInicioAtividade;

    public void criarAtor(AtorRequest atorRequest){
        Ator ator = new Ator(atorRequest.getNome(),
                atorRequest.getDataNascimento(),
                atorRequest.getStatusCarreira(),
                atorRequest.getAnoInicioAtividade());

        fakeDatabase.persisteAtor(ator);
    }
}

package br.com.cwi.reset.rodrigolorandi.service;

import br.com.cwi.reset.rodrigolorandi.entities.Ator;
import br.com.cwi.reset.rodrigolorandi.entities.FakeDatabase;
import br.com.cwi.reset.rodrigolorandi.enums.StatusCarreira;
import br.com.cwi.reset.rodrigolorandi.request.AtorRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    private String nome;
    private LocalDate dataNascimento;
    private StatusCarreira statusCarreira;
    private Integer anoInicioAtividade;

    List<Ator> todosAtores = new ArrayList<>();

    public void criarAtor(AtorRequest atorRequest){
        Ator ator = new Ator(atorRequest.getNome(),
                atorRequest.getDataNascimento(),
                atorRequest.getStatusCarreira(),
                atorRequest.getAnoInicioAtividade());

        todosAtores.add(ator);
        fakeDatabase.persisteAtor(ator);
    }

    public List<Ator> listarAtoresEmAtividade(String filtroNome){
        for ( Ator ator : todosAtores){
            if(ator.getStatusCarreira() == StatusCarreira.EM_ATIVIDADE){
                System.out.println(ator);
            }
        }


    }


}

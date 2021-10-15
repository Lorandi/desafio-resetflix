package br.com.cwi.reset.rodrigolorandi.service;

import br.com.cwi.reset.rodrigolorandi.entities.Ator;
import br.com.cwi.reset.rodrigolorandi.entities.FakeDatabase;
import br.com.cwi.reset.rodrigolorandi.exception.*;
import br.com.cwi.reset.rodrigolorandi.request.AtorRequest;

import java.time.LocalDate;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarAtor( AtorRequest atorRequest) throws Exception {

        if(atorRequest.getNome() == null){
            throw new NomeNaoInformadoException();
        }

        if(atorRequest.getDataNascimento() == null){
            throw new DataNascimentoNaoInformadoException();
        }

        if(atorRequest.getStatusCarreira() == null){
            throw new StatusCarreiraNaoInformadoException();
        }

        if(atorRequest.getAnoInicioAtividade() == null){
            throw new AnoInicioAtividadeNaoInformadoException();
        }

        if (atorRequest.getNome().split(" ").length  < 2){
            throw new InformarNomeSobrenomeException("ator");
        }

        LocalDate hoje = LocalDate.now();

        if(atorRequest.getDataNascimento().isAfter(hoje)){
            throw new NaoCadastrarNaoNacidosException("atores");
        }

        Integer anoNascimento = atorRequest.getDataNascimento().getYear();

        if(atorRequest.getAnoInicioAtividade() < anoNascimento){
            throw new AnoInicioInvalidoException("ator");
        }

        List<Ator> atores = fakeDatabase.recuperaAtores();

        for(Ator atoresListados : atores){
            if(atoresListados.getNome().equalsIgnoreCase(atorRequest.getNome())){
                throw new JaExisteCadastradoException(atorRequest.getNome());
            }
        }

        Integer geraId = atores.size() + 1;

        Ator ator = new Ator(geraId, atorRequest.getNome(), atorRequest.getDataNascimento(),atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());
        fakeDatabase.persisteAtor(ator);

    }

}




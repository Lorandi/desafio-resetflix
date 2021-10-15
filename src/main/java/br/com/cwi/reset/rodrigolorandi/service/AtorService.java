package br.com.cwi.reset.rodrigolorandi.service;

import br.com.cwi.reset.rodrigolorandi.entities.Ator;
import br.com.cwi.reset.rodrigolorandi.entities.FakeDatabase;
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
            throw new Exception("Campo obrigatório não informado. Favor informar o campo nome.");
        }

        if(atorRequest.getDataNascimento() == null){
            throw new Exception("Campo obrigatório não informado. Favor informar o campo dataNascimento.");
        }

        if(atorRequest.getStatusCarreira() == null){
            throw new Exception("Campo obrigatório não informado. Favor informar o campo statusCarreira.");
        }

        if(atorRequest.getAnoInicioAtividade() == null){
            throw new Exception("Campo obrigatório não informado. Favor informar o campo inicioAtividade.");
        }

        if (atorRequest.getNome().split(" ").length  < 2){
            throw new Exception("Deve ser informado no mínimo nome e sobrenome para o ator.");
        }

        LocalDate hoje = LocalDate.now();

        if(atorRequest.getDataNascimento().isAfter(hoje)){
            throw new Exception("Não é possível cadastrar atores não nascidos.");
        }

        Integer anoNascimento = atorRequest.getDataNascimento().getYear();

        if(atorRequest.getAnoInicioAtividade() < anoNascimento){
            throw new Exception("Ano de início de atividade inválido para o ator cadastrado.");
        }

        List<Ator> atores = fakeDatabase.recuperaAtores();

        for(Ator atoresListados : atores){
            if(atoresListados.getNome().equalsIgnoreCase(atorRequest.getNome())){
                throw new Exception(String.format("Já existe um ator cadastrado para o nome %s.", atorRequest.getNome()));
            }
        }

        Integer geraId = atores.size() + 1;

        Ator ator = new Ator(geraId, atorRequest.getNome(), atorRequest.getDataNascimento(),atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());
        fakeDatabase.persisteAtor(ator);

    }

}




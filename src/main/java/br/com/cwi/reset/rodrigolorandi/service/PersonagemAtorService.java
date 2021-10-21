package br.com.cwi.reset.rodrigolorandi.service;

import br.com.cwi.reset.rodrigolorandi.entities.FakeDatabase;
import br.com.cwi.reset.rodrigolorandi.entities.PersonagemAtor;
import br.com.cwi.reset.rodrigolorandi.request.PersonagemRequest;

import java.util.ArrayList;
import java.util.List;

public class PersonagemAtorService {

    private FakeDatabase fakeDatabase;

    public PersonagemAtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void cadastrarPersonagemAtor(PersonagemRequest personagemRequest) throws Exception {

    }

    public List<PersonagemAtor> consultarPersonagemAtor(String nome) throws Exception {
        List<PersonagemAtor> personagens = new ArrayList<>();

        return personagens;
    }
}

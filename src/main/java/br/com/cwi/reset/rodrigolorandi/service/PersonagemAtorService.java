package br.com.cwi.reset.rodrigolorandi.service;

import br.com.cwi.reset.rodrigolorandi.entities.Ator;
import br.com.cwi.reset.rodrigolorandi.entities.FakeDatabase;
import br.com.cwi.reset.rodrigolorandi.entities.PersonagemAtor;
import br.com.cwi.reset.rodrigolorandi.exception.CanseiDeCriarExceptionCustomizadaException;
import br.com.cwi.reset.rodrigolorandi.request.PersonagemRequest;
import br.com.cwi.reset.rodrigolorandi.validator.PersonagemRequestCamposObrigatoriosValidator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonagemAtorService {

    private FakeDatabase fakeDatabase;
    private AtorService atorService;

    public PersonagemAtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
        this.atorService = new AtorService(fakeDatabase);
    }

    public PersonagemAtor cadastrarPersonagemAtor(PersonagemRequest personagemRequest) throws Exception {
        new PersonagemRequestCamposObrigatoriosValidator().accept(personagemRequest);

        final Integer idGerado = fakeDatabase.recuperaPersonagens().size() + 1;
        final Ator ator = atorService.consultarAtor(personagemRequest.getIdAtor());

        final PersonagemAtor personagemAtor = new PersonagemAtor(idGerado, ator, personagemRequest.getNomePersonagem(), personagemRequest.getDescricaoPersonagem(), personagemRequest.getTipoAtuacao());

        fakeDatabase.persistePersonagem(personagemAtor);

        return personagemAtor;
    }

    public List<PersonagemAtor> consultarPersonagemAtor(String nome) throws Exception {
        return fakeDatabase.recuperaPersonagens();
    }

    private void validarPersonagensAtoresFilme(final List<PersonagemRequest> personagens) throws Exception {
        if (personagens.isEmpty()) {
            throw new CanseiDeCriarExceptionCustomizadaException("Esta validação não estava nas regras.");
        }

        final Set<PersonagemRequest> personagemRequestSet = new HashSet<>();

        for (PersonagemRequest personagemRequest : personagens) {
            new PersonagemRequestCamposObrigatoriosValidator().accept(personagemRequest);

            /**
             * A linha: "if (personagemRequestSet.contains(personagemRequest))"
             *
             * Cai na implementação do Set abaixo
             * Implementação macro
             * https://docs.oracle.com/javase/7/docs/api/java/util/Set.html#contains(java.lang.Object)
             *
             * Que por sua vez chama o equals da classe da chave
             * Na prática:
             * PersonagemRequest.equals(PersonagemRequest);
             * {@link br.com.cwi.reset.josealencar.request.PersonagemRequest#equals(Object)}
             */
            if (personagemRequestSet.contains(personagemRequest)) {
                throw new CanseiDeCriarExceptionCustomizadaException("Não é permitido informar o mesmo ator/personagem mais de uma vez para o mesmo filme.");
            } else {
                personagemRequestSet.add(personagemRequest);
            }
        }
    }

    public List<PersonagemAtor> cadastrarPersonagensFilme(final List<PersonagemRequest> personagens) throws Exception {
        validarPersonagensAtoresFilme(personagens);

        final List<PersonagemAtor> personagensAtores = new ArrayList<>();

        for (PersonagemRequest request : personagens) {
            personagensAtores.add(cadastrarPersonagemAtor(request));
        }

        return personagensAtores;
    }
}
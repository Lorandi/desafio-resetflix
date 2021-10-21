package br.com.cwi.reset.rodrigolorandi.service;

import br.com.cwi.reset.rodrigolorandi.entities.*;
import br.com.cwi.reset.rodrigolorandi.enums.Genero;
import br.com.cwi.reset.rodrigolorandi.exception.AtributosNaoCadastradosExcepcion;
import br.com.cwi.reset.rodrigolorandi.exception.CampoNaoInformadoException;
import br.com.cwi.reset.rodrigolorandi.exception.JaExisteCadastradoException;
import br.com.cwi.reset.rodrigolorandi.request.FilmeRequest;
import br.com.cwi.reset.rodrigolorandi.request.PersonagemRequest;

import java.util.ArrayList;
import java.util.List;

public class FilmeService {

    private FakeDatabase fakeDatabase;
    private DiretorService diretorService;
    private EstudioService estudioService;
    private AtorService atorService;
    private PersonagemAtorService personagemAtorService;

    public FilmeService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
        this.diretorService = new DiretorService(fakeDatabase);
        this.estudioService = new EstudioService(fakeDatabase);
        this.atorService = new AtorService(fakeDatabase);
        this.personagemAtorService = new PersonagemAtorService(fakeDatabase);
    }

    public void criarFilme(FilmeRequest filmeRequest) throws Exception {
        if (filmeRequest.getNome() == null) {
            throw new CampoNaoInformadoException("nome");
        }
        if (filmeRequest.getAnoLancamento() == null) {
            throw new CampoNaoInformadoException("anoLancamento");
        }
        if (filmeRequest.getCapaFilme() == null) {
            throw new CampoNaoInformadoException("capaFilme");
        }
        if (filmeRequest.getGeneros() == null) {
            throw new CampoNaoInformadoException("generos");
        }
        if (filmeRequest.getIdDiretor() == null) {
            throw new CampoNaoInformadoException("idDiretor");
        }
        if (filmeRequest.getIdEstudio() == null) {
            throw new CampoNaoInformadoException("idEstudio");
        }
        if (filmeRequest.getResumo() == null) {
            throw new CampoNaoInformadoException("resumo");
        }
        if (filmeRequest.getPersonagens() == null) {
            throw new CampoNaoInformadoException("personagens");
        }

        List<Estudio> estudios = fakeDatabase.recuperaEstudios();
        Boolean estudioNaoListado = true;
        for (Estudio estudiosListados : estudios) {
            if (estudiosListados.getId().equals(filmeRequest.getIdEstudio())) {
                estudioNaoListado = false;
            }
        }
        if (estudioNaoListado) {
            throw new AtributosNaoCadastradosExcepcion("estúdio", filmeRequest.getIdEstudio());
        }

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();
        Boolean diretorNaoListado = true;
        for (Diretor diretoresListados : diretores) {
            if (diretoresListados.getId().equals(filmeRequest.getIdDiretor())) {
                estudioNaoListado = false;
            }
        }
        if (diretorNaoListado) {
            throw new AtributosNaoCadastradosExcepcion("diretor", filmeRequest.getIdDiretor());
        }

        List<Ator> atores = fakeDatabase.recuperaAtores();
        List<PersonagemRequest> personagens = filmeRequest.getPersonagens();
        Boolean atorListado = false;
        for (Ator atoresListados : atores) {
            for (PersonagemRequest request : personagens) {
                if (atoresListados.getId().equals(request.getIdAtor())) {
                    atorListado = true;
                }
                if (!atorListado) {
                    throw new AtributosNaoCadastradosExcepcion("ator", request.getIdAtor());
                }
            }
        }
    }

    public List<Filme> consultarFilmes(
            String nomeFilme,
            String nomeDiretor,
            String nomePersonagem,
            String nomeAtor) throws Exception {
        List<Filme> filmes = new ArrayList<>();

        return filmes;
    }
}




package br.com.cwi.reset.rodrigolorandi.service;

import br.com.cwi.reset.rodrigolorandi.entities.Ator;
import br.com.cwi.reset.rodrigolorandi.entities.AtorEmAtividade;
import br.com.cwi.reset.rodrigolorandi.entities.Estudio;
import br.com.cwi.reset.rodrigolorandi.entities.FakeDatabase;
import br.com.cwi.reset.rodrigolorandi.enums.StatusCarreira;
import br.com.cwi.reset.rodrigolorandi.exception.*;
import br.com.cwi.reset.rodrigolorandi.request.EstudioRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EstudioService {

    private FakeDatabase fakeDatabase;

    public EstudioService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {

        if (estudioRequest.getNome() == null) {
            throw new NomeNaoInformadoException();
        }

        if (estudioRequest.getDescricao() == null) {
            throw new CampoNaoInformadoException("descricao");
        }

        if (estudioRequest.getDataCriacao() == null) {
            throw new CampoNaoInformadoException("dataCriacao");
        }

        if (estudioRequest.getStatusAtividade() == null) {
            throw new CampoNaoInformadoException("statusAtividade");
        }

        LocalDate hoje = LocalDate.now();

        if (estudioRequest.getDataCriacao().isAfter(hoje)) {
            throw new DataCriacaoEstudioNoFuturoException();
        }

        List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        for (Estudio estudiosListados : estudios) {
            if (estudiosListados.getNome().equalsIgnoreCase(estudioRequest.getNome())) {
                throw new JaExisteCadastradoException("Estudio", estudioRequest.getNome());
            }
        }

        Integer geraId = estudios.size() + 1;

        Estudio estudio = new Estudio(geraId,estudioRequest.getNome(), estudioRequest.getDescricao(), estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade());
        fakeDatabase.persisteEstudio(estudio);
    }

    public Ator consultarAtor(Integer id) throws Exception {

        if( id == null){
            throw new FiltroIdNaoInformadoException();
        }

        List<Ator> atores = fakeDatabase.recuperaAtores();

        for (Ator ator : atores){
            if(ator.getId().equals(id)){
                return ator;
            }
        }
        throw new ConsultarPeloIdException("ator",id);
    }

    public List<Ator> consultarAtores() throws Exception {
        final List<Ator> atores = fakeDatabase.recuperaAtores();

        if (atores.isEmpty()) {
            throw new ListaVaziaException("ator", "atores");
        }

        return atores;
    }
}




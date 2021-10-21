package br.com.cwi.reset.rodrigolorandi.service;

import br.com.cwi.reset.rodrigolorandi.entities.*;
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
                throw new JaExisteCadastradoException("estudio", estudioRequest.getNome());
            }
        }

        Integer geraId = estudios.size() + 1;

        Estudio estudio = new Estudio(geraId,estudioRequest.getNome(), estudioRequest.getDescricao(), estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade());
        fakeDatabase.persisteEstudio(estudio);
    }


    public List<Estudio> consultarEstudios(String filtroNome) throws Exception {
        List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        if (estudios.isEmpty()) {
            throw new ListaVaziaException("estúdio", "estúdios");
        }

        List<Estudio> retorno = new ArrayList<>();

        if (filtroNome != null) {
            for (Estudio estudio : estudios) {
                boolean containsFilter = estudio.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                if (containsFilter) {
                    retorno.add(new Estudio(estudio.getId(), estudio.getNome(), estudio.getDescricao(), estudio.getDataCriacao(), estudio.getStatusAtividade()));
                }
            }
        } else {
            for (Estudio estudio : estudios) {
                retorno.add(new Estudio(estudio.getId(), estudio.getNome(), estudio.getDescricao(), estudio.getDataCriacao(), estudio.getStatusAtividade()));
            }
        }
        if (retorno.isEmpty()) {
            throw new FiltroNomeNaoEncontrado("Estúdio", filtroNome);
        }
        return retorno;
    }


    public Estudio consultarEstudio(Integer id) throws Exception {

        if( id == null){
            throw new FiltroIdNaoInformadoException();
        }

        List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        for (Estudio estudio : estudios){
            if(estudio.getId().equals(id)){
                return estudio;
            }
        }
        throw new ConsultarPeloIdException("estúdio",id);
    }

}




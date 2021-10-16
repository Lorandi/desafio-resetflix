package br.com.cwi.reset.rodrigolorandi.service;

import br.com.cwi.reset.rodrigolorandi.entities.Ator;
import br.com.cwi.reset.rodrigolorandi.entities.AtorEmAtividade;
import br.com.cwi.reset.rodrigolorandi.entities.FakeDatabase;
import br.com.cwi.reset.rodrigolorandi.enums.StatusCarreira;
import br.com.cwi.reset.rodrigolorandi.exception.*;
import br.com.cwi.reset.rodrigolorandi.request.AtorRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarAtor(AtorRequest atorRequest) throws Exception {

        if (atorRequest.getNome() == null) {
            throw new NomeNaoInformadoException();
        }

        if (atorRequest.getDataNascimento() == null) {
            throw new DataNascimentoNaoInformadoException();
        }

        if (atorRequest.getStatusCarreira() == null) {
            throw new StatusCarreiraNaoInformadoException();
        }

        if (atorRequest.getAnoInicioAtividade() == null) {
            throw new AnoInicioAtividadeNaoInformadoException();
        }

        if (atorRequest.getNome().split(" ").length < 2) {
            throw new InformarNomeSobrenomeException("ator");
        }

        LocalDate hoje = LocalDate.now();

        if (atorRequest.getDataNascimento().isAfter(hoje)) {
            throw new NaoCadastrarNaoNacidosException("atores");
        }

        Integer anoNascimento = atorRequest.getDataNascimento().getYear();

        if (atorRequest.getAnoInicioAtividade() < anoNascimento) {
            throw new AnoInicioInvalidoException("ator");
        }

        List<Ator> atores = fakeDatabase.recuperaAtores();

        for (Ator atoresListados : atores) {
            if (atoresListados.getNome().equalsIgnoreCase(atorRequest.getNome())) {
                throw new JaExisteCadastradoException(atorRequest.getNome());
            }
        }

        Integer geraId = atores.size() + 1;

        Ator ator = new Ator(geraId, atorRequest.getNome(), atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());
        fakeDatabase.persisteAtor(ator);
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {
        List<Ator> atoresCadastrados = fakeDatabase.recuperaAtores();

        if (atoresCadastrados.isEmpty()) {
            throw new ListaVaziaException("ator", "atores");
        }

        List<AtorEmAtividade> retorno = new ArrayList<>();

        if (filtroNome != null) {
            for (Ator ator : atoresCadastrados) {
                boolean containsFilter = ator.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                boolean emAtividade = StatusCarreira.EM_ATIVIDADE.equals(ator.getStatusCarreira());
                if (containsFilter && emAtividade) {
                    retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
                }
            }
        } else {
            for (Ator ator : atoresCadastrados) {
                boolean emAtividade = StatusCarreira.EM_ATIVIDADE.equals(ator.getStatusCarreira());
                if (emAtividade) {
                    retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
                }
            }
        }
        if (retorno.isEmpty()) {
            throw new FiltroNomeNaoEncontrado("Ator", filtroNome);
        }
        return retorno;
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




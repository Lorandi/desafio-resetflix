package br.com.cwi.reset.rodrigolorandi.service;
import br.com.cwi.reset.rodrigolorandi.entities.Diretor;
import br.com.cwi.reset.rodrigolorandi.entities.FakeDatabase;
import br.com.cwi.reset.rodrigolorandi.exception.*;
import br.com.cwi.reset.rodrigolorandi.request.DiretorRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws Exception {
        if (diretorRequest.getNome() == null) {
            throw new NomeNaoInformadoException();
        }

        if (diretorRequest.getDataNascimento() == null) {
            throw new DataNascimentoNaoInformadoException();
        }

        if (diretorRequest.getAnoInicioAtividade() == null) {
            throw new AnoInicioAtividadeNaoInformadoException();
        }

        if (diretorRequest.getNome().split(" ").length < 2) {
            throw new InformarNomeSobrenomeException("diretor");
        }

        LocalDate hoje = LocalDate.now();

        if (diretorRequest.getDataNascimento().isAfter(hoje)) {
            throw new NaoCadastrarNaoNacidosException("diretores");
        }

        Integer anoNascimento = diretorRequest.getDataNascimento().getYear();

        if (diretorRequest.getAnoInicioAtividade() < anoNascimento) {
            throw new AnoInicioInvalidoException("diretor");
        }

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        for (Diretor diretoresListados : diretores) {
            if (diretoresListados.getNome().equalsIgnoreCase(diretoresListados.getNome())) {
                throw new JaExisteCadastradoException(diretorRequest.getNome());
            }
        }

        Integer geraId = diretores.size() + 1;

        Diretor diretor = new Diretor(geraId, diretorRequest.getNome(), diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());

        fakeDatabase.persisteDiretor(diretor);
    }

    public List<Diretor> listarDiretores(String filtroNome) throws Exception {
        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        if (diretores.isEmpty()) {
            throw new ListaVaziaException("diretor", "diretores");
        }

        List<Diretor> retorno = new ArrayList<>();

        if (filtroNome != null) {
            for (Diretor diretor : diretores) {
                boolean containsFilter = diretor.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                if (containsFilter) {
                    retorno.add(new Diretor(diretor.getId(), diretor.getNome(), diretor.getDataNascimento(), diretor.getAnoInicioAtividade()));
                }
            }
        } else {
            for (Diretor diretor : diretores) {
                retorno.add(new Diretor(diretor.getId(), diretor.getNome(), diretor.getDataNascimento(), diretor.getAnoInicioAtividade()));
            }
        }
        if (retorno.isEmpty()) {
            throw new FiltroNomeNaoEncontrado("Diretor", filtroNome);
        }
        return retorno;
    }

    public Diretor consultarDiretor(final Integer id) throws Exception {
        if (id == null) {
            throw new FiltroIdNaoInformadoException();
        }

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        for (Diretor diretor : diretores) {
            if (diretor.getId().equals(id)) {
                return diretor;
            }
        }
        throw new ConsultarPeloIdException("diretor", id);
    }
}

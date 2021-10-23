package br.com.cwi.reset.rodrigolorandi.validator;

import br.com.cwi.reset.rodrigolorandi.exception.*;

import java.time.LocalDate;

public class BasicInfoRequiredValidator {

    public void accept(final String nome, final LocalDate dataNascimento, final Integer anoInicioAtividade) throws Exception {
        if (nome == null) {
            throw new NomeNaoInformadoException();
        }

        if (dataNascimento == null) {
            throw new DataNascimentoNaoInformadoException();
        }

        if (anoInicioAtividade == null) {
            throw new AnoInicioAtividadeNaoInformadoException();
        }

        if (nome.split(" ").length < 2) {
            throw new InformarNomeSobrenomeException("PERDI");
        }

        if (LocalDate.now().isBefore(dataNascimento)) {
            throw new NaoCadastrarNaoNacidosException("Perdi 3");
        }

        if (anoInicioAtividade <= dataNascimento.getYear()) {
            throw new AnoInicioInvalidoException("PERDI 2");
        }
    }
}
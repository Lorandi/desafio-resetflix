package br.com.cwi.reset.rodrigolorandi.exception;

public class FiltroNomeNaoEncontrado extends Exception {
    public FiltroNomeNaoEncontrado(String profissional, String filtro) {
        super(String.format("%s não encontrato com o filtro %s, favor informar outro filtro.", profissional, filtro));
    }
}

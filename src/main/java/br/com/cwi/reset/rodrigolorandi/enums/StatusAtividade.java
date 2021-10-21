package br.com.cwi.reset.rodrigolorandi.enums;

public enum StatusAtividade {

    EM_ATIVIDADE("Em atividade"),
    ENCERRADO("Encerrado");

    String value;

    StatusAtividade(String value) {
        this.value = value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}

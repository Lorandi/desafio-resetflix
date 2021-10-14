package br.com.cwi.reset.rodrigolorandi.enums;

public enum StatusCarreira {
    EM_ATIVIDADE("Em atividade"),
    APOSENTADO("Aposentado");

    String value;

    StatusCarreira(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

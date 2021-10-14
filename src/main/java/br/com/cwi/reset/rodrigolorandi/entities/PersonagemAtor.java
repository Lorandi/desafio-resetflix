package br.com.cwi.reset.rodrigolorandi.entities;


import br.com.cwi.reset.rodrigolorandi.enums.TipoAtuacao;


public class PersonagemAtor {

    private static Integer sequence = 0;

    private Integer id;
    private Ator ator;
    private String nomePersonagem;
    private String descricaoPersonagem;
    private TipoAtuacao tipoAtuacao;

    public PersonagemAtor(Ator ator, String nomePersonagem, String descricaoPersonagem, TipoAtuacao tipoAtuacao) {
        this.id = sequence++;
        this.ator = ator;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.tipoAtuacao = tipoAtuacao;
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public String getDescricaoPersonagem() {
        return descricaoPersonagem;
    }

    public void setDescricaoPersonagem(String descricaoPersonagem) {
        this.descricaoPersonagem = descricaoPersonagem;
    }

    public TipoAtuacao getTipoAtuacao() {
        return tipoAtuacao;
    }

    public void setTipoAtuacao(TipoAtuacao tipoAtuacao) {
        this.tipoAtuacao = tipoAtuacao;
    }

    @Override
    public String toString() {
        return "PersonagemAtor{" +
                "id=" + id +
                ", ator=" + ator +
                ", nomePersonagem='" + nomePersonagem + '\'' +
                ", descricaoPersonagem='" + descricaoPersonagem + '\'' +
                ", tipoAtuacao=" + tipoAtuacao +
                '}';
    }
}

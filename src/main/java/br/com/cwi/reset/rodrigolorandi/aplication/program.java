package br.com.cwi.reset.rodrigolorandi.aplication;

import br.com.cwi.reset.rodrigolorandi.entities.Ator;
import br.com.cwi.reset.rodrigolorandi.entities.Diretor;
import br.com.cwi.reset.rodrigolorandi.enums.StatusCarreira;

public class program {
    public static void main(String[] args) {
        Ator ator = new Ator( "Rodrivo", "18/03/1980", StatusCarreira.EM_ATIVIDADE, 1994);
        Ator ator2 = new Ator( "Pedro", "18/03/1980", StatusCarreira.EM_ATIVIDADE, 1994);
        Ator ator3 = new Ator( "Flavio", "18/03/1980", StatusCarreira.EM_ATIVIDADE, 1994);

        Diretor Diretor = new Diretor( "Rodrivo", "18/03/1980", StatusCarreira.EM_ATIVIDADE, 1994);
        Diretor Diretor2 = new Diretor( "Pedro", "18/03/1980", StatusCarreira.EM_ATIVIDADE, 1994);
        Diretor Diretor3 = new Diretor( "Flavio", "18/03/1980", StatusCarreira.EM_ATIVIDADE, 1994);

        System.out.println(ator);
        System.out.println(ator2);
        System.out.println(ator3);

        System.out.println(Diretor);
        System.out.println(Diretor2);
        System.out.println(Diretor3);
    }
}

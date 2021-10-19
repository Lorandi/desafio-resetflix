package br.com.cwi.reset.rodrigolorandi.controller;


import br.com.cwi.reset.rodrigolorandi.exception.CampoNaoInformadoException;
import br.com.cwi.reset.rodrigolorandi.exception.NomeNaoInformadoException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @GetMapping
    public String helloWorld() throws Exception {
        throw new NomeNaoInformadoException();
    }

//    @GetMapping
//    public String helloWorld() {
//        return "Minha API resetflix está UP!!!";
//    }
}

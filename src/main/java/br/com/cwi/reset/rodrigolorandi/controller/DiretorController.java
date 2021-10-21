package br.com.cwi.reset.rodrigolorandi.controller;

import br.com.cwi.reset.rodrigolorandi.entities.Ator;
import br.com.cwi.reset.rodrigolorandi.entities.AtorEmAtividade;
import br.com.cwi.reset.rodrigolorandi.entities.Diretor;
import br.com.cwi.reset.rodrigolorandi.entities.FakeDatabase;
import br.com.cwi.reset.rodrigolorandi.request.AtorRequest;
import br.com.cwi.reset.rodrigolorandi.request.DiretorRequest;
import br.com.cwi.reset.rodrigolorandi.service.AtorService;
import br.com.cwi.reset.rodrigolorandi.service.DiretorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private DiretorService diretorService;

    public DiretorController() {
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody DiretorRequest diretorRequest) throws Exception {
        this.diretorService.cadastrarDiretor(diretorRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Diretor> listarDiretores(String filtroNome) throws Exception {
        return this.diretorService.listarDiretores(filtroNome);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Diretor consultarDiretor(@PathVariable Integer id) throws Exception {
        return this.diretorService.consultarDiretor(id);
    }

}

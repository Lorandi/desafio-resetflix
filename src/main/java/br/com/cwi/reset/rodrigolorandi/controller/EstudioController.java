package br.com.cwi.reset.rodrigolorandi.controller;


import br.com.cwi.reset.rodrigolorandi.entities.Estudio;
import br.com.cwi.reset.rodrigolorandi.entities.FakeDatabase;
import br.com.cwi.reset.rodrigolorandi.request.EstudioRequest;
import br.com.cwi.reset.rodrigolorandi.service.EstudioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudios")
public class EstudioController {

    private EstudioService estudioService;

    public EstudioController() {
        this.estudioService = new EstudioService(FakeDatabase.getInstance());
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio(@RequestBody EstudioRequest estudioRequest) throws Exception {
        this.estudioService.criarEstudio(estudioRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Estudio> consultarEstudios(String filtroNome) throws Exception {
        return this.estudioService.consultarEstudios(filtroNome);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Estudio consultarEstudio(@PathVariable Integer id) throws Exception {
        return this.estudioService.consultarEstudio(id);
    }

}

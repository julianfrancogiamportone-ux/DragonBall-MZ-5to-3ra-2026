package dragonball.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dragonball.IService.IPeleadorService;
import dragonball.entidades.Peleador;

@RestController
@RequestMapping("/api/characters")

public class PeleadorController {
    @Autowired
    private IPeleadorService pService;

    @GetMapping
    public List<Peleador> getAllCharacters() {
        return pService.findAllCharacters();
    }

    @PostMapping
    public Peleador createCharacter(@RequestBody Peleador peleador) {
        return pService.saveCharacter(peleador);
    }

}

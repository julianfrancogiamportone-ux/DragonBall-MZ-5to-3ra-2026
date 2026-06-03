package dragonball.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dragonball.IService.IAtaqueService;
import dragonball.entidades.Ataque;



@RestController
@RequestMapping("/api/characters")

public class AtaqueController {

	@Autowired
    private IAtaqueService atService;

    @GetMapping
    public List<Ataque> getAllCharacters() {
        return atService.findAllCharacters();
    }

    @PostMapping
    public Ataque createCharacter(@RequestBody Ataque ataque) {
        return atService.saveCharacter(ataque);
    }
}

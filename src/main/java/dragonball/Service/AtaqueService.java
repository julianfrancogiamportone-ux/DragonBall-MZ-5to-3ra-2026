package dragonball.service;


import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import org.springframework.stereotype.Service;

import dragonball.IService.IAtaqueService;
import dragonball.entidades.Ataque;
import dragonball.repository.AtaqueRepository;


@Service
public class AtaqueService implements IAtaqueService {

	@Autowired
    private AtaqueRepository jRepository;

    public List<Ataque> findAllCharacters() {
        return jRepository.findAll();
    }

    public Ataque saveCharacter(Ataque ataque) {
        return jRepository.save(ataque);
    }
 
}
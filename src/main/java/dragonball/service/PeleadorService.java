package dragonball.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dragonball.entidades.Peleador;
import dragonball.repository.PeleadorRepository;
import dragonball.IService.IPeleadorService;

@Service

public class PeleadorService implements IPeleadorService {

    @Autowired
    private PeleadorRepository pRepository;

    public List<Peleador> findAllCharacters() {
        return pRepository.findAll(); 
    }

    public Peleador saveCharacter(Peleador peleador) {
        return pRepository.save(peleador);
    }

}

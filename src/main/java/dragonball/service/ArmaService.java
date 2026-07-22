package dragonball.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dragonball.IService.IArmaService;
import dragonball.entidades.Arma;

@Service
public class ArmaService implements IArmaService {
    @Autowired
    private ArmaRepository aRepository;
    public List<Arma> findAllArmas() {
        return aRepository.findAll();
    }
    public Arma saveArma(Arma arma) {
        return aRepository.save(arma);
    }

    @Override
    public List<Arma> getAllArmas() {
        return aRepository.findAll();
    }

    @Override
    public Arma createArma(Arma arma) {
        return aRepository.save(arma);
    }
}

interface ArmaRepository {
    List<Arma> findAll();
    Arma save(Arma arma);
}

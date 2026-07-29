package dragonball.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dragonball.IService.IArmaService;
import dragonball.entidades.Arma;
import dragonball.repository.ArmaRepository;

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
}
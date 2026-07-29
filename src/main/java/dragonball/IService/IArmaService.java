package dragonball.IService;
import java.util.List;
import dragonball.entidades.Arma;

public interface IArmaService {
    List<Arma> findAllArmas();
    Arma saveArma(Arma arma);
}

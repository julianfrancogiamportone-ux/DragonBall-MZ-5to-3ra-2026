package dragonball.IService;
import java.util.List;
import dragonball.entidades.Arma;

public interface IArmaService {
    List<Arma> getAllArmas();
    Arma createArma(Arma arma);
}

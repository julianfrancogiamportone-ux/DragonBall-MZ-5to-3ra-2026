package dragonball.IService;
import dragonball.entidades.Peleador;
import java.util.List;


public interface IPeleadorService {

	public List<Peleador> findAllCharacters();
    public Peleador saveCharacter(Peleador peleador);

}


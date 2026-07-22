package dragonball.IService;

import java.util.List;

import dragonball.entidades.Ataque;

public interface IAtaqueService  {

	public List<Ataque> findAllCharacters();
    public Ataque saveCharacter(Ataque ataque);
 
}

package dragonball.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dragonball.IService.IArmaService;
import dragonball.entidades.Arma;

@RestController
@RequestMapping("/api") 
public class ArmaController {
    @Autowired
    private IArmaService armaService;

    @GetMapping("/armas")
    public List<Arma> getAllArmas() {
        return armaService.getAllArmas();
    }

    @PostMapping("/armas")
    public Arma createArma(@RequestBody Arma arma) {
        return armaService.createArma(arma);
    }
}

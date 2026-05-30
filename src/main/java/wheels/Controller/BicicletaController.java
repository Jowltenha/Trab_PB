package wheels.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; // <-- Certifique-se de que esse import existe
import org.springframework.web.bind.annotation.RequestBody; // <-- Certifique-se de que esse import existe
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wheels.Classes.Bicicleta;
import wheels.Repository.BicicletaRepository;
import wheels.Status.StatusBicicleta;

import java.util.List;

@RestController
@RequestMapping("/bicicletas")
public class BicicletaController {

    @Autowired
    private BicicletaRepository bicicletaRepository;

    @GetMapping
    public List<Bicicleta> listarTodas() {
        return bicicletaRepository.findAll();
    }

    // VEJA SE ESTE METODO ESTÁ EXATAMENTE ASSIM:
    @PostMapping
    public Bicicleta cadastrar(@RequestBody Bicicleta novaBicicleta) {
        novaBicicleta.setStatus(StatusBicicleta.DISPONIVEL);
        return bicicletaRepository.save(novaBicicleta);
    }
}
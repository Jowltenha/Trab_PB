package wheels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // <-- Avisa que esta classe expõe endpoints HTTP e responde em formato JSON
@RequestMapping("/bicicletas") // <-- Define que qualquer requisição que comece com /bicicletas cai aqui
public class BicicletaController {

    @Autowired // <-- Pede ao Spring injetar o repositorio de forma automatica
    private BicicletaRepository bicicletaRepository;

    // Criando uma rota GET para listar todas as bicicletas
    // Endereço completo: http://localhost:8080/bicicletas
    @GetMapping
    public List<Bicicleta> listarTodas() {
        return bicicletaRepository.findAll();
    }

}

package wheels.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wheels.Classes.*;
import wheels.Repository.*;
import wheels.Status.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

    @Autowired
    private LocacaoRepository locacaoRepository;

    @Autowired
    private BicicletaRepository bicicletaRepository; // <-- Injetando para poder atualizar a bike

    @GetMapping
    public List<Locacao> listarTodas() {
        return locacaoRepository.findAll();
    }

    @PostMapping
    public Locacao abrirLocacao(@RequestBody Locacao novaLocacao) {
        novaLocacao.setStatus(StatusLocacao.EM_ANDAMENTO); // Ou o nome exato que estiver no seu Enum (ex: ATIVA)

        // 1. Buscar a bicicleta completa no banco para saber o estado atual dela
        Bicicleta bike = bicicletaRepository.findById(novaLocacao.getBicicleta().getId())
                .orElseThrow(() -> new RuntimeException("Bicicleta não encontrada"));

        // [Regra de negócio Extra]: Validar se ela já não está ocupada
        if (bike.getStatus() == StatusBicicleta.EM_USO) {
            throw new RuntimeException("Esta bicicleta já está em uso no momento!");
        }

        // 2. Modificar o status da bicicleta para EM_USO e salvar no banco
        bike.setStatus(StatusBicicleta.EM_USO);
        bicicletaRepository.save(bike);

        // 3. Configurar os dados da locação
        novaLocacao.setBicicleta(bike); // Associa a bike atualizada
        novaLocacao.setDataInicio(LocalDateTime.now());

        // 4. Salvar e retornar a locação
        return locacaoRepository.save(novaLocacao);
    }
}
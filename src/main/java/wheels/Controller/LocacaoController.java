package wheels.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wheels.Classes.Locacao;
import wheels.Repository.LocacaoRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

    @Autowired
    private LocacaoRepository locacaoRepository;

    @GetMapping
    public List<Locacao> listarTodas() {
        return locacaoRepository.findAll();
    }

    @PostMapping
    public Locacao abrirLocacao(@RequestBody Locacao novaLocacao) {
        // Define o momento exato do início do aluguel
        novaLocacao.setDataInicio(LocalDateTime.now());
        return locacaoRepository.save(novaLocacao);
    }
}

package wheels.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate; // <-- Importante
import wheels.Classes.*;
import wheels.Repository.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario novoUsuario) {
        // Verifica se o usuário enviou um endereço e se tem um CEP preenchido
        if (novoUsuario.getEndereco() != null && novoUsuario.getEndereco().getCep() != null) {
            String cep = novoUsuario.getEndereco().getCep().replace("-", ""); // Remove hífen se houver

            try {
                // Endereço da API pública ViaCEP
                String url = "https://viacep.com.br/ws/" + cep + "/json/";

                // O RestTemplate vai lá na internet, pega o JSON do ViaCEP e joga dentro da nossa classe Endereco!
                RestTemplate restTemplate = new RestTemplate();
                Endereco enderecoCompleto = restTemplate.getForObject(url, Endereco.class);

                if (enderecoCompleto != null && enderecoCompleto.getLogradouro() != null) {
                    // Preserva o CEP original enviado pelo usuário
                    novoUsuario.setEndereco(enderecoCompleto);
                }
            } catch (Exception e) {
                // Se a internet falhar ou o CEP não existir, ele apenas segue viagem com o que o usuário digitou
                System.out.println("Erro ao buscar CEP na API externa: " + e.getMessage());
            }
        }

        return usuarioRepository.save(novoUsuario);
    }
}

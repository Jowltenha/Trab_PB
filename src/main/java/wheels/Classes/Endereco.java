package wheels.Classes;

import jakarta.persistence.Embeddable;

@Embeddable // <-- Indica que esta classe pode ser embutida em outra tabela
public class Endereco {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    // Construtor vazio obrigatório para o JPA
    public Endereco() {
    }

    // Seu construtor existente...
    public Endereco(String cep, String logradouro, String bairro, String localidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    // Seus Getters, Setters e toString() existentes...
    public String getCep() { return cep; }
    public String getLogradouro() { return logradouro; }
    public String getBairro() { return bairro; }
    public String getLocalidade() { return localidade; }
    public String getUf() { return uf; }
}
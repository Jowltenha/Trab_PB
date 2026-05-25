public class Endereco {
    private String cep; // cep: "20040-002"
    private String logradouro; // nome da rua, avenida, etc... -> logradouro: "Avenida Rio Branco" (A rua)
    private String bairro; // bairro: "Centro"
    private String localidade; // Cidade -> localidade: "Rio de Janeiro" (A cidade)
    private String uf; // Unidade da Federação -> uf: "RJ" (O estado)

    public Endereco(String cep, String logradouro, String bairro, String localidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    // Getters e Setters
    public String getCep() { return cep; }
    public String getLogradouro() { return logradouro; }
    public String getBairro() { return bairro; }
    public String getLocalidade() { return localidade; }
    public String getUf() { return uf; }

    @Override
    public String toString() {
        return logradouro + ", " + bairro + " - " + localidade + "/" + uf + " (CEP: " + cep + ")";
    }
}
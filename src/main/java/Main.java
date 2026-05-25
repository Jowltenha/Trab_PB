public class Main {
    public static void main(String[] args) {
        // Fluxo que você já tinha
        Usuario u = new Usuario("João Pedro", "123", "joao@email.com");
        Bicicleta b = new Bicicleta(1, "Wilier Montegrappa");
        Locacao loc = new Locacao(u, b);
        System.out.println("Locação iniciada para: " + loc.getUsuario().getNome());

        System.out.println("\n--- [TP4] SIMULAÇÃO DA FEATURE: BUSCA CEP ---");

        // 1. Instanciando o serviço de busca
        ViaCepService viaCepService = new ViaCepService();
        String cepDigitado = "20000-000";

        System.out.println("Usuário " + u.getNome() + " solicitou atualização de endereço para o CEP: " + cepDigitado);

        try {
            // 2. Chamando o método projetado (vai disparar a UnsupportedOperationException)
            Endereco end = viaCepService.buscarEnderecoPorCep(cepDigitado);
            u.setEndereco(end);
        } catch (UnsupportedOperationException e) {
            // 3. Capturando o comportamento para provar que o fluxo foi mapeado
            System.out.println("[Simulação] Fluxo de chamada interceptado com sucesso!");
            System.out.println("[Mensagem do Sistema]: " + e.getMessage());
        }

        System.out.println("--------------------------------------------");
    }
}
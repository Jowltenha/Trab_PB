package wheels;

import java.time.LocalDateTime;

public class Locacao {
    private Usuario usuario;
    private Bicicleta bicicleta;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private double valor;
    private StatusLocacao status; // <- NOVO ATRIBUTO UTILIZANDO O ENUM

    public Locacao(Usuario usuario, Bicicleta bicicleta) {
        this.usuario = usuario;
        this.bicicleta = bicicleta;
        this.dataInicio = LocalDateTime.now();
        this.status = StatusLocacao.EM_ANDAMENTO; // <- TODA LOCAÇÃO INICIA "EM ANDAMENTO"

        // Boa prática: ao iniciar uma locação, o status da bicicleta muda para EM_USE
        this.bicicleta.setStatus(StatusBicicleta.EM_USO);
    }

    // <- NOVO MÉTODO PARA FINALIZAR A LOCAÇÃO COM SEGURANÇA
    public void finalizarLocacao(double valorCobrado) {
        this.dataFim = LocalDateTime.now();
        this.valor = valorCobrado;
        this.status = StatusLocacao.CONCLUIDA; // <- MUDA O STATUS COM ENUM

        // Libera a bicicleta novamente
        this.bicicleta.setStatus(StatusBicicleta.DISPONIVEL);
    }

    // Getters e Setters existentes[cite: 3]
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Bicicleta getBicicleta() { return bicicleta; }
    public void setBicicleta(Bicicleta bicicleta) { this.bicicleta = bicicleta; }

    public LocalDateTime getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDateTime dataInicio) { this.dataInicio = dataInicio; }

    public LocalDateTime getDataFim() { return dataFim; }
    public void setDataFim(LocalDateTime dataFim) { this.dataFim = dataFim; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    // <- NOVOS GETTER E SETTER PARA O ENUM
    public StatusLocacao getStatus() { return status; }
    public void setStatus(StatusLocacao status) { this.status = status; }
}
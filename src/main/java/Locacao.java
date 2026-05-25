import java.time.LocalDateTime;

public class Locacao {
    private Usuario usuario;
    private Bicicleta bicicleta;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private double valor;

    public Locacao(Usuario usuario, Bicicleta bicicleta) {
        this.usuario = usuario;
        this.bicicleta = bicicleta;
        this.dataInicio = LocalDateTime.now();
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }
    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    // Métodos para finalizar locação e calcular valor

}
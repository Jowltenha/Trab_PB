package wheels.Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.time.LocalDateTime;

@Entity // <-- Cria a tabela 'locacao' no SQLite
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // <-- Chave primária da locação

    @ManyToOne // <-- Relacionamento: Muitas locações para Um usuário
    @JoinColumn(name = "usuario_id") // <-- Cria a coluna 'usuario_id' como chave estrangeira
    private Usuario usuario;

    @ManyToOne // <-- Relacionamento: Muitas locações para Uma bicicleta
    @JoinColumn(name = "bicicleta_id") // <-- Cria a coluna 'bicicleta_id' como chave estrangeira
    private Bicicleta bicicleta;

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private double valor;

    // Construtor vazio obrigatório para o JPA
    public Locacao() {
    }

    // Seu construtor existente (vamos garantir que a data de início seja gravada agora)
    public Locacao(Usuario usuario, Bicicleta bicicleta) {
        this.usuario = usuario;
        this.bicicleta = bicicleta;
        this.dataInicio = LocalDateTime.now();
    }

    // Getters e Setters para o ID novo
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    // Outros Getters e Setters abaixo (getUsuario, getBicicleta, etc.)...
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
}
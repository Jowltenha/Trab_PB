package wheels;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity // <-- Avisa ao Spring que esta classe vai virar uma tabela no SQLite
public class Bicicleta {

    @Id // <-- Define que este campo é a Chave Primária (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // <-- Faz o ID ser auto-incremento (1, 2, 3...)
    private int id;

    private String modelo;

    @Enumerated(EnumType.STRING) // <-- Salva o Enum como Texto no banco (ex: "DISPONIVEL") em vez de números
    private StatusBicicleta status;

    // CONSTRUTOR VAZIO: Obrigatório para o bom funcionamento do banco de dados JPA
    public Bicicleta() {
    }

    // Seu construtor existente
    public Bicicleta(int id, String modelo) {
        this.id = id;
        this.modelo = modelo;
        this.status = StatusBicicleta.DISPONIVEL;
    }

    // Getters e Setters existentes
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public StatusBicicleta getStatus() { return status; }
    public void setStatus(StatusBicicleta status) { this.status = status; }
}
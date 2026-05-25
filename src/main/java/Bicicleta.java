public class Bicicleta {
    private int id;
    private String modelo;
    private StatusBicicleta status;

    public Bicicleta(int id, String modelo) {
        this.id = id;
        this.modelo = modelo;
        this.status = StatusBicicleta.DISPONIVEL;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public StatusBicicleta getStatus() {
        return status;
    }
    public void setStatus(StatusBicicleta status) {
        this.status = status;
    }
}
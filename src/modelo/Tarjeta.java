package modelo;

public class Tarjeta {
    int limite;

    public Tarjeta(int limite) {
        this.limite = limite;
    }

    public int getLimite() {
        return limite;
    }

    public void disminuirLimite(int cantidad){
        this.limite = limite-cantidad;
    }
}

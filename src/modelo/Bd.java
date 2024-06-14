package modelo;

import java.util.ArrayList;

public class Bd {
    ArrayList<Producto> productos;
    Tarjeta tarjeta;
    ArrayList<Producto> comprasRealizadas;

    private static Bd instance;

    private Bd() {
        productos = new ArrayList<>();
        productos.add(new Producto("Arroz",1200));
        productos.add(new Producto("Azucar",4000));
        productos.add(new Producto("Pollo",1800));
        this.tarjeta = new Tarjeta(10000);
        this.comprasRealizadas = new ArrayList<>();
    }

    public static Bd getInstance() {
        if (instance == null) {
            instance = new Bd();
        }
        return instance;
    }

    //region Getters y Setters
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public ArrayList<Producto> getComprasRealizadas() {
        return comprasRealizadas;
    }

    public void setComprasRealizadas(ArrayList<Producto> comprasRealizadas) {
        this.comprasRealizadas = comprasRealizadas;
    }

    //endregion
}

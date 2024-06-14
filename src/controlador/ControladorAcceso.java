package controlador;

import modelo.Bd;
import modelo.Producto;
import modelo.Tarjeta;

import java.util.ArrayList;

public class ControladorAcceso {
    Bd bd;

    public ControladorAcceso() {
        this.bd = Bd.getInstance();
    }


    //Get Arrays
    public ArrayList<Producto> getProductos(){
        return this.bd.getProductos();
    }

    public ArrayList<Producto> getComprasRealizadas(){
        return bd.getComprasRealizadas();
    }

    //Utilidades
    public int getLimiteTarjeta(){
        return this.bd.getTarjeta().getLimite();
    }

    public Producto getProductoById(int idProducto){
        return this.getProductos().get(idProducto);
    }

    public void disminuirLimite(int pCantidad){
        this.bd.getTarjeta().disminuirLimite(pCantidad);
    }

}

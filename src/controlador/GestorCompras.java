package controlador;

import modelo.Producto;

public class GestorCompras {
    private ControladorAcceso controladorAcceso;

    public GestorCompras(ControladorAcceso controladorAcceso) {
        this.controladorAcceso = controladorAcceso;
    }

    public boolean realizarCompra(int pIndexProducto){
        Producto productoAComprar = this.controladorAcceso.getProductoById(pIndexProducto);
        int limiteTarjeta = this.controladorAcceso.getLimiteTarjeta();
        int precioProducto = productoAComprar.getPrecio();

        if(limiteTarjeta >= precioProducto){
            controladorAcceso.getComprasRealizadas().add(productoAComprar);
            controladorAcceso.disminuirLimite(precioProducto);
            return true;
        }else
            return false;
    }



}

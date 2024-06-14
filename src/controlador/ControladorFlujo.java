package controlador;

import modelo.Bd;
import modelo.Producto;
import vista.VistaPrincipal;

public class ControladorFlujo {
    VistaPrincipal vistaPrincipal;
    ControladorAcceso controladorAcceso;

    GestorMenus gestorMenus;
    GestorCompras gestorCompras;

    public ControladorFlujo() {
        controladorAcceso = new ControladorAcceso();
        this.vistaPrincipal = new VistaPrincipal(this);

        this.gestorMenus = new GestorMenus(controladorAcceso, this.vistaPrincipal);
        this.gestorCompras = new GestorCompras(controladorAcceso);

    }

    public void iniciarApp(){
        this.gestorMenus.mostrarMenuPrincipal();
    }

    public void procesarOpcionMenuPrincipal(int pOpcion) {
        int numeroProductos = this.controladorAcceso.getProductos().size();
        int pIndexProducto = pOpcion -1;

        if(pOpcion <= numeroProductos){
            //Si entra quiere decir que el cliente está escogiendo comprar un producto
            Boolean compraRealizada = this.gestorCompras.realizarCompra(pIndexProducto);
            if(compraRealizada){
                this.vistaPrincipal.imprimir("Compra realizada con exito.");
            }else {
                this.vistaPrincipal.imprimir("Limite insuficiente");
            }
            this.gestorMenus.mostrarMenuPrincipal();

        } else if (pOpcion == numeroProductos+1) {
            this.gestorMenus.mostrarMenuCompras();
        } else if (pOpcion == numeroProductos+2) {
            this.vistaPrincipal.imprimir("Gracias por utilizar nuestros servicios...");
        } else {
            //No presionó una opción valida. Volver.
            this.vistaPrincipal.imprimir("Debe elegir una opcion valida");
            this.gestorMenus.mostrarMenuPrincipal();
        }
    }

    public void procesarOpcionMenuCompras(int pOpcion) {
        if(pOpcion == 0){
            this.gestorMenus.mostrarMenuPrincipal();
        }else {
            this.vistaPrincipal.imprimir("Debe seleccionar una Opcion valida = 0");
            this.gestorMenus.mostrarMenuCompras();
        }
    }

}

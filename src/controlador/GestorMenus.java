package controlador;

import vista.VistaPrincipal;

public class GestorMenus {
    VistaPrincipal vistaPrincipal;
    ControladorAcceso controladorAcceso;

    public GestorMenus(ControladorAcceso controladorAcceso, VistaPrincipal pVistaPrincipal) {
        this.vistaPrincipal = pVistaPrincipal;
        this.controladorAcceso = controladorAcceso;
    }

    public void mostrarMenuPrincipal(){
        this.vistaPrincipal.mostrarMenuPrincipal(this.controladorAcceso.getLimiteTarjeta(),this.controladorAcceso.getProductos());
    }

    public void mostrarMenuCompras() {
        this.vistaPrincipal.mostrarMenuCompras(this.controladorAcceso.getComprasRealizadas());
    }
}

package vista;

import controlador.ControladorFlujo;
import modelo.Producto;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class VistaPrincipal {
    ControladorFlujo controladorFlujo;

    public VistaPrincipal(ControladorFlujo pControladorFlujo) {
        this.controladorFlujo = pControladorFlujo;
    }

    public void mostrarMenuPrincipal(int pLimiteTarjeta, ArrayList<Producto> pProductos ) {
        int numeroProducto = 1;
        imprimir("Limite de tarjeta: %d", pLimiteTarjeta);
        imprimir("*** Compre productos ***");
        imprimir("");

        for (Producto producto: pProductos){
            imprimir("%d - Producto: %s Precio: %d",numeroProducto, producto.getNombre(),producto.getPrecio());
            numeroProducto++;
        }
        imprimir("%d - Mostrar Compras",numeroProducto);numeroProducto++;
        imprimir("%d - Salir",numeroProducto);

        this.controladorFlujo.procesarOpcionMenuPrincipal(this.pedirOpcion("Escoja su opcion: "));
    }

    public void mostrarMenuCompras(ArrayList<Producto> pProductosComprados) {
        imprimir("*** Productos comprados ***");
        for (Producto producto: pProductosComprados){
            imprimir("Producto: %s Precio: %d", producto.getNombre(),producto.getPrecio());
        }
        this.controladorFlujo.procesarOpcionMenuCompras(pedirOpcion("0 - Volver: "));
    }


    public String pedirCadena(String pMensaje){
        Scanner teclado = new Scanner(System.in);
        imprimirInLine(pMensaje);
        return teclado.nextLine();
    }

    public int pedirOpcion(String pMensaje){
        Scanner teclado = new Scanner(System.in);
        imprimirInLine(pMensaje);
        return teclado.nextInt();
    }

    public void imprimir(String format, Object... args) {
        System.out.printf(format, args);
        System.out.println("");
    }

    public void imprimirInLine(String format, Object... args){
        System.out.printf(format, args);
    }


}

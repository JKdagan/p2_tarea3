package tarea3_GUI;

import tarea3_logica.*;

import javax.swing.*;
import java.awt.*;

import static tarea3_GUI.PanelExpDinero.labelVuelto;

//Panel que representará al Expendedor
public class PanelExpendedor extends JPanel {
    //Consta de 3 Paneles que representaran:
    private static PanelExpDinero panel_dinero;//el dinero de la maquina y el vuelto que suelta
    private static PanelExpProductos panel_productos_expendedor;//los productos que hay con sus precios y cantidades disponibles
    private static PanelExpCompra panel_producto_comprado;//un deposito en donde llega el producto seleccionado luego de una compra exitosa
    //Un Color para colocar en algun fondo de algun panel
    Color color1= new Color(36, 203, 32);
    //Constructor por defecto;le añadimos los 3 Paneles nombrados arriba en orden cada uno en una fila que aplicamos con el GridLayout
    /*@param color, es un Color que se le añadira al PanelExpendedor
     */
    public PanelExpendedor(Color color) {
        super();
        this.panel_dinero = new PanelExpDinero(Color.PINK);
        this.panel_productos_expendedor = new PanelExpProductos(Color.magenta);
        this.panel_producto_comprado = new PanelExpCompra(color1);

        this.add(panel_dinero);
        this.add(panel_productos_expendedor);
        this.add(panel_producto_comprado);

        this.setBackground(color);
        this.setSize(100,100);
        this.setLayout(new GridLayout(3,1));

    }
    //Metodo que actualiza las Monedas que están en el Expendedor
    public static void updateLabelMonedasPagadas() {
        panel_dinero.labelMonedasPagadas.setText("Monto ingresado: " + PanelPrincipal.expendedor.getPago());
    }

}

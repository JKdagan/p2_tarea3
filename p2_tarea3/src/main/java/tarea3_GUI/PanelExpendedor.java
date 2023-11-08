package tarea3_GUI;

import tarea3_logica.*;

import javax.swing.*;
import java.awt.*;

import static tarea3_GUI.PanelExpDinero.labelVuelto;


public class PanelExpendedor extends JPanel {
    private static PanelExpDinero panel_ingreso_dinero;
    private static PanelExpProductos panel_productos_expendedor;
    private static PanelExpCompra panel_producto_comprado;
    Color color1= new Color(224,99,180);
    public PanelExpendedor(Color color) {
        super();
        this.panel_ingreso_dinero = new PanelExpDinero(Color.PINK);
        this.panel_productos_expendedor = new PanelExpProductos(Color.magenta);
        this.panel_producto_comprado = new PanelExpCompra(color1);

        this.add(panel_ingreso_dinero);
        this.add(panel_productos_expendedor);
        this.add(panel_producto_comprado);

        this.setBackground(color);
        this.setSize(100,100);
        this.setLayout(new GridLayout(3,1));

    }

    public static void updateLabelMonedasPagadas() {
        panel_ingreso_dinero.labelMonedasPagadas.setText("Monto ingresado: " + PanelPrincipal.expendedor.getPago());
    }

    public static void actualizarVuelto(int vuelto) {
        labelVuelto.setText("Vuelto: " + vuelto);
    }
}

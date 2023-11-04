package tarea3_GUI;

import tarea3_logica.Expendedor;

import javax.swing.*;
import java.awt.*;


public class PanelExpendedor extends JPanel {
    private PanelExpDinero panel_ingreso_dinero;
    private PanelExpProductos panel_productos_expendedor;
    private PanelExpCompra panel_producto_comprado;
    private Expendedor expendedor;

    public PanelExpendedor(Color color, Expendedor expendedor) {
        super();
        this.panel_ingreso_dinero = new PanelExpDinero(Color.orange);
        this.panel_productos_expendedor = new PanelExpProductos(Color.magenta,expendedor);
        this.panel_producto_comprado = new PanelExpCompra(Color.blue);
        this.expendedor = expendedor;

        this.add(panel_ingreso_dinero);
        this.add(panel_productos_expendedor);
        this.add(panel_producto_comprado);

        this.setBackground(color);
        this.setSize(100,100);
        this.setLayout(new GridLayout(3,1));

    }

}

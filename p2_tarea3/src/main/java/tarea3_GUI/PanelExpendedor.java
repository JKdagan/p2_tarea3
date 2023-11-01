package tarea3_GUI;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private PanelExpCompra producto_comprado;
    private PanelExpDinero dinero;
    private PanelExpProductos productos;

    public PanelExpendedor(Color color) {
        super();
        this.producto_comprado = new PanelExpCompra(Color.blue);
        this.dinero= new PanelExpDinero(Color.orange);
        this.productos= new PanelExpProductos(Color.magenta);
        this.add(producto_comprado);
        this.add(dinero);
        this.add(productos);

        this.setBackground(color);
        this.setSize(100,100);
        this.setLayout(new GridLayout(3,1));
    }

}

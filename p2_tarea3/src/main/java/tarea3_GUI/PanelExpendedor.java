package tarea3_GUI;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private PanelExpCompra productocomprado;
    private PanelExpDinero dinero;
    private PanelExpProductos productos;

    public PanelExpendedor() {
        super();
    }
    public PanelExpendedor(Color color) {
        super();
        productocomprado= new PanelExpCompra(Color.blue);
        dinero= new PanelExpDinero(Color.orange);
        productos=new PanelExpProductos(Color.magenta);
        this.add(productocomprado);
        this.add(dinero);
        this.add(productos);

        this.setBackground(color);
        this.setSize(100,100);
        this.setLayout(new GridLayout(3,1));
    }

}

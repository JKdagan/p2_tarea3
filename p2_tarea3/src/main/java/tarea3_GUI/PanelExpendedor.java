package tarea3_GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;


public class PanelExpendedor extends JPanel {
    private PanelExpDinero dinero;
    private PanelExpProductos productos;
    private PanelExpCompra productocomprado;


    public PanelExpendedor(Color color) {
        super();

        this.dinero= new PanelExpDinero(Color.orange);
        this.productos=new PanelExpProductos(Color.magenta);
        this.productocomprado= new PanelExpCompra(Color.blue);

        this.add(dinero);
        this.add(productos);
        this.add(productocomprado);

        this.setBackground(color);
        this.setSize(100,100);
        this.setLayout(new GridLayout(3,1));

    }


}

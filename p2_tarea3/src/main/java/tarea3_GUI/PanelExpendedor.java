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

            dinero= new PanelExpDinero(Color.orange);
            productos=new PanelExpProductos(Color.magenta);
            productocomprado= new PanelExpCompra(Color.blue);
            this.setLayout(new GridLayout(3,1));

            this.add(dinero);
            this.add(productos);
            this.add(productocomprado);

            this.setBackground(color);


        }


}

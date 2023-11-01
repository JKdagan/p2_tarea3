package tarea3_GUI;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    public PanelComprador(Color color){
        super();
        this.setBackground(color);
        this.setSize(100,100);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //mi idea es colocar una imagen de una persona, una vez se haya entregado el producto comprado(PanelExpProducto) se añade una imagen del producto al lado de la imagen de la persona
    }




}

package tarea3_GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class PanelExpProductos extends JPanel {

    public PanelExpProductos(Color color) {
        this.setBackground(color);

        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton boton1 = new JButton("1. CocaCola");
        JButton boton2 = new JButton("2. Sprite");
        JButton boton3 = new JButton("3. Fanta");
        JButton boton4 = new JButton("4. Super8");
        JButton boton5 = new JButton("5. Snickers");

        botonesPanel.add(boton1);
        botonesPanel.add(boton2);
        botonesPanel.add(boton3);
        botonesPanel.add(boton4);
        botonesPanel.add(boton5);

        this.add(botonesPanel);










    }


}

package tarea3_GUI;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana(String titulo, int width, int height, boolean visible){

        super();
        this.setLayout(new BorderLayout());
        this.setTitle(titulo);

        PanelPrincipal panel= new PanelPrincipal(Color.white);

        this.setResizable(false);
        this.setVisible(visible);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}

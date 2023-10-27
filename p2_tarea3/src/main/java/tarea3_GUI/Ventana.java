package tarea3_GUI;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana() {
        super();
        this.setVisible(true);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }//por defecto si no paso parametros
    public Ventana(String titulo, int width, int height, boolean visible){

        super();
        this.setLayout(new BorderLayout());
        this.setTitle(titulo);
        this.setVisible(visible);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

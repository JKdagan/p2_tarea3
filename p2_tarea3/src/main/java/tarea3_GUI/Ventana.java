package tarea3_GUI;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private PanelPrincipal panelPrincipal;

    public Ventana(String titulo, int width, int height, boolean visible, Color color_fondo){

        super();
        this.setLayout(new BorderLayout());
        this.setTitle(titulo);

        this.add(new PanelPrincipal(Color.black));

        this.setVisible(visible);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

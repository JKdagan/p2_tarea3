package tarea3_GUI;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    PanelPrincipal panel_principal;
    public Ventana(){
        super();
        this.setTitle("Tarea3");
        this.setLayout(new BorderLayout());
        this.setSize(1500, 800);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel_principal = new PanelPrincipal(Color.white);
        this.add(panel_principal);
    }
}

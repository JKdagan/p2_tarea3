package tarea3_GUI;

import javax.swing.*;
import java.awt.*;
//Ventana que se abra apenas empiece a correr el main, en esta se verá nuestro programa
public class Ventana extends JFrame {
    //PanelPrincipal que le asignaremos a la ventana
    PanelPrincipal panel_principal;
    //Constructor por defecto; le ponemos titulo, un Layout, que al cerrar la ventana se termine el programa y le añadimos el PanelPrincipal
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

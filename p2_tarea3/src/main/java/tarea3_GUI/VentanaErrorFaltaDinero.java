package tarea3_GUI;

import javax.swing.*;
import java.awt.*;

public class VentanaErrorFaltaDinero extends JFrame {
    public VentanaErrorFaltaDinero(String title){
        super();
        this.setLayout(new BorderLayout());
        title="PagoInsuficienteException";
        this.setTitle(title);
        this.setSize(1200, 600);
    }
}

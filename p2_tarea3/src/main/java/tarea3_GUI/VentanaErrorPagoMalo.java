package tarea3_GUI;

import javax.swing.*;
import java.awt.*;

public class VentanaErrorPagoMalo extends JFrame {
    public VentanaErrorPagoMalo(String title){
        super();
        this.setLayout(new BorderLayout());
        title="PagoIncorrectoException";
        this.setTitle(title);
        this.setSize(1200, 600);
    }
}

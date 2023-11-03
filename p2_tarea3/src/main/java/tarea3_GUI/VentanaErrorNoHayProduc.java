package tarea3_GUI;

import javax.swing.*;
import java.awt.*;

public class VentanaErrorNoHayProduc extends JFrame {
    public VentanaErrorNoHayProduc(String title){
        super();
        this.setLayout(new BorderLayout());
        title="NoHayProductosException";
        this.setTitle(title);
        this.setSize(1200, 600);
    }
}

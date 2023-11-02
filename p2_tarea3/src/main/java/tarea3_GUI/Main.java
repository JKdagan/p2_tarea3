package tarea3_GUI;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Ventana ventana= new Ventana("Tarea3",1500,800,true);
        PanelPrincipal panel= new PanelPrincipal(Color.white);
        ventana.add(panel);
    }
}
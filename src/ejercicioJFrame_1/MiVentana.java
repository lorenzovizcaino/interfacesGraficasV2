package ejercicioJFrame_1;

import javax.swing.*;

public class MiVentana extends JFrame {
    private static int contador=0;
    private static int x=0;
    private static int y=0;

    public MiVentana() {
        contador ++;
        setSize(450,300);
        setLocation(x,y);
        setTitle("Ventana "+contador);
        x+=100;
        y+=100;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }
}

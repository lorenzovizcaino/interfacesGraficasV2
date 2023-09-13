package escribiendomarco;

import javax.swing.*;
import java.awt.*;

public class EscribiendoEnMarco {
    public static void main(String[] args) {
        MarcoTexto marcoTexto=new MarcoTexto();
        marcoTexto.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
}

class MarcoTexto extends JFrame{
    public MarcoTexto(){
        setBounds(400,200,600,450);
        setTitle("Escritura en JFrame");
        //añadir lamina al marco
        PrimerPanel primerPanel=new PrimerPanel();
        add(primerPanel);
        setVisible(true);
    }
}

class PrimerPanel extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Primer Panel",20,20);
    }
}

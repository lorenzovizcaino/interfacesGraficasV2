package primeralamina;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MiVentana miVentana=new MiVentana();

    }
}

class MiVentana extends JFrame {
    public MiVentana(){
        setBounds(200,200,400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Mi primera Lamina");
        MiLamina miLamina=new MiLamina();
        add(miLamina);
        setVisible(true);
    }

}

class MiLamina extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color color=new Color(255,128,155);
        g.setColor(color);
        Font font=new Font("Verdana",Font.BOLD,15);
        g.setFont(font);
        g.drawString("Mi primera Lamina",20,20);
    }
}

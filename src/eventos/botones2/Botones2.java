package eventos.botones2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botones2 {
    public static void main(String[] args) {
        Marco marco=new Marco();
    }
}

class Marco extends JFrame{
    public Marco(){
        setBounds(100,100,450,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Lamina lamina=new Lamina();
        add(lamina);
        setVisible(true);
    }
}
class Lamina extends JPanel  {
    JButton botonAzul=new JButton("Azul");
    JButton botonRojo=new JButton("Rojo");
    JButton botonAmarillo=new JButton("Amarillo");

    public Lamina(){

        add(botonAzul);
        add(botonRojo);
        add(botonAmarillo);
        ColorFondo Azul=new ColorFondo(Color.BLUE);
        ColorFondo Rojo=new ColorFondo(Color.RED);
        ColorFondo Amarillo=new ColorFondo(Color.YELLOW);
        botonAzul.addActionListener(Azul);
        botonRojo.addActionListener(Rojo);
        botonAmarillo.addActionListener(Amarillo);

    }

    //CLASE INTERNA
    private class ColorFondo implements ActionListener{
        private Color colorDeFondo;

        public ColorFondo(Color colorDeFondo) {
            this.colorDeFondo = colorDeFondo;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setBackground(colorDeFondo);

        }
    }







}



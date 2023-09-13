package eventos.primerBoton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Boton {
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
class Lamina extends JPanel implements ActionListener {
    JButton botonAzul=new JButton("Azul");
    JButton botonRojo=new JButton("Rojo");
    JButton botonAmarillo=new JButton("Amarillo");

    public Lamina(){

        add(botonAzul);
        add(botonRojo);
        add(botonAmarillo);
        botonAzul.addActionListener(this);
        botonRojo.addActionListener(this);
        botonAmarillo.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object objeto=e.getSource();
        if(objeto==botonAzul){
            setBackground(Color.BLUE);
        } else if (objeto==botonRojo) {
            setBackground(Color.RED);
        }else{
            setBackground(Color.YELLOW);
        }

    }
}
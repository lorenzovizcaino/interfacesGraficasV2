package aulaenlanube.ejemplos.ejemplosMIOS;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class textAreaConDrawString {
    public static void main(String[] args) {
        new VentanaDrawString();
    }
}

class VentanaDrawString extends JFrame{
    public VentanaDrawString(){
        setBounds(100,100,300,200);
        LaminaDrawString laminaDrawString=new LaminaDrawString();
        add(laminaDrawString);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class LaminaDrawString extends JPanel{


    JButton boton;
    String frase="Frase a Mostrar";
    int contador=0;
    Color colorSelecionado=Color.BLACK;
    boolean presionarBoton=false;



    public LaminaDrawString(){
        setLayout(new BorderLayout());
        Panel panel=new Panel();
        add(panel,BorderLayout.CENTER);
        boton=new JButton("Boton");
        add(boton,BorderLayout.SOUTH);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelecionado=JColorChooser.showDialog(null,"Introducir Color",colorSelecionado);
                presionarBoton=true;
               repaint();
            }

        });


    }

    private class Panel extends JPanel{
        public Panel(){

        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if(presionarBoton) {
                contador++;
                g.setColor(colorSelecionado);
                g.setFont(new Font("Verdana", Font.BOLD, 14));
                g.drawString(frase + ": " + contador, this.getWidth() / 6, this.getHeight() / 2);
            }






        }
    }

}




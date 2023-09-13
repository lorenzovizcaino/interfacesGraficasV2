package eventos.MultiplesOyentes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        MarcoMO marcoMO=new MarcoMO();
    }


}

class MarcoMO extends JFrame{
    public MarcoMO(){
        setBounds(600,100,600,450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Multiples ventanas");
        laminaMO lainaMO=new laminaMO();
        add(lainaMO);
        setVisible(true);

    }
}

class laminaMO extends JPanel {
    private JButton nueva, cerrar;
    public laminaMO(){
        nueva=new JButton("Nueva Ventana");
        cerrar=new JButton("Cerrar todas");
        add(nueva);
        add(cerrar);
        CreaMarco creaMarco=new CreaMarco();
        nueva.addActionListener(creaMarco);
    }

    private class CreaMarco implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MarcoNuevo marcoNuevo=new MarcoNuevo(cerrar);
        }
    }
}

class MarcoNuevo extends JFrame{
    private static int contador=0;
    private static int x=0;
    private static int y=0;

    public MarcoNuevo(JButton boton){
        contador++;
        x+=100;
        y+=100;
        setTitle("Ventana "+contador);
        setBounds(x,y,300,200);
        CierraTodos cierraTodos=new CierraTodos();
        boton.addActionListener(cierraTodos);
        setVisible(true);

    }

    private class CierraTodos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}

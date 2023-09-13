package eventos.eventosDeVentana;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main2 {
    public static void main(String[] args) {
        Marco2 marco2=new Marco2();
        EventosDeVentana2 eventosDeVentana2=new EventosDeVentana2();
        marco2.addWindowListener(eventosDeVentana2);
    }
}

class Marco2 extends JFrame{
    public Marco2(){
        setBounds(100,100,600,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

class EventosDeVentana2 extends WindowAdapter {

    //CLASES ADAPTADORAS: EN VEZ DE IMPLEMENTAR WindowListener HEREDAMOS DE WindowAdapter, QUE ES UNA CLASE QUE TIENE IMPLEMENTADA WindowListener ADEMAS
    //DE OTRAS, CON ELLO LO QUE SE CONSIGUE ES NO TENER QUE PONER TODOS LOS METODOS DE LA INTERFAZ, Y SOLO TENER EN EL CODIGO LOS METODOS QUE NECESITEMOS,
    //VER LA DIFERENCIA CON LA CLASE JTool DE ESTE PAQUETE.

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Gracias por trabajar con nosotros");
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Bienvenido a la App");
    }
}

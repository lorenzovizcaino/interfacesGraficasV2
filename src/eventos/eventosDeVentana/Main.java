package eventos.eventosDeVentana;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main {
    public static void main(String[] args) {
        Marco marco=new Marco();
        EventosDeVentana eventosDeVentana=new EventosDeVentana();
        marco.addWindowListener(eventosDeVentana);
    }
}

class Marco extends JFrame{
    public Marco(){
        setBounds(100,100,600,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

class EventosDeVentana implements WindowListener{

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Ventana Abierta");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Cerrando ventana");

    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Ventana cerrada");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Ventana minimizada");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Ventana restaurada tras minimizar");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Ventana Activa");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Ventana en segundo plano");
    }
}

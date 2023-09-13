package eventos.eventosDeVentana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

public class Main3{
    public static void main(String[] args) {
        Marco3 marco3=new Marco3();
        EventosDeVentana3 eventosDeVentana3=new EventosDeVentana3();
        marco3.addWindowStateListener(eventosDeVentana3);
    }
}

class Marco3 extends JFrame {
    public Marco3(){
        setBounds(100,100,600,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

class EventosDeVentana3 implements WindowStateListener {


    @Override
    public void windowStateChanged(WindowEvent e) {
        System.out.println("La ventana ha cambiado de estado");
       // System.out.println(e.getNewState());
        if(e.getNewState()== Frame.MAXIMIZED_BOTH) {
            System.out.println("Has maximizado la ventana");
        }else if(e.getNewState()==Frame.ICONIFIED){
            System.out.println("Has minimizado la ventana");
        }
    }
}

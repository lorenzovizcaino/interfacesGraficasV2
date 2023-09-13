package eventos.eventosderaton;



import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Main {
    public static void main(String[] args) {
        MarcoM marco=new MarcoM();
//        EventosDeRaton eventosDeRaton=new EventosDeRaton();
//        marco.addMouseListener(eventosDeRaton);

//        EventosdeRaton2 eventosdeRaton2=new EventosdeRaton2();
//        marco.addMouseListener(eventosdeRaton2);

        EventosDeRaton3 eventosDeRaton3=new EventosDeRaton3();
        marco.addMouseMotionListener(eventosDeRaton3);




    }
}

class MarcoM extends JFrame {
    public MarcoM(){
        setBounds(100,100,600,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

class EventosDeRaton implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Has presionado y soltado");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Has hecho clic");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Has soltado");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Has entrado");

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Has salido");

    }
}


//  UTILIZANDO LA CLASE ADAPTADORA MouseAdapter
class EventosdeRaton2 extends MouseAdapter{
    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("Coordenada X= "+e.getX()+
//                         "\nCoordenada Y= "+e.getY());

        if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK) {
            System.out.println("Has pulsado el boton  izquierdo");
        }
        else if (e.getModifiersEx()==MouseEvent.BUTTON2_DOWN_MASK) {
            System.out.println("Has pulsado la rueda del raton");
            
        }else{
            System.out.println("Has pulsado el boton  derecho");
        }
    }
}

class EventosDeRaton3 implements MouseMotionListener{

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Estas arrastrando el raton");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Estas moviendo el raton");
    }
}

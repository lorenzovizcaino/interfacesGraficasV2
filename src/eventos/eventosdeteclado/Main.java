package eventos.eventosdeteclado;



import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Main {
        public static void main(String[] args) {
            MarcoT marco=new MarcoT();

            EventoTeclado eventoTeclado=new EventoTeclado();
            marco.addKeyListener(eventoTeclado);



        }
    }

    class MarcoT extends JFrame {
        public MarcoT(){
            setBounds(100,100,600,400);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setVisible(true);
        }
    }

    class EventoTeclado implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
//            System.out.println("Has tecleado una tecla");
//            System.out.println(e.getKeyChar());
        }

        @Override
        public void keyPressed(KeyEvent e) {
//            System.out.println("Has pulsado una tecla");
//            System.out.println(e.getKeyCode());
            //PARA UNA TECLA EN CONCRETO
//            if(e.getKeyChar()=='j'){
//                System.out.println("HOLA");
//            }
//            if(e.getKeyCode()==40){
//                System.out.println("HAS pulsado la tecla abajo");
//            }
//            if(e.getKeyCode()==KeyEvent.VK_B){
//                System.out.println("HAS pulsado la tecla b");
//            }

            //SI QUEREMOS SABER QUE TECLA SE PULSA
            System.out.println("has pulsado la tecla: "+e.getKeyText(e.getKeyCode()));
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //System.out.println("Has soltado una tecla");

        }
    }


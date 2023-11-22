package eventos.eventosdeteclado.Belen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel{

    JTextField areatexto;
    JTextArea area;
    Panel(){
        setLayout(new GridLayout(2,1,10,10));
        areatexto = new JTextField(40);

        area = new JTextArea();
        area.setBounds(0,2,100,100);

        areatexto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(" Has escrito algo "+ e.getKeyChar());
                area.setText("Has pulsado la i"+ e.getKeyChar());

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //Uso del boton CTRL+S
                if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S){
                    System.exit(0);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });






        add(areatexto);
        add(area);


    }



}

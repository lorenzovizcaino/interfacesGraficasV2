package componentesSwing.JPopupMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainJPopupMenu {

    public static void main(String[] args) {
        VentanaJPopupMenu ventanaJPopupMenu =new VentanaJPopupMenu();

    }
}

class VentanaJPopupMenu extends JFrame {
    public VentanaJPopupMenu(){
        setBounds(100,100,600,450);
        setTitle("VentanaJPopupMenu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LaminaJPopupMenu laminaJPopupMenu =new LaminaJPopupMenu();
        add(laminaJPopupMenu);


        setVisible(true);
    }
}

class LaminaJPopupMenu extends JPanel{
    JPopupMenu emergente;
    JMenuItem rojo, verde, amarillo;


    public LaminaJPopupMenu(){
        emergente=new JPopupMenu();
        rojo=new JMenuItem("Rojo");
        verde=new JMenuItem("Verde");
        amarillo=new JMenuItem("Amarillo");

        rojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.RED);
            }
        });
        // DOS FORMAS DISTINTAS DE HACER LO MISMO:
        // ARRIBA, HACEMOS UNA CLASE INTERNA ANOMINA.
        // ABAJO, UTILIZAMOS LA CLASE INTERNA INSTANCIADA.
        CambiaColor cambiaColor=new CambiaColor();
        verde.addActionListener(cambiaColor);
        amarillo.addActionListener(cambiaColor);
        emergente.add(rojo);
        emergente.add(verde);
        emergente.add(amarillo);
        setComponentPopupMenu(emergente);




    }
    private class CambiaColor implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand()=="Verde"){
                setBackground(Color.GREEN);
            }
            if(e.getActionCommand()=="Amarillo"){
                setBackground(Color.YELLOW);
            }

        }
    }


}

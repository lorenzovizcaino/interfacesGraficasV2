package layouts.borderlayouts;

import javax.swing.*;
import java.awt.*;

public class UsoLayouts {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MarcoConLayout miMarco=new MarcoConLayout();

        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        miMarco.setVisible(true);

    }

}

class MarcoConLayout extends JFrame{


    public MarcoConLayout(){

        setTitle("Disposiciones");

        setBounds(600,350,600,300);

        PanelconLayout lamina=new PanelconLayout();

       add(lamina);

    }

}

class PanelconLayout extends JPanel{

    public PanelconLayout(){
        setLayout(new BorderLayout(10,10));

        add(new JButton("Amarillo"),BorderLayout.NORTH);

        add(new JButton("Rojo"),BorderLayout.SOUTH);

        add(new JButton("Azul"),BorderLayout.EAST);

        add(new JButton("Verde"),BorderLayout.WEST);

        add(new JButton("Morado"),BorderLayout.CENTER);


    }
}

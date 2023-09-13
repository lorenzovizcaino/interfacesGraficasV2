package layouts.flowlayouts;

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

        //LAS DOS SIGUIENTES LINEAS LAS UTILIZAMOS PARA UBICAR LOS DIFERENTES ELEMENTOS EN LA INTERFAZ. Comentado se ha puesto en el constructor de PanelconLayout
        //FlowLayout disposicion=new FlowLayout(FlowLayout.RIGHT);
        //lamina.setLayout(disposicion);

        //SIMPLIFICAMOS EN 1 LINEA LAS 2 ANTERIORES EN LA SIGUIENTE LINEA. Comentado se ha puesto en el constructor de PanelconLayout
        //lamina.setLayout(new FlowLayout(FlowLayout.RIGHT));

        add(lamina);

    }

}

class PanelconLayout extends JPanel{

    public PanelconLayout(){

        setLayout(new FlowLayout(FlowLayout.RIGHT));

        add(new JButton("Amarillo"));

        add(new JButton("Rojo"));

        add(new JButton("Azul"));


    }
}

package componentesSwing.JSpinner;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        VentanaJSpinner ventanaJSpinner =new VentanaJSpinner();

    }
}

class VentanaJSpinner extends JFrame {
    public VentanaJSpinner(){
        setBounds(100,100,600,450);
        setTitle("VentanaJSpinner");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LaminaJSpinner laminaJSpinner =new LaminaJSpinner();
        add(laminaJSpinner);


        setVisible(true);
    }
}

class LaminaJSpinner extends JPanel{
    private JSpinner jSpinner;
    private String[] meses={"Enero", "Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    private SpinnerListModel spinnerListModel;


    public LaminaJSpinner(){
        // Spinner CON DATOS TIPO String DE UN ARRAY (SIGUIENTES 2 LINEAS COMENTADAS)
        // spinnerListModel=new SpinnerListModel(meses);
        // jSpinner=new JSpinner(spinnerListModel);

        //Spinner CON CONSTRUCTOR POR DEFECTO (jSpiner=new JSpinner()) MUESTRA NUMEROS DEL 0 AL INFINITO, TANTO POSITIVOS COMO NEGATIVOS

        //Spinner CON CONSTRUCTOR QUE INSTANCIA LA CLASE SpinnerNumberModel SE PUEDE CONFIGURAR CON LOS VALORES QUE SE QUIERA
        jSpinner=new JSpinner(new SpinnerNumberModel(5,-5,15,1));
        jSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(jSpinner.getValue());
            }
        });

        jSpinner.setPreferredSize(new Dimension(100,20));
        add(jSpinner);





    }


}

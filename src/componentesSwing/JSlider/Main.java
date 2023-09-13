package componentesSwing.JSlider;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        VentanaJSlider ventanaJSlider=new VentanaJSlider();

    }
}

class VentanaJSlider extends JFrame {
    public VentanaJSlider(){
        setBounds(100,100,600,450);
        setTitle("VentanaJSlider");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LaminaJSlider laminaSlider=new LaminaJSlider();
        add(laminaSlider);


        setVisible(true);
    }
}

class LaminaJSlider extends JPanel{

    private JComboBox opciones;
    private JLabel etiqueta;
    private JSlider deslizador;



    public LaminaJSlider(){
        setLayout(new BorderLayout());
        JPanel norte=new JPanel();
        JPanel sur=new JPanel();

        add(norte,BorderLayout.NORTH);
        add(sur,BorderLayout.SOUTH);

        CambiarFuente cambiarFuente=new CambiarFuente();

        opciones=new JComboBox<>();
        opciones.addItem("Verdana");
        opciones.addItem("Times New Roman");
        opciones.addItem("Arial");
        opciones.addActionListener(cambiarFuente);
        norte.add(opciones);

        deslizador=new JSlider(8,36,20);
        deslizador.setMajorTickSpacing(12);
        deslizador.setMinorTickSpacing(2);
        deslizador.setPaintTicks(true);
        deslizador.setPaintLabels(true);
        deslizador.addChangeListener(cambiarFuente);

        norte.add(deslizador);


        etiqueta=new JLabel("Hola Alumnos de Java");

        sur.add(etiqueta);









    }

    private class CambiarFuente implements ActionListener, ChangeListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            etiqueta.setFont(new Font((String)opciones.getSelectedItem(),Font.BOLD,deslizador.getValue()));
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            etiqueta.setFont(new Font((String)opciones.getSelectedItem(),Font.BOLD,deslizador.getValue()));
        }
    }


}


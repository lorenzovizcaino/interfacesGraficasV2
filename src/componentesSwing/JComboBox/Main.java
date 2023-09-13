package componentesSwing.JComboBox;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        VentanaJComboBox ventanaJComboBox=new VentanaJComboBox();

    }
}

class VentanaJComboBox extends JFrame {
    public VentanaJComboBox(){
        setBounds(100,100,600,450);
        setTitle("VentanaJComboBox");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LaminaJComboBox laminaJComboBox=new LaminaJComboBox();
        add(laminaJComboBox);


        setVisible(true);
    }
}

class LaminaJComboBox extends JPanel{

    private JComboBox opciones;
    private JLabel etiqueta;



    public LaminaJComboBox(){
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

        etiqueta=new JLabel("Hola Alumnos de Java");

        sur.add(etiqueta);









    }

    private class CambiarFuente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {


            //MI MANERA
//            if (opciones.getSelectedItem().equals("Verdana")){
//                Font verdana=new Font("Verdana",Font.BOLD,16);
//                etiqueta.setFont(verdana);
//            }
//
//            if (opciones.getSelectedItem().equals("Times New Roman")){
//                Font timesNewRoman=new Font("Times New Roman",Font.BOLD,16);
//                etiqueta.setFont(timesNewRoman);
//            }
//
//            if (opciones.getSelectedItem().equals("Arial")){
//                Font arial=new Font("Arial",Font.BOLD,16);
//                etiqueta.setFont(arial);
//            }

            //MANERA DEL PROFE, MUCHO MAS OPTIMIZADA
            etiqueta.setFont(new Font((String)opciones.getSelectedItem(),Font.BOLD,16));
        }
    }


}

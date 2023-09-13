package componentesSwing.JCheckBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Main {
    public static void main(String[] args) {
        VentanaJCheckBox ventanaJCheckBox=new VentanaJCheckBox();

    }
}

class VentanaJCheckBox extends JFrame {
    public VentanaJCheckBox(){
        setBounds(100,100,600,450);
        setTitle("VentanaJCheckBox");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LaminaJCheckBox laminaJCheckBox=new LaminaJCheckBox();
        add(laminaJCheckBox);

        setVisible(true);
    }
}

class LaminaJCheckBox extends JPanel{
    private JLabel etiqueta;
    private JCheckBox box1, box2;
    private Font fuenteOriginal=new Font("Times New Roman",Font.PLAIN,12);


    public LaminaJCheckBox(){
        setLayout(new BorderLayout());
        etiqueta=new JLabel("Hola alumnos de JAVA");

        etiqueta.setFont(fuenteOriginal);
        JPanel norte=new JPanel();
        norte.setLayout(new FlowLayout());
        add(norte, BorderLayout.NORTH);
        norte.add(etiqueta);

        JPanel sur=new JPanel();
        add(sur,BorderLayout.SOUTH);
        box1=new JCheckBox("NEGRITA");
        box2=new JCheckBox("CURSIVA");

        FormatoLetras formatoLetras=new FormatoLetras();
        box1.addActionListener(formatoLetras);
        box2.addActionListener(formatoLetras);

        sur.add(box1);
        sur.add(box2);






    }
    private class FormatoLetras implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            //MI CODIGO
//            if(box1.isSelected()){
//                Font fuenteB=new Font("Verdana",Font.BOLD,16);
//                etiqueta.setFont(fuenteB);
//            }else if(box2.isSelected()){
//                Font fuenteI=new Font("Verdana",Font.ITALIC,16);
//                etiqueta.setFont(fuenteI);
//            }else if(box1.isSelected() && box2.isSelected()){
//                Font fuenteBI=new Font("Verdana",3,16);
//                etiqueta.setFont(fuenteBI);
//            }else{
//                etiqueta.setFont(fuenteOriginal);
//            }


            //CODIGO DEL PROFE
            int negritaCursiva=0;
            if(box1.isSelected()) negritaCursiva+=Font.BOLD;
            if(box2.isSelected()) negritaCursiva+=Font.ITALIC;
            etiqueta.setFont(new Font("Verdana",negritaCursiva,16));

        }
    }


}

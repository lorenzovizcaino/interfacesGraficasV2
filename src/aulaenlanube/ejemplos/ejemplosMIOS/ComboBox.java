package aulaenlanube.ejemplos.ejemplosMIOS;

import javax.swing.*;
import java.awt.*;

public class ComboBox {
    public static void main(String[] args) {
        new VentanaComboBox();
    }
}

class VentanaComboBox extends JFrame{
    public VentanaComboBox(){
        setBounds(100,100,500,300);
        setTitle("Ejemplo ComboBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaminaComboBox lamina=new LaminaComboBox();
        add(lamina);
        setVisible(true);
    }

}

class LaminaComboBox extends JPanel{
    private JTextField campoTexto;
    private String[] datos={"1DAM", "2DAM","1DAW","2DAW"};
    private JComboBox<String> combo;
    private JButton boton;
    private JLabel comunicacion;
    public LaminaComboBox(){
        setLayout(new FlowLayout());
        campoTexto=new JTextField(10);
        add(campoTexto);
        combo=new JComboBox<>(datos);
        add(combo);
        boton=new JButton("Matriculate");
        add(boton);
        comunicacion=new JLabel();
        add(comunicacion);

        campoTexto.addActionListener(e ->{
            System.out.println("Has pulsado ENTER");
        });

        boton.addActionListener(e -> {
            if(campoTexto.getText().length()<3){
                comunicacion.setForeground(Color.RED);
                comunicacion.setText("ERROR al matricular: El nombre debe de tener como minimo 3 letras");

            }else{
                comunicacion.setText("El alumno "+campoTexto.getText()+" se ha matriculado en "+combo.getSelectedItem());
            }
        });
        combo.addActionListener(e -> {
            comunicacion.setText("Valor del ComboBox modificado: "+combo.getSelectedItem());
        });

    }
}

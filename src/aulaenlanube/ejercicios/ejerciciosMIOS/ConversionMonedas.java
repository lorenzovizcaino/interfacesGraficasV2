package aulaenlanube.ejercicios.ejerciciosMIOS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversionMonedas {
    public static void main(String[] args) {
        new VentanaConversionMonedas();
    }
}

class VentanaConversionMonedas extends JFrame{

    public VentanaConversionMonedas(){
        setBounds(100,100,300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Conversor Monedas");
        LaminaConversionMonedas laminaConversionMonedas=new LaminaConversionMonedas();
        add(laminaConversionMonedas);
        setVisible(true);
    }
}

class LaminaConversionMonedas extends JPanel{
    private JTextField cantidadTransformar;
    private String[] cambios={"Euro a Dolar", "Dolar a Euro"};
    private JComboBox<String> transformar;
    private JLabel resultado;
    public LaminaConversionMonedas(){
        setLayout(new BorderLayout());
        cantidadTransformar=new JTextField(10);
        transformar=new JComboBox<>(cambios);
        resultado=new JLabel("Cantidad Transformada");
        add(cantidadTransformar,BorderLayout.NORTH);
        add(transformar,BorderLayout.CENTER);
        add(resultado,BorderLayout.SOUTH);
        transformar.addActionListener(e ->{
            if(transformar.getSelectedItem().equals("Euro a Dolar")){
                    resultado.setText(String.valueOf(Integer.parseInt(cantidadTransformar.getText())/0.91));
                }else{
                    resultado.setText(String.valueOf(Integer.parseInt(cantidadTransformar.getText())*0.91));
                }
        });

//        transformar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(transformar.getSelectedItem().equals("Euro a Dolar")){
//                    resultado.setText(String.valueOf(Integer.parseInt(cantidadTransformar.getText())/0.91));
//                }else{
//                    resultado.setText(String.valueOf(Integer.parseInt(cantidadTransformar.getText())*0.91));
//                }
//            }
//        });


    }
}
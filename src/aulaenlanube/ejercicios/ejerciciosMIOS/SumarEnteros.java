package aulaenlanube.ejercicios.ejerciciosMIOS;

import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;

public class SumarEnteros {
    public static void main(String[] args) {
        new VentanaSumarEnteros();
    }
}

class VentanaSumarEnteros extends JFrame{
    public VentanaSumarEnteros(){
        setBounds(100,100,300,200);
        setTitle("Sumar Enteros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaminaSumarEnteros laminaSumarEnteros=new LaminaSumarEnteros();
        add(laminaSumarEnteros);
        setVisible(true);
    }
}

class LaminaSumarEnteros extends JPanel{
    private JTextField textFieldEntero1, textFieldEntero2;
    private JLabel labelResultado;
    private boolean num1=false;
    private boolean num2=false;

    public LaminaSumarEnteros(){
        setLayout(new FlowLayout());
        textFieldEntero1=new JTextField(10);
        textFieldEntero2=new JTextField(10);
        labelResultado=new JLabel();
        add(textFieldEntero1);
        add(textFieldEntero2);
        add(labelResultado);

        textFieldEntero1.addActionListener(e->{
            num1=ComprobarEntero(textFieldEntero1.getText());
            Resultado();

        });

        textFieldEntero2.addActionListener(e->{
            num2=ComprobarEntero(textFieldEntero2.getText());
            Resultado();

        });

    }

    private void Resultado() {
        if(num1 && num2){
            int resultado=Integer.parseInt(textFieldEntero1.getText())+Integer.parseInt(textFieldEntero2.getText());
            labelResultado.setText(String.valueOf(resultado));
        }else{
            labelResultado.setText("Falta algun numero o alguno de ellos no  es un numero");
        }
    }

    private boolean ComprobarEntero(String text) {
        boolean num=false;
        try{
            int numero1=Integer.parseInt(text);
            num=true;

        }catch (NumberFormatException e){

        }
        return num;
    }
}

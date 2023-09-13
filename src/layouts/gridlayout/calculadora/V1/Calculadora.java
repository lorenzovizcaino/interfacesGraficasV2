package layouts.gridlayout.calculadora.V1;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    public static void main(String[] args) {
        Marco calculadora=new Marco();
    }
}

class Marco extends JFrame{
    public Marco(){
        setBounds(100,100,450,300);
        setTitle("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Lamina1 laminaNumeros=new Lamina1();
        add(laminaNumeros,BorderLayout.CENTER);

        Lamina2 laminaResultados=new Lamina2();

        add(laminaResultados,BorderLayout.NORTH);
        setVisible(true);
    }
}

class Lamina1 extends JPanel{

    public Lamina1(){
        setLayout(new GridLayout(4,4));
        //PARA ACCEDER A UNA CLASE INTERNA (TIENE QUE SER public) SE INSTANCIA PRIMERO LA CLASE PRINCIPAL
        // Y CON ESA INSTANCIA SE INSTANCIA TAMBIEN LA CLASE INTERNA (proximas 2 lineas de codigo)
        Lamina2 lamina2=new Lamina2();
        Lamina2.InsertarNumero insertarNumero=lamina2.new InsertarNumero();

        //SE CREA UN METODO PARA CREAR LOS BOTONES, PARA QUE A LA HORA DE PONER A LA ESCUCHA LOS DIFERENTES BOTONES EL CODIGO SEA MAS SENCILLO
        PonerBoton("7",insertarNumero);
        PonerBoton("8",insertarNumero);
        PonerBoton("9",insertarNumero);
        PonerBoton("X",insertarNumero);
        PonerBoton("4",insertarNumero);
        PonerBoton("5",insertarNumero);
        PonerBoton("6",insertarNumero);
        PonerBoton("-",insertarNumero);
        PonerBoton("1",insertarNumero);
        PonerBoton("2",insertarNumero);
        PonerBoton("3",insertarNumero);
        PonerBoton("+",insertarNumero);
        PonerBoton("+/-",insertarNumero);
        PonerBoton("0",insertarNumero);
        PonerBoton(",",insertarNumero);
        PonerBoton("=",insertarNumero);
    }

    private void PonerBoton(String textoBoton, Lamina2.InsertarNumero oyente) {
        JButton boton=new JButton(textoBoton);
        boton.addActionListener(oyente);
        add(boton);
    }
}

class Lamina2 extends JPanel{
    private JButton resultado;
    public Lamina2(){
        setLayout(new BorderLayout());
        resultado=new JButton("0");
        resultado.setEnabled(false);
        add(resultado);
    }
    public class InsertarNumero implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String entrada=e.getActionCommand(); //EL METODO getActionCommand() NOS DEVUELVE UN STRING CON EL TEXTO DEL BOTON PULSADO

            resultado.setText(resultado.getText()+entrada);
            System.out.println(resultado.getText());


        }
    }
}



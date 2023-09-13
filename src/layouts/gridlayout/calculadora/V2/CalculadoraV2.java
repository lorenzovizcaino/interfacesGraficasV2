package layouts.gridlayout.calculadora.V2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraV2 {
    public static void main(String[] args) {
        MarcoV2 calculadora=new MarcoV2();
    }
}
class MarcoV2 extends JFrame{
    public MarcoV2(){
        setBounds(100,100,450,300);
        setTitle("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LaminaCalculadora laminaCalculadora=new LaminaCalculadora();
        add(laminaCalculadora);
        setVisible(true);
    }
}

class LaminaCalculadora extends JPanel{
    private JButton pantalla;
    private JPanel numeracion;
    private boolean comienzo;
    private double op1=0,op2=0, resultado=0;
    private String operacion="";
    private boolean segundoOperador=false;
    private String entradaAnterior="";
    private boolean boolEntradaAnterior=false;
    private boolean boolEntrada=false;
    public LaminaCalculadora(){
        comienzo=true;
        setLayout(new BorderLayout());
        pantalla =new JButton("0");
        pantalla.setEnabled(false);
        add(pantalla,BorderLayout.NORTH);

        numeracion=new JPanel();
        numeracion.setLayout(new GridLayout(5,4));

        InsertarNumero insertarNumero=new InsertarNumero();

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
        PonerBoton("=",insertarNumero);
        PonerBoton("0",insertarNumero);
        PonerBoton(".",insertarNumero);
        PonerBoton("/",insertarNumero);
        PonerBoton("C",insertarNumero);
        add(numeracion,BorderLayout.CENTER);

    }

    private void PonerBoton(String textoBoton, InsertarNumero oyente) {
        JButton boton=new JButton(textoBoton);
        boton.addActionListener(oyente);
        numeracion.add(boton);
    }

    private class InsertarNumero implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            String entrada=e.getActionCommand(); //EL MÉTODO getActionCommand() NOS DEVUELVE UN STRING CON EL TEXTO DEL BOTÓN PULSADO

            if(comienzo){
                //EL SIGUIENTE if ES PARA DETECTAR QUE CUANDO SE PULSEN DOS O MAS SIGNOS UTILICE EL ULTIMO PULSADO
                if(entrada.equals("X") && boolEntradaAnterior || entrada.equals("+") && boolEntradaAnterior || entrada.equals("/") && boolEntradaAnterior || entrada.equals("-") && boolEntradaAnterior || entrada.equals("=") && boolEntradaAnterior ||  entrada.equals("C") && boolEntradaAnterior){
                    //pantalla.setText("0");
                    operacion=entrada;
                }else{
                    pantalla.setText(entrada);
                    comienzo=false;
                }

            }else{

                switch(entrada){
                    case "0":
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                    case "5":
                    case "6":
                    case "7":
                    case "8":
                    case "9":
                    case ".":
                        pantalla.setText(pantalla.getText()+entrada);
                        boolEntrada=false;
                        break;
                    case "X":
                        op1= Double.parseDouble(pantalla.getText());



                        comienzo=true;
                        operacion="X";
                        break;
                    case "+":
                        op1= Double.parseDouble(pantalla.getText());

                        comienzo=true;
                        operacion="+";
                        break;
                    case "-":
                        op1= Double.parseDouble(pantalla.getText());

                        comienzo=true;
                        operacion="-";
                        break;
                    case "/":
                        op1= Double.parseDouble(pantalla.getText());

                        comienzo=true;
                        operacion="/";
                        break;

                    case "=":
                        op2= Double.parseDouble(pantalla.getText());
                        //comienzo=true;
                        switch (operacion){
                            case "X":
                                resultado=op1*op2;
                                pantalla.setText(String.valueOf(resultado));
                                break;
                            case "+":
                                resultado=op1+op2;
                                pantalla.setText(String.valueOf(resultado));
                                break;
                            case "-":
                                resultado=op1-op2;
                                pantalla.setText(String.valueOf(resultado));
                                break;
                            case "/":
                                resultado=op1/op2;
                                pantalla.setText(String.valueOf(resultado));
                                break;

                        }
                        break;
                    case "C":
                        op1=0;
                        op2=0;
                        comienzo=true;
                        pantalla.setText("0");
                        break;

                }
                entradaAnterior=entrada;
                if(entradaAnterior.equals("X")||entradaAnterior.equals("+")||entradaAnterior.equals("/")||entradaAnterior.equals("-")||entradaAnterior.equals("=")||entradaAnterior.equals("C")){
                    boolEntradaAnterior=true;
                }else{
                    boolEntradaAnterior=false;
                }

            }
        }
    }
    }






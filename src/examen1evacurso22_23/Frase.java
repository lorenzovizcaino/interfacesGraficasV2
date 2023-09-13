package examen1evacurso22_23;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frase {
    public static void main(String[] args) {
        VentanaFrase ventanaFrase=new VentanaFrase();
    }

}


class VentanaFrase extends JFrame {
    public VentanaFrase(){
        setBounds(100,100,1000,400);
        setTitle("Interface Frase");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaminaFrase lamina=new LaminaFrase();
        add(lamina);
        setVisible(true);

    }

}

class LaminaFrase extends JPanel{

    private JLabel introducirFrase;
    private JTextField frase;
    private  JButton procesarFrase;
    private JLabel etiquetas[]=new JLabel[5];
    private JTextField cuadrosTexto[]=new JTextField[5];
    private JButton limpiar;
    private JButton salir;
    private String[] textos={"Numero de letras", "Numero de palabras", "Invertir frase", "Separar palabras", "Primera posicion vocal"};
    private Font fuenteTitulos=new Font("Verdana",Font.BOLD,14);




    public LaminaFrase(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();

        introducirFrase=new JLabel("Introduce una frase");
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1.0;
        gbc.weighty=1.0;
        gbc.fill=GridBagConstraints.BOTH;
        introducirFrase.setFont(fuenteTitulos);
        add(introducirFrase,gbc);

        frase=new JTextField();
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth=4;
        gbc.gridheight=1;
        gbc.weightx=1.0;
        gbc.weighty=1.0;
        gbc.fill=GridBagConstraints.BOTH;
        add(frase,gbc);

        procesarFrase=new JButton("Procesar Frase");
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=1;
        gbc.gridheight=5;
        gbc.weightx=1.0;
        gbc.weighty=1.0;
        gbc.fill=GridBagConstraints.BOTH;
        gbc.insets=new Insets(10,25,10,25);
        //gbc.anchor=GridBagConstraints.CENTER;
        procesarFrase.setFont(fuenteTitulos);
        add(procesarFrase,gbc);
        Operatividad operatividad=new Operatividad();
        procesarFrase.addActionListener(operatividad);

        CrearContenedor(gbc);

        limpiar=new JButton("Limpiar");
        gbc.gridx=1;
        gbc.gridy=7;
        gbc.gridwidth=2;
        gbc.gridheight=2;
        gbc.weightx=1.0;
        gbc.weighty=1.0;
        gbc.fill=GridBagConstraints.BOTH;

        limpiar.setFont(fuenteTitulos);
        limpiar.addActionListener(operatividad);
        add(limpiar,gbc);

        salir=new JButton("Salir");
        gbc.gridx=3;
        gbc.gridy=7;
        gbc.gridwidth=2;
        gbc.gridheight=2;
        gbc.weightx=1.0;
        gbc.weighty=1.0;
        gbc.fill=GridBagConstraints.BOTH;

        salir.setFont(fuenteTitulos);
        salir.addActionListener(operatividad);
        add(salir,gbc);





    }

    private void CrearContenedor(GridBagConstraints gbc) {
        int x=1;
        int y=2;
        for (int i = 0; i < 5; i++) {
            etiquetas[i]=new JLabel(textos[i]);
            gbc.gridx=x;
            gbc.gridy=y;
            gbc.gridwidth=1;
            gbc.gridheight=1;
            gbc.weightx=1.0;
            gbc.weighty=1.0;
            gbc.fill=GridBagConstraints.BOTH;
            gbc.insets=new Insets(4,5,10,4);
            add(etiquetas[i],gbc);

            cuadrosTexto[i]=new JTextField(40);
            cuadrosTexto[i].setEditable(false);
            cuadrosTexto[i].setToolTipText(textos[i]);
            Border border = BorderFactory.createRaisedSoftBevelBorder();
            cuadrosTexto[i].setBorder(border);
            x++;
            gbc.gridx=x;
            gbc.gridy=y;
            gbc.gridwidth=3;
            gbc.gridheight=1;
            gbc.weightx=1.0;
            gbc.weighty=1.0;
            gbc.fill=GridBagConstraints.BOTH;
            gbc.insets=new Insets(4,5,10,4);
            add(cuadrosTexto[i],gbc);
            x--;
            y++;



        }
    }
    private class Operatividad implements ActionListener{
        String fraseTrabajada="";

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==procesarFrase){
                ContarLetras();
                ContarPalabras();
                InvertirFrase();
                SepararPalabras();
                PrimeraPosicionVocal();

            }
            if(e.getSource()==limpiar){
                frase.setText("");
                for (int i = 0; i < 5; i++) {
                    cuadrosTexto[i].setText("");

                }
            }
            if(e.getSource()==salir){
                System.exit(0);
            }
        }

        private void PrimeraPosicionVocal() {
            String fraseAcumulada=frase.getText().toLowerCase();
            int vocal = 0;
            for (int i = 0; i < fraseAcumulada.length()-1; i++) {
                if(fraseAcumulada.charAt(i)=='a' || fraseAcumulada.charAt(i)=='e' || fraseAcumulada.charAt(i)=='i' || fraseAcumulada.charAt(i)=='o' || fraseAcumulada.charAt(i)=='u'){
                    vocal=i;
                    break;
                }
            }
            cuadrosTexto[4].setText(String.valueOf(vocal));
        }

        private void SepararPalabras() {
            cuadrosTexto[3].setText(fraseTrabajada);
            fraseTrabajada="";

        }

        private void InvertirFrase() {
            String fraseAcumulada=frase.getText().trim();
            String fraseReves="";
            int lonFrase=fraseAcumulada.length()-1;
            for (int i = lonFrase; i >=0 ; i--) {
                fraseReves+=fraseAcumulada.charAt(i);
            }
            cuadrosTexto[2].setText(fraseReves);
        }

        private void ContarPalabras() {
            String fraseAcumulada=frase.getText().trim();
            int contarPalabras=0;
            String palabras[]=fraseAcumulada.split(" ");
            for (String p:palabras) {
                if(!(p.equals(""))) {
                    contarPalabras++;
                    fraseTrabajada+=p+"-";
                }
            }
            cuadrosTexto[1].setText(String.valueOf(contarPalabras));
        }

        private void ContarLetras() {
            int numLetras=0;
            String fraseAcumulada=frase.getText().replace(" ","").trim();
            numLetras=fraseAcumulada.length();
            cuadrosTexto[0].setText(String.valueOf(numLetras));
        }
    }
}

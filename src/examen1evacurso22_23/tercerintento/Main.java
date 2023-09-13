package examen1evacurso22_23.tercerintento;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        VentanaFrase ventanaFrase=new VentanaFrase();
    }
}

class VentanaFrase extends JFrame{
    public VentanaFrase(){
        setBounds(100,100,1200,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Frase");
        LaminaFrase laminaFrase=new LaminaFrase();
        add(laminaFrase);

        setVisible(true);

    }
}

class LaminaFrase extends JPanel{

    private JLabel introducirFrase;
    private JTextField fraseAComprobar;
    private JButton botonEjecutar;
    private JButton limpiar;
    private JButton salir;
    private JButton pintar;
    private JButton mostrar;

    private Font fuenteGrande=new Font("Arial",Font.BOLD,20);


    private GridBagConstraints gbc;
    private ConfigConstrains configConstrains=new ConfigConstrains();
    PanelCentral panelCentral;
    Dibujo dibujo;
    Color colorPintar;


    public LaminaFrase(){
        setLayout(new GridBagLayout());
        Funcionalidad funcionalidad=new Funcionalidad();
        gbc=new GridBagConstraints();
        introducirFrase=new JLabel("Introduce una frase");
        introducirFrase.setFont(fuenteGrande);
        introducirFrase.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc=configConstrains.Constrains(0,0,1,1,0.0,0.0,GridBagConstraints.NONE,GridBagConstraints.CENTER,new Insets(10,20,10,20));
        add(introducirFrase,gbc);

        fraseAComprobar=new JTextField(20);
        Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
        fraseAComprobar.setBorder(border);
        gbc=configConstrains.Constrains(1,0,6,1,1.0,0.0,GridBagConstraints.BOTH,GridBagConstraints.CENTER,new Insets(10,20,10,20));
        fraseAComprobar.addFocusListener(funcionalidad);
        add(fraseAComprobar,gbc);

        botonEjecutar=new JButton("Procesar frase");
        botonEjecutar.setFont(fuenteGrande);
        botonEjecutar.setDisplayedMnemonicIndex(0);
        gbc=configConstrains.Constrains(0,1,1,5,1.0,1.0,GridBagConstraints.VERTICAL,GridBagConstraints.CENTER,new Insets(10,20,10,20));
        add(botonEjecutar,gbc);



        panelCentral=new PanelCentral();

        gbc=configConstrains.Constrains(1,1,4,5,1.0,1.0,GridBagConstraints.BOTH,GridBagConstraints.CENTER,new Insets(10,20,10,20));


        botonEjecutar.addActionListener(funcionalidad);
        botonEjecutar.addKeyListener(funcionalidad);

        add(panelCentral,gbc);

        dibujo=new Dibujo();
        dibujo.setBorder(BorderFactory.createTitledBorder("Dibujar Frase"));
        gbc=configConstrains.Constrains(5,1,2,5,1.0,0,GridBagConstraints.BOTH,GridBagConstraints.CENTER,new Insets(10,20,10,20));
        add(dibujo,gbc);


        salir=new JButton("Salir");
        salir.setFont(fuenteGrande);
        salir.setDisplayedMnemonicIndex(0);
        gbc=configConstrains.Constrains(0,7,1,1,1.0,0.0,GridBagConstraints.BOTH,GridBagConstraints.CENTER,new Insets(10,20,10,20));
        salir.addActionListener(funcionalidad);
        add(salir,gbc);

        limpiar=new JButton("Limpiar");
        limpiar.setFont(fuenteGrande);
        limpiar.setDisplayedMnemonicIndex(0); //subraya el caracter que quieras del jButton

        gbc=configConstrains.Constrains(1,7,4,1,1.0,0.0,GridBagConstraints.BOTH,GridBagConstraints.CENTER,new Insets(10,20,10,20));
        limpiar.addActionListener(funcionalidad);
        limpiar.addKeyListener(funcionalidad);
        add(limpiar,gbc);

        pintar=new JButton("Pintar");
        pintar.setEnabled(false);
        pintar.setFont(fuenteGrande);
        pintar.setDisplayedMnemonicIndex(3);
        gbc=configConstrains.Constrains(5,7,1,1,1.0,0,GridBagConstraints.BOTH,GridBagConstraints.CENTER,new Insets(10,20,10,20));
        pintar.addActionListener(e->{
            colorPintar=JColorChooser.showDialog(this,"Elegir Color",Color.BLACK);
        });
        pintar.addKeyListener(funcionalidad);
        add(pintar,gbc);

        mostrar=new JButton("Mostrar");
        mostrar.setFont(fuenteGrande);
        mostrar.setDisplayedMnemonicIndex(0);

        mostrar.setEnabled(false);
        gbc=configConstrains.Constrains(6,7,1,1,1.0,0,GridBagConstraints.BOTH,GridBagConstraints.CENTER,new Insets(10,20,10,20));
        mostrar.addActionListener(e->{
            dibujo.setColor(colorPintar);
            dibujo.setFraseAComprobar(fraseAComprobar.getText());
            dibujo.repaint();
        });
        mostrar.addKeyListener(funcionalidad);
        add(mostrar,gbc);















    }
    private class Funcionalidad  implements ActionListener, FocusListener, KeyListener {

        String fraseConSeparadores;
        Color color;




        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==botonEjecutar){
                ejecutar();


            }

            if(e.getSource()==limpiar){
                limpiar();


            }

            if(e.getSource()==salir){
                System.exit(0);
            }


        }

        private void ejecutar() {
            ContarLetras();
            ContarPalabras();
            InvertirFrase();
            SepararPalabras();
            PrimeraPosicionVocal();
            pintar.setEnabled(true);
            mostrar.setEnabled(true);
        }

        private void limpiar() {
            fraseAComprobar.setText("");
            for (int i = 0; i < 5; i++) {
                panelCentral.ModificarCampos("",i);
            }
            pintar.setEnabled(false);
            mostrar.setEnabled(false);
            dibujo.setFraseAComprobar("");
            dibujo.repaint();
        }

        private void PrimeraPosicionVocal() {
            String fraseTrabajada=fraseAComprobar.getText().toLowerCase();
            int posicion=0;
            for (int i = 0; i < fraseTrabajada.length(); i++) {
                if(fraseTrabajada.charAt(i)=='a' || fraseTrabajada.charAt(i)=='e' || fraseTrabajada.charAt(i)=='i' || fraseTrabajada.charAt(i)=='o' || fraseTrabajada.charAt(i)=='u'){
                    posicion=i;
                    break;
                }

            }
            panelCentral.ModificarCampos(String.valueOf(posicion),4);
        }

        private void SepararPalabras() {
            panelCentral.ModificarCampos(fraseConSeparadores,3);
        }

        private void InvertirFrase() {
            String fraseTrabajada=fraseAComprobar.getText().trim();
            String fraseDelReves="";
            for (int i = fraseTrabajada.length()-1; i >= 0 ; i--) {
                fraseDelReves+=fraseTrabajada.charAt(i);
            }
            panelCentral.ModificarCampos(fraseDelReves,2);

        }

        private void ContarPalabras() {
            fraseConSeparadores="";
            String fraseTrabajada=fraseAComprobar.getText().trim();
            int contadorPalabras=0;
            String palabras[]=fraseTrabajada.split(" ");
            for (String p:palabras) {
                if(!(p.equals(""))){
                    contadorPalabras++;
                    fraseConSeparadores+=p+"-";
                }
            }


            panelCentral.ModificarCampos(String.valueOf(contadorPalabras),1);


        }

        private void ContarLetras() {
            String fraseTrabajada=fraseAComprobar.getText().replace(" ","").trim();
            int numLetras=fraseTrabajada.length();

            panelCentral.ModificarCampos(String.valueOf(numLetras),0);


        }
        //metodos de la interfaz FocusListener
        @Override
        public void focusGained(FocusEvent e) {
            mostrar.setEnabled(false);
            pintar.setEnabled(false);
        }

        @Override
        public void focusLost(FocusEvent e) {
            mostrar.setEnabled(true);
            pintar.setEnabled(true);
        }

        //metodos de la interfaz KeyListener
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyChar()=='p' || e.getKeyChar()=='P'){
                ejecutar();
            }

            if(e.getKeyCode()==KeyEvent.VK_L){   //vale para mayusculas y minusculas
                limpiar();
            }
            if(e.getKeyChar()=='s' || e.getKeyChar()=='S'){
                System.exit(0);
            }
            if(e.getKeyChar()=='t' || e.getKeyChar()=='T'){
                colorPintar=JColorChooser.showDialog(pintar,"Elegir Color",Color.BLACK);
            }
            if(e.getKeyCode()==KeyEvent.VK_M){
                dibujo.setColor(colorPintar);
                dibujo.setFraseAComprobar(fraseAComprobar.getText());
                dibujo.repaint();
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }


}

class Dibujo extends JPanel{
    private String fraseAComprobar;
    private Color color;

    public Dibujo(){
        fraseAComprobar=new String();
        color=Color.BLACK;
    }



    public void setFraseAComprobar(String fraseAComprobar) {
        this.fraseAComprobar = fraseAComprobar;
    }


    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.setFont(new Font("Arial",Font.BOLD,24));
        g.drawString(fraseAComprobar,this.getWidth()/6,this.getHeight()/2);
    }
}

class PanelCentral extends JPanel{
    private JLabel [] etiquetas=new JLabel[5];
    private JTextField [] campos=new JTextField[5];
    private String [] textosJLabel={"Numero de letras", "Numero de palabras", "Invertir frase", "Separar palabras", "Primera posicion vocal"};
    private GridBagConstraints gbc=new GridBagConstraints();
    private ConfigConstrains configConstrains=new ConfigConstrains();
    private Font fuentePequena=new Font("Arial",Font.BOLD,12);
    private int x=0;
    private int y=0;
    public PanelCentral(){
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("Procesar Frase"));
        for (int i = 0; i < 5; i++) {
            etiquetas[i]=new JLabel(textosJLabel[i]);
            etiquetas[i].setFont(fuentePequena);
            etiquetas[i].setAlignmentX(JLabel.CENTER_ALIGNMENT);
            gbc=configConstrains.Constrains(x,y,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,20,10,20));
            add(etiquetas[i],gbc);
            x++;
            campos[i]=new JTextField(20);
            campos[i].setToolTipText(textosJLabel[i]);
            campos[i].setEditable(false);
            Border border = BorderFactory.createRaisedSoftBevelBorder();
            campos[i].setBorder(border);


            gbc=configConstrains.Constrains(x,y,3,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,0,10,10));
            add(campos[i],gbc);

            x--;
            y++;

        }


    }



    public void ModificarCampos(String dato, int indice) {
        campos[indice].setText(dato);

        System.out.println(campos[indice].getText());
    }
}



class ConfigConstrains{

    private GridBagConstraints gbc=new GridBagConstraints();

    public GridBagConstraints Constrains(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int fill, int anchor, Insets insets){
        gbc.gridx=gridx;
        gbc.gridy=gridy;
        gbc.gridwidth=gridwidth;
        gbc.gridheight=gridheight;
        gbc.weightx=weightx;
        gbc.weighty=weighty;
        gbc.fill=fill;
        gbc.anchor=anchor;
        gbc.insets=insets;
        return gbc;
    }

    public GridBagConstraints Constrains(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, Insets insets){
        gbc.gridx=gridx;
        gbc.gridy=gridy;
        gbc.gridwidth=gridwidth;
        gbc.gridheight=gridheight;
        gbc.weightx=weightx;
        gbc.weighty=weighty;
        gbc.insets=insets;
        return gbc;
    }





}

package escribiendomarco;

import javax.swing.*;
import java.awt.*;



public class TipoLetra {

    public static void main(String[] args) {
        Marco marco=new Marco();
    }
}

class Marco extends JFrame{
    public Marco(){
        setBounds(300,200,600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Lamina lamina=new Lamina();
        add(lamina);
        setVisible(true);
    }
}

class Lamina extends JPanel{
    private String letra;
    public Lamina() {
        letra=JOptionPane.showInputDialog("TIPO DE LETRA");
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        String [] letras=LetrasLocales();
        Font miLetra;
        boolean encontrado=false;
        for (String l:letras) {
            if(l.equalsIgnoreCase(letra)) encontrado=true;
        }
        if(encontrado){
             miLetra=new Font(letra,Font.BOLD,26);
        }else{
             miLetra=new Font("Arial",Font.BOLD,26);
        }

        g2.setFont(miLetra);
        g2.setPaint(Color.BLUE);
        g2.drawString("Hola Alumnos de Java",100,100);
    }


    private String[] LetrasLocales() {
        GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] misFuentes=graphicsEnvironment.getAvailableFontFamilyNames();
        return misFuentes;
    }
}

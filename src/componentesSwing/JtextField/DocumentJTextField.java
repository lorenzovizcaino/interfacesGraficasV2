package componentesSwing.JtextField;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class DocumentJTextField {
    public static void main(String[] args) {
        Ventana3 ventana3=new Ventana3();
    }

}

class Ventana3 extends JFrame{
    public Ventana3(){
        setBounds(100,100,600,450);
        setTitle("Ventana3");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Lamina3 lamina3=new Lamina3();
        add(lamina3);

        setVisible(true);
    }
}

class Lamina3 extends JPanel{
    JTextField campoTexto;
    public Lamina3(){

        campoTexto=new JTextField(20);
        Document document=campoTexto.getDocument();
        EscuchaTexto escuchaTexto=new EscuchaTexto();
        document.addDocumentListener(escuchaTexto);
        add(campoTexto);

    }
    private class EscuchaTexto implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            System.out.println("Has introducido texto");
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            System.out.println("Has borrado texto");
        }

        @Override
        public void changedUpdate(DocumentEvent e) {

        }
    }
}

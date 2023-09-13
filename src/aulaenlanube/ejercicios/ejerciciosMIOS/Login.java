package aulaenlanube.ejercicios.ejerciciosMIOS;

import javax.swing.*;
import java.awt.*;

public class Login {
    public static void main(String[] args) {
        new VentanaLogin();
    }
}

class VentanaLogin extends JFrame{

    public VentanaLogin(){
        setBounds(100,100,500,200);
        setTitle("Identificacion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaminaLogin laminaLogin=new LaminaLogin();
        add(laminaLogin);
        setVisible(true);
    }
}

class LaminaLogin extends JPanel{
    private JLabel lNombre,lPass, lVpass;
    private JTextField tFNombre, tFPass, tFVPass;
    private JButton comprobar;

    private int mayusculas=0, minusculas=0, numeros=0;


    public LaminaLogin(){
        setLayout(new GridLayout(4,2));
        lNombre=new JLabel("Nombre");
        lPass=new JLabel("Password");
        lVpass=new JLabel("Verificar Password");

        tFNombre=new JTextField(10);
        tFPass=new JTextField(10);
        tFVPass=new JTextField(10);

        comprobar=new JButton("Comprobar");
        add(lNombre);
        add(tFNombre);
        add(lPass);
        add(tFPass);
        add(lVpass);
        add(tFVPass);
        add(comprobar);

        comprobar.addActionListener(e->{
            ComprobarPassword();

        });



    }

    private void ComprobarPassword() {
        String pass=tFPass.getText();
        if(pass.length()<8){
            JOptionPane.showMessageDialog(null,"La Contraseña tiene menos de 8 caracteres","ERROR",JOptionPane.ERROR_MESSAGE);

        }else{
            for (int i = 0; i < pass.length(); i++) {
                if(pass.charAt(i)>47 && pass.charAt(i)<58) numeros++;
                if(pass.charAt(i)>64 && pass.charAt(i)<91) mayusculas++;
                if(pass.charAt(i)>96 && pass.charAt(i)<123) minusculas++;

            }

            if(numeros>0 && mayusculas>0 && minusculas>0){
                if(pass.equals(tFVPass.getText())){
                    tFNombre.setText("");
                    tFPass.setText("");
                    tFVPass.setText("");
                    JOptionPane.showMessageDialog(null,"USUARIO y CONTRASEÑAS CORRECTOS","Aceso permitido",JOptionPane.INFORMATION_MESSAGE);

                }else{
                    JOptionPane.showMessageDialog(null,"La contraseña de verificacion es diferente","ERROR",JOptionPane.ERROR_MESSAGE);

                }
            }else{
                JOptionPane.showMessageDialog(null,"La contraseña debe de tener al menos 1 numero, 1 Mayuscula y 1 Minuscula","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            numeros=0;
            mayusculas=0;
            minusculas=0;
        }
    }
}

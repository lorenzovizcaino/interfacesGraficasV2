package componentesSwing.procesadorTextos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        VentanaProcesadorTextos ventanaProcesadorTextos =new VentanaProcesadorTextos();

    }
}

class VentanaProcesadorTextos extends JFrame {
    public VentanaProcesadorTextos(){
        setBounds(100,100,750,500);
        setTitle("Procesador Textos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LaminaProcesadorTextos laminaProcesadorTextos =new LaminaProcesadorTextos();
        add(laminaProcesadorTextos);


        setVisible(true);
    }
}

class LaminaProcesadorTextos extends JPanel{
    private JMenuBar barra;
    private JMenu fuente,estilo,tamaño;
    private JMenuItem arial, courier, verdana;
    private JMenuItem negrita, cursiva;
    private JMenuItem tam1, tam2, tam3, tam4;
    private AccionesProcesadorTextos accionesProcesadorTextos =new AccionesProcesadorTextos();

    private  String font="Tahoma";
    private int style=Font.PLAIN, size=16;
    private int negritas=0;
    private int cursivas=0;
    private boolean boolNegrita=false;
    private boolean boolCursiva=false;


    private JTextPane cajaTexto;



    public LaminaProcesadorTextos(){
        setLayout(new BorderLayout());
        JPanel norte=new JPanel();
        add(norte,BorderLayout.NORTH);


        barra=new JMenuBar();
//        CrearMenu("Fuente");
//        CrearMenu("Estilo");
//        CrearMenu("Tamaño");



        fuente=new JMenu("Fuente");
        estilo=new JMenu("Estilo");
        tamaño=new JMenu("Tamaño");
        barra.add(fuente);
        barra.add(estilo);
        barra.add(tamaño);
        CrearMenuItem(fuente,"Arial");
        CrearMenuItem(fuente,"Courier");
        CrearMenuItem(fuente,"Verdana");
        CrearMenuItem(estilo,"Negrita");
//        negrita=new JMenuItem("Negrita");
//        negrita.addActionListener(new StyledEditorKit.BoldAction());
//        estilo.add(negrita);
        CrearMenuItem(estilo,"Cursiva");
        CrearMenuItem(tamaño,"12");
        CrearMenuItem(tamaño,"16");
        CrearMenuItem(tamaño,"20");
        CrearMenuItem(tamaño,"24");


        norte.add(barra);


        cajaTexto=new JTextPane();
        cajaTexto.setFont(new Font(font,style,size));
        add(cajaTexto,BorderLayout.CENTER);








    }

    private void CrearMenuItem(JMenu jMenu, String nombreMenu) {
        jMenu.add(new JMenuItem(nombreMenu)).addActionListener(accionesProcesadorTextos);
    }

    private void CrearMenu(String nombreMenu) {
        barra.add(new JMenu(nombreMenu));
    }

    private class AccionesProcesadorTextos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {



            if(e.getActionCommand()=="Courier" || e.getActionCommand()=="Verdana" || e.getActionCommand()=="Arial"){
                font=e.getActionCommand();
            }
            if(e.getActionCommand()=="Negrita"){
                negritas++;
                if(negritas%2==0){
                    if(boolCursiva){
                        style=Font.ITALIC;
                        boolNegrita=false;
                    }else{
                        style=Font.PLAIN;
                        boolNegrita=false;
                    }

                }else{
                    style=Font.BOLD;
                    boolNegrita=true;
                }
            }

            if(e.getActionCommand()=="Cursiva"){
                cursivas++;
                if(cursivas%2==0){
                    if(boolNegrita){
                        style=Font.BOLD;
                        boolCursiva=false;
                    }else{
                        style=Font.PLAIN;
                        boolCursiva=false;
                    }
                }else{
                    style=Font.ITALIC;
                    boolCursiva=true;
                }
            }

            if(boolCursiva && boolNegrita){
                style=3;
            }
            if(e.getActionCommand()=="12" || e.getActionCommand()=="16" || e.getActionCommand()=="20" || e.getActionCommand()=="24"){
                size= Integer.parseInt(e.getActionCommand());
            }
            cajaTexto.setFont(new Font(font,style,size));



        }
    }


}
package componentesSwing.procesadorTextos2;

import javax.swing.*;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        VentanaProcesadorTextos2 ventanaProcesadorTextos2 =new VentanaProcesadorTextos2();

    }
}

class VentanaProcesadorTextos2 extends JFrame {
    public VentanaProcesadorTextos2(){
        setBounds(100,100,750,550);
        setTitle("Procesador Textos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LaminaProcesadorTextos2 laminaProcesadorTextos2 =new LaminaProcesadorTextos2();
        add(laminaProcesadorTextos2);
        setVisible(true);
    }
}

class LaminaProcesadorTextos2 extends JPanel{
    private JMenuBar barra;
    private JMenu fuente,estilo,tamaño;
    private  String font="Tahoma";
    private int style=Font.PLAIN, size=16;
    private JTextPane cajaTexto;
    private JToolBar jToolBar;




    public LaminaProcesadorTextos2(){
        setLayout(new BorderLayout());
        JPanel norte=new JPanel();
        add(norte,BorderLayout.NORTH);

        barra=new JMenuBar();
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
        CrearMenuItem(estilo,"Cursiva");
        CrearMenuItem(tamaño,"12");
        CrearMenuItem(tamaño,"16");
        CrearMenuItem(tamaño,"20");
        CrearMenuItem(tamaño,"24");

        norte.add(barra);

        cajaTexto=new JTextPane();
        cajaTexto.setFont(new Font(font,style,size));
        add(cajaTexto,BorderLayout.CENTER);

        jToolBar=new JToolBar(JToolBar.VERTICAL);

        CrearBarraVertical("Negrita",new ImageIcon("D:\\MEGA\\VERANO 23\\INTERFACES GRAFICAS\\InteliJ\\interfacesGraficas\\src\\componentesSwing\\procesadorTextos2\\Negrita.png"));
        CrearBarraVertical("Cursiva",new ImageIcon("D:\\MEGA\\VERANO 23\\INTERFACES GRAFICAS\\InteliJ\\interfacesGraficas\\src\\componentesSwing\\procesadorTextos2\\Cursiva.png"));
        CrearBarraVertical("Subrayado",new ImageIcon("D:\\MEGA\\VERANO 23\\INTERFACES GRAFICAS\\InteliJ\\interfacesGraficas\\src\\componentesSwing\\procesadorTextos2\\Subrayado.png"));
        CrearBarraVertical("Verde",new ImageIcon("D:\\MEGA\\VERANO 23\\INTERFACES GRAFICAS\\InteliJ\\interfacesGraficas\\src\\componentesSwing\\procesadorTextos2\\bolaVerde.png"));
        CrearBarraVertical("Rojo",new ImageIcon("D:\\MEGA\\VERANO 23\\INTERFACES GRAFICAS\\InteliJ\\interfacesGraficas\\src\\componentesSwing\\procesadorTextos2\\bolaRoja.png"));
        CrearBarraVertical("Amarillo",new ImageIcon("D:\\MEGA\\VERANO 23\\INTERFACES GRAFICAS\\InteliJ\\interfacesGraficas\\src\\componentesSwing\\procesadorTextos2\\bolaAmarilla.png"));
        CrearBarraVertical("A_Izquierda",new ImageIcon("D:\\MEGA\\VERANO 23\\INTERFACES GRAFICAS\\InteliJ\\interfacesGraficas\\src\\componentesSwing\\procesadorTextos2\\Izquierda.png"));
        CrearBarraVertical("A_Derecha",new ImageIcon("D:\\MEGA\\VERANO 23\\INTERFACES GRAFICAS\\InteliJ\\interfacesGraficas\\src\\componentesSwing\\procesadorTextos2\\Derecha.png"));
        CrearBarraVertical("A_Centrada",new ImageIcon("D:\\MEGA\\VERANO 23\\INTERFACES GRAFICAS\\InteliJ\\interfacesGraficas\\src\\componentesSwing\\procesadorTextos2\\Centrado.png"));
        CrearBarraVertical("A_Justificada",new ImageIcon("D:\\MEGA\\VERANO 23\\INTERFACES GRAFICAS\\InteliJ\\interfacesGraficas\\src\\componentesSwing\\procesadorTextos2\\Justificado.png"));






        add(jToolBar,BorderLayout.WEST);




    }

    private void CrearBarraVertical(String nombre, ImageIcon imageIcon) {
        JButton boton=new JButton(imageIcon);
        if(nombre.equals("Negrita")) boton.addActionListener(new StyledEditorKit.BoldAction());
        if(nombre.equals("Cursiva")) boton.addActionListener(new StyledEditorKit.ItalicAction());
        if(nombre.equals("Subrayado")) boton.addActionListener(new StyledEditorKit.UnderlineAction());
        if(nombre.equals("Verde")) boton.addActionListener(new StyledEditorKit.ForegroundAction("Verde",new Color(79,122,45)));
        if(nombre.equals("Rojo")) boton.addActionListener(new StyledEditorKit.ForegroundAction("Rojo",new Color(255,0,0)));
        if(nombre.equals("Amarillo")) boton.addActionListener(new StyledEditorKit.ForegroundAction("Amarillo",new Color(254,238,0)));
        if(nombre.equals("A_Izquierda")) boton.addActionListener(new StyledEditorKit.AlignmentAction("Alineacion Izquierda", StyleConstants.ALIGN_LEFT));
        if(nombre.equals("A_Derecha")) boton.addActionListener(new StyledEditorKit.AlignmentAction("Alineacion Derecha", StyleConstants.ALIGN_RIGHT));
        if(nombre.equals("A_Centrada")) boton.addActionListener(new StyledEditorKit.AlignmentAction("Alineacion Centrada", StyleConstants.ALIGN_CENTER));
        if(nombre.equals("A_Justificada")) boton.addActionListener(new StyledEditorKit.AlignmentAction("Alineacion Justificada", StyleConstants.ALIGN_JUSTIFIED));

        jToolBar.add(boton);
    }

    private void CrearMenuItem(JMenu jMenu, String nombreMenu) {
        JMenuItem jMenuItem=new JMenuItem(nombreMenu);
        jMenu.add(jMenuItem);

        if(jMenu.getActionCommand().equals("Fuente")){
            jMenuItem.addActionListener(new StyledEditorKit.FontFamilyAction("cambiarLetra",nombreMenu));
        }

        if(jMenu.getActionCommand().equals("Estilo")){
            if(jMenuItem.getActionCommand().equals("Negrita")){
                jMenuItem.addActionListener(new StyledEditorKit.BoldAction());
            }else{
                jMenuItem.addActionListener(new StyledEditorKit.ItalicAction());
            }

        }

        if(jMenu.getActionCommand().equals("Tamaño")){
            jMenuItem.addActionListener(new StyledEditorKit.FontSizeAction("tamañoLetra",Integer.parseInt(nombreMenu)));
        }

        //"cambiarLetra Y tamañoLetra SE PODRÍA PONER CUALQUIER String, NO TIENE IMPORTANCIA LO QUE SE PONGA

    }


}
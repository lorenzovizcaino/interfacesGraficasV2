package discoduroderoer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class c_MiniEncuesta {
    public static void main(String[] args) {
        new VentanaMiniEncuesta();
    }
}

class VentanaMiniEncuesta extends JFrame{

    public VentanaMiniEncuesta(){
        setBounds(100,100,300,500);
        setTitle("Mini Encuesta");
        LaminaMiniEncuesta laminaMiniEncuesta=new LaminaMiniEncuesta();
        add(laminaMiniEncuesta);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class LaminaMiniEncuesta extends JPanel{

    private JLabel sistemaOperativo, especialidad, horasLabel, horas;
    private JRadioButton windows,linux,mac;
    private JCheckBox programacion, diseño, administracion;

    private JSlider horasSlider;
    private JButton generar;
    private ButtonGroup grupo;
    private GBCConstrains constrains;
    private String mensaje="Tu sistema operativo preferido es ";
    private String mensaje2="";
    private int contadorEspecialidades;
    private JSeparator separador1,separador2;



    public LaminaMiniEncuesta(){
        setLayout(new GridBagLayout());
        constrains=new GBCConstrains();


        sistemaOperativo=new JLabel("Elige un sistema operativo");
        windows=new JRadioButton("Windows",true);
        linux=new JRadioButton("Linux");
        mac=new JRadioButton("Mac");
        grupo=new ButtonGroup();
        grupo.add(windows);
        grupo.add(linux);
        grupo.add(mac);

        separador1=new JSeparator();

        especialidad=new JLabel("Elige tu especialidad");
        programacion=new JCheckBox("Programacion");
        diseño=new JCheckBox("Diseño grafico");
        administracion=new JCheckBox("Administracion");

        separador2=new JSeparator();

        horasLabel=new JLabel("Horas que dedicas en el ordenador");
        horas=new JLabel("0    ");
        horasSlider=new JSlider(0,8,0);
        horasSlider.setMajorTickSpacing(4);
        horasSlider.setMinorTickSpacing(1);
        horasSlider.setPaintTicks(true);
        horasSlider.setPaintLabels(true);

        generar=new JButton("Generar");
        JPanel slider=new JPanel();
        slider.add(horas);
        slider.add(horasSlider);



        add(sistemaOperativo,constrains.Constrains(0,0,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,0,5,0)));
        add(windows,constrains.Constrains(0,1,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,0,5,0)));
        add(linux,constrains.Constrains(0,2,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,0,5,0)));
        add(mac,constrains.Constrains(0,3,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,0,5,0)));
        add(separador1,constrains.Constrains(0,4,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,0,5,0)));
        add(especialidad,constrains.Constrains(0,5,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,0,5,0)));
        add(programacion,constrains.Constrains(0,6,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,0,5,0)));
        add(diseño,constrains.Constrains(0,7,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,0,5,0)));
        add(administracion,constrains.Constrains(0,8,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,0,5,0)));
        add(separador2,constrains.Constrains(0,9,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,0,5,0)));
        add(horasLabel,constrains.Constrains(0,10,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,0,5,0)));
        add(slider,constrains.Constrains(0,11,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,0,5,0)));
        add(generar,constrains.Constrains(0,12,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,70,5,70)));

        horasSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                horas.setText(String.valueOf(horasSlider.getValue())+"    ");
            }
        });




        generar.addActionListener(e->{
            if (windows.isSelected()) mensaje+="Windows,";
            if(linux.isSelected()) mensaje+="Linux,";
            if(mac.isSelected()) mensaje+="Mac,";
            if(programacion.isSelected()){
                contadorEspecialidades++;
                mensaje2+="Programacion";
            }
            if(diseño.isSelected()){
                contadorEspecialidades++;
                mensaje2+=", Diseño grafico";
            }
            if(administracion.isSelected()){
                contadorEspecialidades++;
                mensaje2+=", Administracion";
            }

            if(contadorEspecialidades==0){
                mensaje+=" no tienes especialidades";
            }
            else if(contadorEspecialidades==1){
                mensaje+=" tu especialidad es "+mensaje2;
            }
            else{
                mensaje+=" tus especialidades son "+mensaje2;
            }
            mensaje+=" y el numero de horas dedicadas la ordenador son "+horas.getText();

            JOptionPane.showMessageDialog(this,mensaje,"Muestra de datos",JOptionPane.INFORMATION_MESSAGE);
            mensaje="Tu sistema operativo preferido es ";
            mensaje2="";
            contadorEspecialidades=0;
        });






    }

}


package discoduroderoer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class e_Imitador {
    public static void main(String[] args) {
        new VentanaImitador();
    }
}
class VentanaImitador extends JFrame{

    public VentanaImitador(){
        setBounds(100,100,400,400);
        setTitle("Imitador");
        LaminaImitador laminaImitador=new LaminaImitador();
        add(laminaImitador);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
class LaminaImitador extends JPanel{
    private JLabel original, espejo;
    private JRadioButton opcion1, opcion2,opcion3, opcion1Espejo, opcion2Espejo, opcion3Espejo;
    private ButtonGroup grupo, grupoEspejo;
    private JCheckBox opcion4, opcion5, opcion6, opcion4Espejo, opcion5Espejo, opcion6Espejo;
    private JTextField tField, tFieldEspejo;
    private JComboBox combo, comboEspejo;
    private JSpinner spinner, spinnerEspejo;
    private JSeparator separador;
    private String[] items={"item1", "item2", "item3"};
    GBCConstrains constrains=new GBCConstrains();

    public LaminaImitador(){
        setLayout(new GridBagLayout());
        original=new JLabel("Original");
        opcion1=new JRadioButton("Opcion1");
        opcion2=new JRadioButton("Opcion2",true);
        opcion3=new JRadioButton("Opcion3");
        grupo=new ButtonGroup();
        grupo.add(opcion1);
        grupo.add(opcion2);
        grupo.add(opcion3);
        opcion4=new JCheckBox("Opcion 4",true);
        opcion5=new JCheckBox("Opcion 5",true);
        opcion6=new JCheckBox("Opcion 6");
        tField=new JTextField("Op1",10);
        combo=new JComboBox<>(items);
        spinner=new JSpinner(new SpinnerNumberModel(0,0,20,1));
        separador=new JSeparator();

        espejo=new JLabel("Espejo");
        opcion1Espejo=new JRadioButton("Opcion1",opcion1.isSelected());
        opcion1Espejo.setEnabled(false);
        opcion2Espejo=new JRadioButton("Opcion2",opcion2.isSelected());
        opcion2Espejo.setEnabled(false);
        opcion3Espejo=new JRadioButton("Opcion3",opcion3.isSelected());
        opcion3Espejo.setEnabled(false);
        grupoEspejo=new ButtonGroup();
        grupoEspejo.add(opcion1Espejo);
        grupoEspejo.add(opcion2Espejo);
        grupoEspejo.add(opcion3Espejo);
        opcion4Espejo=new JCheckBox("Opcion 4",opcion4.isSelected());
        opcion4Espejo.setEnabled(false);
        opcion5Espejo=new JCheckBox("Opcion 5",opcion5.isSelected());
        opcion5Espejo.setEnabled(false);
        opcion6Espejo=new JCheckBox("Opcion 6",opcion6.isSelected());
        opcion6Espejo.setEnabled(false);
        tFieldEspejo=new JTextField(tField.getText(),10);
        tFieldEspejo.setEnabled(false);
        comboEspejo=new JComboBox<>(items);
        comboEspejo.setEnabled(false);
        spinnerEspejo=new JSpinner(new SpinnerNumberModel(0,0,20,1));
        spinnerEspejo.setEnabled(false);



        opcion1.addActionListener(e->{
            opcion1Espejo.setSelected(opcion1.isSelected());
        });

        opcion2.addActionListener(e->{
            opcion2Espejo.setSelected(opcion2.isSelected());
        });

        opcion3.addActionListener(e->{
            opcion3Espejo.setSelected(opcion3.isSelected());
        });

        opcion4.addActionListener(e->{
            opcion4Espejo.setSelected(opcion4.isSelected());
        });
        opcion5.addActionListener(e->{
            opcion5Espejo.setSelected(opcion5.isSelected());
        });
        opcion6.addActionListener(e->{
            opcion6Espejo.setSelected(opcion6.isSelected());
        });

        tField.addActionListener(e->{
            tFieldEspejo.setText(tField.getText());
        });
        tField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                tFieldEspejo.setText(tField.getText());
            }
        });

        combo.addActionListener(e->{
            comboEspejo.setSelectedItem(combo.getSelectedItem());
        });

        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                spinnerEspejo.setValue(spinner.getValue());
            }
        });



        add(original,constrains.Constrains(0,0,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(opcion1,constrains.Constrains(0,1,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(opcion2,constrains.Constrains(0,2,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(opcion3,constrains.Constrains(0,3,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(opcion4,constrains.Constrains(1,1,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(opcion5,constrains.Constrains(1,2,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(opcion6,constrains.Constrains(1,3,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(tField,constrains.Constrains(2,1,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(combo,constrains.Constrains(2,2,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(spinner,constrains.Constrains(2,3,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));

        add(separador,constrains.Constrains(0,4,3,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));

        add(espejo,constrains.Constrains(0,5,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(opcion1Espejo,constrains.Constrains(0,6,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(opcion2Espejo,constrains.Constrains(0,7,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(opcion3Espejo,constrains.Constrains(0,8,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(opcion4Espejo,constrains.Constrains(1,6,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(opcion5Espejo,constrains.Constrains(1,7,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(opcion6Espejo,constrains.Constrains(1,8,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(tFieldEspejo,constrains.Constrains(2,6,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(comboEspejo,constrains.Constrains(2,7,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));
        add(spinnerEspejo,constrains.Constrains(2,8,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,10,5,10)));

    }
}
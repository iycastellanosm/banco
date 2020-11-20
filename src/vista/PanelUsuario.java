/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Ivan
 */
public class PanelUsuario extends JPanel{
    JTextField infoDocumento;
    JTextField infoNombre;
    JTextField infoApellido;
    JRadioButton infoMasculino;
    JRadioButton infoFemenino;
    JRadioButton infoOtro;
    JTextField infoOcupacion;
    JTextField infoCorreo;
    JTextField infoTelefono;
    JTextField infoDireccion;
    JLabel labelDocumento;
    JLabel labelNombre;
    JLabel labelApellido;
    JLabel labelGenero;
    JLabel labelDireccion;
    JLabel labelTelefono;
    JLabel labelCorreo;
    JLabel labelOcupacion;
            
    PanelUsuario(){
        GridLayout grilla1 = new GridLayout(0, 2);
        this.setLayout(grilla1);
        labelDocumento = new JLabel("Documento", JLabel.LEFT);
        this.add(labelDocumento);
        infoDocumento = new JTextField();
        this.add(infoDocumento);
        labelNombre = new JLabel("Nombre(s)", JLabel.LEFT);
        this.add(labelNombre);
        infoNombre = new JTextField();
        this.add(infoNombre);
        labelApellido = new JLabel("Apellido(s)", JLabel.LEFT);
        this.add(labelApellido);
        infoApellido = new JTextField();
        this.add(infoApellido);
        labelGenero = new JLabel("Genero", JLabel.LEFT);
        this.add(labelGenero);
        JPanel panelGenero = new JPanel();
        infoMasculino = new JRadioButton("Masculino");
        infoFemenino = new JRadioButton("Femenino");
        infoOtro = new JRadioButton("Otro");
        ButtonGroup infoGenero = new ButtonGroup();
        infoGenero.add(infoMasculino);
        infoGenero.add(infoFemenino);
        infoGenero.add(infoOtro);
        infoMasculino.setSelected(true);
        panelGenero.add(infoMasculino);
        panelGenero.add(infoFemenino);
        panelGenero.add(infoOtro);
        this.add(panelGenero);
        labelDireccion = new JLabel("Direccion", JLabel.LEFT);
        this.add(labelDireccion);
        infoDireccion = new JTextField();
        this.add(infoDireccion);
        labelTelefono = new JLabel("Telefono", JLabel.LEFT);
        this.add(labelTelefono);
        infoTelefono = new JTextField(12);
        this.add(infoTelefono);
        labelCorreo = new JLabel("Correo", JLabel.LEFT);
        this.add(labelCorreo);
        infoCorreo = new JTextField();
        this.add(infoCorreo);
        labelOcupacion = new JLabel("Ocupacion", JLabel.LEFT);
        this.add(labelOcupacion);
        infoOcupacion = new JTextField();
        this.add(infoOcupacion);
    }
    
    public void setInvisible(){
        infoNombre.setVisible(false);
        infoApellido.setVisible(false);
        infoOcupacion.setVisible(false);
        infoTelefono.setVisible(false);
        infoCorreo.setVisible(false);
        infoDireccion.setVisible(false);
        infoMasculino.setVisible(false);
        infoFemenino.setVisible(false);
        infoOtro.setVisible(false);
        labelNombre.setVisible(false);
        labelApellido.setVisible(false);
        labelGenero.setVisible(false);
        labelDireccion.setVisible(false);
        labelTelefono.setVisible(false);
        labelCorreo.setVisible(false);
        labelOcupacion.setVisible(false);
    }
    
}

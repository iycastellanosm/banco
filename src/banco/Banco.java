/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Ivan
 */
public class Banco { // hacer un banco -> 

    // FRONTEND esto se hace con código (de Java)
    // BACKEND esto de hace con código (de Java)
    
    /**
     * @param args the command line arguments
     */
    public static void funcionPrincipal(){
        JFrame ventanaPrincipal = new JFrame();
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setSize(500, 500);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setLocation(300, 100);
        ventanaPrincipal.setTitle("Ventana Principal");
        GridLayout grilla1 = new GridLayout(0, 1);
        JPanel panel = new JPanel();
        panel.setLayout(grilla1);
        ventanaPrincipal.add(panel);
        panel.setSize(200, 200);
        JLabel titulo = new JLabel("Mi Aplicación de Banco", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(titulo);
        BotonPrincipal boton1 = new BotonPrincipal("Gestión cuentas de usuario");
        BotonPrincipal boton2 = new BotonPrincipal("Gestion cuentas bancarias");
        panel.add(boton1);
        panel.add(boton2);
        
        ActionListener clickBoton = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                //System.out.println("HOLA");
                ventanaPrincipal.setVisible(false);
                gestionUsuarios();
            }
        };
        boton1.addActionListener(clickBoton);
    }
    
    public static void gestionUsuarios(){
        JFrame ventanaUsuarios = new JFrame();
        ventanaUsuarios.setVisible(true);
        ventanaUsuarios.setSize(500, 500);
        ventanaUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaUsuarios.setLocation(300, 100);
        ventanaUsuarios.setTitle("Gestion Usuarios");  
        GridLayout grilla1 = new GridLayout(0, 1);
        JPanel panel = new JPanel();
        panel.setLayout(grilla1);
        ventanaUsuarios.add(panel);
        panel.setSize(200, 200);
        JLabel titulo = new JLabel("Gestion usuarios", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(titulo);
        BotonPrincipal boton1 = new BotonPrincipal("Crear usuario");
        BotonPrincipal boton2 = new BotonPrincipal("Consultar usuario");
        BotonPrincipal boton3 = new BotonPrincipal("Actualizar usuario");
        BotonPrincipal boton4 = new BotonPrincipal("Borrar usuario");
        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);
        
        ActionListener clickBoton = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                //System.out.println("HOLA");
                ventanaUsuarios.dispose();
                crearUsuarios();
            }
        };
        boton1.addActionListener(clickBoton);
    }
    
    public static void gestionCuentas(){
        JFrame ventanaUsuarios = new JFrame();
        ventanaUsuarios.setVisible(true);
        ventanaUsuarios.setSize(500, 500);
        ventanaUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaUsuarios.setLocation(300, 100);
        ventanaUsuarios.setTitle("Gestion Cuentas");  
        GridLayout grilla1 = new GridLayout(0, 1);
        JPanel panel = new JPanel();
        panel.setLayout(grilla1);
        ventanaUsuarios.add(panel);
        panel.setSize(200, 200);
        JLabel titulo = new JLabel("Gestion cuentas", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(titulo);
        BotonPrincipal boton1 = new BotonPrincipal("Crear cuenta");
        BotonPrincipal boton2 = new BotonPrincipal("Consultar cuenta");
        BotonPrincipal boton3 = new BotonPrincipal("Actualizar cuenta");
        BotonPrincipal boton4 = new BotonPrincipal("Borrar cuenta");
        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);
    }
    
    public static void crearUsuarios(){
        JFrame ventanaUsuarios = new JFrame();
        ventanaUsuarios.setVisible(true);
        ventanaUsuarios.setSize(500, 500);
        ventanaUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaUsuarios.setLocation(300, 100);
        ventanaUsuarios.setTitle("Crear usuario");  
        GridLayout grilla1 = new GridLayout(0, 2);
        JPanel panelTitulo = new JPanel();
        JPanel panel = new JPanel();
        JPanel panelSubmit = new JPanel();
        JPanel panelAuxiliar = new JPanel(new GridLayout(0, 1));
        panelAuxiliar.add(panelTitulo);
        panelAuxiliar.add(panel);
        panelAuxiliar.add(panelSubmit);
        ventanaUsuarios.add(panelAuxiliar);
        panel.setLayout(grilla1);
        panel.setSize(200, 200);
        JLabel titulo = new JLabel("Crear usuario", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        panelTitulo.add(titulo);
        JLabel labelDocumento = new JLabel("Documento", JLabel.CENTER);
        panel.add(labelDocumento);
        JTextField infoDocumento = new JTextField();
        panel.add(infoDocumento);
        JLabel labelNombre = new JLabel("Nombre(s)", JLabel.CENTER);
        panel.add(labelNombre);
        JTextField infoNombre = new JTextField();
        panel.add(infoNombre);
        JLabel labelApellido = new JLabel("Apellido(s)", JLabel.CENTER);
        panel.add(labelApellido);
        JTextField infoApellido = new JTextField();
        panel.add(infoApellido);
        JLabel labelGenero = new JLabel("Genero", JLabel.CENTER);
        panel.add(labelGenero);
        JPanel panelGenero = new JPanel();
        JRadioButton infoMasculino = new JRadioButton("Masculino");
        infoMasculino.setSelected(true);
        JRadioButton infoFemenino = new JRadioButton("Femenino");
        JRadioButton infoOtro = new JRadioButton("Otro");
        ButtonGroup infoGenero = new ButtonGroup();
        infoGenero.add(infoMasculino);
        infoGenero.add(infoFemenino);
        infoGenero.add(infoOtro);
        panelGenero.add(infoMasculino);
        panelGenero.add(infoFemenino);
        panelGenero.add(infoOtro);
        panel.add(panelGenero);
        JLabel labelDireccion = new JLabel("Direccion", JLabel.CENTER);
        panel.add(labelDireccion);
        JTextField infoDireccion = new JTextField();
        panel.add(infoDireccion);
        JLabel labelTelefono = new JLabel("Telefono", JLabel.CENTER);
        panel.add(labelTelefono);
        JTextField infoTelefono = new JTextField();
        panel.add(infoTelefono);
        JLabel labelCorreo = new JLabel("Correo", JLabel.CENTER);
        panel.add(labelCorreo);
        JTextField infoCorreo = new JTextField();
        panel.add(infoCorreo);
        JLabel labelOcupacion = new JLabel("Ocupacion", JLabel.CENTER);
        panel.add(labelOcupacion);
        JTextField infoOcupacion = new JTextField();
        panel.add(infoOcupacion);
        JButton submitUsuario = new JButton();
        submitUsuario.setText("Enviar");
        panelSubmit.add(submitUsuario);
        
        ActionListener clickBoton = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String documento = infoDocumento.getText();
                String nombre = infoNombre.getText();
                String apellido = infoApellido.getText();
                String direccion = infoDireccion.getText();
                String telefono = infoTelefono.getText();
                String correo = infoCorreo.getText();
                String ocupacion = infoOcupacion.getText();
                String genero;
                if(infoMasculino.isSelected()){
                    genero = "Masculino";
                }
                else if(infoFemenino.isSelected()){
                    genero = "Femenino";
                }
                else{
                    genero = "Otro";
                }
                System.out.println("documento: " + documento);
                System.out.println("nombres: " + nombre);
                System.out.println("apellidos: " + apellido);
                System.out.println("genero: " + genero);
                System.out.println("direccion: " + direccion);
                System.out.println("telefono: " + telefono);
                System.out.println("correo: " + correo);
                System.out.println("ocupacion: " + ocupacion);
            }
        };
        submitUsuario.addActionListener(clickBoton);
    }
    
    public static void main(String[] args) {
        funcionPrincipal();
        //gestionUsuarios();
        //gestionCuentas();
        //crearUsuarios();
        
    }
}

class BotonPrincipal extends JButton{
    BotonPrincipal(String texto){
        super();
        this.setPreferredSize(new Dimension(100, 100));
        this.setText(texto);
        this.setFont(new Font("Arial", Font.ITALIC, 20));
    }
}

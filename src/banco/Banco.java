/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Ivan
 */
public class Banco { // hacer un banco -> 
    
    /**
     * @param args the command line arguments
     */
    public static void funcionPrincipal(){
        VentanaPrincipal ventana = new VentanaPrincipal("Ventana Principal");

        GridLayout grilla1 = new GridLayout(0, 1);
        JPanel panel = new JPanel();
        panel.setLayout(grilla1);
        ventana.add(panel);
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
                ventana.setVisible(false);
                gestionUsuarios();
            }
        };
        boton1.addActionListener(clickBoton);
    }
    
    public static void gestionUsuarios(){
        VentanaPrincipal ventana = new VentanaPrincipal("Gestion Usuarios");
        
        GridLayout grilla1 = new GridLayout(0, 1);
        JPanel panel = new JPanel();
        panel.setLayout(grilla1);
        ventana.add(panel);
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
                ventana.dispose();
                crearUsuarios();
            }
        };
        boton1.addActionListener(clickBoton);
    }
    
    public static void gestionCuentas(){
        VentanaPrincipal ventana = new VentanaPrincipal("Gestion Cuentas");
        
        GridLayout grilla1 = new GridLayout(0, 1);
        JPanel panel = new JPanel();
        panel.setLayout(grilla1);
        ventana.add(panel);
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
        VentanaPrincipal ventana = new VentanaPrincipal("Crear usuario");

        PanelTitulo panelTitulo = new PanelTitulo("Crear usuario");
        PanelUsuario panelUsuario = new PanelUsuario();
        JPanel panelSubmit = new JPanel();
        JPanel panelAuxiliar = new JPanel(new FlowLayout());
        panelAuxiliar.add(panelTitulo);
        panelAuxiliar.add(panelUsuario);
        panelAuxiliar.add(panelSubmit);
        ventana.add(panelAuxiliar);
        JButton submitUsuario = new JButton();
        submitUsuario.setBackground(Color.yellow);
        submitUsuario.setText("Enviar");
        panelSubmit.add(submitUsuario);
        
        ActionListener clickBoton = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String documento = panelUsuario.infoDocumento.getText();
                String nombre = panelUsuario.infoNombre.getText();
                String apellido = panelUsuario.infoApellido.getText();
                String direccion = panelUsuario.infoDireccion.getText();
                String telefono = panelUsuario.infoTelefono.getText();
                String correo = panelUsuario.infoCorreo.getText();
                String ocupacion = panelUsuario.infoOcupacion.getText();
                String genero;
                if(panelUsuario.infoMasculino.isSelected()){
                    genero = "Masculino";
                }
                else if(panelUsuario.infoFemenino.isSelected()){
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
                JOptionPane.showMessageDialog(null, "El usuario fue agregado con exito");
            }
        };
        submitUsuario.addActionListener(clickBoton);
    }
    
    public static void modificarUsuarios(){
        VentanaPrincipal ventana = new VentanaPrincipal("Modificar usuario");

        PanelTitulo panelTitulo = new PanelTitulo("Modificar usuario");
        PanelUsuario panelUsuario = new PanelUsuario();
        JPanel panelSubmit = new JPanel();
        JPanel panelAuxiliar = new JPanel(new FlowLayout());
        panelAuxiliar.add(panelTitulo);
        panelAuxiliar.add(panelUsuario);
        panelAuxiliar.add(panelSubmit);
        ventana.add(panelAuxiliar);
        JButton submitUsuario = new JButton();
        submitUsuario.setText("Enviar");
        panelSubmit.add(submitUsuario);
    }
    
    public static void consultarUsuarios(){
        VentanaPrincipal ventana = new VentanaPrincipal("Consultrar usuario");

        PanelTitulo panelTitulo = new PanelTitulo("Consultar usuario");
        PanelUsuario panelUsuario = new PanelUsuario();
        JPanel panelSubmit = new JPanel();
        JPanel panelAuxiliar = new JPanel(new FlowLayout());
        
        panelUsuario.infoNombre.setEditable(false);
        panelUsuario.infoApellido.setEditable(false);
        panelUsuario.infoOcupacion.setEditable(false);
        panelUsuario.infoTelefono.setEditable(false);
        panelUsuario.infoCorreo.setEditable(false);
        panelUsuario.infoDireccion.setEditable(false);
        
        panelAuxiliar.add(panelTitulo);
        panelAuxiliar.add(panelUsuario);
        panelAuxiliar.add(panelSubmit);
        ventana.add(panelAuxiliar);
        JButton submitUsuario = new JButton();
        submitUsuario.setText("Enviar");
        panelSubmit.add(submitUsuario);
    }
    
    public static void borrarUsuarios(){
        VentanaPrincipal ventana = new VentanaPrincipal("Borrar usuario");

        PanelTitulo panelTitulo = new PanelTitulo("Borrar usuario");
        PanelUsuario panelUsuario = new PanelUsuario();
        JPanel panelSubmit = new JPanel();
        JPanel panelAuxiliar = new JPanel(new FlowLayout());
        panelAuxiliar.add(panelTitulo);
        panelAuxiliar.add(panelUsuario);
        panelAuxiliar.add(panelSubmit);
        ventana.add(panelAuxiliar);
        JButton submitUsuario = new JButton();
        submitUsuario.setText("Enviar");
        panelSubmit.add(submitUsuario);
    }
    
    public static void main(String[] args) {
        funcionPrincipal();
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

class VentanaPrincipal extends JFrame{
    VentanaPrincipal(String texto){
        super();
        this.setVisible(true);
        this.setSize(500, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 100);
        this.setTitle(texto);
    }
}

class PanelTitulo extends JPanel{
    PanelTitulo(String texto){
        super();
        JLabel titulo = new JLabel(texto, JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        this.add(titulo);
    }
}
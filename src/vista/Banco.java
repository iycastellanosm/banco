/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import controlador.*;
import model.Usuario;

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
        
        ActionListener clickBoton1 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                //System.out.println("HOLA");
                ventana.dispose();
                crearUsuarios();
            }
        };
        ActionListener clickBoton2 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                //System.out.println("HOLA");
                ventana.dispose();
                consultarUsuarios();
            }
        };
        ActionListener clickBoton3 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                //System.out.println("HOLA");
                ventana.dispose();
                modificarUsuarios();
            }
        };
        ActionListener clickBoton4 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                //System.out.println("HOLA");
                ventana.dispose();
                borrarUsuarios();
            }
        };
        boton1.addActionListener(clickBoton1);
        boton2.addActionListener(clickBoton2);
        boton3.addActionListener(clickBoton3);
        boton4.addActionListener(clickBoton4);
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
        BotonAtras irAtras = new BotonAtras();
        panelSubmit.add(irAtras);
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
                int codigoResultado = ControladorUsuario.crearUsuario(documento, nombre, apellido, genero, direccion, telefono, correo, ocupacion);
                switch(codigoResultado){
                    case 0:
                        JOptionPane.showMessageDialog(null, "El usuario fue agregado con exito");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Debe ingregar un apellido");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese documento");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Hubo un error");
                        break;
                }
            }
        };
        submitUsuario.addActionListener(clickBoton);
        
        ActionListener clickAtras = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                ventana.dispose();
                gestionUsuarios();
            }
        };
        irAtras.addActionListener(clickAtras);
    }
    
    public static void modificarUsuarios(){
        VentanaPrincipal ventana = new VentanaPrincipal("Modificar usuario");

        PanelTitulo panelTitulo = new PanelTitulo("Modificar usuario");
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
        BotonAtras irAtras = new BotonAtras();
        panelSubmit.add(irAtras);
        JButton submitUsuario = new JButton();
        submitUsuario.setText("Enviar");
        panelSubmit.add(submitUsuario);
        
        ActionListener clickAtras = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                ventana.dispose();
                gestionUsuarios();
            }
        };
        irAtras.addActionListener(clickAtras);
        
        ActionListener clickEnviar2 = new ActionListener(){
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
                int codigoResultado = ControladorUsuario.actualizarUsuario(documento, nombre, apellido, genero, direccion, telefono, correo, ocupacion);
                switch(codigoResultado){
                    case 0:
                        JOptionPane.showMessageDialog(null, "El usuario fue actualizado con exito");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Debe ingregar un apellido");
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "El telefono es invalido");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Hubo un error");
                        break;
                }
            }
        };
        
        ActionListener clickEnviar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String documento = panelUsuario.infoDocumento.getText();
                //System.out.println(documento);
                Usuario usuarioConsultado = ControladorUsuario.consultarUsuario(documento);
                if(usuarioConsultado != null){
                    panelUsuario.infoNombre.setText(usuarioConsultado.getNombres());
                    panelUsuario.infoApellido.setText(usuarioConsultado.getApellidos());
                    panelUsuario.infoOcupacion.setText(usuarioConsultado.getOcupacion());
                    panelUsuario.infoTelefono.setText(usuarioConsultado.getTelefono());
                    panelUsuario.infoCorreo.setText(usuarioConsultado.getCorreo());
                    panelUsuario.infoDireccion.setText(usuarioConsultado.getDireccion());
                    panelUsuario.infoNombre.setEditable(true);
                    panelUsuario.infoApellido.setEditable(true);
                    panelUsuario.infoOcupacion.setEditable(true);
                    panelUsuario.infoTelefono.setEditable(true);
                    panelUsuario.infoCorreo.setEditable(true);
                    panelUsuario.infoDireccion.setEditable(true);
                    panelUsuario.infoDocumento.setEditable(false);
                    submitUsuario.removeActionListener(this);
                    submitUsuario.addActionListener(clickEnviar2);
                }
                else{
                    panelUsuario.infoNombre.setText("");
                    panelUsuario.infoApellido.setText("");
                    panelUsuario.infoOcupacion.setText("");
                    panelUsuario.infoTelefono.setText("");
                    panelUsuario.infoCorreo.setText("");
                    panelUsuario.infoDireccion.setText("");
                    JOptionPane.showMessageDialog(null, "No existe ningun usuario con ese documento");
                }
                //ventana.dispose();
                //gestionUsuarios();
            }
        };
        
        
        submitUsuario.addActionListener(clickEnviar);
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
        BotonAtras irAtras = new BotonAtras();
        panelSubmit.add(irAtras);
        JButton submitUsuario = new JButton();
        submitUsuario.setText("Enviar");
        panelSubmit.add(submitUsuario);
        
        ActionListener clickEnviar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String documento = panelUsuario.infoDocumento.getText();
                //System.out.println(documento);
                Usuario usuarioConsultado = ControladorUsuario.consultarUsuario(documento);
                if(usuarioConsultado != null){
                    panelUsuario.infoNombre.setText(usuarioConsultado.getNombres());
                    panelUsuario.infoApellido.setText(usuarioConsultado.getApellidos());
                    panelUsuario.infoOcupacion.setText(usuarioConsultado.getOcupacion());
                    panelUsuario.infoTelefono.setText(usuarioConsultado.getTelefono());
                    panelUsuario.infoCorreo.setText(usuarioConsultado.getCorreo());
                    panelUsuario.infoDireccion.setText(usuarioConsultado.getDireccion());
                }
                else{
                    panelUsuario.infoNombre.setText("");
                    panelUsuario.infoApellido.setText("");
                    panelUsuario.infoOcupacion.setText("");
                    panelUsuario.infoTelefono.setText("");
                    panelUsuario.infoCorreo.setText("");
                    panelUsuario.infoDireccion.setText("");
                    JOptionPane.showMessageDialog(null, "No existe ningun usuario con ese documento");
                }
                //ventana.dispose();
                //gestionUsuarios();
            }
        };
        submitUsuario.addActionListener(clickEnviar);
                
        ActionListener clickAtras = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                ventana.dispose();
                gestionUsuarios();
            }
        };
        irAtras.addActionListener(clickAtras);
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
        BotonAtras irAtras = new BotonAtras();
        panelSubmit.add(irAtras);
        JButton submitUsuario = new JButton();
        submitUsuario.setText("Enviar");
        panelSubmit.add(submitUsuario);
        
        panelUsuario.setInvisible();
        
        ActionListener clickAtras = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                ventana.dispose();
                gestionUsuarios();
            }
        };
        irAtras.addActionListener(clickAtras);
        
        ActionListener clickEnviar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String documento = panelUsuario.infoDocumento.getText();
                //System.out.println(documento);
                int codigoResultado = ControladorUsuario.borrarUsuario(documento);
                switch(codigoResultado){
                    case 0:
                        JOptionPane.showMessageDialog(null, "El usuario fue borrado con exito");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "documento no valido");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "el usuario no existe");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Hubo un error");
                        break;
                }
            }
        };
        submitUsuario.addActionListener(clickEnviar);
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

class BotonAtras extends JButton{
    BotonAtras(){
        super();
        this.setBackground(Color.CYAN);
        this.setText("Regresar");
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


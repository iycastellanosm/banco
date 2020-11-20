/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModeloUsuario;
import model.Usuario;

/**
 *
 * @author Ivan
 */
public class ControladorUsuario {
    
    public static Usuario consultarUsuario(String documento){
        ModeloUsuario modelo = new ModeloUsuario();
        Usuario usuarioConsultado = null;
        try{
            usuarioConsultado = modelo.consultarUsuario(Integer.parseInt(documento));
            if(usuarioConsultado == null){
                System.out.println("Usuario No Existe");
            }
        }
        catch (Exception e){
            System.out.println("Documento NO VALIDO");
        }
        return usuarioConsultado;
    }
    
    public static int crearUsuario(String documento, String nombre, String apellido, String genero, String direccion, String telefono, String correo, String ocupacion){
        ModeloUsuario modelo = new ModeloUsuario();
        Usuario usuarioCreado = new Usuario();
        int documentoInt = 0;
        try{
            documentoInt = Integer.parseInt(documento);
            usuarioCreado.setDocumento(documentoInt);
            usuarioCreado.setNombres(nombre);
            usuarioCreado.setApellidos(apellido);
            usuarioCreado.setGenero(genero);
            usuarioCreado.setDireccion(direccion);
            usuarioCreado.setTelefono(telefono);
            usuarioCreado.setCorreo(correo);
            usuarioCreado.setOcupacion(ocupacion);
            if(nombre.equals("")){ //error por falta de nombre
                return 1;
            }
            if(apellido.equals("")){ //error por falta de apellido
                return 2;
            }
            try{
                if(modelo.crearUsuario(usuarioCreado)){
                    return 0; // usuario insertado
                }
            }
            catch (Exception e){
                return 3;
            }
        }
        catch (Exception e){
            System.out.println("Documento NO VALIDO");
        }
        return 4; // el usuario no fue creado
    }
    
    public static int actualizarUsuario(String documento, String nombre, String apellido, String genero, String direccion, String telefono, String correo, String ocupacion){
        ModeloUsuario modelo = new ModeloUsuario();
        Usuario usuarioModificado = new Usuario();
        int documentoInt = 0;
        try{
            documentoInt = Integer.parseInt(documento);
            usuarioModificado.setDocumento(documentoInt);
            usuarioModificado.setNombres(nombre);
            usuarioModificado.setApellidos(apellido);
            usuarioModificado.setGenero(genero);
            usuarioModificado.setDireccion(direccion);
            usuarioModificado.setTelefono(telefono);
            usuarioModificado.setCorreo(correo);
            usuarioModificado.setOcupacion(ocupacion);
            if(nombre.equals("")){ //error por falta de nombre
                return 1;
            }
            if(apellido.equals("")){ //error por falta de apellido
                return 2;
            }
            if(telefono.length() > 12){ //error el telefono no puede tener mas de 12 caracteres
                return 5;
            }
            try{
                if(modelo.actualizarUsuario(usuarioModificado)){
                    return 0; // usuario insertado
                }
            }
            catch (Exception e){
                System.out.println(e);
                return 3;
            }
        }
        catch (Exception e){
            System.out.println("Documento NO VALIDO");
        }
        return 4; // el usuario no fue creado
    }
    
    public static int borrarUsuario(String documento){
         ModeloUsuario modelo = new ModeloUsuario();
         int documentoInt = 0;
         try{
             documentoInt = Integer.parseInt(documento);
         }
         catch (Exception e){
             return 1; // documento no valido
         }
        try {
            if (modelo.borrarUsuario(documentoInt)){
                return 0; //borro el usuario correctamente
            }
            else{
                return 2; // no hubo usuarios para borrar
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 4;
    }
}

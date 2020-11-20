/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ivan
 */
public class ModeloUsuario {
    
    public boolean crearUsuario(Usuario nuevoUsuario) throws SQLException{
        Connection conn = GestorBD.getConexion();
        String sql = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, nuevoUsuario.getDocumento());
        statement.setString(2, nuevoUsuario.getNombres());
        statement.setString(3, nuevoUsuario.getApellidos());
        statement.setString(4, nuevoUsuario.getGenero());
        statement.setString(5, nuevoUsuario.getDireccion());
        statement.setString(6, nuevoUsuario.getTelefono());
        statement.setString(7, nuevoUsuario.getCorreo());
        statement.setString(8, nuevoUsuario.getOcupacion());
        int rowsInserted = statement.executeUpdate(); //retorna el numero de filas afectadas
        if(rowsInserted > 0){
            return true;
        }
        return false;
    }
    
    public Usuario consultarUsuario(int documentoUsuario) throws SQLException{
        Connection conn = GestorBD.getConexion();
        String sql = "SELECT * from usuario WHERE documento = ?;";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, documentoUsuario);
        ResultSet result = statement.executeQuery();
        if(result.next()){
            Usuario usuarioConsultado = new Usuario();
            usuarioConsultado.setDocumento(result.getInt(1));
            usuarioConsultado.setNombres(result.getString(2));
            usuarioConsultado.setApellidos(result.getString(3));
            usuarioConsultado.setGenero(result.getString(4));
            usuarioConsultado.setDireccion(result.getString(5));
            usuarioConsultado.setTelefono(result.getString(6));
            usuarioConsultado.setCorreo(result.getString(7));
            usuarioConsultado.setOcupacion(result.getString(8));
            return usuarioConsultado;
        }
        return null;
    }
    
    public boolean actualizarUsuario(Usuario usuarioModificado) throws SQLException{
        Connection conn = GestorBD.getConexion();
        String sql = "UPDATE usuario SET nombres = ?, apellidos = ?, genero = ?, direccion = ?, telefono = ?, correo = ?, ocupacion = ? WHERE documento = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuarioModificado.getNombres());
        statement.setString(2, usuarioModificado.getApellidos());
        statement.setString(3, usuarioModificado.getGenero());
        statement.setString(4, usuarioModificado.getDireccion());
        statement.setString(5, usuarioModificado.getTelefono());
        statement.setString(6, usuarioModificado.getCorreo());
        statement.setString(7, usuarioModificado.getOcupacion());
        statement.setInt(8, usuarioModificado.getDocumento());
        int rowsInserted = statement.executeUpdate(); //retorna el numero de filas afectadas
        if(rowsInserted > 0){
            return true;
        }
        return false;
    }
    
    public boolean borrarUsuario(int documentoUsuario) throws SQLException{
        Connection conn = GestorBD.getConexion();
        String sql = "DELETE FROM usuario WHERE documento = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, documentoUsuario);
        int rowsDeleted = statement.executeUpdate(); //retorna el numero de filas afectadas
        if(rowsDeleted > 0){ // se borró el usuario
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) throws SQLException{
        ModeloUsuario modelo = new ModeloUsuario();
        Usuario usuarioConsultado = modelo.consultarUsuario(55555);
        System.out.println("El usuario 55555 es " + usuarioConsultado);
        usuarioConsultado = modelo.consultarUsuario(123456);
        System.out.println("El usuario 123456 es " + usuarioConsultado);
        usuarioConsultado = modelo.consultarUsuario(888888888);
        System.out.println("El usuario 888888888 es " + usuarioConsultado);
    }
}

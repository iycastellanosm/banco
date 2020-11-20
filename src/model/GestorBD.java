/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ivan
 */
public class GestorBD {
    
    private static GestorBD miInstancia; 
    public Connection conn;
    
    private GestorBD(){
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password1";
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                System.out.println("Conectado :)");
                /*String sql = "SELECT * from usuario;";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                while (result.next()){ //next cambia la fila y retorna verdadero cuando la nueva fila existe
                    System.out.println(result.getString(1) + " " + result.getString(2));
                }*/
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Connection getConexion(){
        if (miInstancia == null){
            miInstancia = new GestorBD();
        }
        return miInstancia.conn;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorxmljson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alan_
 */

    import java.sql.*;
public class Conexion {
    private Connection conexion;
    private Statement comando;
   
    @SuppressWarnings("empity-statement")
<<<<<<< HEAD:build/classes/Conexion.java
    public boolean conectar() throws Exception {
        try {
            
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/traduccion/root/''");
            this.comando = conexion.createStatement();
            
            if (true){
                System.out.println("Conexión exitosa");
                
            }
            else {
                System.out.println("Error, no se pudo conectar");
=======
    public boolean Conectar() throws Exception{
        try {
            
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/traduccion/admin/'1234'");
            this.comando = conexion.createStatement();
            
            if (true){
                System.out.println("sobressssss ");
                
            }
            else {
                System.out.println("Error " );
>>>>>>> parent of 3092eff... nueva conexion:src/traductorxmljson/Conexion.java
            }
            return true;
        } catch(SQLException exc){
            System.out.println("Error " + exc.toString());
            return false;
        }
    }
}
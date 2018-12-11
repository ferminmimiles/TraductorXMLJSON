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
    public boolean Conectar() throws Exception{
        try {
            
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/traduccion/admin/'1234'");
            this.comando = conexion.createStatement();
            
            if (true){
                System.out.println("sobressssss ");
                
            }
            else {
                System.out.println("Error " );
            }
            return true;
        } catch(SQLException exc){
            System.out.println("Error " + exc.toString());
            return false;
        }
    }
}
    


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
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author alan_
 */

public class Conexion {
    private Connection conexion;
    private Statement comando;
   
    @SuppressWarnings("empity-statement")
    public boolean Conectar(String host, String BD, String User, String Password) throws Exception{
        boolean con;
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            this.conexion = DriverManager.getConnection("jdbc:mysql://" + host+"/"+BD , User , Password);
            this.comando = conexion.createStatement();
            con = true;
        } catch(SQLException exc){
            System.out.println("Error " + exc.toString());
            con = false;
        }
        return con;
    }
}
    


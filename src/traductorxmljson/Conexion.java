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
   
    @SuppressWarnings("empty-statement")
    public boolean conectar(String host, String BD, String User, String Password) throws Exception {
        try {
            
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            this.conexion = DriverManager.getConnection("jdbc:mysql://" + host+"/"+BD ,  User , Password);
            this.comando = conexion.createStatement();
            
            if (true){
                System.out.println("Conexión exitosa");
                
            }
            else {
                System.out.println("Error, no se pudo conectar");
            }
            return true;
        } catch(SQLException exc){
            System.out.println("Error " + exc.toString());
            return false;
        }
    }
    
    //M
    /**Metodo empleado para llevar a cabo una instruccion
     *La instruccion proviene de la alguno de los formularios
     * en forma de una cadena de caracteres
     * @param instruccion
     * @return resultado
     * @throws java.sql.Exception
     */
    public ResultSet Consulta(String instruccion) throws SQLException {

        ResultSet resultado = this.comando.executeQuery(instruccion);
        return resultado;
    }
    
    //M
    /**Metodo empleado para llevar a cabo la manipulacion de la base de datos
     * recibe comandos como INSERT, UPDATE, DELETE, CREATE, DROP, ALT
     * en forma de cadena de caracteres proveniente de otros formularios
     * @param instruccion
     * @return ejecutado
     * @throws java.sql.Exception 
     */
    public int ejecutarInstruccion(String instruccion) throws SQLException {
        int i;
        i = this.comando.executeUpdate(instruccion);
        System.out.println(instruccion + " Ejecutada");
        return i;
    }
}
package traductorxmljson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * 11/12/2018
 * Esta clase permite la interaccion con una base de datos MySql
 * Hace uso de mysql_conector-java-5.0.8-bin.jar
 * @author Fermin Mireles
 */
public class controlDatos {    
    
    private Statement comando;
    
    //M
    /**Metodo empleado para llevar a cabo una instruccion
     *La instruccion proviene de la alguno de los formularios
     * en forma de una cadena de caracteres
     * @param instruccion
     * @return resultado
     * @throws java.sql.SQLException
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
     * @throws java.sql.SQLException 
     */
    public int ejecutarInstruccion(String instruccion) throws SQLException {
        int i;
        i = this.comando.executeUpdate(instruccion);
        JOptionPane.showMessageDialog(null, instruccion + " Ejecutada");
        return i;
    }
}

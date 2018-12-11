/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorxmljson;

import java.sql.ResultSet;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fermin Mireles
 */
public class controlDatosTest {
    
    public controlDatosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of Consulta method, of class controlDatos.
     */
    @Test
    public void testConsulta() throws Exception {
        System.out.println("Consulta");
        String instruccion = "show tables;";
        controlDatos instance = new controlDatos();
        Conexion con = new Conexion();
        con.Conectar("localhost", "traducciones", "root", "");
        ResultSet expResult = null;
        ResultSet result = instance.Consulta(instruccion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ejecutarInstruccion method, of class controlDatos.
     */
    @Test
    public void testEjecutarInstruccion() throws Exception {
        System.out.println("ejecutarInstruccion");
        String instruccion = "insert into perro values(null, 3, 'negro')";
        controlDatos instance = new controlDatos();
        Conexion con = new Conexion();
        con.Conectar("localhost", "traducciones", "root", "");
        int expResult = 0;
        int result = instance.ejecutarInstruccion(instruccion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

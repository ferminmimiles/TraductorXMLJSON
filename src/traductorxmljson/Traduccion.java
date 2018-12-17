/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorxmljson;
import java.io.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.*;
import org.jdom2.output.*;

/**
 *
 * @author Fabián
 */

    /******FECHA******/
    /****7 de diciembre de 2018****/
    /*****DESCRIPCION*****/
    /*****En esta clase se hace la traducción del contenido de una tabla en MySQL
     para luego guardarla en un archivo xml o json, dependiendo de la elección del usuario*****/
    /*****PROGRAMADOR*****/
    /*****Issac Fabian Balderas Marmolejo*****/

public class Traduccion {
    
    Conexion mConexion;
    String ruta;
    String nombreTabla;
    
    public Traduccion(){
        mConexion = new Conexion();
        //ruta = Frmexistentes.rutaArchivo;
        //nombreTabla = Frmcaptura.nombreTabla;
    }
    
    public void traduccionXml()
    {
        Document doc = new Document();
        Element nombreBaseDatos = new Element("Traducciones"); 
    //    doc.setRootElement(ruta);
        try {
            mConexion.conectar("localhost","traducciones","root","");
            String consulta = "SELECT * FROM '?1'";
            String nuevaConsulta = consulta.replace("?1", nombreTabla);
            ResultSet resultado = mConexion.Consulta(nuevaConsulta);
            ResultSetMetaData datos = resultado.getMetaData();
            int columnas = datos.getColumnCount();
            while (resultado.next()) {
                List listaDatos = new ArrayList();
                for (int i=1; i <= columnas; i++) {
                    String nomColumna = datos.getColumnName(i);                    
                    String valColumna = resultado.getString(i);                    
                    Element archivo = new Element(nomColumna);
                    archivo.setText(valColumna);
                    listaDatos.add(archivo);
                }
                
                Element celda = new Element("registro");
                celda.setContent(listaDatos);
                nombreBaseDatos.addContent(celda);               
            }
            resultado.close();
            XMLOutputter outputter = new XMLOutputter( Format.getPrettyFormat() );
            try {
               outputter.output(doc, new FileOutputStream ( ruta ));
               System.out.println("Arhivo XML creado en " + ruta);
            }
            catch (IOException e) {
                System.out.println(e);
            }
        } catch (SQLException e) {
               System.err.println(e);
        } catch (Exception ex) {
            Logger.getLogger(Traduccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

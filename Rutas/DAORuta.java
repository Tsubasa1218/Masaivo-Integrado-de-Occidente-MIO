/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rutas;

import Data_base.FachadaBD;
import Estaciones.DAOEstacion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Suaza
 */
public class DAORuta {
    FachadaBD fachada;
    public DAORuta(){
        fachada = new FachadaBD();
    }
    
    public int codigoDeNombre(Ruta ruta){
        String consultaSQL = "SELECT id_ruta FROM rutas WHERE nombre_ruta LIKE '" + ruta.nombre + "';";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet numFilas = sentencia.executeQuery(consultaSQL);  
            int codigo = -1;
            //System.out.println("up " + numFilas);
            while(numFilas.next()){
                codigo = numFilas.getInt("id_ruta");
            }
            return codigo;
            
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
        
    }
    
    public void listaRutas(JComboBox cb){
        String consultaSQL = "SELECT nombre_ruta FROM rutas;";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet numFilas = sentencia.executeQuery(consultaSQL);  
            //System.out.println("up " + numFilas);
            cb.addItem("-- Seleccione una ruta --");
            while(numFilas.next()){
                cb.addItem(numFilas.getString("nombre_ruta"));
            }    
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
    }
    
    public int agregarRuta(Ruta ruta){
        String consultaSQL;

        List<String> id_estaciones;
        id_estaciones = new ArrayList<String>();

        //consultaSQL = "INSERT INTO rutas(nombre_ruta, descripcion_ruta) VALUES('" + ruta.nombre + "', '" + ruta.descripcion + "');";

        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            for (String nombre : ruta.estaciones) {
                consultaSQL = "SELECT id_estacion FROM estaciones WHERE nombre_estacion LIKE '" + nombre + "';";
                ResultSet ids = sentencia.executeQuery(consultaSQL);
                while(ids.next()){
                    id_estaciones.add("" + ids.getInt("id_estacion"));
                }
            }
            consultaSQL = "INSERT INTO rutas(nombre_ruta, descripcion_ruta) VALUES('" + ruta.nombre + "', '" + ruta.descripcion + "');";
            int numFilas = sentencia.executeUpdate(consultaSQL);
            //System.out.println("up " + numFilas);  
            if (numFilas != 0) {
                consultaSQL = "SELECT last_value FROM rutas_id_ruta_seq;";
                int ultimoCodigo = -1;
                ResultSet id = sentencia.executeQuery(consultaSQL);
                while(id.next()){
                    ultimoCodigo = id.getInt("last_value");
                }
                for(String ids : id_estaciones){

                    consultaSQL = "INSERT INTO estaciones_en_ruta VALUES (" + ultimoCodigo + ", " + ids + ");";
                    numFilas += sentencia.executeUpdate(consultaSQL);
                }
            }
            return numFilas;
        } catch (SQLException e) {
            System.out.println(e);
        }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
    }
    
    public String obtenerDescripcion(Ruta ruta){
        String consultaSQL = "SELECT descripcion_ruta FROM rutas WHERE nombre_ruta LIKE '" + ruta.nombre + "';";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet numFilas = sentencia.executeQuery(consultaSQL);  
            String nombre = "";
            //System.out.println("up " + numFilas);
            while(numFilas.next()){
                nombre= numFilas.getString("descripcion_ruta");
            }
            return nombre;
            
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return null;
    }
    
    public int modificarRuta(Ruta ruta, int codigo){
        String consultaSQL;

        List<String> id_estaciones;
        id_estaciones = new ArrayList<String>();

        //consultaSQL = "INSERT INTO rutas(nombre_ruta, descripcion_ruta) VALUES('" + ruta.nombre + "', '" + ruta.descripcion + "');";

        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            for (String nombre : ruta.estaciones) {
                consultaSQL = "SELECT id_estacion FROM estaciones WHERE nombre_estacion LIKE '" + nombre + "';";
                ResultSet ids = sentencia.executeQuery(consultaSQL);
                while(ids.next()){
                    id_estaciones.add("" + ids.getInt("id_estacion"));
                }
            }
            consultaSQL = "INSERT INTO rutas VALUES(" + codigo +  ", '" + ruta.nombre + "', '" + ruta.descripcion + "');";
            int numFilas = sentencia.executeUpdate(consultaSQL);
            //System.out.println("up " + numFilas);  
            if (numFilas != 0) {
                for(String ids : id_estaciones){

                    consultaSQL = "INSERT INTO estaciones_en_ruta VALUES (" + codigo + ", " + ids + ");";
                    numFilas += sentencia.executeUpdate(consultaSQL);
                }
            }
            return numFilas;
        } catch (SQLException e) {
            System.out.println(e);
        }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
    }
    
    public int eliminarRuta(int codigo){
        String consultaSQL = "DELETE FROM estaciones_en_ruta WHERE id_ruta = " + codigo + ";";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            int numFilas = sentencia.executeUpdate(consultaSQL); 
            consultaSQL = "DELETE FROM rutas WHERE id_ruta = " + codigo + ";";
            numFilas += sentencia.executeUpdate(consultaSQL);
            //System.out.println("up " + numFilas);  
            return numFilas;
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
    }
    
    public void agregarRutas(javax.swing.JComboBox combo){
        combo.removeAllItems();
        try { 
            String consultaSQL = "SELECT nombre_ruta  FROM rutas";
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(consultaSQL);
            while (tabla.next()){
                combo.addItem(tabla.getString(1));
            }
            tabla.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public String consultarRuta(String estActual,String estDestino){
        String rutas = "";
        try {
            int consultaEstActual = new DAOEstacion().consultarEstacion(estActual);
            int consultaEstDestino = new DAOEstacion().consultarEstacion(estDestino);
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            
            String consultaSQL = "SELECT nombre_ruta FROM rutas WHERE id_ruta IN "
                    + "((SELECT eer1.id_ruta FROM estaciones_en_ruta eer1 WHERE eer1.id_estacion = " + consultaEstActual + " )"
                    + "INTERSECT"
                    + "(SELECT eer2.id_ruta FROM estaciones_en_ruta eer2 WHERE eer2.id_estacion = " + consultaEstDestino + " ));";
            ResultSet tabla = sentencia.executeQuery(consultaSQL);
           
                while(tabla.next()){
                    rutas += tabla.getString("nombre_ruta") + "\t";
                }

            tabla.close();
            return rutas;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar las rutas con las estaciones seleccionada", "Error!", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return null;
    }
    
    public int consultarRuta(String nombreRuta){
        int ruta = 0;
        try { 
            String consultaEstActual = "SELECT id_ruta  FROM rutas WHERE nombre_ruta   = '" + nombreRuta + "';";
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(consultaEstActual);
            while (tabla.next()){
                ruta = tabla.getInt("id_ruta");
            }
            tabla.close();
            return ruta;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
}

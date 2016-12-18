/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rutas;

import Data_base.FachadaBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

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
}

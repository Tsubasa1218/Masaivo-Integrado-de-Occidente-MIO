/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estaciones;

import Data_base.FachadaBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

/**
 *
 * @author Juan Suaza
 */
public class DAOEstacion {
    FachadaBD fachada;
    
    public DAOEstacion(){
        fachada = new FachadaBD();
    }
    
    public int agregarEstacion(Estacion est){
        String consultaSQL = "INSERT INTO estaciones(nombre_estacion, ubicacion_estacion, cedula_empleado) VALUES('" +
                est.nombre + "', '" + est.ubicacion + "', '" + est.empleadoEncargado + "');";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            int numFilas = sentencia.executeUpdate(consultaSQL);  
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
    
    public String obtenerUbicacion(Estacion est){
        String consultaSQL = "SELECT ubicacion_estacion FROM estaciones WHERE nombre_estacion LIKE '" + est.nombre + "';";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet numFilas = sentencia.executeQuery(consultaSQL);  
            String nombre = "";
            //System.out.println("up " + numFilas);
            while(numFilas.next()){
                nombre= numFilas.getString("ubicacion_estacion");
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
    
    public void listarEstaciones(JComboBox cb){
        String consultaSQL = "SELECT nombre_estacion FROM estaciones;";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet numFilas = sentencia.executeQuery(consultaSQL);  
            //System.out.println("up " + numFilas);
            cb.addItem("-- Seleccione una estacion --");
            while(numFilas.next()){
                cb.addItem(numFilas.getString("nombre_estacion"));
            }    
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
    }
    
    public int modificarEstacion(Estacion est){
        String consultaSQL = "UPDATE estaciones SET ubicacion_estacion = '" + est.ubicacion + "', cedula_empleado = '" + est.empleadoEncargado + "' WHERE "+
                "nombre_estacion LIKE '" + est.nombre + "';";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            int numFilas = sentencia.executeUpdate(consultaSQL);  
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
    
    public int eliminarEstacion(Estacion est){
        String consultaSQL = "DELETE FROM estaciones WHERE nombre_estacion LIKE '" + est.nombre + "';";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            int numFilas = sentencia.executeUpdate(consultaSQL);  
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
}

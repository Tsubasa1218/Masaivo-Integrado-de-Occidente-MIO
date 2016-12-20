/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buses;

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
public class DAOBus {
    FachadaBD fachada;
    
    public DAOBus(){
        fachada = new FachadaBD();
    }
    
    public void listaBuses(JComboBox cb){
        String consultaSQL = "SELECT placa_bus FROM buses;";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet numFilas = sentencia.executeQuery(consultaSQL);  
            //System.out.println("up " + numFilas);
            cb.addItem("-- Seleccione un bus --");
            while(numFilas.next()){
                cb.addItem(numFilas.getString("placa_bus"));
            }    
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
    }
    
    public int codigoTipoBus(Bus bus){
        String consultaSQL = "SELECT id_tipo_bus FROM tipo_bus WHERE nombre_tipo LIKE '" + bus.nombre_tipo + "';";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet numFilas = sentencia.executeQuery(consultaSQL);  
            //System.out.println("up " + numFilas);
            int codigo = -1;
            while(numFilas.next()){
                codigo = numFilas.getInt("id_tipo_bus");
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
    
    public int agregarBus(Bus bus){
        String consultaSQL = "INSERT INTO buses VALUES('" + bus.placa + "', " + bus.tipo + ");";
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
    
    public boolean existeBus(String placa){
        String consultaSQL = "SELECT * FROM buses WHERE placa_bus LIKE '" + placa + "';";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet numFilas = sentencia.executeQuery(consultaSQL);  
            //System.out.println("up " + numFilas);  
            int contador = 0;
            while(numFilas.next()){
                contador++;
            }
            System.out.println(consultaSQL);
            if(contador>0){
                return true;
            }else{
                return false;
            }
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return false;
        
    }
    
    public int modificarBus(Bus bus){
        String consultaSQL = "UPDATE buses SET id_tipo_bus = " + bus.tipo + " WHERE placa_bus LIKE '" + bus.placa + "';";
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
    
    public int eliminarBus(Bus bus){
        String consultaSQL = "DELETE FROM buses WHERE placa_bus LIKE '" + bus.placa + "';";
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

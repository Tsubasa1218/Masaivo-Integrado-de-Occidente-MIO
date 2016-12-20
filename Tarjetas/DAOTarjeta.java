/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarjetas;

import Buses.*;
import Data_base.*;
import Estaciones.*;
import GUI.*;
import Pasajeros.*;
import Rutas.*;
import Solicitudes.*;
import Tarjetas.*;
import Usuarios.*;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Juan Suaza
 */
public class DAOTarjeta {
    
    FachadaBD fachada;
    public DAOTarjeta() {
        fachada = new FachadaBD();
    }
    
    public Tarjeta consultarTarjeta(String pin_tarjeta) {
        Tarjeta t = new Tarjeta();
        String sql_select;
        sql_select = "SELECT * FROM tarjetas WHERE pin_tarjeta = '" + pin_tarjeta + "';";
        try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                t.setPin_targeta(tabla.getString("pin_tarjeta"));
                t.setNumero_pasajes(tabla.getInt("numero_pasajes"));
                t.setEstado_tarjeta(tabla.getBoolean("estado_tarjeta"));
            }
            return t;
        }catch(SQLException e){ 
            System.out.println(e); 
        }catch(Exception e){ 
            System.out.println(e); 
        }
        return null;
    }
    
    public int abordarBus(int pin_tarjeta, int id_ruta) {
        Tarjeta t = new Tarjeta();
        String sql_guardar;
        sql_guardar = "INSERT INTO bus_abordado VALUES("
                + pin_tarjeta
                + "," + id_ruta
                + ",now());";
        try{
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            return sentencia.executeUpdate(sql_guardar);
        }catch(SQLException e){ 
            System.out.println(e); 
        }catch(Exception e){ 
            System.out.println(e); 
        }
        return -1;
    }
    
    public int modificarTarjeta(Tarjeta tarjeta){
        String sql_guardar;
        sql_guardar = "UPDATE tarjetas SET numero_pasajes = '" + (tarjeta.getNumero_pasajes() - 1) + "' WHERE pin_tarjeta = '" + tarjeta.getPin_targeta() + "';";
        try{
            Connection conn = fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_guardar);
            conn.close();
            return numFilas;
            
        }catch(SQLException e){
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
        return -1;
    }
}

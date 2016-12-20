/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pasajeros;

import Buses.*;
import Data_base.*;
import Estaciones.*;
import GUI.*;
import Pasajeros.*;
import Rutas.*;
import Solicitudes.*;
import Tarjetas.*;
import Usuarios.*;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Suaza
 */
public class DAOPasajero {
    FachadaBD fachada;
    
    public DAOPasajero(){
        
    }
    
    public String obtenerNombrePasajero(String tiquete){
        String sql_select = "SELECT nombre_pasajero FROM pasajeros WHERE cedula_pasajero IN"
                + "(SELECT sol.cedula_pasajero FROM solicitudes_presentadas sol WHERE sol.tiquete = '" + tiquete + "');";
        String cedula = "";
        try{
            Connection conn = fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                cedula = tabla.getString("nombre_pasajero");
                System.out.println(cedula);
            }
            return cedula;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se ha encontrado la solicitud \nRevisa la los datos ingresados\n Error en obtener nombre pasajero", "Error!", JOptionPane.ERROR_MESSAGE);
            System.out.println(e); 
        }catch(Exception e){ 
            System.out.println(e); 
        }
        return null;
    }
}

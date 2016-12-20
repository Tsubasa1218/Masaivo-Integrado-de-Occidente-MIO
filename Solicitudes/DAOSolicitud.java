/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solicitudes;

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
public class DAOSolicitud {
    Solicitud solicitud;
    FachadaBD fachada;
    
    public DAOSolicitud() {
        fachada = new FachadaBD();
        solicitud = new Solicitud();
        
    }

    public DAOSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    
    public Solicitud obtenerSolicitud(String tiquete){
        String sql_select;
        sql_select = "SELECT * FROM solicitudes WHERE tiquete = '" + tiquete + "';";
        try{
            Connection conn = fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                solicitud.setCedulaEmpleado(tabla.getString("cedula_empleado"));
                solicitud.setDescripcionSolicitud(tabla.getString("descripcion_solicitud"));
                solicitud.setEstadSolicitud(tabla.getBoolean("estado_solicitud"));
                solicitud.setMotivoSolicitud(tabla.getString("motivo_solicitud"));
                solicitud.setRespuesta(tabla.getString("respuesta_solicitud"));
                //System.out.println(tabla.getString("respuesta_solicitud"));
            }
            tabla.close();
            return solicitud;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se ha encontrado la solicitud \nRevisa la los datos ingresados", "Error!", JOptionPane.ERROR_MESSAGE);
            System.out.println(e); 
        }catch(Exception e){ 
            System.out.println(e); 
        }
        return null;
    }
    
    public Solicitud obtenerEstacion(String tiquete){
        String sql_select;
        sql_select = "SELECT * FROM solicitudes WHERE tiquete = '" + tiquete + "';";
        try{
            Connection conn = fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                solicitud.setCedulaEmpleado(tabla.getString("cedula_empleado"));
                solicitud.setDescripcionSolicitud(tabla.getString("descripcion_solicitud"));
                solicitud.setEstadSolicitud(tabla.getBoolean("estado_solicitud"));
                solicitud.setMotivoSolicitud(tabla.getString("motivo_solicitud"));
                solicitud.setRespuesta(tabla.getString("respuesta_solicitud"));
            }
            return solicitud;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se ha encontrado la solicitud \nRevisa la los datos ingresados", "Error!", JOptionPane.ERROR_MESSAGE);
            System.out.println(e); 
        }catch(Exception e){ 
            System.out.println(e); 
        }
        return null;
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Data_base.FachadaBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Juan Suaza
 */
public class DAOReporte {
    
    FachadaBD fachada;
    
    public DAOReporte(){
        fachada = new FachadaBD();
    }
    
    public ResultSet crearReportePasajerosSistema(){     
        String consultaSQL = "SELECT nombre_pasajero, pin_tarjeta FROM tarjeta_personalizada NATURAL JOIN pasajeros;";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet tabla = sentencia.executeQuery(consultaSQL);

            return tabla;
        }catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public ResultSet crearReportePasajerosMovilizados(){
        String consultaSQL = "select R.nombre_ruta, date_trunc('hour', E.fecha_abordaje), COUNT(R.nombre_ruta) FROM bus_abordado E "
                + "NATURAL JOIN rutas R GROUP BY R.nombre_ruta, date_trunc('hour', E.fecha_abordaje) ORDER BY R.nombre_ruta;";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet tabla = sentencia.executeQuery(consultaSQL);

            return tabla;
        }catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public ResultSet crearReporteGanancias(String dia, String mes, String year){
        String fechaConsulta = "'" + year + "-" + mes + "-" + dia + "'";
        System.out.println(fechaConsulta);
        String consultaSQL = "SELECT E.nombre_estacion, 3000*COUNT(E.nombre_estacion) FROM venta_tarjetas V INNER JOIN"
                + " estaciones E ON V.id_estacion = E.id_estacion WHERE fecha_venta = " + fechaConsulta + " GROUP BY E.nombre_estacion;";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet tabla = sentencia.executeQuery(consultaSQL);

            return tabla;
        }catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public ResultSet crearReporteListadoSolicitudes(String dia, String mes, String year){
        String fechaConsulta = "'" + year + "-" + mes + "-" + dia + "'";
        String consultaSQL = "SELECT P.nombre_pasajero, S.descripcion_solicitud, E.nombre_estacion, "
                + "D.nombre_empleado FROM solicitudes_presentadas NATURAL JOIN pasajeros P NATURAL JOIN solicitudes S "
                + "NATURAL JOIN estaciones E NATURAL JOIN empleados D WHERE fecha_solicitud = " + fechaConsulta + " ORDER BY E.nombre_estacion;";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet tabla = sentencia.executeQuery(consultaSQL);

            return tabla;
        }catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public ResultSet crearReporteListadoRutas(){
        String consultaSQL = "SELECT R.nombre_ruta, E.nombre_estacion FROM estaciones_en_ruta NATURAL JOIN rutas R NATURAL JOIN estaciones E;";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet tabla = sentencia.executeQuery(consultaSQL);

            return tabla;
        }catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public ResultSet crearReporteListadoBuses(){
        Calendar hora = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        //System.out.println(sdf.format(hora.getTime()));
        String hora_s = sdf.format(hora.getTime());
        
        String consultaSQL = "SELECT nombre_empleado, placa_bus FROM conduce NATURAL JOIN empleados NATURAL JOIN buses "
                + "WHERE id_tipo_bus = 3 AND fecha = current_date AND " + hora_s + " BETWEEN turno_inicio AND turno_fin;";
        
        System.out.println(consultaSQL);
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet tabla = sentencia.executeQuery(consultaSQL);

            return tabla;
        }catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public ResultSet crearReporteQuejas(){
        String consultaSQL = "SELECT S.motivo_solicitud, COUNT(S.motivo_solicitud) FROM solicitudes S GROUP BY S.motivo_solicitud ORDER BY COUNT(S.motivo_solicitud) DESC;";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet tabla = sentencia.executeQuery(consultaSQL);

            return tabla;
        }catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
}

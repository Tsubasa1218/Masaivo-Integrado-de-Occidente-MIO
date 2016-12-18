/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;
/**
 *
 * @author Juan Suaza
 */
import Data_base.FachadaBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

public class DAOUsuario {
    
    FachadaBD fachada;
    
    public DAOUsuario(){
        fachada = new FachadaBD();
    }
    
    public int asignarTurno(Usuario user){
        String consultaSQLconduce = "INSERT INTO conduce VALUES('" + 
                user.codigo + "', '" + user.placa + "', '" +
                user.turno_inicio + "', '" + user.turno_fin + 
                "', now());";
        
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            int numFilas = sentencia.executeUpdate(consultaSQLconduce);  
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
    
    public int asignarTurnoRuta(Usuario user){
        
        String consultaSQLrutas_asignadas = "INSERT INTO rutas_asignadas VALUES('" + 
               user.placa + "', " + user.ruta_id + ", '" +user.codigo + 
                "', '" + user.turno_inicio + "', '" + user.turno_fin + 
                "', now());";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            int numFilas = sentencia.executeUpdate(consultaSQLrutas_asignadas);  
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
    
    public String tipoUsuario(Usuario user){
        String consultaSQL = "SELECT nombre_cargo FROM empleados NATURAL JOIN cargos WHERE cedula_empleado LIKE '" + user.codigo + "';";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet numFilas = sentencia.executeQuery(consultaSQL);  
            String nombre = "";
            //System.out.println("up " + numFilas);
            while(numFilas.next()){
                nombre= numFilas.getString("nombre_cargo");
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
    
    public String codigoUsuario(Usuario user){
        String consultaSQL = "SELECT cedula_empleado FROM empleados WHERE nombre_empleado LIKE '" + user.nombre + "';";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet numFilas = sentencia.executeQuery(consultaSQL);  
            String nombre = "";
            //System.out.println("up " + numFilas);
            while(numFilas.next()){
                nombre= numFilas.getString("cedula_empleado");
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
    
    public void empleadosNoEncargados(JComboBox cb){
        String consultaSQL = "SELECT nombre_empleado FROM empleados WHERE id_cargo = 5 EXCEPT SELECT nombre_empleado FROM estaciones NATURAL JOIN empleados;";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet numFilas = sentencia.executeQuery(consultaSQL);  
            //System.out.println("up " + numFilas);
            cb.addItem("-- Seleccione un empleado --");
            while(numFilas.next()){
                cb.addItem(numFilas.getString("nombre_empleado"));
            }    
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
    }
    
}

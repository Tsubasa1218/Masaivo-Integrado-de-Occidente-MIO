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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAOUsuario {
    
    FachadaBD fachada;
    Usuario user;
    
    public DAOUsuario(){
        fachada = new FachadaBD();
        user = new Usuario();
    }
    
    public int asignarTurno(Usuario user){
        String consultaSQLconduce = "INSERT INTO conduce VALUES('" + 
                user.codigo + "', '" + user.placa + "', " +
                user.turno_inicio + ", " + user.turno_fin + 
                ", current_date);";
        
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
                "', " + user.turno_inicio + ", " + user.turno_fin + 
                ", current_date);";
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
    
    public int obtenerCodigoCargo(String nombre){
        String consultaSQL = "SELECT id_cargo FROM cargos WHERE nombre_cargo LIKE '" + nombre + "';";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            ResultSet numFilas = sentencia.executeQuery(consultaSQL);  
            //System.out.println("up " + numFilas);
            int cargo = -1;
            while(numFilas.next()){
                cargo = numFilas.getInt("id_cargo");
            }    
            return cargo;
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
    }
    
    public int agregarEmpleado(Usuario user){
        String consultaSQL = "INSERT INTO empleados VALUES('" + user.codigo + "', '" + user.nombre +
                "', '" + user.password + "', " + user.cargoCod + ");";
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
    
    public int validarUsuario(String cedula_empleado, String contraseña_empleado){
        try { 
            String consultaSQL = "SELECT * FROM empleados WHERE cedula_empleado = '" + cedula_empleado
                    //"' AND cedula_empleado = '" + contraseña_empleado
                    + "';";
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(consultaSQL);
            while(tabla.next()){
                user.setCedula(tabla.getString("cedula_empleado"));
                user.setNombre(tabla.getString("nombre_empleado"));
                user.setCargo(tabla.getInt("id_cargo"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al validar el usuario \nRevisa la los datos ingresados", "Error!", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return user.getCargo();
    }
   
    public void consultarTurno(String cedula_empleado, JTable jTable){
        String consultaSQL = "SELECT * FROM conduce WHERE cedula_empleado = '" + cedula_empleado;
        DefaultTableModel dtm = new DefaultTableModel(0,0);
        try{
            int Counter = 0;
            int i = 0;
            //System.out.println(Counter);
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(consultaSQL);
            while(tabla.next()){
                Counter++;
                //System.out.println(Counter);
            }
            //System.out.println(Counter);
            String[][] turno = new String[Counter][4];
            while(tabla.next()){
                turno[i][0] = tabla.getString("placa_bus");
                turno[i][1] = "" + tabla.getInt("turno_inicio");
                turno[i][2] = "" + tabla.getInt("turno_fin");
                turno[i][3] = tabla.getString("fecha");
                i++;
                //System.out.println(i);
            }
            String[] nombreColumnas = {"Placa bus", "Hora de inicio", "Hora de finalizacion", "Fecha"};
            dtm.setColumnIdentifiers(nombreColumnas);
            jTable.setModel(dtm);
            for (int j = 0; j < Counter; j++) {
                //System.out.println(j);
                dtm.addRow(turno[j]);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se ha encontrado el empleado \nRevisa la los datos ingresados", "Error!", JOptionPane.ERROR_MESSAGE);
            System.out.println(e); 
        }catch(Exception e){ 
            System.out.println(e); 
        }
    }
    
    public String getNombre(){
        return user.getNombre();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Suaza
 */
public class ControladorUsuario {
    DAOUsuario daoUsuario;
    
    public ControladorUsuario(){
        daoUsuario = new DAOUsuario();
    }
    
    public int asignarTurno(String codigo, String turno_inicio, String turno_fin, String placa, int ruta_id){
        Usuario user = new Usuario(codigo, "", -1, turno_inicio, turno_fin, placa, ruta_id);
        
        int numFilas1 = daoUsuario.asignarTurno(user);
        int numFilas2 = daoUsuario.asignarTurnoRuta(user);
        if(numFilas1 != -1 && numFilas2 != -1){
            JOptionPane.showMessageDialog(null, "Exito!", "Ruta asignada con exito", JOptionPane.INFORMATION_MESSAGE);
        }
        return numFilas1 + numFilas2;
    }
    
    public String tipoUsuario(String codigo){
        Usuario user = new Usuario(codigo, null, -1, null, null, null, -1);
        
        String nombreCargo = daoUsuario.tipoUsuario(user);
        return nombreCargo;
    }
    
    public String codigoUsuario(String nombre){
        Usuario user = new Usuario(nombre);
        
        String cedula = daoUsuario.codigoUsuario(user);
        
        return cedula;
    }
    
    public void empleadosNoEncargados(JComboBox cb){
        daoUsuario.empleadosNoEncargados(cb);
    }
    
    public int obtenerCodigoCargo(String cargo){
        int id_cargo = daoUsuario.obtenerCodigoCargo(cargo);
        return id_cargo;
    }
    
    public int agregarEmpleado(String nombre, String cedula, String password, int id_cargo){
        Usuario user = new Usuario(nombre, cedula, password, id_cargo);
        
        int numFilas = daoUsuario.agregarEmpleado(user);
        return numFilas;
    }
}

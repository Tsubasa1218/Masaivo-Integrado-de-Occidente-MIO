/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estaciones;

import javax.swing.JComboBox;

/**
 *
 * @author Juan Suaza
 */
public class ControladorEstacion {
    
    DAOEstacion daoEstacion;
    
    public ControladorEstacion(){
        daoEstacion = new DAOEstacion();
    }
    
    public int agregarEstacion(String nombre, String ubicacion, String encargado){
        Estacion est = new Estacion(nombre, ubicacion, encargado);
        
        int numFilas = daoEstacion.agregarEstacion(est);
        
        return numFilas;
    }
    
    public String obtenerUbicacion(String nombre){
        Estacion est = new Estacion(nombre, null, null);
        
        String ubicacion = daoEstacion.obtenerUbicacion(est);
        return ubicacion;
    }
    
    public void listarEstaciones(JComboBox cb){
        daoEstacion.listarEstaciones(cb);
    }
    
    public int modificarEstacion(String nombre, String ubicacion, String encargado){
        Estacion est = new Estacion(nombre, ubicacion, encargado);
        int numFilas = daoEstacion.modificarEstacion(est);
        return numFilas;
    }
    
    public int eliminarEstacion(String nombre){
        Estacion est = new Estacion(nombre, null, null);
        
        int numFilas = daoEstacion.eliminarEstacion(est);
        return numFilas;
    }
    
}

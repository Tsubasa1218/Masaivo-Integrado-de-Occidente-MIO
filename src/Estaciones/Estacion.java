/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estaciones;

/**
 *
 * @author Juan Suaza
 */
public class Estacion {
    int id;
    String nombre, ubicacion, empleadoEncargado;
    
    public Estacion(String nombre, String ubicacion, String empleadoEncargado){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.empleadoEncargado = empleadoEncargado;
    }
    
    
}

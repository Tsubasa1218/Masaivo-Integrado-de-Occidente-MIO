/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rutas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Suaza
 */
public class Ruta {
    String nombre, descripcion;
    List<String> estaciones;
    
    public Ruta(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public Ruta(String nombre, String descripcion, ArrayList<String> estaciones){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estaciones = estaciones;
    }
}
    


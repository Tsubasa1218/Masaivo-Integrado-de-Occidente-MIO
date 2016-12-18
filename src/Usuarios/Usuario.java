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
public class Usuario {
    
    String codigo, nombre, turno_inicio, turno_fin, placa;
    int cargoCod, ruta_id;
    
    public Usuario(String codigo, String nombre, int cargoCod, String turno_inicio, String turno_fin, String placa, int ruta_id){
        this.cargoCod = cargoCod;
        this.codigo = codigo;
        this.nombre = nombre;
        this.turno_inicio= turno_inicio;
        this.turno_fin = turno_fin;
        this.placa = placa;
        this.ruta_id = ruta_id;
    }
    
    public Usuario(String nombre){
        this.nombre = nombre;
  
    }
}

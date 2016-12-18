/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buses;

/**
 *
 * @author Juan Suaza
 */
public class Bus {
    String placa, nombre_tipo;
    int tipo;
    
    public Bus(String placa, int tipo){
        this.tipo = tipo;
        this.placa = placa;
    }
    
    public Bus(String nombre_tipo){
        this.nombre_tipo = nombre_tipo;
    }
    
}

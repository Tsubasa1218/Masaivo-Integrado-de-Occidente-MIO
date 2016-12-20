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
    
    String codigo, nombre, turno_inicio, turno_fin, placa, password;
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
    
    public Usuario(String nombre, String cedula, String password, int id_cargo){
        this.codigo = cedula;
        this.nombre = nombre;
        this.password = password;
        this.cargoCod = id_cargo;
  
    }
    
    
    public Usuario(String nombre){
        this.nombre = nombre;
  
    }
    
    public Usuario(){
            
    }
    
     public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setCedula(String cedula){
        this.codigo = cedula;
    }

    public String getTurno_inicio() {
        return turno_inicio;
    }

    public void setTurno_inicio(String turno_inicio) {
        this.turno_inicio = turno_inicio;
    }

    public String getTurno_fin() {
        return turno_fin;
    }

    public void setTurno_fin(String turno_fin) {
        this.turno_fin = turno_fin;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRuta_id() {
        return ruta_id;
    }

    public void setRuta_id(int ruta_id) {
        this.ruta_id = ruta_id;
    }
    
    public String getCedula(){
        return codigo;
    }
    
    public void setCargo(int cargo){
        this.cargoCod = cargo;
    }
    
    public int getCargo(){
        return cargoCod;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rutas;

import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Juan Suaza
 */
public class ControladorRuta {
    DAORuta daoRuta;
    
    public ControladorRuta(){
        daoRuta = new DAORuta();
        
    }
    
    public int codigoDeNombre(String nombre){
        Ruta ruta = new Ruta(nombre, "");
        
        int codigo = daoRuta.codigoDeNombre(ruta);
        return codigo;
    }
    
    public void listaRutas(JComboBox cb){
        daoRuta.listaRutas(cb);
    }
    
    public int agregarRuta(String nombre, String descripcion, ArrayList<String> estaciones){
        Ruta ruta = new Ruta(nombre, descripcion, estaciones);
        
        int numFilas = daoRuta.agregarRuta(ruta);
        return numFilas;
    }
    
    public String obtenerDescripcion(String nombre){
        Ruta ruta = new Ruta(nombre, null);
        
        String descripcion = daoRuta.obtenerDescripcion(ruta);
        return descripcion;
    }
    public int modificarRuta(String nombre, String descripcion, ArrayList<String> estaciones, int codigo){
        Ruta ruta = new Ruta(nombre, descripcion, estaciones);
        
        int numFilas = daoRuta.eliminarRuta(codigo);
        System.out.println(nombre + " " + descripcion + " " + codigo);
        System.out.println("Ruta eliminada");
        numFilas += daoRuta.modificarRuta(ruta, codigo);
        return numFilas;
    }
    
    public int eliminarRuta(int codigo){
        int numFilas = daoRuta.eliminarRuta(codigo);
        return numFilas;
    }
}

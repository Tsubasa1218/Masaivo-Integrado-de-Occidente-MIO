/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buses;

import javax.swing.JComboBox;

/**
 *
 * @author Juan Suaza
 */
public class ControladorBus {
    DAOBus daoBus;
    
    public ControladorBus(){
        daoBus = new DAOBus();
    }
    
    public void listaBuses(JComboBox cb){
        daoBus.listaBuses(cb);
    }
    public int codigoTipoBus(String nombre){
        Bus bus = new Bus(nombre);
        
        int codigo = daoBus.codigoTipoBus(bus);
        
        return codigo;
    }
    
    public int agregarBus(String placa, int tipo){
        Bus bus = new Bus(placa, tipo);
        
        int numFilas = daoBus.agregarBus(bus);
        return numFilas;
    }
    
    public boolean existeBus(String placa){
        boolean existe = false;
        existe = daoBus.existeBus(placa);
        
        return existe;
    }
    
    public int modificarBus(String placa, int tipo){
        Bus bus = new Bus(placa, tipo);
        
        int numFilas = daoBus.modificarBus(bus);
        
        return numFilas;
    }
    
    public int eliminarBus(String placa){
        Bus bus = new Bus(placa, -1);
        
        int numFilas = daoBus.eliminarBus(bus);
        return numFilas;
    }
}

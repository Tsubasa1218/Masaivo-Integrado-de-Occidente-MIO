/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarjetas;

/**
 *
 * @author Juan Suaza
 */
public class Tarjeta {
    String pin_targeta;
    int numero_pasajes;
    boolean estado_tarjeta;

    public Tarjeta(String pin_targeta, int numero_pasajes, boolean estado_tarjeta) {
        this.pin_targeta = pin_targeta;
        this.numero_pasajes = numero_pasajes;
        this.estado_tarjeta = estado_tarjeta;
    }

    public Tarjeta() {
    }

    public String getPin_targeta() {
        return pin_targeta;
    }

    public void setPin_targeta(String pin_targeta) {
        this.pin_targeta = pin_targeta;
    }

    public int getNumero_pasajes() {
        return numero_pasajes;
    }

    public void setNumero_pasajes(int numero_pasajes) {
        this.numero_pasajes = numero_pasajes;
    }

    public boolean isEstado_tarjeta() {
        return estado_tarjeta;
    }

    public void setEstado_tarjeta(boolean estado_tarjeta) {
        this.estado_tarjeta = estado_tarjeta;
    }
}

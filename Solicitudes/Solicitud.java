/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solicitudes;

/**
 *
 * @author Juan Suaza
 */
public class Solicitud {
    String tiquete;
    String respuesta;
    boolean estadSolicitud;
    String motivoSolicitud;
    String descripcionSolicitud;
    String cedulaEmpleado;

    public Solicitud() {
    }

    public Solicitud(String tiquete, String respuesta, boolean estadSolicitud, String motivoSolicitud, String descripcionSolicitud, String cedulaEmpleado) {
        this.tiquete = tiquete;
        this.respuesta = respuesta;
        this.estadSolicitud = estadSolicitud;
        this.motivoSolicitud = motivoSolicitud;
        this.descripcionSolicitud = descripcionSolicitud;
        this.cedulaEmpleado = cedulaEmpleado;
    }
    
    

    public String getTiquete() {
        return tiquete;
    }

    public void setTiquete(String tiquete) {
        this.tiquete = tiquete;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isEstadSolicitud() {
        return estadSolicitud;
    }

    public void setEstadSolicitud(boolean estadSolicitud) {
        this.estadSolicitud = estadSolicitud;
    }

    public String getMotivoSolicitud() {
        return motivoSolicitud;
    }

    public void setMotivoSolicitud(String motivoSolicitud) {
        this.motivoSolicitud = motivoSolicitud;
    }

    public String getDescripcionSolicitud() {
        return descripcionSolicitud;
    }

    public void setDescripcionSolicitud(String descripcionSolicitud) {
        this.descripcionSolicitud = descripcionSolicitud;
    }

    public String getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(String cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }
    
    
}

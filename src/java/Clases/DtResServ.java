package Clases;

import java.util.Date;
import webservices.DataServicio;

public class DtResServ {
    private DataServicio servicio;
    private int cantidad;
    private Date fechaIni;
    private Date fechaFin;
    
    public DtResServ(DataServicio servicio, int cantidad, Date fechaIni, Date fechaFin) {
        this.servicio = servicio;
        this.cantidad = cantidad;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }

    public DataServicio getServicio() {return servicio;}
    public int getCantidad() {return cantidad;}
    public Date getFechaIni() {return fechaIni;}
    public Date getFechaFin() {return fechaFin;}
    
    
}

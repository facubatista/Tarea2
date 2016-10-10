package Clases;

import Logica.DtServicio;
import java.util.Date;

public class DtResServ {
    private DtServicio servicio;
    private int cantidad;
    private Date fechaIni;
    private Date fechaFin;
    
    public DtResServ(DtServicio servicio, int cantidad, Date fechaIni, Date fechaFin) {
        this.servicio = servicio;
        this.cantidad = cantidad;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }

    public DtServicio getServicio() {return servicio;}
    public int getCantidad() {return cantidad;}
    public String getFechaIni() {return fechaIni.toString();}
    public String getFechaFin() {return fechaFin.toString();}
    
    
}

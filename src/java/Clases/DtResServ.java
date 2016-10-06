package Clases;

import Logica.DtServicio;

public class DtResServ {
    private DtServicio servicio;
    private int cantidad;
    
    public DtResServ(DtServicio servicio, int cantidad) {
        this.servicio = servicio;
        this.cantidad = cantidad;
    }

    public DtServicio getServicio() {return servicio;}
    public int getCantidad() {return cantidad;}
}

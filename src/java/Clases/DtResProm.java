package Clases;

import java.util.Date;
import webservices.DataPromocion;


public class DtResProm {
    private DataPromocion promocion;
    private int cantidad;
    private String proveedor;
    private Date fechaIni;
    private Date fechaFin;
    
    public DtResProm(DataPromocion promocion, int cantidad, Date fechaIni, Date fechaFin) {
        this.promocion = promocion;
        this.cantidad = cantidad;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.proveedor = promocion.getProveedor();
    }

    public DataPromocion getPromocion() {return promocion;}
    public int getCantidad() {return cantidad;}
    public String getProveedor(){ return proveedor;}

    public Date getFechaIni() {
        return fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }
    
}

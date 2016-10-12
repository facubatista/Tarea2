package Clases;

import Logica.DtPromocion;
import java.util.Date;


public class DtResProm {
    private DtPromocion promocion;
    private int cantidad;
    private String proveedor;
    private Date fechaIni;
    private Date fechaFin;
    
    public DtResProm(DtPromocion promocion, int cantidad, Date fechaIni, Date fechaFin) {
        this.promocion = promocion;
        this.cantidad = cantidad;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.proveedor = promocion.getProveedor();
    }

    public DtPromocion getPromocion() {return promocion;}
    public int getCantidad() {return cantidad;}
    public String getProveedor(){ return proveedor;}

    public Date getFechaIni() {
        return fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }
    
}

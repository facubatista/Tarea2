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
    }

    public DtPromocion getPromocion() {return promocion;}
    public int getCantidad() {return cantidad;}
    public String getProveedor(){ return proveedor;}
}

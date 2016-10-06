package Clases;

import Logica.DtPromocion;


public class DtResProm {
    private DtPromocion promocion;
    private int cantidad;
    
    public DtResProm(DtPromocion promocion, int cantidad) {
        this.promocion = promocion;
        this.cantidad = cantidad;
    }

    public DtPromocion getPromocion() {return promocion;}
    public int getCantidad() {return cantidad;}
}

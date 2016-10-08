package Clases;

import Logica.DtPromocion;


public class DtResProm {
    private DtPromocion promocion;
    private int cantidad;
    private String proveedor;
    
    public DtResProm(DtPromocion promocion, int cantidad, String proveedor) {
        this.promocion = promocion;
        this.cantidad = cantidad;
        this.proveedor = proveedor;
    }

    public DtPromocion getPromocion() {return promocion;}
    public int getCantidad() {return cantidad;}
    public String getProveedor(){ return proveedor;}
}

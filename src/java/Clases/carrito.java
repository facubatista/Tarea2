package Clases;

import Logica.DtPromocion;
import Logica.DtServicio;
import java.util.ArrayList;

public class carrito {
    public carrito(){
        servicios = new ArrayList<>();
        promociones = new ArrayList<>();
        total = 0;
    }
    
    public void setServicio(DtServicio serv){this.servicios.add(serv);}
    public void setPromocion(DtPromocion promo){this.promociones.add(promo);}
    public void setTotal(float total){this.total+=total;}
    
    public ArrayList<DtServicio> getServicios(){return servicios;}
    public ArrayList<DtPromocion> getPromociones(){return promociones;}
    public float getTotal(){return this.total;}
    
    private ArrayList<DtServicio> servicios;
    private ArrayList<DtPromocion> promociones;
    float total;
}

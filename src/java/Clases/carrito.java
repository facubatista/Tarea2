package Clases;

import Logica.DtPromocion;
import Logica.DtServicio;
import java.util.ArrayList;

public class carrito {
    public carrito(){
        servicios = new ArrayList<>();
        promociones = new ArrayList<>();
    }
    
    public void setServicio(DtServicio serv){this.servicios.add(serv);}
    public void setPromocion(DtPromocion promo){this.promociones.add(promo);}
    
    public ArrayList<DtServicio> getServicios(){return servicios;}
    public ArrayList<DtPromocion> getPromociones(){return promociones;}
    
    private ArrayList<DtServicio> servicios;
    private ArrayList<DtPromocion> promociones;
}

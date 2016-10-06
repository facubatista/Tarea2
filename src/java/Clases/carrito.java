package Clases;

import java.util.ArrayList;

public class carrito {
    public carrito(){
        servicios = new ArrayList<>();
        promociones = new ArrayList<>();
    }
    
    public void setServicio(DtResServ serv){this.servicios.add(serv);}
    public void setPromocion(DtResProm promo){this.promociones.add(promo);}
    
    public ArrayList<DtResServ> getServicios(){return servicios;}
    public ArrayList<DtResProm> getPromociones(){return promociones;}
    
    private ArrayList<DtResServ> servicios;
    private ArrayList<DtResProm> promociones;
}

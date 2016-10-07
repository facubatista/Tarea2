package Clases;

import java.util.ArrayList;

public class carrito {
    public carrito(){
        servicios = new ArrayList<>();
        promociones = new ArrayList<>();
        total = 0;
    }
    
    public void setServicio(DtResServ serv){this.servicios.add(serv);}
    public void setPromocion(DtResProm promo){this.promociones.add(promo);}
    
    public ArrayList<DtResServ> getServicios(){return servicios;}
    public ArrayList<DtResProm> getPromociones(){return promociones;}
    
    public void setTotal(float tot){this.total+=tot;}
    public float getTotal(){return this.total;}
    
    private ArrayList<DtResServ> servicios;
    private ArrayList<DtResProm> promociones;
    float total;
}

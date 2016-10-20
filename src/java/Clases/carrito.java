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
    
    public float eliminarServ(String nomServ){        
        for(int i=0;i<servicios.size();i++){
            if(servicios.get(i).getServicio().getNombre().equals(nomServ)){
                total=total-(servicios.get(i).getServicio().getPrecio()*servicios.get(i).getCantidad());
                servicios.remove(i);
            }
        }
        return total;
    }
    
    public float eliminarPromo(String nomPromo){        
        for(int i=0;i<promociones.size();i++){
            DtResProm promo = promociones.get(i);
            if(promo.getPromocion().getNombre().equals(nomPromo)){
                total = total-(promo.getPromocion().getTotal()*promociones.get(i).getCantidad());
                promociones.remove(i);
            }
        }
        return total;
    }
    
    private ArrayList<DtResServ> servicios;
    private ArrayList<DtResProm> promociones;
    float total;
}

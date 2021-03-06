package Servlets;

import Clases.DtResProm;
import Clases.DtResServ;
import Clases.carrito;
import Logica.Factory;
import Logica.IcontClientes;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kevin
 */
@WebServlet(name = "ServletCarrito", urlPatterns = {"/ServletCarrito"})
public class ServletCarrito extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        IcontClientes cont = Factory.getInstance().crearContCliente();
        HttpSession sesion = request.getSession();
        
        //Confirmar Reserva
        if(request.getParameter("confirmarReserva")!=null && sesion.getAttribute("carrito")!=null){
            carrito car = (carrito) sesion.getAttribute("carrito");
            cont.crearReserva((String)sesion.getAttribute("nickUsuario"),car.getTotal());
            if(car.getPromociones().size()>0){
                for(int i=0;i<car.getPromociones().size();i++){
                    DtResProm rp = car.getPromociones().get(i);
                    cont.seleccionarProveedor(rp.getProveedor());//selecciona el proveedor para buscar la promocion en la logica
                    cont.agregarPromoAreserva(rp.getPromocion().getNombre(), rp.getCantidad(), rp.getFechaIni(), rp.getFechaFin());
                }
            }
            if(car.getServicios()!=null){
                for(int i=0;i<car.getServicios().size();i++){
                    DtResServ rs = car.getServicios().get(i);
                    cont.seleccionarProveedor(rs.getServicio().getProveedor());//selecciona el proveedor para buscar el servicio en la logica
                    cont.agregarServicioAreserva(rs.getServicio().getNombre(), rs.getCantidad(), rs.getFechaIni(), rs.getFechaFin());
                }
            }
            
            cont.limpiar();
            sesion.removeAttribute("carrito");            
        }
        
        //Borrar Carrito
        if(request.getParameter("borrarCarrito")!=null && sesion.getAttribute("carrito")!=null){
            sesion.removeAttribute("carrito");
        }
        
        //Eliminar servicio del carrito
        if(request.getParameter("eliminarServicioCar")!=null){
            carrito car = (carrito)sesion.getAttribute("carrito");
            car.eliminarServ(request.getParameter("eliminarServicioCar"));
            
            response.setContentType("text/plain");
            response.getWriter().write(String.valueOf(Math.round(car.getTotal())));
        }
        
        //Eliminar promocion del carrito
        if(request.getParameter("eliminarPromoCar")!=null){
            carrito car = (carrito)sesion.getAttribute("carrito");
            car.eliminarPromo(request.getParameter("eliminarPromoCar"));
            
            response.setContentType("text/plain");
            response.getWriter().write(String.valueOf(Math.round(car.getTotal())));
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletCarrito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletCarrito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

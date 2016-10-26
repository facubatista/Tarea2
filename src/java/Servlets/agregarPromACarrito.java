package Servlets;

import Clases.DtResProm;
import Clases.carrito;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webservices.DataPromocion;
import webservices.WSProveedores;
import webservices.WSProveedoresService;

public class agregarPromACarrito extends HttpServlet {

    SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
            
            String nombre = request.getParameter("nombrePromocion");
            String proveedor = request.getParameter("nombreProveedor");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            
            Integer diaIni = Integer.parseInt(request.getParameter("diaIni"));
            Integer mesIni = Integer.parseInt(request.getParameter("mesIni"));
            Integer anioIni = Integer.parseInt(request.getParameter("anioIni"));
            String fechaIni = diaIni.toString() + "/" + mesIni.toString() + "/" + anioIni.toString();
            
            Integer diaFin = Integer.parseInt(request.getParameter("diaFin"));
            Integer mesFin = Integer.parseInt(request.getParameter("mesFin"));
            Integer anioFin = Integer.parseInt(request.getParameter("anioFin"));
            String fechaFin = diaFin.toString() + "/" + mesFin.toString() + "/" + anioFin.toString();
            
            WSProveedoresService wsps = new WSProveedoresService();
            WSProveedores wsp = wsps.getWSProveedoresPort();
            
            HttpSession sesion = request.getSession();
            
            carrito car;
            
            if(sesion.getAttribute("carrito")==null){
                car = new carrito();
                sesion.setAttribute("carrito", car);
            }else
                car = (carrito) sesion.getAttribute("carrito");
            
            DataPromocion p = wsp.seleccionarPromocionAListar(proveedor, nombre);
            DtResProm dt = new DtResProm(p, cantidad, dateformat.parse(fechaIni), dateformat.parse(fechaFin));
            
            float total = p.getTotal() * cantidad;
            car.setPromocion(dt);
            car.setTotal(total);
            
            sesion.setAttribute("carrito", car);
            response.getWriter().println("{respuesta:'ok'}");
        
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
            Logger.getLogger(agregarPromACarrito.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(agregarPromACarrito.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(agregarPromACarrito.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(agregarPromACarrito.class.getName()).log(Level.SEVERE, null, ex);
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

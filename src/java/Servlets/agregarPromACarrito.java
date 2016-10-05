package Servlets;

import Clases.carrito;
import Logica.DtPromocion;
import Logica.DtServicio;
import Logica.Factory;
import Logica.IcontProveedores;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class agregarPromACarrito extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nombre = request.getParameter("nombrePromocion");
            String proveedor = request.getParameter("nombreProveedor");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            
            IcontProveedores cont = Factory.getInstance().crearContProveedores();
            
            HttpSession sesion = request.getSession();
            
            carrito car;
            
            if(sesion.getAttribute("carrito")==null){
                car = new carrito();
                sesion.setAttribute("carrito", car);
            }else
                car = (carrito) sesion.getAttribute("carrito");
            
            for(int i = 0; i<cantidad; i++){
                DtPromocion p = cont.seleccionarPromocionAListar(proveedor, nombre);
                car.setPromocion(p);
                car.setTotal(p.getTotal());
            }
            sesion.setAttribute("carrito", car);
            response.getWriter().println("{respuesta:'ok', facu:'hola'}");
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

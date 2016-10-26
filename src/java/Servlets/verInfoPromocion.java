package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webservices.DataPromocion;
import webservices.DataServicio;
import webservices.WSProveedores;
import webservices.WSProveedoresService;

@WebServlet(name = "verInfoPromocion", urlPatterns = {"/InfoPromocion"})
public class verInfoPromocion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        WSProveedoresService wsps = new WSProveedoresService();
        WSProveedores wsp = wsps.getWSProveedoresPort();
        
        String nombre = request.getParameter("nombrePromocion");
        String proveedor = request.getParameter("nombreProveedor");
        
        String nomProm = nombre.replace("+", " ");
        
        DataPromocion p = wsp.seleccionarPromocionAListar(proveedor, nomProm);
        
        Iterator<String> it = p.getServicios().iterator();
        
        ArrayList<DataServicio> listaServ = new ArrayList<>();
        while(it.hasNext()){
            listaServ.add(wsp.seleccionarServicioAListar(proveedor, it.next()));
        }
        
        if(!listaServ.isEmpty())
            request.setAttribute("listaServicios", listaServ);
        
        request.setAttribute("promocion", p);
//        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Vistas/infoPromocion.jsp");
        dispatcher.forward(request, response);
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
            Logger.getLogger(verInfoPromocion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(verInfoPromocion.class.getName()).log(Level.SEVERE, null, ex);
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

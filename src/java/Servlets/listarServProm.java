package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webservices.DataPromociones;
import webservices.DataServicios;
import webservices.WSCatCiudad;
import webservices.WSCatCiudadService;
import webservices.WSProveedores;
import webservices.WSProveedoresService;


@WebServlet(name = "listarServProm", urlPatterns = {"/ServProm"})
public class listarServProm extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        WSProveedoresService wsps = new WSProveedoresService();
        WSProveedores wsp = wsps.getWSProveedoresPort();
        
        WSCatCiudadService wsccs = new WSCatCiudadService();
        WSCatCiudad wscc = wsccs.getWSCatCiudadPort();
        
        
        
        DataServicios listaServicios = wsp.listarServiciosBuscados((String)request.getParameter("busqueda"));
        
        DataPromociones listaPromociones = wsp.listarPromocionesBuscadas((String)request.getParameter("busqueda"));
        
        request.setAttribute("listaServicios", listaServicios);
        request.setAttribute("listaPromociones", listaPromociones);
        request.setAttribute("listaCategorias", wscc.traerCategorias());
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Vistas/servProm.jsp");
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
            Logger.getLogger(listarServProm.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(listarServProm.class.getName()).log(Level.SEVERE, null, ex);
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

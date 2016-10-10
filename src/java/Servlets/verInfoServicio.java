package Servlets;

import Logica.DtServicio;
import Logica.Factory;
import Logica.IcontProveedores;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Facu
 */
public class verInfoServicio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        IcontProveedores cont = Factory.getInstance().crearContProveedores();
        
        String nombre = request.getParameter("nombreServicio");
        String proveedor = request.getParameter("nombreProveedor");
        
        String nomServ = nombre.replace("+", " ");
        
        ArrayList<byte[]> lista = cont.getBufferedImageServicio(proveedor, nomServ);
        
        DtServicio s = cont.seleccionarServicioAListar(proveedor, nomServ);
        
        request.setAttribute("servicio", s);
        request.setAttribute("listaImagenes", lista);
//        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Vistas/infoServicio.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(verInfoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(verInfoServicio.class.getName()).log(Level.SEVERE, null, ex);
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

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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webservices.DataServicio;
import webservices.WSProveedores;
import webservices.WSProveedoresService;

@WebServlet(name = "verInfoServicio", urlPatterns = {"/InfoServicio"})
public class verInfoServicio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        
        WSProveedoresService wsps = new WSProveedoresService();
        WSProveedores wsp = wsps.getWSProveedoresPort();
        
        String nombre = request.getParameter("nombreServicio");
        String proveedor = request.getParameter("nombreProveedor");
        
        String nomServ = nombre.replace("+", " ");
        
        //ArrayList<byte[]> lista = cont.getBufferedImageServicio(proveedor, nomServ);
        
        DataServicio s = wsp.seleccionarServicioAListar(proveedor, nomServ);
        
        request.setAttribute("servicio", s);
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

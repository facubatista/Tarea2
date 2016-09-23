/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Factory;
import Logica.IcontClientes;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ServletUsuarios", urlPatterns = {"/ServUsuarios"})
public class ServletUsuarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        IcontClientes cont = Factory.getInstance().crearContCliente();
        HttpSession sesion = request.getSession();
                
        //Iniciar Sesión
        String nomUsuario = request.getParameter("nomUsuario");
        if(sesion.getAttribute("nickUsuario")==null && nomUsuario!=null){
            nomUsuario=cont.verificarUsuario(nomUsuario);//Retorna el nickname
            sesion.setAttribute("nickUsuario", nomUsuario);
            //Se toman el nombre y el apellido del usuario para mostrarlo en la cabecera
            nomUsuario = cont.seleccionarClienteAListar(nomUsuario).getNombre()+" "+cont.seleccionarClienteAListar(nomUsuario).getApellido();
            //Se setea el nombre de usuario en la sesion
            sesion.setAttribute("nomUsuario", nomUsuario);//Es el nombre para mostrar en el header
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
        
        //Verificar que el nickname sea valido
        if(request.getParameter("verificarUsuario")!=null){
            //especifica que el tipo de respuesta va a ser texto
            response.setContentType("text/plain");
            String claveUsuario=request.getParameter("verificarUsuario");
            if(cont.verificarUsuario(claveUsuario).equals("false")){
                response.getWriter().write("false");
                /*response.getWriter().write("{\"verificacion\" : [" +
                        "{ \"respuesta\":\"false\"}]}");*/
            }
            else{//Se crea el texto correspondiente a un objeto jason de nombre verificacion, con el atributo booleano
                /*response.getWriter().write("{\"verificacion\" : [" +
                        "{ \"respuesta\":\""+cont.verificarUsuario(claveUsuario)+"\"}]}");*/
                response.getWriter().write("true");
            }
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
        HttpSession sesion = request.getSession();
        
        //Cerrar Sesión
        if(request.getParameter("Sesion").equals("Cerrar") /*&& sesion.getAttribute("nomUsuario").equals("Anonimo")==false*/){
            sesion.setAttribute("nomUsuario", "Anonimo");
            sesion.removeAttribute("nickUsuario");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
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
            Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
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

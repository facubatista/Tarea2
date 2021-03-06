/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.carrito;
import Logica.DtCliente;
import Logica.DtReserva;
import Logica.Factory;
import Logica.IcontClientes;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;
import sun.misc.BASE64Decoder;

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
            
            throws ServletException, IOException, SQLException, ParseException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        IcontClientes cont = Factory.getInstance().crearContCliente();
        HttpSession sesion = request.getSession();
       
        
        //Iniciar Sesión
        String nomUsuario = request.getParameter("nomUsuario");//el nomUsuario que viene en el param puede ser el nickname o el email del cliente
        if (sesion.getAttribute("nickUsuario") == null && nomUsuario != null) {
            nomUsuario = cont.verificarUsuario(nomUsuario);//Retorna el nickname
            sesion.setAttribute("nickUsuario", nomUsuario);
            sesion.setAttribute("DtCliente", cont.seleccionarClienteAListar(nomUsuario));//DtCliente para Ver Perfil
            sesion.setAttribute("imagenUsuario", cont.getImagenUsuarioEnArrayBytes(nomUsuario));

            DtCliente cliente = cont.seleccionarClienteAListar(nomUsuario);

            //Se toman el nombre y el apellido del usuario para mostrarlo en la cabecera
            nomUsuario = cliente.getNombre() + " " + cliente.getApellido();
            //Se setea el nombre de usuario en la sesion
            sesion.setAttribute("nomUsuario", nomUsuario);//Es el nombre para mostrar en el header 

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }       
         
        //Verificar que el nickname sea valido
        if (request.getParameter("verificarUsuario") != null) {
            //especifica que el tipo de respuesta va a ser texto
            response.setContentType("text/plain");
            String claveUsuario = request.getParameter("verificarUsuario");
            if (cont.verificarUsuario(claveUsuario).equals("false")) {
                response.getWriter().write("false");
                /*response.getWriter().write("{\"verificacion\" : [" +
                        "{ \"respuesta\":\"false\"}]}");*/
            } else {//Se crea el texto correspondiente a un objeto jason de nombre verificacion, con el atributo booleano
                /*response.getWriter().write("{\"verificacion\" : [" +
                        "{ \"respuesta\":\""+cont.verificarUsuario(claveUsuario)+"\"}]}");*/
                response.getWriter().write("true");
            }
        }
       
        //Verificar password
        if (request.getParameter("verificarPassword") != null && request.getParameter("passUser") != null) {
           response.setContentType("text/plain");
           String nickname = (String)request.getParameter("passUser");
           nickname = cont.verificarUsuario(nickname);//Retorna el nickname, esto es por si el usuario ingresa su email para logearse
           String claveUsuario = (String)request.getParameter("verificarPassword");
            if (cont.userPassValido(nickname, claveUsuario)==true){
                response.getWriter().write("passOK");
            } else {
                response.getWriter().write("passMAL");
            }
        }

        //Alta de usuario
        if (request.getParameter("Registrar") != null) {
            response.setContentType("text/plain");
            String nick = (String) request.getParameter("user");
            String nombre = (String) request.getParameter("name");
            String apellido = (String) request.getParameter("surname");
            String email = (String) request.getParameter("email");
            String pass = (String) request.getParameter("pass");
            String mes = (String) request.getParameter("month");
            String dia = (String) request.getParameter("day");
            String anio = (String) request.getParameter("year");
            int numMes = 0;
            if (mes.equals("Enero")) {
                numMes = 1;
            }
            if (mes.equals("Febrero")) {
                numMes = 2;
            }
            if (mes.equals("Marzo")) {
                numMes = 3;
            }
            if (mes.equals("Abril")) {
                numMes = 4;
            }
            if (mes.equals("Mayo")) {
                numMes = 5;
            }
            if (mes.equals("Junio")) {
                numMes = 6;
            }
            if (mes.equals("Julio")) {
                numMes = 7;
            }
            if (mes.equals("Agosto")) {
                numMes = 8;
            }
            if (mes.equals("Setiembre")) {
                numMes = 9;
            }
            if (mes.equals("Octubre")) {
                numMes = 10;
            }
            if (mes.equals("Noviembre")) {
                numMes = 11;
            }
            if (mes.equals("Diciembre")) {
                numMes = 12;
            }
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String day = dia + "/" + String.valueOf(numMes) + "/" + anio;
            Date fecha = format.parse(day);
            if (cont.crearUserWeb(nick, pass, nombre, apellido, email, fecha, null)) {
                response.getWriter().write("true");
            } else {
                response.getWriter().write("false");
            }

        }

        if (request.getParameter("RImagen") != null) {
            response.setContentType("text/plain");
                String base64 = (String) request.getParameter("archivo");
                base64=base64.substring(base64.indexOf(",")+1);
                BufferedImage image = null;
                String nickname = (String) request.getParameter("nickname");
                byte[] imageByte;
                try {
                    BASE64Decoder decoder = new BASE64Decoder();
                    imageByte = decoder.decodeBuffer(base64);
                    ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
                    image = ImageIO.read(bis);
                    bis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (cont.agregarImagen(nickname, image)) {
                    response.getWriter().write(base64);
                } else {
                   
                    response.getWriter().write("false");
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

        try {
            IcontClientes cont = Factory.getInstance().crearContCliente();
            HttpSession sesion = request.getSession();

            //Cerrar Sesión
            if (request.getParameter("Sesion") != null) {
                sesion.setAttribute("nomUsuario", "Anonimo");
                sesion.removeAttribute("nickUsuario");
                sesion.removeAttribute("imagenUsuario");
                sesion.removeAttribute("carrito");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response); 
                
            }

            //Ver Perfil
            if (request.getParameter("VerPerfil") != null) {

                String nickUsuario = (String) sesion.getAttribute("nickUsuario");
                DtCliente cliente = cont.seleccionarClienteAListar(nickUsuario);
                request.setAttribute("ReservasCli", cont.listarResDeCli(nickUsuario));

                RequestDispatcher dispatcher = request.getRequestDispatcher("/Vistas/VerPerfil.jsp");
                dispatcher.forward(request, response);
            }
            
            //Cambair Estado de reserva
            if (request.getParameter("cambiarEstadoRes") != null) {
                String nickUsuario = (String) sesion.getAttribute("nickUsuario");
                int numRes = Integer.valueOf(request.getParameter("cambiarEstadoRes"));
                cont.seleccionarReserva(numRes, nickUsuario);//Se selecciona la reserva a cambiar, esto ya estaba implementado de la tarea 1
                cont.cambiarEstado("Cancelada");//Siempre se cambia a este estado porque solo se puede cambiar a cancelada
            }
            
            //Ver Reserva
            if (request.getParameter("VerReserva") != null) {
                String nickUsuario = (String) sesion.getAttribute("nickUsuario");
                int num = Integer.valueOf((String) request.getParameter("numero"));
                DtReserva res = cont.mostrarReserva(num, nickUsuario);
                request.setAttribute("Reserva", res);
                RequestDispatcher dispatcher = request.getRequestDispatcher("./Vistas/VerReserva.jsp");
                dispatcher.forward(request, response);
            }
            
            

        } catch (SQLException ex) {
            Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
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
            IcontClientes cont = Factory.getInstance().crearContCliente();
            HttpSession sesion = request.getSession();
                  
            processRequest(request, response);
        } catch (SQLException | ParseException | InterruptedException ex) {
            Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

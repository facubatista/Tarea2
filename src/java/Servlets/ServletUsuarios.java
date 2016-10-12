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
            throws ServletException, IOException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        IcontClientes cont = Factory.getInstance().crearContCliente();
        HttpSession sesion = request.getSession();

        //Iniciar Sesión
        String nomUsuario = request.getParameter("nomUsuario");
        if (sesion.getAttribute("nickUsuario") == null && nomUsuario != null) {
            nomUsuario = cont.verificarUsuario(nomUsuario);//Retorna el nickname
            sesion.setAttribute("nickUsuario", nomUsuario);
            sesion.setAttribute("DtCliente", cont.seleccionarClienteAListar(nomUsuario));//DtCliente para Ver Perfil
            sesion.setAttribute("imagenUsuario", cont.geImagenUsuarioEnArrayBytes(nomUsuario));
            DtCliente cliente = cont.seleccionarClienteAListar(nomUsuario);

            //Se toman el nombre y el apellido del usuario para mostrarlo en la cabecera
            nomUsuario = cliente.getNombre() + " " + cliente.getApellido();
            //Se setea el nombre de usuario en la sesion
            sesion.setAttribute("nomUsuario", nomUsuario);//Es el nombre para mostrar en el header 
            sesion.setAttribute("imagenUsuario", cliente.getImagen());//imagen para la cabecera

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


        if (request.getParameter("pass") != null && request.getParameter("user") != null) {
            response.setContentType("text/plain");
            String nick = request.getParameter("user");
            String nombre = request.getParameter("name");
            String apellido = request.getParameter("surname");
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            String mes = request.getParameter("month");
            String dia = request.getParameter("day");
            String anio = request.getParameter("year");
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
            if(cont.crearUserWeb(nick, pass, nombre, apellido, email, fecha, null))
            response.getWriter().write("true");
            else response.getWriter().write("false");
        }

        if (request.getParameter("archivo") != null && request.getParameter("nickname") != null) {
            response.setContentType("text/plain");
            String nickname = request.getParameter("nickname");
            String base64 = request.getParameter("archivo");
            BufferedImage image = null;
            byte[] imageByte;
            try {
                BASE64Decoder decoder = new BASE64Decoder();
                imageByte = decoder.decodeBuffer(base64.substring(base64.indexOf(",")+1));
                ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
                image = ImageIO.read(bis);
                bis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(cont.agregarImagen(nickname, image))
            response.getWriter().write("true");
            else response.getWriter().write("false");
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

            if(request.getParameter("VerPerfil")!=null){

                String nickUsuario = (String) sesion.getAttribute("nickUsuario");
                DtCliente cliente = cont.seleccionarClienteAListar(nickUsuario);
                request.setAttribute("ReservasCli", cont.listarResDeCli(nickUsuario));

                RequestDispatcher dispatcher = request.getRequestDispatcher("/Vistas/VerPerfil.jsp");
                dispatcher.forward(request, response);
            }
            
            if(request.getParameter("VerReserva")!=null){
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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    } 
}


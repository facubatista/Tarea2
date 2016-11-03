/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webservices.DataCliente;
import webservices.DataReserva;
import webservices.DataRsRp;
import webservices.ParseException_Exception;
import webservices.WSClientes;
import webservices.WSClientesService;

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
            
            throws ServletException, IOException, SQLException, ParseException, InterruptedException, ParseException_Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        WSClientesService wscs = new WSClientesService();
        WSClientes wsc = wscs.getWSClientesPort();
        
        //IcontClientes cont = Factory.getInstance().crearContCliente();
        HttpSession sesion = request.getSession();
       
        
        //Iniciar Sesión
        String claveUsuario = (String) request.getParameter("nomUsuario");//la clave puede ser el nickname o el email del cliente
        if (sesion.getAttribute("nickUsuario") == null && claveUsuario != null) {
            String nickname = wsc.verificarUsuario(claveUsuario);//Retorna el nickname
            sesion.setAttribute("nickUsuario", nickname);

            //DtCliente para Ver Perfil
            DataCliente cliente = (DataCliente) wsc.getDataCliente(nickname);
            sesion.setAttribute("DataCliente", cliente);
           
            //Se toman el nombre y el apellido del usuario para mostrarlo en la cabecera
            String nomUsuario = cliente.getNombre() + " " + cliente.getApellido();
            //Se setea el nombre de usuario en la sesion
            sesion.setAttribute("nomUsuario", nomUsuario);//Es el nombre para mostrar en el header 
            sesion.setMaxInactiveInterval(60*60*24);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }       
         
        //Verificar que el nickname sea valido
        if (request.getParameter("verificarUsuario") != null) {
            //especifica que el tipo de respuesta va a ser texto
            response.setContentType("text/plain");
            claveUsuario = request.getParameter("verificarUsuario");
            if (wsc.verificarUsuario(claveUsuario).equals("false")) {
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
           nickname = wsc.verificarUsuario(nickname);//Retorna el nickname, esto es por si el usuario ingresa su email para logearse
           String passUsuario = (String)request.getParameter("verificarPassword");
            if (wsc.userPassValido(nickname, passUsuario)==true){
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
            //Date fecha = format.parse(day);
            if (wsc.crearUserWeb(nick, pass, nombre, apellido, email, day, null)) {
                response.getWriter().write("true");
            } else {
                response.getWriter().write("false");
            }

        }

//        if (request.getParameter("RImagen") != null) {
//            response.setContentType("text/plain");
//                String base64 = (String) request.getParameter("archivo");
//                base64=base64.substring(base64.indexOf(",")+1);
//                BufferedImage image = null;
//                String nickname = (String) request.getParameter("nickname");
//                byte[] imageByte;
//                try {
//                    BASE64Decoder decoder = new BASE64Decoder();
//                    imageByte = decoder.decodeBuffer(base64);
//                    ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
//                    image = ImageIO.read(bis);
//                    bis.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                if (cont.agregarImagen(nickname, image)) {
//                    response.getWriter().write(base64);
//                } else {
//                   
//                    response.getWriter().write("false");
//                }
//            }
        
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
        WSClientesService wscs = new WSClientesService();
        WSClientes wsc = wscs.getWSClientesPort();
        
        if (request.getParameter("Sesion") != null) {
            sesion.setAttribute("nomUsuario", "Anonimo");
            sesion.removeAttribute("nickUsuario");
            sesion.removeAttribute("DataCliente");
            //sesion.removeAttribute("imagenUsuario");
            sesion.removeAttribute("carrito");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
            
        }
        
        if (request.getParameter("VerPerfil") != null && sesion.getAttribute("nickUsuario")!=null) {
            
            String nickUsuario = (String)sesion.getAttribute("nickUsuario");
            
            request.setAttribute("ReservasCli", wsc.listarResDeCli(nickUsuario));
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Vistas/VerPerfil.jsp");
            dispatcher.forward(request, response);
        }
//        if (request.getParameter("cambiarEstadoRes") != null) {
//            String nickUsuario = (String) sesion.getAttribute("nickUsuario");
//            int numRes = Integer.valueOf(request.getParameter("cambiarEstadoRes"));
//            wsc.seleccionarReserva(numRes, nickUsuario);//Se selecciona la reserva a cambiar, esto ya estaba implementado de la tarea 1
//            wsc.cambiarEstado("Cancelada");//Siempre se cambia a este estado porque solo se puede cambiar a cancelada
//        }
        if (request.getParameter("VerReserva") != null) {
            String nickUsuario = (String) sesion.getAttribute("nickUsuario");
            int num = Integer.valueOf((String) request.getParameter("numero"));
            DataRsRp RSRP = wsc.traerRsRp(num, nickUsuario);
            DataReserva res = wsc.mostrarReserva(num, nickUsuario);
            request.setAttribute("RSRP", RSRP);
            request.setAttribute("Reserva", res);
            RequestDispatcher dispatcher = request.getRequestDispatcher("./Vistas/VerReserva.jsp");
            dispatcher.forward(request, response);
        }
        
        if(request.getParameter("pdf")!=null){     
            try {
                //Se crea el documento
                Document documento = new Document();
                
                // Array bde bytes para el pdf
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PdfWriter.getInstance(documento, baos);
                
                //Abrir el documento para editarlo
                documento.open();                
                
                //No se para que sirve, no es el titulo que aparece en el pdf
                documento.addTitle("Factura");
        
                //Es el titulo que aparece en el pdf
                Paragraph p = new Paragraph("Factura",
                                                        FontFactory.getFont("arial",   // fuente
                                                        20,                            // tamaño
                                                        Font.BOLD/*,                   // estilo
                                                        BaseColor.CYAN*/));            //color
                p.setAlignment(Element.ALIGN_CENTER);//centrar
                documento.add(p);//Se agrega el párrafo al pdf

                //Agrega espacio
                documento.add(new Chunk("\n"));

                //Fuente en negrita
                Font font = FontFactory.getFont("arial", 12, Font.BOLD);

                //Palabras en negrta
                Chunk nroFactura = new Chunk("\nN° de factura: ", font);
                Chunk fecha = new Chunk("\nFecha de entrega: ", font);
                Chunk nroReserva = new Chunk("\nN° de reserva: ", font);
                Chunk clienteRes = new Chunk("\nCliente: ", font);
                Chunk infoReserva = new Chunk("\nInformación de reserva: \n", font);

                //En la derecha hay que poner los valores de la factura(factura.get...)
                documento.add(nroFactura); documento.add(new Chunk("1"));
                documento.add(fecha);      documento.add(new Chunk("22/10/2016"));
                documento.add(nroReserva); documento.add(new Chunk("10"));
                documento.add(clienteRes); documento.add(new Chunk("ClienteEjemplo"));
                documento.add(infoReserva);

                //Tabla de 6 columnas
                PdfPTable tabla = new PdfPTable(6);
                tabla.setWidthPercentage(100);//Ancho de la tabla, 100%
                
                //Primera fila ed la tabla, titulos en negrita con fuente "font"
                tabla.addCell(new Paragraph("Tipo", font));
                tabla.addCell(new Paragraph("Proveedor", font));
                tabla.addCell(new Paragraph("Nombre", font));
                tabla.addCell(new Paragraph("Precio", font));
                tabla.addCell(new Paragraph("Cantidad", font));
                tabla.addCell(new Paragraph("Total", font));

                //Otra fila
                tabla.addCell("Servicio");
                tabla.addCell("moody");
                tabla.addCell("Euro-Vuelo-S");
                tabla.addCell("$200");
                tabla.addCell("3");
                tabla.addCell("$600");

                //Otra fila
                tabla.addCell("Promoción");
                tabla.addCell("moody");
                tabla.addCell("Promo1");
                tabla.addCell("$400");
                tabla.addCell("1");
                tabla.addCell("$400");

                PdfPCell c = new PdfPCell();
                c.setBorder(0);

                //Otra fila, las c ocupan espacio en blanco
                tabla.addCell(c);
                tabla.addCell(c);
                tabla.addCell(c);
                tabla.addCell(c);
                tabla.addCell(c);
                tabla.addCell(new Paragraph("$1000", font));//Es el Total, ultima columna de la ultima fila

                documento.add(tabla);//Se agrega la tabla al pdf
                
                documento.close();//Se cierra el pdf

                //Setear la cabecera del response para poder enviar el pdf
                response.setHeader("Expires", "0");
                response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
                response.setHeader("Pragma", "public");
                //Con "attachment indicamos que va a ser descargado, con "filename" el nombre
                response.setHeader("Content-disposition", "attachment;filename=" + "factura.pdf");
                
                //Indica que se va a enviar un archivo tipo pdf
                response.setContentType("application/pdf");
                //Tamaño del contenido, pdf
                response.setContentLength(baos.size());
                //Escribir el baos(ByteArrayOutputStream) en el response
                OutputStream os = response.getOutputStream();
                baos.writeTo(os);
                os.flush();
                os.close();
            }catch(DocumentException e) {
                throw new IOException(e.getMessage());
            }
        }
        
        //Si no entra a ningun if redirecciona al index
        response.sendRedirect("/Tarea2/index.jsp");
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
        } catch (SQLException | ParseException | InterruptedException ex) {
            Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException_Exception ex) {
            Logger.getLogger(ServletUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

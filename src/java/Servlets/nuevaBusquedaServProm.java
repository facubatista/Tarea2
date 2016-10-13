package Servlets;

import Logica.DtPromocion;
import Logica.DtServicio;
import Logica.Factory;
import Logica.IcontProveedores;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class nuevaBusquedaServProm extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            HttpSession session = request.getSession();
            
            String categoria = request.getParameter("categoria");
            
            IcontProveedores cont = Factory.getInstance().crearContProveedores();
            ArrayList<DtServicio> listaServicios = cont.listarServiciosBuscados(categoria);
            Iterator<DtServicio> it = listaServicios.iterator();
            
            out.println("<table id=\"tabla\">");
                out.println("<thead>");
                    out.println("<tr>");
                        out.println("<th style=\"text-decoration: underline\"><b>Tipo</b></th>");
                        out.println("<th style=\"text-decoration: underline\"><b>Nombre</b></th>");
                        out.println("<th style=\"text-decoration: underline\"><b>Proveedor</b></th>");
                        if(session.getAttribute("nickUsuario") != null){
                            out.println("<th><b>Agregar a carrito</b></th>");
                        }
                    out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                    while(it.hasNext()){
                        DtServicio s = it.next();
                        out.println("<tr>");
                        out.println("<td class=\"TdTipo\">Servicio</td>");
                        out.println("<td class=\"TdNombreS\">");
                            if(!s.getImagenes().isEmpty()){
                                BufferedImage originalImage=(BufferedImage) s.getImagenes().get(0).getImage();
                                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                                ImageIO.write(originalImage, "jpg", baos );
                                byte[] arrayBytes = baos.toByteArray();
                                String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(arrayBytes);

                                out.println("<img class=\"imgMini\" src=\"data:image/jpg;base64,"+b64+"\">");
                            }else{
                                out.println("<img class=\"imgMini\" src=\"/Tarea2/Imag/SinImagen.jpg\">");
                            }
                            String nomServ = s.getNombre().replace(" ", "+");
                            out.println("<a href="+ request.getContextPath() +"/InfoServicio?nombreServicio="+ nomServ +"&nombreProveedor="+ s.getProveedor() +">\n" +
"                                            "+ s.getNombre() +"\n" +
"                                        </a>");
                        out.println("</td>");
                        out.println("<td class=\"TdProveedor\">"+ s.getProveedor() +"</td>");
                            if(session.getAttribute("nickUsuario") != null){
                                out.println("<td class=\"TdAgregarACarrito\">");
                                    out.println("<div class=\"aOcultar\">");
                                        out.println("<label class=\"precio\">Precio: $"+ Math.round(s.getPrecio()) +"</label>");
                                        //<%--Fecha de inicio del servicio--%>
                                        out.println("<div id=\"fechaIni\">");
                                            out.println("<label class=\"labelIni\" >Inicio:</label>");
                                            out.println("<input id=\"diaIni\" name=\"diaIni\" maxlength=\"2\" placeholder=\"dd\" type=\"text\"/>");
                                            out.println("<label class=\"label2\" >/</label>");
                                            out.println("<select id=\"mesIni\" name=\"mesIni\">");
                                                out.println("<option name=\"01\">Enero</option>");
                                                out.println("<option name=\"02\">Febrero</option>");
                                                out.println("<option name=\"03\">Marzo</option>");
                                                out.println("<option name=\"04\">Abril</option>");
                                                out.println("<option name=\"05\">Mayo</option>");
                                                out.println("<option name=\"06\">Junio</option>");
                                                out.println("<option name=\"07\">Julio</option>");
                                                out.println("<option name=\"08\">Agosto</option>");
                                                out.println("<option name=\"09\">Setiembre</option>");
                                                out.println("<option name=\"10\">Octubre</option>");
                                                out.println("<option name=\"11\">Noviembre</option>");
                                                out.println("<option name=\"12\">Diciembre</option>");
                                            out.println("</select>");
                                            out.println("<label class=\"label2\" >/</label>");
                                            out.println("<input id=\"anioIni\" name=\"anioIni\" maxlength=\"4\" placeholder=\"aaaa\" type=\"text\"/>");
                                        out.println("</div>");
                                        //<%--Fecha de Fin del servicio--%>
                                        out.println("<div id=\"fechaFin\">");
                                        out.println("<label class=\"labelFin\" >Fin:</label>");
                                        out.println("<input id=\"diaFin\" name=\"diaFin\" maxlength=\"2\" placeholder=\"dd\" type=\"text\"/>");
                                        out.println("<label class=\"label2\" >/</label>");
                                        out.println("<select id=\"mesFin\" name=\"mesFin\">");
                                            out.println("<option name=\"01\">Enero</option>"
                                                    + "<option name=\"02\">Febrero</option>\n" +
"                                                        <option name=\"03\">Marzo</option>\n" +
"                                                        <option name=\"04\">Abril</option>\n" +
"                                                        <option name=\"05\">Mayo</option>\n" +
"                                                        <option name=\"06\">Junio</option>\n" +
"                                                        <option name=\"07\">Julio</option>\n" +
"                                                        <option name=\"08\">Agosto</option>\n" +
"                                                        <option name=\"09\">Setiembre</option>\n" +
"                                                        <option name=\"10\">Octubre</option>\n" +
"                                                        <option name=\"11\">Noviembre</option>\n" +
"                                                        <option name=\"12\">Diciembre</option>");
                                        out.println("</select>");
                                        out.println("<label class=\"label2\" >/</label>");
                                        out.println("<input id=\"anioFin\" name=\"anioFin\" maxlength=\"4\" placeholder=\"aaaa\" type=\"text\"/>");
                                        out.println("</div>");
                                            out.println("<form <%--action=\"agregarSCarrito--%> onsubmit=\"return agregarSACarrito(this.parentElement.parentElement)\" name=\"formAgregar\">");
                                            out.println("<input type=\"hidden\" id =\"nombreServicio\" value="+ s.getNombre() +" name=\"nombreServicio\">");
                                            out.println("<input type=\"hidden\" id =\"nombreProveedor\" value="+ s.getProveedor() +" name=\"nombreProveedor\">");
                                            out.println("<label>Cantidad:</label><input type=\"text\" name=\"cantidad\" id=\"txtCantidad\" class=\"cantidad\" onkeyup=\"calcularPrecio(this.parentElement.parentElement, "+ Math.round(s.getPrecio()) +")\">");
                                            out.println("<input id =\"agregar\" type=\"submit\" value=\"agregar al carrito\" >");
                                            out.println("</form>");
                                        out.println("</div>");
                                        out.println("<div class=\"aMostrar\" hidden=\"\">\n" +
"                                                       <img src=\"Imag/carrito.png\" alt=\"imagen de carrito\"> En carrito\n" +
"                                                   </div>");
                                    out.println("</td>");
                            }
                        out.println("</tr>");
                    }
                    out.println("</tbody>");
                out.println("</table>");
                
                ArrayList<DtPromocion> listaPromociones = cont.listarPromocionesBuscadas(categoria);
                Iterator<DtPromocion> iterador = listaPromociones.iterator();

                while(iterador.hasNext()){
                    DtPromocion p = iterador.next();
                    out.println("<tr>");
                        out.println("<td class=\"TdTipo\">Promocion</td>");
                        out.println("<td>");
                            out.println("<a href="+ request.getContextPath() +"/InfoPromocion?nombrePromocion="+ p.getNombre() +"&nombreProveedor="+ p.getProveedor() +">\n" +
"                                            "+ p.getNombre() +"\n" +
"                                        </a>");
                    out.println("</td>");
                    out.println("<td class=\"TdProveedor\">"+ p.getProveedor() +"</td>");
                    if(session.getAttribute("nickUsuario") != null){
                        out.println("<td>");
                            out.println("<div class=\"aOcultar\">\n" +
"                                                <form onsubmit=\"return agregarPACarrito(this.parentElement.parentElement)\" name=\"formAgregar\">\n" +
"                                                    <input type=\"hidden\" id =\"nombrePromocion\" value="+ p.getNombre() +" name=\"nombrePromocion\">\n" +
"                                                    <input type=\"hidden\" id =\"nombreProveedor\" value="+ p.getProveedor() +" name=\"nombreProveedor\">\n" +
"                                                    <input type=\"text\" name=\"cantidad\" id=\"txtCantidad\" class=\"cantidad\" onkeyup=\"calcularPrecio(this.parentElement.parentElement, "+ p.getTotal() +")\">\n" +
"                                                    <input id =\"agregar\" type=\"submit\" value=\"agregar al carrito\" ><!-- cambiar esto!-->\n" +
"                                                </form>\n" +
"                                                    <label class=\"precio\">Precio: $"+ Math.round(p.getTotal()) +"</label>\n" +
"                                            </div>\n" +
"                                            <div class=\"aMostrar\" hidden=\"\">\n" +
"                                                <img src=\"Imag/carrito.png\" alt=\"imagen de carrito\"> En carrito\n" +
"                                            </div>");
                        out.println("</td>");
                    }
                    out.println("</tr>");
                }
                out.println("</body>");
            out.println("</table>");
                                
                                
                            
                        
            
            
            /*out.println("<table>");
            out.println("<tr>");
            out.println("<td>"+ categoria +"</td>");
            out.println("<td>APELLIDO</td>");
            out.println("<td>EDAD</td>");
            out.println("</tr>");
            out.println("<td>HOLA</td>");
            out.println("<td>PIM PAM PUM</td>");
            out.println("<td>COSO COLOR</td>");
            out.println("</tr>");
            out.println("</table>");*/
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
            Logger.getLogger(nuevaBusquedaServProm.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(nuevaBusquedaServProm.class.getName()).log(Level.SEVERE, null, ex);
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

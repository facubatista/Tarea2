<%@page import="java.util.ArrayList"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.io.File"%>
<%@page import="java.io.File"%>
<%@page import="javax.imageio.ImageIO"%>

<%@page import="org.apache.tomcat.util.http.fileupload.IOUtils"%>
<%@page import="java.util.Base64"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Url"%>
<%@page import="java.net.URL"%>
<%@page import="Logica.DtPromocion"%>
<%@page import="java.util.Iterator"%>
<%@page import="Clases.carrito"%>
<%@page import="Logica.DtServicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>InfoServicio</title>
        <link rel="stylesheet" type="text/css" href="CSS/Cabecera.css"/>
        <link rel ="stylesheet" href="CSS/infoServCss.css">
        <link rel ="stylesheet" href="CSS/Layout.css">
        <script src="JS/javaScript.js"></script>
        <jsp:include page="Cabecera.jsp" />
    </head>
    <body>
        <%
            DtServicio s = (DtServicio)request.getAttribute("servicio");
            
            ArrayList<byte[]> listaImagenes = (ArrayList)request.getAttribute("listaImagenes");
            
            /*BufferedImage bi = new BufferedImage ( s.getImagenes().get(0).getImage().getWidth ( null ), s.getImagenes().get(0).getImage().getHeight ( null ), BufferedImage.TYPE_INT_ARGB );
            Graphics bg = bi.getGraphics ();
            bg.drawImage ( s.getImagenes().get(0).getImage(), 0, 0, null );
            bg.dispose ();
            */
            /*BufferedImage bi = (BufferedImage)s.getImagenes().get(0).getImage();
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            
            
            
            ImageIO.write( bi, "jpg", baos );
            //baos.flush();
            byte[] imageInByteArray = baos.toByteArray();
            baos.close();*/
            Iterator<byte[]> iterador = listaImagenes.iterator();
            String b64 = null;
            String b64Chica1 = null;
            String b64Chica2 = null;
            String b64Chica3 = null;
            
            if(iterador.hasNext())
                b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(iterador.next());
            

        %>  
        
        <div class="principal">
            <div class="fila">
                <div class="cinco columnas" id="colUno">
                    <center>
                        <%if(b64 != null){%>
                            <img id="imgGrande" src="data:image/jpg;base64, <%=b64%>" alt="Visruth.jpg not found">
                        <%}%>
                    </center>
                    <center>
                        <div id="imgChicas">
                            <%
                                if(iterador.hasNext()){
                                b64Chica1 = javax.xml.bind.DatatypeConverter.printBase64Binary(iterador.next());
                                String paraFuncion = "data:image/jpg;base64, " + b64Chica1;
                            %>
                                <img id="chica1" class="chica" src="data:image/jpg;base64, <%=b64Chica1%>" onMouseOver="cambiarImagen(<%= b64Chica1 %>)" onmouseout="volverImagen(<%= paraFuncion %>)">
                            <%}%>
                            
                            <%
                                if(iterador.hasNext()){
                                b64Chica2 = javax.xml.bind.DatatypeConverter.printBase64Binary(iterador.next());
                                String paraFuncion2 = "data:image/jpg;base64, " + b64Chica2;
                            %>
                                <img id="chica2" class="chica" src="data:image/jpg;base64, <%=b64Chica2%>" onMouseOver="cambiarImagen(<%= b64Chica2 %>)" onmouseout="volverImagen(<%= paraFuncion2 %>)">
                            <%}%>
                            
                            <%
                                if(iterador.hasNext()){
                                b64Chica3 = javax.xml.bind.DatatypeConverter.printBase64Binary(iterador.next());
                                String paraFuncion3 = "data:image/jpg;base64, " + b64Chica3;
                            %>
                                <img id="chica3" class="chica" src="data:image/jpg;base64, <%=b64Chica3%>" onMouseOver="cambiarImagen(<%= b64Chica3 %>)" onmouseout="volverImagen(<%= paraFuncion3 %>)">
                            <%}%>
                        </div>
                    </center>
                </div>
                <div class="siete columnas" id="colDos">
                    <h2><%= s.getNombre() %></h2>
                    <br>
                    <p><%= s.getDescripcion() %></p>
                </div>
            </div>
            
            <div class="fila">
                <div class="seis columnas" id="colTres">
                        <table>
                            <thead>
                                <tr>
                                  <th>Proveedor</th>
                                  <th>Origen</th>
                                  <th>Destino</th>
                                  <th>Precio</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><%= s.getProveedor() %></td>
                                    <td><%= s.getOrigen() %></td>
                                    <%if(s.getDestino() == null){%>
                                        <td>-------------</td>
                                    <%}else{%>
                                        <td><%= s.getDestino() %></td>
                                    <%}%>
                                    
                                    <td><%= s.getPrecio() %></td>
                                </tr>
                            </tbody>
                        </table>
                </div>
                
                <div class="seis columnas" id="colCuatro">
                        <div class="aOcultar">
                            <label class="precio">Precio: <%= s.getPrecio() %></label>
                            <form <%--action="agregarSCarrito--%> onsubmit="return agregarACarrito(this.parentElement.parentElement)" name="formAgregar">
                                <input type="hidden" id ="nombreServicio" value="<%= s.getNombre() %>" name="nombreServicio">
                                <input type="hidden" id ="nombreProveedor" value="<%= s.getProveedor() %>" name="nombreProveedor">
                                <input type="text" name="cantidad" id="txtCantidad" class="cantidad" onkeyup="calcularPrecio(this.parentElement.parentElement, <%= s.getPrecio() %>)">
                                <input id ="agregar" type="submit" value="Agregar al carrito" >
                            </form>
                        </div>
                        <div class="aMostrar" hidden="">
                            <img src="Imag/carrito.png" alt="imagen de carrito"> En carrito
                        </div>
                    <div id="categorias">
                        <h3>Categorias:</h3>
                        <center>
                            <%
                                Iterator<String> it = s.getCategorias().iterator();
                                while(it.hasNext()){
                                    String cat = it.next();
                                    if(!cat.contains("Tipo") && !cat.equals("Empresas") && !cat.equals("Ubicacion") && !cat.equals("Habitaciones") && !cat.equals("Tarifa") && !cat.equals("Marca")){
                            %>
                            <label><%= cat %></label>
                            <%}
                            }%>
                        </center>
                    </div>
                </div>
            </div>
                            
        </div>
        <jsp:include page="Pie.jsp" />
    </body>
</html>

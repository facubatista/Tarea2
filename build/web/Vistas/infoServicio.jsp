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
            
        %>  
        
        <div class="principal">
            
            <div class="fila">
                <div class="cinco columnas" id="colUno">
                    <center>
                        <img id="imgGrande" src="Imag/prueba.jpg">
                    </center>
                    <center>
                        <div id="imgChicas">
                            <img id="chica1" class="chica" src="Imag/prueba2.jpg" onMouseOver="cambiarImagen(1)" onmouseout="volverImagen()">
                            <img id="chica2" class="chica" src="Imag/prueba3.jpg" onMouseOver="cambiarImagen(2)" onmouseout="volverImagen()">
                            <img id="chica3" class="chica" src="Imag/prueba4.jpg" onMouseOver="cambiarImagen(3)" onmouseout="volverImagen()">
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
                                <input id ="agregar" type="submit" value="agregar al carrito" >
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

<%@page import="java.util.List"%>
<%@page import="webservices.DataServicio"%>
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
<%@page import="java.util.Iterator"%>
<%@page import="Clases.carrito"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info de Servicio</title>
        <link type="image/x-icon" rel="shortcut icon"  href="/Tarea2/Imag/IconoH4T.ico">
        <link rel="stylesheet" type="text/css" href="CSS/Cabecera.css"/>
        <link rel ="stylesheet" href="CSS/infoServCss.css">
        <link rel ="stylesheet" href="CSS/Layout.css">
        <script src="JS/ServProm.js"></script>
        <jsp:include page="Cabecera.jsp" />
    </head>
    <body>
        <%
            DataServicio s = (DataServicio)request.getAttribute("servicio");
            
            List<byte[]> listaImagenes = s.getImagenes();
            
            Iterator<byte[]> iterador = listaImagenes.iterator();
            String b64 = null;
            String b64Chica1 = null;
            String b64Chica2 = null;
            
            if(iterador.hasNext())
                b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(iterador.next());
            

        %>  
        
        <div class="principal">
            <div class="fila">
                <div class="cinco columnas" id="colUno">
                    <center>
                        <%if(b64 != null){%>
                            <img id="imgGrande" src="data:image/jpg;base64, <%=b64%>">
                        <%}%>
                    </center>
                </div>
                <div class="siete columnas" id="colDos">
                    <h2><%= s.getNombre() %></h2>
                    <br>
                    <p><%= s.getDescripcion() %></p>
                </div>
            </div>
            <div class="fila">
                <div class="cinco columnas" id="colTres">
                    <center>
                        <div id="imgChicas">
                            <%if(b64 != null){%> 
                                <img id="chica1" class="chica" src="data:image/jpg;base64, <%=b64%>" onMouseOver="cambiarImagen(this)">
                            <%}%>
                            <%
                                if(iterador.hasNext()){
                                b64Chica1 = javax.xml.bind.DatatypeConverter.printBase64Binary(iterador.next());
                            %>
                                <img id="chica2" class="chica" src="data:image/jpg;base64, <%=b64Chica1%>" onMouseOver="cambiarImagen(this)"<%-- onmouseout="volverImagen(<%= paraFuncion %>)"--%>>
                            <%}%>

                            <%
                                if(iterador.hasNext()){
                                b64Chica2 = javax.xml.bind.DatatypeConverter.printBase64Binary(iterador.next());
                            %>
                                <img id="chica3" class="chica" src="data:image/jpg;base64, <%=b64Chica2%>" onMouseOver="cambiarImagen(this)"<%-- onmouseout="volverImagen(<%= paraFuncion2 %>)"--%>>
                            <%}%>
                        </div>
                    </center>
                </div>
                <div class="siete columnas" id="colCuatro">
                    <%if(session.getAttribute("nickUsuario") != null){%>
                    <div class="aOcultar">
                        <h2> Agregar a Carrito</h2>
                        <label class="precio">Precio: $<%= s.getPrecio() %></label>
                        <%--Fecha de inicio del servicio--%>
                        <div id="fechaIni">
                            <label class="labelIni" >Fecha inicio:</label>
                            <input id="diaIni" name="diaIni" maxlength="2" placeholder="dd" type="text"/>
                            <label class="label2" >/</label>
                            <select id="mesIni" name="mesIni">
                                <option name="01">Enero</option>
                                <option name="02">Febrero</option>
                                <option name="03">Marzo</option>
                                <option name="04">Abril</option>
                                <option name="05">Mayo</option>
                                <option name="06">Junio</option>
                                <option name="07">Julio</option>
                                <option name="08">Agosto</option>
                                <option name="09">Setiembre</option>
                                <option name="10">Octubre</option>
                                <option name="11">Noviembre</option>
                                <option name="12">Diciembre</option>
                            </select>
                            <label class="label2" >/</label>
                            <input id="anioIni" name="anioIni" maxlength="4" placeholder="aaaa" type="text"/>
                        </div>

                        <%--Fecha de Fin del servicio--%>
                        <div id="fechaFin">
                            <label class="labelFin" >Fecha fin:</label>
                            <input id="diaFin" name="diaFin" maxlength="2" placeholder="dd" type="text"/>
                            <label class="label2" >/</label>
                            <select id="mesFin" name="mesFin">
                                <option name="01">Enero</option>
                                <option name="02">Febrero</option>
                                <option name="03">Marzo</option>
                                <option name="04">Abril</option>
                                <option name="05">Mayo</option>
                                <option name="06">Junio</option>
                                <option name="07">Julio</option>
                                <option name="08">Agosto</option>
                                <option name="09">Setiembre</option>
                                <option name="10">Octubre</option>
                                <option name="11">Noviembre</option>
                                <option name="12">Diciembre</option>
                            </select>
                            <label class="label2" >/</label>
                            <input id="anioFin" name="anioFin" maxlength="4" placeholder="aaaa" type="text"/>
                        </div>
                        <div class="agregarACarrito">
                            <form <%--action="agregarSCarrito--%> onsubmit="return agregarSACarrito(this.parentElement.parentElement.parentElement)" name="formAgregar">
                                <input type="hidden" id ="nombreServicio" value="<%= s.getNombre() %>" name="nombreServicio">
                                <input type="hidden" id ="nombreProveedor" value="<%= s.getProveedor() %>" name="nombreProveedor">
                                <input type="text" name="cantidad" id="txtCantidad" class="cantidad" onkeyup="calcularPrecio(this.parentElement.parentElement.parentElement, <%= s.getPrecio() %>)">
                                <input id ="agregar" type="submit" value="agregar al carrito" >
                            </form>
                        </div>
                    </div>
                    <div class="aMostrar" hidden="">
                        <img src="Imag/carrito.png" alt="imagen de carrito"> En carrito
                    </div>
                    <%}%>
                </div>
            </div>
            <div class="fila">
                <div class="cinco columnas" id="colCinco">
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
                                    
                                    <td>$<%= s.getPrecio() %></td>
                                </tr>
                            </tbody>
                        </table>
                </div>
                
                <div class="siete columnas" id="colSeis">
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

<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.DtServicio"%>
<%@page import="Logica.DtPromocion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info de Promocion</title>
        <link type="image/x-icon" rel="shortcut icon"  href="/Tarea2/Imag/IconoH4T.ico">
        <link rel="stylesheet" type="text/css" href="CSS/Cabecera.css"/>
        <link rel ="stylesheet" href="CSS/infoPromCss.css">
        <link rel ="stylesheet" href="CSS/Layout.css">
        <script src="JS/jQuery.js"></script>
        <script src="JS/ServProm.js"></script>
        <jsp:include page="Cabecera.jsp" /> 
    </head>
    <body>
        <%
            DtPromocion p = (DtPromocion)request.getAttribute("promocion");
        %>
        
        <div class="principal">
            
            <div class="fila">
                <div class="doce columnas" id="colUno">
                    <center>
                        <h2><%= p.getNombre() %></h2>
                        <center>
                            <div>
                                <table>
                                    <thead>
                                        <tr>
                                          <th>Proveedor</th>
                                          <th>Descuento</th>
                                          <th>Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><%= p.getProveedor() %></td>
                                            <td><%= p.getPorcentaje() %></td>
                                            <td><%= p.getTotal() %></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </center>
                    </center>
                </div>
            </div>
            <div class="fila">
                <center>
                <div class="doce columnas" id="colDos">
                <%if(session.getAttribute("nickUsuario") != null){%>
                <h2>Agregar al Carrito</h2>
                    <div class="aOcultar">
                        <label class="precio">Precio: <%= p.getTotal() %></label>
                        <%--Fecha de inicio del Promocion--%>
                        <div id="fechaIni">
                            <label class="labelIni" >Inicio:</label>
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
                            <label class="labelFin" >Fin:</label>
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
                        <form <%--action="agregarSCarrito--%> onsubmit="return agregarPACarrito(this.parentElement.parentElement)" name="formAgregar">
                            <input type="hidden" id ="nombrePromocion" value="<%= p.getNombre() %>" name="nombrePromocion">
                            <input type="hidden" id ="nombreProveedor" value="<%= p.getProveedor() %>" name="nombreProveedor">
                            <label>Cantidad:</label><input type="text" name="cantidad" id="txtCantidad" class="cantidad" onkeyup="calcularPrecio(this.parentElement.parentElement, <%= p.getTotal() %>)">
                            <input id ="agregar" type="submit" value="agregar al carrito" >
                        </form>
                    </div>
                    <div class="aMostrar" hidden="">
                        <img src="Imag/carrito.png" alt="imagen de carrito"> En carrito
                    </div>
                    <%}%>
                </div>
            </center>
            </div>
            <div class="fila">
                <div class="doce columnas" id="colTres">
                    <center>
                        <h2>Servicios incluidos:</h2>
                    </center>
                    <center>
                        <table>
                            <thead>
                                <tr>
                                  <th>Nombre</th>
                                  <th>Origen</th>
                                  <th>Destino</th>
                                  <th>Precio</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    if(request.getAttribute("listaServicios") != null){
                                        ArrayList lista = (ArrayList)request.getAttribute("listaServicios");
                                        Iterator<DtServicio> it = lista.iterator();
                                            
                                        while(it.hasNext()){
                                            DtServicio s = it.next();
                                %>
                                    <tr>
                                        <td id="TdNombre">
                                            <%
                                            if(!s.getImagenes().isEmpty()){
                                                BufferedImage originalImage=(BufferedImage) s.getImagenes().get(0).getImage();
                                                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                                                ImageIO.write(originalImage, "jpg", baos );
                                                byte[] arrayBytes = baos.toByteArray();
                                                String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(arrayBytes);
                                            %>
                                                <img class="imgMini" src="data:image/jpg;base64, <%=b64%>">
                                            <%}%>
                                            <% String nomServ = s.getNombre().replace(" ", "+"); %>
                                            <a href="<%= request.getContextPath()%>/InfoServicio?nombreServicio=<%= nomServ %>&nombreProveedor=<%= s.getProveedor() %>">
                                                <%= s.getNombre() %>
                                            </a>
                                        </td>
                                        <td><%= s.getOrigen() %></td>
                                        <%if(s.getDestino() != null){%>
                                            <td><%= s.getDestino() %></td>
                                        <%}else{%>
                                            <td>-------------</td>
                                        <%}%>
                                        <td><%= s.getPrecio() %></td>
                                    </tr>
                                <%}}%>
                            </tbody>
                        </table>
                    </center>
                </div>
            </div>
        </div>
        <jsp:include page="Pie.jsp" />
    </body>
</html>

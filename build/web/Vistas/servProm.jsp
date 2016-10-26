<%@page import="webservices.DataPromocion"%>
<%@page import="webservices.DataPromociones"%>
<%@page import="webservices.DataServicio"%>
<%@page import="webservices.DataServicios"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="Logica.DtCategoria"%>
<%@page import="Logica.Factory"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.awt.image.DataBufferByte"%>
<%@page import="java.awt.image.WritableRaster"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="Logica.DtPromocion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.DtServicio"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado de Busqueda</title>
        <link type="image/x-icon" rel="shortcut icon"  href="/Tarea2/Imag/IconoH4T.ico">
        <link rel="stylesheet" type="text/css" href="CSS/Cabecera.css"/>
        <link rel ="stylesheet" href="CSS/ServPromCss.css">
        <!link rel ="stylesheet" href="../CSS/Cabecera.css">
        <script src="JS/jQuery.js"></script>
        <script src="JS/ServProm.js"></script>
        <jsp:include page="Cabecera.jsp" />
    </head>
    
    <body>
        <!jsp:include page="Cabecera.jsp" />
        <%--<ul class="clase">
            <li><a href="#" >Uno</a></li> 
            <li><a href="#" >Dos</a></li>
            <li><a href="#" >Tres</a></li>
        </ul>--%>
        <br>
        <div class="principal">
            <div class="fila">
                <div class="tres columnas" id="colUno">
                    <%
                        List<DtCategoria> listaCategorias = Factory.getInstance().crearContCatCiudad().listarCategorias();
                        Iterator itCat = listaCategorias.iterator();
                        ArrayList<String> list = new ArrayList<>();
                        while(itCat.hasNext()){ 
                            DtCategoria aux = (DtCategoria)itCat.next();
                            list.add(aux.getNombre());
                        }
                        Collections.sort(list);
                        itCat = list.iterator();
                    %>
                    <ul id="menu_arbol">
                        <li id="Raiz" title="Todos"><a onclick="busqueda('');" href="#">Todos</a></li>
                        <%
                        while(itCat.hasNext()){
                            String aux = (String)itCat.next();
                        %>
                        <li title="<%= aux %>"><a href="#" onclick="busqueda('<%= aux %>');"><%= aux %></a></li>
                        <%}%>
                   </ul>
                </div>
                <div class="nueve columnas" id="colDos">
                    
                    <div>
                        <table id="tabla">
                            <thead>
                                <tr>
                                  <th style="text-decoration: underline"><b>Tipo</b></th>
                                  <th style="text-decoration: underline"><b>Nombre</b></th>
                                  <th style="text-decoration: underline"><b>Proveedor</b></th>
                                  <%if(session.getAttribute("nickUsuario") != null){%>
                                  <th><b>Agregar a carrito</b></th>
                                  <%}%>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                DataServicios listaServicios = (DataServicios)request.getAttribute("listaServicios");
                                Iterator<DataServicio> it = listaServicios.getServicios().iterator();

                                while(it.hasNext()){
                                    DataServicio s = it.next();
                                %>
                                <tr>
                                    <td class="TdTipo">Servicio</td>
                                    <td class="TdNombreS">
                                        <%
                                            if(!s.getImagenes().isEmpty()){
                                            String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(s.getImagenes().get(0));
                                        %>
                                            <img class="imgMini" src="data:image/jpg;base64, <%=b64%>">
                                        <%}else{%>
                                        <img class="imgMini" src="/Tarea2/Imag/SinImagen.jpg">
                                        <%}%>
                                        <% String nomServ = s.getNombre().replace(" ", "+"); %>
                                        <a href="<%= request.getContextPath()%>/InfoServicio?nombreServicio=<%= nomServ %>&nombreProveedor=<%= s.getProveedor() %>">
                                            <%= s.getNombre() %>
                                        </a>
                                    </td>
                                    <td class="TdProveedor"><%= s.getProveedor() %></td>
                                    <%if(session.getAttribute("nickUsuario") != null){  %>
                                        <td class="TdAgregarACarrito">
                                            <div class="aOcultar">
                                                <label class="precio">Precio: $<%= Math.round(s.getPrecio()) %></label>
                                                <%--Fecha de inicio del servicio--%>
                                                <div id="fechaIni">
                                                    <label class="labelIni" >Inicio:</label>
                                                    <input id="diaIni" name="diaIni" maxlength="2" placeholder="dd" type="text" required/>
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
                                                <form <%--action="agregarSCarrito--%> onsubmit="return agregarSACarrito(this.parentElement.parentElement)" name="formAgregar">
                                                    <input type="hidden" id ="nombreServicio" value="<%= s.getNombre() %>" name="nombreServicio">
                                                    <input type="hidden" id ="nombreProveedor" value="<%= s.getProveedor() %>" name="nombreProveedor">
                                                    <label>Cantidad:</label><input type="text" name="cantidad" id="txtCantidad" class="cantidad" onkeyup="calcularPrecio(this.parentElement.parentElement, <%= Math.round(s.getPrecio()) %>)">
                                                    <input id ="agregar" type="submit" value="agregar al carrito" >
                                                </form>
                                            </div>
                                            <div class="aMostrar" hidden="">
                                                <img src="Imag/carrito.png" alt="imagen de carrito"> En carrito
                                            </div>
                                        </td>
                                    <%}%>
                                </tr>
                                <%}%>

                                <%
                                    DataPromociones listaPromociones = (DataPromociones)request.getAttribute("listaPromociones");
                                    Iterator<DataPromocion> iterador = listaPromociones.getPromociones().iterator();

                                    while(iterador.hasNext()){
                                        DataPromocion p = iterador.next();
                                %>
                                <tr>
                                    <td class="TdTipo">Promocion</td>
                                    <td>
                                        <% String nomProm = p.getNombre().replace(" ", "+"); %>
                                        <a href="<%= request.getContextPath()%>/InfoPromocion?nombrePromocion=<%= nomProm %>&nombreProveedor=<%= p.getProveedor() %>">
                                            <%= p.getNombre() %>
                                        </a>
                                    </td>
                                    <td class="TdProveedor"><%= p.getProveedor() %></td>
                                    <%if(session.getAttribute("nickUsuario") != null){%>
                                        <td>
                                            <div class="aOcultar">
                                                <label class="precio">Precio: $<%= Math.round(p.getTotal()) %></label>
                                                <%--Fecha de inicio del Promocion--%>
                                                <div id="fechaIni">
                                                    <label class="labelIni" >Inicio:</label>
                                                    <input id="diaIni" name="diaIni" maxlength="2" placeholder="dd" type="text" required/>
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
                                                    <input id="anioIni" name="anioIni" maxlength="4" placeholder="aaaa" type="text" required/>
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
                                                    <input id="anioFin" name="anioFin" maxlength="4" placeholder="aaaa" type="text" required/>
                                                </div>
                                                <form <%--action="agregarSCarrito--%> onsubmit="return agregarPACarrito(this.parentElement.parentElement)" name="formAgregar" >
                                                    <input type="hidden" id ="nombrePromocion" value="<%= p.getNombre() %>" name="nombrePromocion">
                                                    <input type="hidden" id ="nombreProveedor" value="<%= p.getProveedor() %>" name="nombreProveedor">
                                                    <label>Cantidad:</label><input type="text" name="cantidad" id="txtCantidad" class="cantidad" onkeyup="calcularPrecio(this.parentElement.parentElement, <%= Math.round(p.getTotal()) %>)" required>
                                                    <input id ="agregar" type="submit" value="agregar al carrito" >
                                                </form>
                                            </div>
                                            <div class="aMostrar" hidden="">
                                                <img src="Imag/carrito.png" alt="imagen de carrito"> En carrito
                                            </div>
                                        </td>
                                    <%}%>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="Pie.jsp" />
    </body>
</html>

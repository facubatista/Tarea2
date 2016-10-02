<%@page import="Logica.DtPromocion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.DtServicio"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="CSS/Cabecera.css"/>
        <link rel ="stylesheet" href="CSS/ServPromCss.css">
        <!link rel ="stylesheet" href="../CSS/Cabecera.css">
        <script src="JS/javaScript.js"></script>
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
                <div class="doce columnas" id="colUno">
                    
                        <div>
                            <table>
                                <thead>
                                    <tr>
                                      <th style="text-decoration: underline"><b>Tipo</b></th>
                                      <th style="text-decoration: underline"><b>Nombre</b></th>
                                      <th style="text-decoration: underline"><b>Proveedor</b></th>
                                      <%if(session.getAttribute("nickUsuario") != null){%>
                                      <th class="izquierda" ><b>Cantidad</b></th>
                                      <%}%>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                    ArrayList<DtServicio> listaServicios = (ArrayList)request.getAttribute("listaServicios");
                                    Iterator<DtServicio> it = listaServicios.iterator();
                                    
                                    while(it.hasNext()){
                                        DtServicio s = it.next();
                                    %>
                                    <tr>
                                        <td>Servicio</td>
                                        <td>
                                            <a href="<%= request.getContextPath()%>/InfoServicio?nombreServicio=<%= s.getNombre() %>&nombreProveedor=<%= s.getProveedor() %>">
                                                <%= s.getNombre() %>
                                            </a>
                                        </td>
                                        <td><%= s.getProveedor() %></td>
                                        <%if(session.getAttribute("nickUsuario") != null){%>
                                            <td>
                                                <div class="aOcultar">
                                                    <form <%--action="agregarSCarrito--%> onsubmit="return agregarSACarrito(this.parentElement.parentElement)" name="formAgregar">
                                                        <input type="hidden" id ="nombreServicio" value="<%= s.getNombre() %>" name="nombreServicio">
                                                        <input type="hidden" id ="nombreProveedor" value="<%= s.getProveedor() %>" name="nombreProveedor">
                                                        <input type="text" name="cantidad" id="txtCantidad" class="cantidad" onkeyup="calcularPrecio(this.parentElement.parentElement, <%= s.getPrecio() %>)">
                                                        <input id ="agregar" type="submit" value="agregar al carrito" >
                                                    </form>
                                                        <label class="precio">Precio: <%= s.getPrecio() %></label>
                                                </div>
                                                <div class="aMostrar" hidden="">
                                                    <img src="Imag/carrito.png" alt="imagen de carrito"> En carrito
                                                </div>
                                            </td>
                                        <%}%>
                                    </tr>
                                    <%}%>
                                    
                                    <%
                                        ArrayList<DtPromocion> listaPromociones = (ArrayList)request.getAttribute("listaPromociones");
                                        Iterator<DtPromocion> iterador = listaPromociones.iterator();
                                        
                                        while(iterador.hasNext()){
                                            DtPromocion p = iterador.next();
                                    %>
                                    <tr>
                                        <td>Promocion</td>
                                        <td>
                                            <a href="<%= request.getContextPath()%>/InfoPromocion?nombrePromocion=<%= p.getNombre() %>&nombreProveedor=<%= p.getProveedor() %>">
                                                <%= p.getNombre() %>
                                            </a>
                                        </td>
                                        <td><%= p.getProveedor() %></td>
                                        <%if(session.getAttribute("nickUsuario") != null){%>
                                            <td>
                                                <div class="aOcultar">
                                                    <form <%--action="agregarSCarrito--%> onsubmit="return agregarPACarrito(this.parentElement.parentElement)" name="formAgregar">
                                                        <input type="hidden" id ="nombrePromocion" value="<%= p.getNombre() %>" name="nombrePromocion">
                                                        <input type="hidden" id ="nombreProveedor" value="<%= p.getProveedor() %>" name="nombreProveedor">
                                                        <input type="text" name="cantidad" id="txtCantidad" class="cantidad" onkeyup="calcularPrecio(this.parentElement.parentElement, <%= p.getTotal() %>)">
                                                        <input id ="agregar" type="submit" value="agregar al carrito" ><!-- cambiar esto!-->
                                                    </form>
                                                        <label class="precio">Precio: <%= p.getTotal() %></label>
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
    </body>
</html>

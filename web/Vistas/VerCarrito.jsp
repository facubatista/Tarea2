<%-- 
    Document   : VerCarrito
    Created on : 21/09/2016, 12:03:57 PM
    Author     : Kevin
--%>

<%@page import="Logica.DtServicio"%>
<%@page import="java.util.Iterator"%>
<%@page import="Clases.carrito"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito de compras</title>
        <link rel="stylesheet" type="text/css" href="CSS/Layout.css"/>
        <link rel="stylesheet" type="text/css" href="CSS/Cabecera.css"/>
        <link rel="stylesheet" type="text/css" href="CSS/VerCarrito.css"/>
    </head>
    <body>
        <jsp:include page="Cabecera.jsp" />
        <%
            carrito car = (carrito)session.getAttribute("carrito");
            
        %>
        <div class="principal">
            <div class="fila" id="CarritoyTitulo">
                <img src="Imag/imagenCarrito.png" alt="imagen de carrito">
                <p>Carrito de compras</p>
            </div>
            <div class="fila">
                <table class="doce columnas" style="margin-top: 10px">
                    <thead class="doce columnas">
                            <tr class="doce columnas">
                              <th class="nueve columnas" style="text-align: left;">Servicios</th>
                              <th class="una columnas">Precio</th>
                              <th class="una columnas">Cantidad</th>
                              <th class="una columnas">Total</th>
                            </tr>
                        </thead>
                        <tbody class="doce columnas">
                            <%if(car!=null){
                                Iterator<DtServicio> it = car.getServicios().iterator();
                                
                                while(it.hasNext()){
                                    DtServicio s = it.next();
                            %>
                            <tr class="doce columnas">
                                <td class="nueve columnas">
                                    <img src="Imag/prueba2.jpg" style="width:25%;">
                                    <h3><%= s.getNombre() %></h3>
                                    <p><%= s.getDescripcion() %></p>
                                </td>
                                <td class="una columnas">$<%= s.getPrecio() %></td>
                                <td class="una columnas"><%= s.getPrecio() %></td>
                                <td class="una columnas">$<%= s.getPrecio() %></td>
                            </tr>
                            <%  }
                            }%>
                        </tbody>
                    </table>
                        <table class="doce columnas">
                        <thead class="doce columnas">
                            <tr class="doce columnas">
                              <th class="nueve columnas" style="text-align: left">Promociones</th>
                              <th class="una columnas">Precio</th>
                              <th class="una columnas">Cantidad</th>
                              <th class="una columnas">Total</th>
                            </tr>
                        </thead>
                        <tbody class="doce columnas">
                            <%if(car!=null){
                                Iterator<DtServicio> it = car.getServicios().iterator();
                                
                                while(it.hasNext()){
                                    DtServicio s = it.next();
                            %>
                            <tr class="doce columnas">
                                <td class="nueve columnas">
                                    <img src="Imag/prueba3.jpg" style="width:25%;">
                                    <h3><%= s.getNombre() %></h3>
                                    <p><%= s.getDescripcion() %></p>
                                </td>
                                <td class="una columnas">$<%= s.getPrecio() %></td>
                                <td class="una columnas"><%= s.getPrecio() %></td>
                                <td class="una columnas">$<%= s.getPrecio() %></td>
                            </tr>
                            <%  }
                            }%>
                        </tbody>
                    </table>    
            </div>
        </div>
    </body>
</html>

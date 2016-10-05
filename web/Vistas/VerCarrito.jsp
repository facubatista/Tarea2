<%@page import="Logica.DtPromocion"%>
<%@page import="Logica.DtServicio"%>
<%@page import="java.util.Iterator"%>
<%@page import="Clases.carrito"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito de compras</title>
        <link rel="stylesheet" type="text/css" href="/Tarea2/CSS/Layout.css"/>
        <link rel="stylesheet" type="text/css" href="/Tarea2/CSS/Cabecera.css"/>
        <link rel="stylesheet" type="text/css" href="/Tarea2/CSS/VerCarrito.css"/>
        <script src="/Tarea2/JS/javaScript.js"></script>
    </head>
    <body>
        <jsp:include page="Cabecera.jsp" />
        <%
            carrito car = (carrito)session.getAttribute("carrito");
            
        %>
        <div class="principal">
            <div class="fila" id="CarritoyTitulo">
                <img src="/Tarea2/Imag/imagenCarrito.png" alt="imagen de carrito">
                <p>Carrito de compras</p>
            </div>
            <%if(car!=null){ %>
            <div class="fila">
                <%
                Iterator<DtServicio> it = car.getServicios().iterator();

                //Si no hay servicios ni promociones no se muestran el total y el confirmar reserva
                boolean hayServicios=false;
                if(it.hasNext()){
                    hayServicios=true;
                }                                

                if(it.hasNext()){
                 %>
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
                        <%while(it.hasNext()){
                            DtServicio s = it.next();
                        %>
                        <tr class="doce columnas">
                            <td class="nueve columnas">
                                <img src="/Tarea2/Imag/prueba2.jpg" style="width:25%;">
                                <a href="<%= request.getContextPath()%>/InfoServicio?nombreServicio=<%= s.getNombre() %>&nombreProveedor=<%= s.getProveedor() %>"><%= s.getNombre() %></a>
                                <p><%= s.getDescripcion() %></p>
                            </td>
                            <td class="una columnas">$<%= s.getPrecio() %></td>
                            <td class="una columnas"><%= s.getPrecio() %></td>
                            <td class="una columnas">$<%= s.getPrecio() %></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                    <%}%>
                <%
                        Iterator<DtPromocion> itP = car.getPromociones().iterator();

                        //Si no hay servicios ni promociones no se muestran el total y el confirmar reserva
                        boolean hayPromos=false;
                        if(itP.hasNext()){
                            hayPromos=true;
                        }

                        if(itP.hasNext()){
                    %>
                <table class="doce columnas">
                    <thead class="doce columnas">
                        <tr class="doce columnas">
                          <th class="nueve columnas" style="text-align: left">Promociones</th>
                          <th class="una columnas">Proveedor</th>
                          <th class="una columnas">Descuento</th>
                          <th class="una columnas">Total</th>
                        </tr>
                    </thead>
                    <tbody class="doce columnas">
                        <%    while(itP.hasNext()){
                            DtPromocion p = itP.next();
                    %>
                        <tr class="doce columnas">
                            <td class="nueve columnas">
                                <img src="/Tarea2/Imag/prueba3.jpg" style="width:25%;">
                                <a href="<%= request.getContextPath()%>/InfoPromocion?nombrePromocion=<%= p.getNombre() %>&nombreProveedor=<%= p.getProveedor() %>"><%= p.getNombre() %></a>
                                <p>laskaskdmklasmdlskdmlkasdmlaksmdlaksmdlkasmdlam</p>
                            </td>
                            <td class="una columnas"><%= p.getProveedor() %></td>
                            <td class="una columnas"><%= p.getPorcentaje() %></td>
                            <td class="una columnas">$<%= p.getTotal() %></td>
                        </tr>
                            <%  }%>
                    </tbody>
                </table> 
                            <%}%>
            </div>
             
                <%if(hayPromos || hayServicios){%>
            <table class="doce columnas">
                <thead class="doce columnas">
                    <tr class="doce columnas">
                      <th class="doce columnas" style="text-align: left;">Total de reserva: $<%= car.getTotal() %></th>
                    </tr>
                </thead>
            </table> 
            <div class="fila">
                <a class="botones" href="http://i.imgur.com/TUcQR.jpg">Confirmar Reserva</a>
            </div>
                <%}
            }%>
        </div>
    </body>
</html>

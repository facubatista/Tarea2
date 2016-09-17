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
    </head>
    <body>
        <% DtServicio s = (DtServicio)request.getAttribute("servicio"); %>
        <h2><%= s.getNombre() %> </h2>
        <h2><%= s.getProveedor() %> </h2>
        
        <%
            carrito car = (carrito)session.getAttribute("carrito");
            Iterator<DtServicio> iterador = car.getServicios().iterator();
            Iterator<DtPromocion> it = car.getPromociones().iterator();
            while(iterador.hasNext()){
        %>
        <p><%= iterador.next().getNombre() %></p>
        <%  }
            while(iterador.hasNext()){
        %>
        <p><%= iterador.next().getNombre() %></p>
        <%}%>
    </body>
</html>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.DtReserva"%>
<%@page import="Logica.DtRS"%>
<%@page import="Logica.DtRP"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Reserva</title>
        <link rel="stylesheet" type="text/css" href="./CSS/Layout.css"/>
        <link rel="stylesheet" type="text/css" href="./CSS/Cabecera.css"/>
        <link rel="stylesheet" type="text/css" href="./CSS/Pie.css"/>
        <link rel="stylesheet" type="text/css" href="./CSS/reservas.css"/>
        <script src="../JS/jQuery.js"></script>
        <script src="../JS/javaScript.js"></script>
    </head>
    <body>
        <jsp:include page="Cabecera.jsp" />
        <% DtReserva res = (DtReserva) request.getAttribute("Reserva");
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        %>
        <form class="principal">
        <div class="reserva">
            <label class="lblRes">Reserva</label>
            <label class="nro">Número de reserva:</label>
            <label class="nro1"><%= res.getNumero() %></label>
            <label class="fech">Fecha de creación:</label>
            <label class="fech1"><%= df.format(res.getFechaCreacion()) %> </label>
            <label class="est">Estado:</label>
            <label class="est1"><%= res.getEstado() %></label>
            <label class="tot">Total: <%= res.getPrecioTotal() %></label>
        </div>
        <br class="espacio"/>
        <% ArrayList<DtRP> rp = res.getPromociones();
            Iterator iterador = rp.iterator();
            while(iterador.hasNext()){
                DtRP dtp = (DtRP)iterador.next();
        %>
        <div class="prom">
            <label class="lbln">Nombre promocion:</label>
            <a class="nomP" href="./InfoPromocion?nombrePromocion=<%= dtp.getPromocion() %>&nombreProveedor=<%=dtp.getProveedor() %>"><%= dtp.getPromocion() %></a>
            <label class="lblf">Fecha inicio:</label>
            <label class="fechIniP"><%= df.format(dtp.getFechaIni()) %> </label>
            <label class="lblf">Fecha fin:</label>
            <label class="fechFinP"><%= df.format(dtp.getFechaFin()) %> </label>
            <label class="cantP">Cantidad: <%= dtp.getCantidad() %> </label>
        </div>
        <br class="espacio"/>
        <%}
            ArrayList<DtRS> rs = res.getServicios();
            iterador = rs.iterator();
            while(iterador.hasNext()){
                DtRS dts = (DtRS)iterador.next();
        %>
        <div class="serv" >
            <label class="lbln">Nombre Servicio:</label>
            <a class="nomS" href="./InfoServicio?nombreServicio=<%=dts.getServicio()%>&nombreProveedor=<%=dts.getProveedor() %>" ><%= dts.getServicio() %></a>
            <label class="lblf">Fecha inicio:</label>
            <label class="fechIniS"><%= df.format(dts.getFechaIni()) %></label>
            <label class="lblf">Fecha fin:</label>
            <label class="fechFinS"><%= df.format(dts.getFechaFin()) %></label>
            <label class="cantS">Cantidad: <%= dts.getCantidad() %></label>
        </div>
        <br class="espacio"/>
        <%} %>
        </form>
        <jsp:include page="Pie.jsp" />
    </body>
</html>

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
        <link type="image/x-icon" rel="shortcut icon"  href="/Tarea2/Imag/IconoH4T.ico">
        <link rel="stylesheet" type="text/css" href="./CSS/Layout.css"/>
        <link rel="stylesheet" type="text/css" href="./CSS/Cabecera.css"/>
        <link rel="stylesheet" type="text/css" href="./CSS/Pie.css"/>
        <link rel="stylesheet" type="text/css" href="./CSS/reservas.css"/>
        <script src="/Tarea2/JS/jQuery.js"></script>
        <script src="/Tarea2/JS/javaScript.js"></script>
    </head>
    <body>
        <jsp:include page="Cabecera.jsp" />
        <% DtReserva res = (DtReserva) request.getAttribute("Reserva");
            SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
            
            ArrayList<DtRP> rp = res.getPromociones();
            Iterator iteradorPromo = rp.iterator();
            
            ArrayList<DtRS> rs = res.getServicios();
            Iterator iteradorServ = rs.iterator();
        %>
        <form class="principal">
            <div id="divPestanias" class="fila">
                <ul>
                    <li><a id="mostrarInfoRes" class="selec" href="#" onclick="cambiarPestaniaEnVerRes(this)">Reserva</a></li>
                    <%if(iteradorPromo.hasNext()){%>
                    <li><a id="mostrarPromosRes" class="NOselec" href="#" onclick="cambiarPestaniaEnVerRes(this)">Promociones</a></li>
                    <%}if(iteradorServ.hasNext()){%>
                    <li><a id="mostrarServRes" class="NOselec" href="#" onclick="cambiarPestaniaEnVerRes(this)">Servicios</a></li>
                    <%}%>
                </ul>
            </div>
            <div id="InfoRes" class="fila">
                <div class="fila">
                    <h4>Número: <%= res.getNumero() %></h4>
                    <h4>Fecha de creación: <%= dateformat.format(res.getFechaCreacion()) %></h4>
                    <h4>Estado: <%= res.getEstado() %></h4>
                    <h4>Total: $<%= res.getPrecioTotal() %></h4>
                </div>
            </div>
            <div id="PromosRes" hidden="true" style="overflow: hidden">
                <table class="doce columnas">
                    <thead class="doce columnas">
                        <tr class="doce columnas">
                            <th class="tres columnas" style="text-align: left">Promociones</th>
                            <th class="dos columnas">Proveedor</th>
                            <th class="tres columnas">Fecha de inicio</th>
                            <th class="tres columnas">Fecha de fin</th>
                            <th class="una columnas">Cantidad</th>
                        </tr>
                    </thead>
                    <tbody class="doce columnas">
                    <%while(iteradorPromo.hasNext()){
                        DtRP dtp = (DtRP)iteradorPromo.next();
                    %>
                        <tr class="doce columnas trPromo">
                            <td class="tres columnas">
                                <a id="nomPromo" href="<%= request.getContextPath()%>/InfoPromocion?nombrePromocion=<%= dtp.getPromocion() %>&nombreProveedor=<%= dtp.getProveedor()%>"><%= dtp.getPromocion() %></a>
                            </td>
                            <td class="dos columnas"><%= dtp.getProveedor() %></td>
                            <td class="tres columnas"><%= dateformat.format(dtp.getFechaIni()) %></td>
                            <td class="tres columnas"><%= dateformat.format(dtp.getFechaFin())  %></td>
                            <td class="una columnas"><%= dtp.getCantidad() %></td>
                        </tr>
                    <%}%>
                    </tbody>
                </table>
            </div> 
            <div id="ServRes" hidden="true" style="overflow: hidden">
                <table class="doce columnas">
                    <thead class="doce columnas">
                        <tr class="doce columnas">
                            <th class="tres columnas" style="text-align: left">Servicios</th>
                            <th class="dos columnas">Proveedor</th>
                            <th class="tres columnas">Fecha de inicio</th>
                            <th class="tres columnas">Fecha de fin</th>
                            <th class="una columnas">Cantidad</th>
                        </tr>
                    </thead>
                    <tbody class="doce columnas">
                    <%while(iteradorServ.hasNext()){
                        DtRS dts = (DtRS)iteradorServ.next();
                    %>
                        <tr class="doce columnas trPromo">
                            <td class="tres columnas">
                                <a id="nomPromo" href="<%= request.getContextPath()%>/InfoServicio?nombreServicio=<%= dts.getServicio() %>&nombreProveedor=<%= dts.getProveedor() %>"><%= dts.getServicio() %></a>
                            </td>
                            <td class="dos columnas"><%= dts.getProveedor() %></td>
                            <td class="tres columnas"><%= dateformat.format(dts.getFechaIni()) %></td>
                            <td class="tres columnas"><%= dateformat.format(dts.getFechaFin())  %></td>
                            <td class="una columnas"><%= dts.getCantidad() %></td>
                        </tr>
                    <%}%>
                    </tbody>
                </table>
            </div>
        </form>      
        <jsp:include page="Pie.jsp" />
    </body>
</html>

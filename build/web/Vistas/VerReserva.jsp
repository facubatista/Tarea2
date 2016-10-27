<%@page import="webservices.DtRP"%>
<%@page import="webservices.DtRS"%>
<%@page import="webservices.DataRsRp"%>
<%@page import="webservices.DataReserva"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.ArrayList"%>
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
        <%  DataRsRp RsRp = (DataRsRp) request.getAttribute("RSRP");
            DataReserva res = (DataReserva)request.getAttribute("Reserva");
            
            SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
            
            //ArrayList<DataRP> rp = (ArrayList)res.getPromociones();
            Iterator iteradorPromo = RsRp.getPromociones().iterator();
            
            //ArrayList<DataRS> rs = res.getServicios();
            Iterator iteradorServ = RsRp.getServicios().iterator();
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
                    <h4>Fecha de creación: <%= res.getFechaCreacion() %></h4>
                    <h4>Estado: <%= res.getEstado() %></h4>
                    <h4>Total: $<%= res.getPrecioTotal() %></h4>
                </div>
            </div>
            <div id="PromosRes" hidden style="overflow: hidden">
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
                            <td class="tres columnas"><%= dateformat.format(dtp.getFechaIni().toGregorianCalendar().getTime()) %></td>
                            <td class="tres columnas"><%= dateformat.format(dtp.getFechaFin().toGregorianCalendar().getTime()) %></td>
                            <td class="una columnas"><%= dtp.getCantidad() %></td>
                        </tr>
                    <%}%>
                    </tbody>
                </table>
            </div> 
            <div id="ServRes" hidden style="overflow: hidden">
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
                            <td class="tres columnas"><%= dateformat.format(dts.getFechaIni().toGregorianCalendar().getTime()) %></td>
                            <td class="tres columnas"><%= dateformat.format(dts.getFechaFin().toGregorianCalendar().getTime())  %></td>
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

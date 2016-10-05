<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.DtServicio"%>
<%@page import="Logica.DtPromocion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>InfoPromocion</title>
        <link rel="stylesheet" type="text/css" href="CSS/Cabecera.css"/>
        <link rel ="stylesheet" href="CSS/infoPromCss.css">
        <link rel ="stylesheet" href="CSS/Layout.css">
        
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
                <div class="doce columnas" id="colDos">
                    <h2>Servicios:</h2>
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
                                        <td><%= s.getNombre() %></td>
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
    </body>
</html>

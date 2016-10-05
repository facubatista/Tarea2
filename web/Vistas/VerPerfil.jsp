<%-- 
    Document   : VerPerfil
    Created on : 03/10/2016, 02:39:24 PM
    Author     : Kevin
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logica.DtReserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Logica.DtCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Perfil</title>
        <link rel="stylesheet" type="text/css" href="/Tarea2/CSS/Layout.css"/>
        <link rel="stylesheet" type="text/css" href="/Tarea2/CSS/Cabecera.css"/>
        <link rel="stylesheet" type="text/css" href="/Tarea2/CSS/VerPerfil.css"/>
        <script src="/Tarea2/JS/javaScript.js"></script>
    </head>
    <body>
        <%
           DtCliente cliente = (DtCliente) session.getAttribute("DtCliente");
           
           SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
    
        %>
        <jsp:include page="Cabecera.jsp" />
        <div class="principal">
            
            <div class="fila" id="FotoyNombre">
                <%if(cliente.getImagen()!=null){%>
                <img src="/Tarea2/Imag/prueba3.jpg" alt="foto del usuario"><!--Cambiar por imagen del usuario-->
                <%}else{%>
                <img src="/Tarea2/Imag/IconoUsuario.png" alt="imagen alternativa del usuario" class="Alternativa"> 
                <%}%>                
                <p><%= cliente.getNombre()+" "+cliente.getApellido()%></p>
            </div>
            
            <div id="divPestanias" class="fila">
                <ul>
                    <li><a id="mostrarInfo" class="selec" href="#" onclick="cambiarPestania(this)">Información</a></li>
                    <li><a id="mostrarRes" class="NOselec" href="#" onclick="cambiarPestania(this)">Reservas</a></li>
                </ul>
            </div>
            
            <div id="infoCliente" class="fila">
                <div class="fila">
                    <%if(cliente.getImagen()!=null){%>
                    <img src="/Tarea2/Imag/prueba3.jpg" style="width:25%;">
                    <%}else{%>
                    <img src="/Tarea2/Imag/IconoUsuario.png" alt="imagen alternativa del usuario" class="Alternativa"> 
                    <%}%> 
                    <h4>Nickname: <%= cliente.getNickname() %><h4>
                    <h4>Nombre: <%= cliente.getNombre() %><h4>
                    <h4>Apellido: <%= cliente.getApellido() %><h4>
                    <h4>e-mail: <%= cliente.getMail() %><h4>
                    <h4>Fecha de Nacimiento: <%= dateformat.format(cliente.getFechaNac()) %><h4>       
                </div>
            </div>
            
            <div id="resCliente" hidden="true" style="overflow: hidden">
                <table class="doce columnas">
                    <thead class="doce columnas">
                            <tr class="doce columnas">
                              <th class="tres columnas" style="text-align: left;">Número</th>
                              <th class="tres columnas">Estado</th>
                              <th class="tres columnas">Fecha de Creación</th>
                              <th class="tres columnas">Total</th>
                            </tr>
                        </thead>
                        <tbody class="doce columnas">
                            <%
                                List<DtReserva> listaReservas = (List)session.getAttribute("ReservasCli");
                                Iterator<DtReserva> it = listaReservas.iterator();

                                while(it.hasNext()){
                                    DtReserva r = it.next();
                            %>
                            <tr class="doce columnas">
                                <td class="tres columnas"><a action=""><%= r.getNumero() %></a></td>
                                <td class="tres columnas"><%= r.getEstado() %></td>
                                <td class="tres columnas"><%= dateformat.format(r.getFechaCreacion()) %></td>
                                <td class="tres columnas">$<%= r.getPrecioTotal() %></td>
                            </tr>
                            <%  }%>
                        </tbody>
                    </table>    
            </div>
            
        </div>
    </body>
</html>

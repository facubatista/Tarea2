<%-- 
    Document   : VerPerfil
    Created on : 03/10/2016, 02:39:24 PM
    Author     : Kevin
--%>
<%@page import="webservices.DataReserva"%>
<%@page import="webservices.DataReservas"%>
<%@page import="webservices.DataCliente"%>
<%@page import="java.util.Base64"%>
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
        <title>Mi Perfil</title>
        <link type="image/x-icon" rel="shortcut icon"  href="/Tarea2/Imag/IconoH4T.ico">
        <link rel="stylesheet" type="text/css" href="/Tarea2/CSS/Layout.css"/>
        <link rel="stylesheet" type="text/css" href="/Tarea2/CSS/Cabecera.css"/>
        <link rel="stylesheet" type="text/css" href="/Tarea2/CSS/VerPerfil.css"/>
        <script src="/Tarea2/JS/javaScript.js"></script>
    </head>
    <body>
        <%
           DataCliente cliente = (DataCliente) session.getAttribute("DataCliente");
           
           SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
           dateformat.setTimeZone(cliente.getFechaNac().toGregorianCalendar().getTimeZone());
           
           String imagenUsuarioB64=null;
            if(cliente != null){
                if(cliente.getImagen() != null){
                    //byte[] imagenUsuario = (byte[])session.getAttribute("imagenUsuario");
                    //imagenUsuarioB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imagenUsuario);
                    imagenUsuarioB64 = Base64.getEncoder().encodeToString(cliente.getImagen());
                }
            }
        %>
        <jsp:include page="Cabecera.jsp" />
        <div class="principal">
            
            <div class="fila" id="FotoyNombre">
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
                    <%if(imagenUsuarioB64!=null){%>
                    <img src="data:image/jpg;base64, <%=imagenUsuarioB64%>" alt="foto de usuario">
                    <%}else{%>
                    <img src="/Tarea2/Imag/IconoUsuario.png" alt="imagen alternativa del usuario" class="Alternativa"> 
                    <%}%> 
                    <h4>Nickname: <%= cliente.getNickname() %></h4>
                    <h4>Nombre: <%= cliente.getNombre() %></h4>
                    <h4>Apellido: <%= cliente.getApellido() %></h4>
                    <h4>e-mail: <%= cliente.getMail() %></h4>
                    
                    <h4>Fecha de Nacimiento: <%= dateformat.format(cliente.getFechaNac().toGregorianCalendar().getTime()) %></h4>       
                </div>
            </div>
            
            <div id="resCliente" hidden style="overflow: hidden">
                <table class="doce columnas">
                    <thead class="doce columnas">
                            <tr class="doce columnas">
                              <th class="dos columnas" style="text-align: left;">Número</th>
                              <th class="tres columnas">Estado</th>
                              <th class="tres columnas">Fecha de Creación</th>
                              <th class="dos columnas">Total</th>
                              <th class="dos columnas"></th>
                            </tr>
                        </thead>
                        <tbody class="doce columnas">
                            <%
                                DataReservas listaReservas = (DataReservas) request.getAttribute("ReservasCli");
                                Iterator<DataReserva> it = listaReservas.getReservas().iterator();
                                
                                
                                while(it.hasNext()){
                                    DataReserva r = it.next();
                            %>
                            <tr class="doce columnas">
                                <td class="dos columnas"><a href="./ServUsuarios?VerReserva=true&numero=<%=r.getNumero() %>"><%= r.getNumero() %></a></td>
                                <td class="tres columnas estadoRes"><%= r.getEstado() %></td>
                                <td class="tres columnas"><%= dateformat.format(r.getFechaCreacion().toGregorianCalendar().getTime()) %></td>
                                <td class="dos columnas">$<%= r.getPrecioTotal() %></td>
                                <%if(r.getEstado().equals("Registrada")){%>
                                <td class="dos columnas">
                                    <button class="botones" onclick="return cambiarEstadoRes(<%= r.getNumero()%>,this.parentElement.parentElement)">Cancelar</button>
                                </td>
                                <%}else{%>
                                <td class="dos columnas"></td>
                                <%}%>
                            </tr>
                            <%  }%>
                        </tbody>
                    </table>    
            </div>
            
        </div>
    </body>
</html>

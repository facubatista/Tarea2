<%-- 
    Document   : VerPerfil
    Created on : 03/10/2016, 02:39:24 PM
    Author     : Kevin
--%>

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
    </head>
    <body>
        <%
           DtCliente cliente = (DtCliente) session.getAttribute("DtCliente");
           
           SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
    
        %>
        <jsp:include page="Cabecera.jsp" />
        <div class="principal">
            <div class="fila">
                <img src="/Tarea2/Imag/prueba3.jpg" style="width:25%;">
                <h4>Nickname: <%= cliente.getNickname() %><h4>
                <h4>Nombre: <%= cliente.getNombre() %><h4>
                <h4>Apellido: <%= cliente.getApellido() %><h4>
                <h4>e-mail: <%= cliente.getMail() %><h4>
                <h4>Fecha de Nacimiento: <%= dateformat.format(cliente.getFechaNac()) %><h4>       
            </div>
        </div>
    </body>
</html>

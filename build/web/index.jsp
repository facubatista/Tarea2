<%@page import="Logica.DtCategoria"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Factory"%>
<%@page import="Logica.IcontCatCiudad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Help4Traveling</title>
        <link rel="stylesheet" href="CSS/Layout.css">
        <link rel="stylesheet" href="CSS/Cabecera.css">
        <link type="image/x-icon" rel="shortcut icon"  href="Imag/IconoH4T.ico">
        <jsp:include page="Vistas/Cabecera.jsp" />
    </head>
    <body>
        <%
            IcontCatCiudad contCat = Factory.getInstance().crearContCatCiudad();
            List<DtCategoria> listaCat = contCat.listarCategorias();
        %>
    </body>
</html>

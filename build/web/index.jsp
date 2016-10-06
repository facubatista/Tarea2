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
    </head>
    <body>
        <%
            IcontCatCiudad contCat = Factory.getInstance().crearContCatCiudad();
            List<DtCategoria> listaCat = contCat.listarCategorias();
        %>
        <jsp:include page="Vistas/Cabecera.jsp" />
        <div class="principal">
            <div class="cuatro columnas">
                <ul>
                <%  
                for(int i=0;i<listaCat.size();i++){
                %>    
                <li class="categoria"><%=listaCat.get(i).getNombre()%></li>
                <%}%>
                </ul>
            </div>
            <div class="ocho columnas">
                
            </div>
        </div>
    </body>
</html>

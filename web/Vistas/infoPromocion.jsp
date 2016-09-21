<%@page import="Logica.DtPromocion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% DtPromocion p = (DtPromocion)request.getAttribute("promocion");
        %>
        <h1><%= p.getNombre() %></h1>
    </body>
</html>

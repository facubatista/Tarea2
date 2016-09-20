
<%@page import="Logica.DtPromocion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/Cabecera.css"/>
        <link rel="stylesheet" type="text/css" href="CSS/infoPCss.css"/>
        <jsp:include page="Cabecera.jsp" />
        <script src="JS/javaScript.js"></script>
        <title>InfoServicio</title>
    </head>
    <body>
        <%
            DtPromocion p = (DtPromocion)request.getAttribute("promocion");
        %>
        <div class="principal"> 
            
            <div class="fila">
                <center>
                    <div class="doce columnas" id="colUno">
                        <div id="informacion">
                            <h1><%= p.getNombre() %></h1>
                            <label></label>
                        </div>
                    </div>
                </center>
                <%--<div class="siete columnas" id="colDos">
                </div>--%>
            </div>
            
            
            <div class="fila">
                <center>
                <div class="doce columnas" id="colDos">
                    <h3>Servicios:</h3>
                    <table>
                        <thead>
                                <th><b>Proveedor:</b></th>
                                <th><b>Origen:</b></th>
                                <th><b>Destino:</b></th>
                                <th><b>Precio:</b></th>
                        </thead>
                        <tbody>
                            <tr> <td></td> </tr>
                            <tr> <td></td> </tr>
                            <tr>
                                
                            </tr>
                            <tr> <td></td> </tr>
                        </tbody>
                    </table>
                </div>
            </center>
            </div>
                            
        </div>
    </body>
</html>

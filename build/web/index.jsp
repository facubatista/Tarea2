<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Help4Traveling</title>
        <link rel="stylesheet" href="CSS/Cabecera.css">
        <link type="image/x-icon" rel="shortcut icon"  href="Imag/IconoH4T.ico">
    </head>
    <body>
        <header>
             <%if(session.getAttribute("nomUsuario")==null)
                    session.setAttribute("nomUsuario", "Anonimo");
                %>
             <%if(session.getAttribute("Sesion")==null)
                    session.setAttribute("Sesion", "Iniciar");
                %>
            <div class="cuatro columnas">
                <img src="Imag/H4T.jpg" alt="imagen de header" width="250">
            </div>
            <div class="cuatro columnas">
                <form id="formBuscar" action="ServProm" method="POST">
                    <input id="buscar" name="busqueda" placeholder="Servicio o Promoción" type="text">
                    <input value="Buscar" class="botones" type="submit">
                </form>
            </div>
            <div id="SesionUsuario" class="cuatro columnas">                
                <div class="imagenYcarrito"> 
                    <img id="ImagenUsuario" src="Imag/IconoUsuario.png" alt="imagen de usuario" width="80">
                    
                    <a class="botones" id="BotonCarrito" class="botones AlinearIzq" href="http://www.google.com.uy">Carrito de compras</a>
                </div>
                <div >
                    <h4><%=session.getAttribute("nomUsuario")%></h4>
                <%if(session.getAttribute("nomUsuario").equals("Anonimo")){%>                
                <a id="IniC" class="botones" href="<%= request.getContextPath()%>/ServUsuarios?Sesion=Iniciar">Iniciar Sesión</a><!Vistas/IniciarSesion.jsp>
                <%}else{%>
                <a id="IniC" class="botones" href="<%= request.getContextPath()%>/ServUsuarios?Sesion=Cerrar">Cerrar Sesión</a>
                <%}%>
                </div>     
                                  
            </div> 
            <div class="doce columnas">
                Vuelos > Empresas > Iberia
            </div>
        </header>
        <!--<div>
            <form action="ServProm" method="POST">
                Buscar:<input type="text" name="busqueda">
                <input type="submit" value="Buscar">
            </form>
        </div>-->
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión</title>
        <link rel="stylesheet" type="text/css" href="CSS/Cabecera.css"/>
        <link rel="stylesheet" type="text/css" href="CSS/SesionCss.css"/>
        <script src="JS/javaScript.js"></script>
    </head>
    <body>
        <jsp:include page="Cabecera.jsp" /> 
        <form id="IniciarC" name="IniciarC" action="ServUsuarios" method="post">
            <label for="nom"> Nombre: </label>
            <label id="nickInvalido" hidden="">Nickname inválido</label>
            <input oninput="verificarNick(this,nickInvalido,botonIngresar,botonIngresarDis)" id="nom" name="nomUsuario" placeholder="Escriba su nickname" required="" type="text"> 
            <label for="contra">Contraseña: </label> 
            <input id="contra" name="contra" placeholder="Escriba su contraseña" required="" type="password">
            <input id="botonIngresar" value="Ingresar" type="submit">
            <input id="botonIngresarDis" hidden="" disabled="" value="Ingresar" type="submit">
        </form>
    </body>
</html>

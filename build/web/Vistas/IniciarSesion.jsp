<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión</title>
        <link rel="stylesheet" type="text/css" href="/Tarea2/CSS/Layout.css"/>
        <link rel="stylesheet" type="text/css" href="/Tarea2/CSS/Cabecera.css"/>
        <link rel="stylesheet" type="text/css" href="/Tarea2/CSS/SesionCss.css"/>
        <script src="/Tarea2/JS/sha1.js"></script>
        <script src="/Tarea2/JS/javaScript.js"></script>
    </head>
    <body>
        <jsp:include page="Cabecera.jsp" /> 
        <div id="IniciarC" name="IniciarC">
            <label id="nomUsuario" for="nom"> Usuario: </label>
            <label id="nickInvalido" hidden="">Nickname o email inválido</label>
            <input onblur="verificarUsuario(this)" onfocus="return ocultarMsjPassInc(this.parentElement,this)" id="nomUsr" name="nomUsuario" placeholder="Escriba su nickname o email" required="" type="text"> 
            <label for="contra">Contraseña: </label> 
            <label id="passwordIncorrecta" hidden="">Contraseña incorrecta</label>
            <input onfocus="return ocultarMsjPassInc(this.parentElement,this)" id="contra" name="contra" placeholder="Escriba su contraseña" required="" type="password">
            <input id="botonIngresar" class="botones" hidden="" value="Ingresar" type="submit" onclick="return iniciarSesion(this.parentElement);">
            <input id="botonIngresarDis" class="botones"  disabled="" value="Ingresar" type="submit">
        </div>
        <form id="RegistrarC" name="Registrarse" action="/Tarea2/Vistas/AltaUsuario.jsp" method="get">
            <label for="botonReg" >¿No tienes cuenta?</label> 
            <input id="botonReg" class="botones" value="Registrarse" type="submit">
        </form>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar usuario</title>
        <link type="image/x-icon" rel="shortcut icon"  href="/Tarea2/Imag/IconoH4T.ico">
        <link rel="stylesheet" type="text/css" href="../CSS/Layout.css"/>
        <link rel="stylesheet" type="text/css" href="../CSS/Cabecera.css"/>
        <link rel="stylesheet" type="text/css" href="../CSS/Registrar.css"/>
        <link rel="stylesheet" type="text/css" href="../CSS/Pie.css"/>
        <script src="../JS/jQuery.js"></script>
        <script src="../JS/jquerysession.js"></script>
        <script src="../JS/sha1.js"></script>
	<script src="../JS/user.js"></script>
        <script src="../JS/javaScript.js"></script>
    </head>
    <body>
        <jsp:include page="Cabecera.jsp" /> 
        <form id="RegistrarC" name="RegistrarC" onsubmit="return pruebaServlet()" method="POST">
            <div class="fila">
                <label class="label" >Nickname :</label>
                <label class="labelerr" id="errNick" hidden="">Este nickname esta ocupado</label>
                <input id="nickname" name="nickname" type="text" required/>                
                <label class="label" >Nombre :</label>
                <input id="nombre" name="nombre" type="text" required/>
                <label class="label" >Apellido :</label>
                <input id="apellido" name="apellido" type="text" required/>
                <label class="label" >Email :</label>
                <label class="labelerr" id="errEmail" hidden="">Este correo esta ocupado</label>
                <label class="labelerr" id="errEmailFormato" hidden="">Formato de e-mail incorrecto</label>
                <input id="email" name="email" type="text" required/>
                <label class="label" >Contraseña :</label>
                <input id="contrasenia" name="contraseña" type="password" required/>
                <label class="label" >Verificar contraseña :</label>
                <label class="labelerr" id="errContra" hidden="">Las contraseñas no coinciden</label>
                <input id="recontrasenia" name="recontraseña" type="password" required/>
                <div id="fecha">
                    <label class="labelFecha" >Fecha de nacimiento :</label>
                    <input id="dia" name="dia" maxlength="2" placeholder="dd" type="text" required/>
                    <label class="labelBarra" >/</label>
                    <select id="mes" name="mes">
                        <option name="01">Enero</option>
                        <option name="02">Febrero</option>
                        <option name="03">Marzo</option>
                        <option name="04">Abril</option>
                        <option name="05">Mayo</option>
                        <option name="06">Junio</option>
                        <option name="07">Julio</option>
                        <option name="08">Agosto</option>
                        <option name="09">Setiembre</option>
                        <option name="10">Octubre</option>
                        <option name="11">Noviembre</option>
                        <option name="12">Diciembre</option>
                    </select>
                    <label class="labelBarra" >/</label>
                    <input id="anio" name="anio" maxlength="4" placeholder="aaaa" type="text" required/>
                </div>
                <label class="label" >Imagen(opcional) :</label>
                <input id="imagen" name="imagen" type="file" accept="image/jpeg"/>
            </div>
            <div>
                <input id="botonRegistrar" class="botones" name="botonRegistrar" value="Registrar" type="SUBMIT"/>
                <input id="botonRegistrarDis" class="botones" disabled="disabled" style="display: none;" value="Registrar" type="submit">
            </div>
        </form>
        <jsp:include page="Pie.jsp" /> 
    </body>
</html>
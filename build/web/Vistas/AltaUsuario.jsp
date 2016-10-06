<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar usuario</title>
        <link rel="stylesheet" type="text/css" href="../CSS/Layout.css"/>
        <link rel="stylesheet" type="text/css" href="../CSS/Cabecera.css"/>
        <link rel="stylesheet" type="text/css" href="../CSS/Registrar.css"/>
        <script src="../JS/jQuery.js"></script>
        <script src="../JS/sha1.js"></script>
	<script src="../JS/jreserva.js"></script>
    </head>
    <body>
        <jsp:include page="Cabecera.jsp" /> 
        <form id="RegistrarC" name="RegistrarC" action="" method="POST">
            <label class="Principal" >Registrar Usuario</label>
            <br/>
            <div>
                <label class="label" >Nickname :</label>
                <input id="nickname" name="nickname" type="text" required/>
                <label class="labelerr" id="errNick" hidden="">Este nickname esta ocupado</label>
            </div>
            <div>
                <label class="label" >Nombre :</label>
                <input id="nombre" name="nombre" type="text" required/>
            </div>
            <div>
                <label class="label" >Apellido :</label>
                <input id="apellido" name="apellido" type="text" required/>
            </div>
            <div> 
                <label class="label" >Email :</label>
                <input id="email" name="email" type="text" required/>
                <label class="labelerr" id="errEmail" hidden="">Este correo esta ocupado</label>
            </div>
            <div>
                <label class="label" >Contraseña :</label>
                <input id="contraseña" name="contraseña" type="password" required/>
            </div>
            <div>
                <label class="label" >Verificar contraseña :</label>
                <input id="recontraseña" name="recontraseña" type="password" required/>
                <label class="labelerr" name="errContra" id="errContra" hidden="">Las contraseñas no coinciden</label>
            </div>
            <div>
                <label class="label" >Fecha de nacimiento :</label>
                <input id="dia" name="dia" maxlength="2" placeholder="dd" type="text" required/>
                <label class="label2" >/</label>
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
                <label class="label2" >/</label>
                <input id="anio" name="anio" maxlength="4" placeholder="aaaa" type="text" required/>
            </div>
            <div>
                <label class="label" >Imagen(opcional) :</label>
                <input id="imagen" name="imagen" type="file" accept="image/jpeg"/>
            </div>
            <br/>
            <div> 
                <input id="botonRegistrar" name="botonRegistrar" value="Registrar" type="SUBMIT"/>
            </div>
        </form>
    </body>
</html>

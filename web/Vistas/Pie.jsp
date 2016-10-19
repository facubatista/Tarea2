<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pie</title>
        <link rel ="stylesheet" href="/Tarea2/CSS/Pie.css">
        <script src="JS/javaScript.js"></script>
    </head>
    <body>
        <div class="fila">
            <div id="Pie">
                <button id="botonCargarDatos" onclick="cargarDatos()">Cargar datos de prueba</button>
                <label id="cartelDeEspera" hidden>Aguarde un momento por favor</label>
            </div>
        </div>
    </body>
</html>

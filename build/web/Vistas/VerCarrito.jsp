<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.util.Base64"%>
<%@page import="Clases.DtResProm"%>
<%@page import="Clases.DtResServ"%>
<%@page import="Logica.DtPromocion"%>
<%@page import="Logica.DtServicio"%>
<%@page import="java.util.Iterator"%>
<%@page import="Clases.carrito"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito de compras</title>
        <link rel="stylesheet" type="text/css" href="/Tarea2/CSS/Layout.css"/>
        <link rel="stylesheet" type="text/css" href="/Tarea2/CSS/Cabecera.css"/>
        <link rel="stylesheet" type="text/css" href="/Tarea2/CSS/VerCarrito.css"/>
        <script src="/Tarea2/JS/javaScript.js"></script>
    </head>
    <body>
        <jsp:include page="Cabecera.jsp" />
        <div class="principal">
            <div class="fila" id="CarritoyTitulo">
                <img src="/Tarea2/Imag/imagenCarrito.png" alt="imagen de carrito">
                <p>Carrito de compras</p>
            </div>
            <%if(session.getAttribute("carrito")!=null){ %>
            <div class="fila" id="PromosYServicios">
                <%
                carrito car = (carrito)session.getAttribute("carrito");
                Iterator<DtResServ> it = car.getServicios().iterator();

                //Si no hay servicios ni promociones no se muestran el total y el confirmar reserva
                boolean hayServicios=false;
                
                if(it.hasNext()){
                    hayServicios=true;
                 %>
                <table class="doce columnas">
                    <thead class="doce columnas">
                        <tr class="doce columnas">
                          <th class="ocho columnas" style="text-align: left;">Servicios</th>
                          <th class="una columnas">Precio</th>
                          <th class="una columnas">Cantidad</th>
                          <th class="una columnas">Total</th>
                          <th class="una columnas"></th>
                        </tr>
                    </thead>
                    <tbody class="doce columnas">
                        <%while(it.hasNext()){
                            DtResServ rs = it.next();
                            DtServicio s = rs.getServicio();
                            
                            String imagenServBase64=null;                            
                            if(s.getImagenes().isEmpty()==false){
                                BufferedImage originalImage=(BufferedImage) s.getImagenes().get(0).getImage();
                                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                                ImageIO.write(originalImage, "jpg", baos );
                                byte[] arrayBytes = baos.toByteArray();
                                imagenServBase64 = javax.xml.bind.DatatypeConverter.printBase64Binary(arrayBytes);
                            }
                        %>
                        <tr class="doce columnas trServ">
                            <td class="ocho columnas">
                                <%if(imagenServBase64!=null){%>
                                <img src="data:image/jpg;base64, <%=imagenServBase64%>" alt="foto de usuario" style="width:25%;">
                                <%}else{%>
                                <img src="/Tarea2/Imag/SinImagen.jpg" style="width:25%;">
                                <%}%> 
                                <a id="nomServ" href="<%= request.getContextPath()%>/InfoServicio?nombreServicio=<%= s.getNombre() %>&nombreProveedor=<%= s.getProveedor() %>"><%= s.getNombre() %></a>
                                <p><%= s.getDescripcion() %></p>
                            </td>
                            <td class="una columnas">$<%= Math.round(s.getPrecio()) %></td>
                            <td class="una columnas"><%= rs.getCantidad() %></td>
                            <td class="una columnas">$<%= Math.round(s.getPrecio() * rs.getCantidad()) %></td>
                            <td class="una columnas"><img class="imgCancelar" src="/Tarea2/Imag/imagenCancelar.png" onclick="eliminarServicioCar(this.parentElement.parentElement)"></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                    <%}%>
                    <%
                        Iterator<DtResProm> itP = car.getPromociones().iterator();

                        //Si no hay servicios ni promociones no se muestran el total y el confirmar reserva
                        boolean hayPromos=false;

                        if(itP.hasNext()){
                            hayPromos=true;
                    %>
                <table id="Promociones" class="doce columnas">
                    <thead class="doce columnas">
                        <tr class="doce columnas">
                          <th class="siete columnas" style="text-align: left">Promociones</th>
                          <th class="una columnas">Precio</th>
                          <th class="una columnas">Descuento</th>
                          <th class="una columnas">Cantidad</th>
                          <th class="una columnas">Total</th>
                          <th class="una columnas"></th>
                        </tr>
                    </thead>
                    <tbody class="doce columnas">
                        <%    while(itP.hasNext()){
                            DtResProm rp = itP.next();
                            DtPromocion p = rp.getPromocion();
                    %>
                        <tr class="doce columnas trPromo">
                            <td class="siete columnas">
                                <a id="nomPromo" href="<%= request.getContextPath()%>/InfoPromocion?nombrePromocion=<%= p.getNombre() %>&nombreProveedor=<%= p.getProveedor() %>"><%= p.getNombre() %></a>
                            </td>
                            <td class="una columnas">$<%= Math.round(p.getTotal()) %></td>
                            <td class="una columnas">%<%= Math.round(p.getPorcentaje()) %></td>
                            <td class="una columnas"><%= rp.getCantidad()  %></td>
                            <td class="una columnas">$<%= Math.round(p.getTotal() * rp.getCantidad()) %></td>
                            <td class="una columnas"><img class="imgCancelar" src="/Tarea2/Imag/imagenCancelar.png" onclick="eliminarPromoCar(this.parentElement.parentElement)"></td>
                        </tr>
                            <%  }%>
                    </tbody>
                </table> 
                            <%}%>                            
                    <%if(hayPromos || hayServicios){%>
                <table class="doce columnas">
                   <thead class="doce columnas">
                       <tr class="doce columnas">
                         <th id="totalReserva" class="doce columnas" style="text-align: left;">Total de reserva: $<%= Math.round(car.getTotal()) %></th>
                       </tr>
                   </thead>
                </table>
            </div>
            
            <!--Div usado cuando se borra el carrito-->
            <div class="CarritoVacio" hidden="">
                <p>No hay elementos en el carrito</p>
            </div>
             
            <div id="confirmarBorrarRes" class="fila">
                <a id="borrarCar" class="botones" onclick="return borrarCarrito(this.parentElement)">Borrar Carrito</a>
                <a id="confirmarRes" class="botones" onclick="return confirmarReserva(this.parentElement)">Confirmar Reserva</a>      
                <p hidden="">La reserva se ha realizado correctamente</p>
            </div>
                <%}else{%>
            </div><!--Es para cerrar el div "PromosYServicios en caso de qeu no entre en el if anterior"-->
            <div class="CarritoVacio">
                <p>No hay elementos en el carrito</p>
            </div>
                <%}%>
            <%}else{%>
            <div class="CarritoVacio">
                <p>No hay elementos en el carrito</p>
            </div>
            <%}%>
            
        </div>
    </body>
</html>
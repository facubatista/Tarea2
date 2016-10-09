<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.awt.image.DataBufferByte"%>
<%@page import="java.awt.image.WritableRaster"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="Logica.DtPromocion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.DtServicio"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="CSS/Cabecera.css"/>
        <link rel ="stylesheet" href="CSS/ServPromCss.css">
        <!link rel ="stylesheet" href="../CSS/Cabecera.css">
        <script src="JS/jQuery.js"></script>
        <script src="JS/ServProm.js"></script>
        <jsp:include page="Cabecera.jsp" />
    </head>
    
    <body>
        <!jsp:include page="Cabecera.jsp" />
        <%--<ul class="clase">
            <li><a href="#" >Uno</a></li> 
            <li><a href="#" >Dos</a></li>
            <li><a href="#" >Tres</a></li>
        </ul>--%>
        <br>
        <div class="principal">
            <div class="fila">
                <div class="tres columnas" id="colUno">
                    <ul id="menu_arbol">
                        <li id="Raiz" title="Todos"><a onclick="busqueda('');" href="#">Todos</a></li>
                        <li class="primero"><a href="#" title="Vuelos">Vuelos</a>
                            <ul>
                                <li class="nieto" title="Iberia"><a href="#" onclick="busqueda('Iberia');">Iberia</a></li>
                                <li class="nieto" title="American Airlines"><a onclick="busqueda('American Airlines');" href="#">American Airlines</a></li>
                                <li class="nieto" title="Air France"><a onclick="busqueda('Air France');" href="#">Air France</a></li>
                                <li class="nieto" title="TAM"><a onclick="busqueda('TAM');" href="#">TAM</a></li>
                            </ul>
                            <br>
                            <ul>
                                <li class="nieto" title="LowCost"><a onclick="busqueda('LowCost');" href="#">LowCost</a></li>
                                <li class="nieto" title="Standard"><a onclick="busqueda('Standard');" href="#">Standard</a></li>
                                <li class="nieto" title="First Class"><a onclick="busqueda('First Class');" href="#">First Class</a></li>
                            </ul>
                        <br>
                        </li>
                        <li class="primero"><a onclick="busqueda('Alojamientos');" href="#">Alojamientos</a>
                            <ul>
                                <li class="nieto" title="Hotel"><a onclick="busqueda('Hotel');" href="#">Hotel</a></li>
                                <li class="nieto" title="Hostal"><a onclick="busqueda('Hostal');" href="#">Hostal</a></li>
                                <li class="nieto" title="Apartamento"><a onclick="busqueda('Apartamento');" href="#">Apartamento</a></li>
                                <li class="nieto" title="Casa"><a onclick="busqueda('Casa');" href="#">Casa</a></li>
                            </ul>
                            <br>
                            <ul>
                                <li class="nieto" title="Playa"><a onclick="busqueda('Playa');" href="#">Playa</a></li>
                                <li class="nieto" title="Rural"><a onclick="busqueda('Rural');" href="#">Rural</a></li>
                                <li class="nieto" title="Montaña"><a onclick="busqueda('Montaña');" href="#">Montaña</a></li>
                            </ul>
                            <br>
                            <ul>
                                <li class="nieto" title="Monoambiente"><a onclick="busqueda('Monoambiente');" href="#">Monoambiente</a></li>
                                <li class="nieto" title="Un dormitorio"><a onclick="busqueda('Un dormitorio');" href="#">Un dormitorio</a></li>
                                <li class="nieto" title="Dos dormitorios"><a onclick="busqueda('Dos dormitorios');" href="#">Dos dormitorios</a></li>
                            </ul>
                        <br>
                        </li>
                        <li class="primero"><a onclick="busqueda('Automoviles');" href="#" title="Automoviles">Automoviles</a>
                            <ul>
                                <%--<li class="hijo">Tarifa</li>--%>
                                <li class="nieto" title="Mini"><a onclick="busqueda('Mini');" href="#">Mini</a></li>
                                <li class="nieto" title="Economico"><a onclick="busqueda('Economico');" href="#">Economico</a></li>
                                <li class="nieto" title="Full"><a onclick="busqueda('Full');" href="#">Full</a></li>
                            </ul>
                                <br>
                            <ul>
                                <%--<li class="hijo">Tipo vehiculo</li>--%>
                                <li class="nieto" title="Auto"><a onclick="busqueda('Auto');" href="#">Auto</a></li>
                                <li class="nieto" title="Camioneta"><a onclick="busqueda('Camioneta');" href="#">Camioneta</a></li>
                                <li class="nieto" title="Camion"><a onclick="busqueda('Camion');" href="#">Camion</a></li>
                                <li class="nieto" title="Moto"><a onclick="busqueda('Moto');" href="#">Moto</a></li>
                            </ul>
                                <br>
                            <ul>
                                <%--<li class="hijo">Marca</li>--%>
                                <li class="nieto" title="Chevrolet"><a onclick="busqueda('Chevrolet');" href="#">Chevrolet</a></li>
                                <li class="nieto" title="Peugeot"><a onclick="busqueda('Peugeot');" href="#">Peugeot</a></li>
                                <li class="nieto" title="Daihatsu"><a onclick="busqueda('Daihatsu');" href="#">Daihatsu</a></li>
                                <li class="nieto" title="Fiat"><a onclick="busqueda('Fiat');" href="#">Fiat</a></li>
                            </ul>
                            <br>
                        </li>
                        <li class="primero"><a onclick="busqueda('Cruceros');" href="#" title="Cruceros">Cruceros</a>
                             <ul>
                                  <li><a onclick="busqueda('Mediterraneo');" href="#" title="Mediterraneo">Mediterraneo</a></li>
                                  <li><a onclick="busqueda('Mar Negro');" href="#" title="Mar Negro">Mar Negro</a></li>
                                  <li><a onclick="busqueda('Caribe');" href="#" title="Caribe">Caribe</a></li>
                                  <li><a onclick="busqueda('Nilo');" href="#" title="Nilo">Nilo</a></li>
                                  <li><a onclick="busqueda('Alaska');" href="#" title="Alaska">Alaska</a></li>
                             </ul>
                        </li>
                   </ul>
                </div>
                <div class="nueve columnas" id="colDos">
                    
                    <div>
                        <table id="tabla">
                            <thead>
                                <tr>
                                  <th style="text-decoration: underline"><b>Tipo</b></th>
                                  <th style="text-decoration: underline"><b>Nombre</b></th>
                                  <th style="text-decoration: underline"><b>Proveedor</b></th>
                                  <%if(session.getAttribute("nickUsuario") != null){%>
                                  <th><b>Agregar a carrito</b></th>
                                  <%}%>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                ArrayList<DtServicio> listaServicios = (ArrayList)request.getAttribute("listaServicios");
                                Iterator<DtServicio> it = listaServicios.iterator();

                                while(it.hasNext()){
                                    DtServicio s = it.next();
                                %>
                                <tr>
                                    <td class="TdTipo">Servicio</td>
                                    <td class="TdNombreS">
                                        <%
                                            if(!s.getImagenes().isEmpty()){
                                            BufferedImage originalImage=(BufferedImage) s.getImagenes().get(0).getImage();
                                            ByteArrayOutputStream baos=new ByteArrayOutputStream();
                                            ImageIO.write(originalImage, "jpg", baos );
                                            byte[] arrayBytes = baos.toByteArray();
                                            String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(arrayBytes);
                                        %>
                                            <img class="imgMini" src="data:image/jpg;base64, <%=b64%>">
                                        <%}%>
                                        <a href="<%= request.getContextPath()%>/InfoServicio?nombreServicio=<%= s.getNombre() %>&nombreProveedor=<%= s.getProveedor() %>">
                                            <%= s.getNombre() %>
                                        </a>
                                    </td>
                                    <td class="TdProveedor"><%= s.getProveedor() %></td>
                                    <%if(session.getAttribute("nickUsuario") != null){  %>
                                        <td class="TdAgregarACarrito">
                                            <div class="aOcultar">
                                                <label class="precio">Precio: <%= s.getPrecio() %></label>
                                                <%--Fecha de inicio del servicio--%>
                                                <div id="fechaIni">
                                                    <label class="labelIni" >Inicio:</label>
                                                    <input id="diaIni" name="diaIni" maxlength="2" placeholder="dd" type="text"/>
                                                    <label class="label2" >/</label>
                                                    <select id="mesIni" name="mesIni">
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
                                                    <input id="anioIni" name="anioIni" maxlength="4" placeholder="aaaa" type="text"/>
                                                </div>

                                                <%--Fecha de Fin del servicio--%>
                                                <div id="fechaFin">
                                                    <label class="labelFin" >Fin:</label>
                                                    <input id="diaFin" name="diaFin" maxlength="2" placeholder="dd" type="text"/>
                                                    <label class="label2" >/</label>
                                                    <select id="mesFin" name="mesFin">
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
                                                    <input id="anioFin" name="anioFin" maxlength="4" placeholder="aaaa" type="text"/>
                                                </div>
                                                <form <%--action="agregarSCarrito--%> onsubmit="return agregarSACarrito(this.parentElement.parentElement)" name="formAgregar">
                                                    <input type="hidden" id ="nombreServicio" value="<%= s.getNombre() %>" name="nombreServicio">
                                                    <input type="hidden" id ="nombreProveedor" value="<%= s.getProveedor() %>" name="nombreProveedor">
                                                    <label>Cantidad:</label><input type="text" name="cantidad" id="txtCantidad" class="cantidad" onkeyup="calcularPrecio(this.parentElement.parentElement, <%= s.getPrecio() %>)">
                                                    <input id ="agregar" type="submit" value="agregar al carrito" >
                                                </form>
                                            </div>
                                            <div class="aMostrar" hidden="">
                                                <img src="Imag/carrito.png" alt="imagen de carrito"> En carrito
                                            </div>
                                        </td>
                                    <%}%>
                                </tr>
                                <%}%>

                                <%
                                    ArrayList<DtPromocion> listaPromociones = (ArrayList)request.getAttribute("listaPromociones");
                                    Iterator<DtPromocion> iterador = listaPromociones.iterator();

                                    while(iterador.hasNext()){
                                        DtPromocion p = iterador.next();
                                %>
                                <tr>
                                    <td class="TdTipo">Promocion</td>
                                    <td>
                                        <a href="<%= request.getContextPath()%>/InfoPromocion?nombrePromocion=<%= p.getNombre() %>&nombreProveedor=<%= p.getProveedor() %>">
                                            <%= p.getNombre() %>
                                        </a>
                                    </td>
                                    <td class="TdProveedor"><%= p.getProveedor() %></td>
                                    <%if(session.getAttribute("nickUsuario") != null){%>
                                        <td>
                                            <div class="aOcultar">
                                                <form <%--action="agregarSCarrito--%> onsubmit="return agregarPACarrito(this.parentElement.parentElement)" name="formAgregar">
                                                    <input type="hidden" id ="nombrePromocion" value="<%= p.getNombre() %>" name="nombrePromocion">
                                                    <input type="hidden" id ="nombreProveedor" value="<%= p.getProveedor() %>" name="nombreProveedor">
                                                    <input type="text" name="cantidad" id="txtCantidad" class="cantidad" onkeyup="calcularPrecio(this.parentElement.parentElement, <%= p.getTotal() %>)">
                                                    <input id ="agregar" type="submit" value="agregar al carrito" ><!-- cambiar esto!-->
                                                </form>
                                                    <label class="precio">Precio: <%= p.getTotal() %></label>
                                            </div>
                                            <div class="aMostrar" hidden="">
                                                <img src="Imag/carrito.png" alt="imagen de carrito"> En carrito
                                            </div>
                                        </td>
                                    <%}%>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <header>
        <%if(session.getAttribute("nomUsuario")==null)
               session.setAttribute("nomUsuario", "Anonimo");
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
                <a id="IniC" class="botones" href="Vistas/IniciarSesion.jsp">Iniciar Cesión</a>
                <%}else{%>
                <a id="IniC" class="botones" href="http://www.google.com.uy">Cerrar Cesión</a>
                <%}%>
            </div>                                  
        </div>  
       <div class="doce columnas">
           Vuelos > Empresas > Iberia
       </div>
   </header>

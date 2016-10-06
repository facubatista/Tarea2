<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <header>
        <%if(session.getAttribute("nomUsuario")==null)
               session.setAttribute("nomUsuario", "Anonimo");
           %>
       <div class="cuatro columnas">
           <a href="/Tarea2/index.jsp">
            <img src="/Tarea2/Imag/H4T.jpg" alt="imagen de header" width="250" onclick="">
           </a>
       </div>
       <div class="cuatro columnas">
           <form id="formBuscar" action="/Tarea2/ServProm" method="POST">
               <input id="buscar" name="busqueda" placeholder="Buscar servicio o promoción" type="text">
               <input value="Buscar" class="botones" type="submit">
           </form>
       </div>
       <div id="SesionUsuario" class="cuatro columnas">                
            <div class="imagenYcarrito">
                <%if(session.getAttribute("imagenUsuario")!=null){%>
                <img class="ImagenUsuario" src="/Tarea2/Imag/prueba3.jpg" alt="imagen de usuario">
                <%}else{%>
                <img class="ImagenUsuario Altern" src="/Tarea2/Imag/IconoUsuario.png" alt="imagen de usuario alternativa">
                <%}%>
                <% if(session.getAttribute("nomUsuario").equals("Anonimo")==false){ %>
                    <a id="BotonCarrito" class="botones AlinearIzq" href="/Tarea2/Vistas/VerCarrito.jsp">Carrito de compras</a>
                <% } %>    
            </div>
            <div >                
                <%if(session.getAttribute("nomUsuario").equals("Anonimo")){%>
                <h4><%=session.getAttribute("nomUsuario")%></h4>
                <a id="IniC" class="botones" href="/Tarea2/Vistas/IniciarSesion.jsp">Iniciar Sesión</a>
                <%}else{%>
                <a id="VerPerfil" href="/Tarea2/Vistas/VerPerfil.jsp"><%=session.getAttribute("nomUsuario")%></a>
                <a id="IniC" class="botones" href="<%= request.getContextPath()%>/ServUsuarios?Sesion=Cerrar">Cerrar Sesión</a>
                <%}%>
            </div>                                  
        </div>  
       <div class="doce columnas">
           <label id="categorias">Vuelos > Empresas > Iberia</label>
       </div>
   </header>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <header>
        <%
        if(session.getAttribute("nomUsuario")==null){
            session.setAttribute("nomUsuario", "Anonimo");
        }
        
        String imagenUsuarioB64=null;
        if(session.getAttribute("imagenUsuario")!=null){
             byte[] imagenUsuario = (byte[])session.getAttribute("imagenUsuario");
             imagenUsuarioB64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imagenUsuario);
        }
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
                <%if(imagenUsuarioB64!=null){%>
                <a href="<%= request.getContextPath()%>/ServUsuarios?VerPerfil=true">
                    <img src="data:image/jpg;base64, <%=imagenUsuarioB64%>" alt="foto del usuario" class="ImagenUsuario Real"><!--Cambiar por imagen del usuario-->
                </a>
                <%}else{%>
                <img src="/Tarea2/Imag/IconoUsuario.png" alt="imagen alternativa del usuario" class="ImagenUsuario Altern"> 
                <%}%>
                <% if(session.getAttribute("nomUsuario").equals("Anonimo")==false){ %>
                <a id="BotonCarrito" class="botones AlinearIzq" href="/Tarea2/Vistas/VerCarrito.jsp">Carrito de compras</a>
                <% } %>    
            </div>
            <div >                
                <%if(session.getAttribute("nomUsuario").equals("Anonimo")){%>
                <h4><%=session.getAttribute("nomUsuario")%></h4>
                <a id="IniC" class="botones" href="/Tarea2/Vistas/IniciarSesion.jsp">Iniciar Sesión</a>
                <a id="linkRegistrarse" href="/Tarea2/Vistas/AltaUsuario.jsp">Registrarse</a>
                <%}else{%>
                <a id="VerPerfil" href="<%= request.getContextPath()%>/ServUsuarios?VerPerfil=true"><%=session.getAttribute("nomUsuario")%></a>
                <a id="IniC" class="botones" href="<%= request.getContextPath()%>/ServUsuarios?Sesion=Cerrar">Cerrar Sesión</a>
                <%}%>
            </div>                                  
        </div>  
       <div class="doce columnas">
           <label id="categorias">Vuelos > Empresas > Iberia</label>
       </div>
   </header>

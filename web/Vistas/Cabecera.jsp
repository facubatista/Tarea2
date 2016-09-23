<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <header>
        <%if(session.getAttribute("nomUsuario")==null)
               session.setAttribute("nomUsuario", "Anonimo");
           %>
       <div class="cuatro columnas">
           <img src="/Tarea2/Imag/H4T.jpg" alt="imagen de header" width="250">
       </div>
       <div class="cuatro columnas">
           <form id="formBuscar" action="ServProm" method="POST">
               <input id="buscar" name="busqueda" placeholder="Buscar servicio o promoción" type="text">
               <input value="Buscar" class="botones" type="submit">
           </form>
       </div>
       <div id="SesionUsuario" class="cuatro columnas">                
            <div class="imagenYcarrito"> 
                <img id="ImagenUsuario" src="/Tarea2/Imag/IconoUsuario.png" alt="imagen de usuario" width="80">

                <a id="BotonCarrito" class="botones AlinearIzq" href="ServletCarrito?verCarrito=true">Carrito de compras</a>
            </div>
            <div >
                <h4><%=session.getAttribute("nomUsuario")%></h4>
                <%if(session.getAttribute("nomUsuario").equals("Anonimo")){%>
                <a id="IniC" class="botones" href="<%= request.getContextPath()%>/ServUsuarios?Sesion=Iniciar">Iniciar Sesión</a>
                <%}else{%>
                <a id="IniC" class="botones" href="<%= request.getContextPath()%>/ServUsuarios?Sesion=Cerrar">Cerrar Sesión</a>
                <%}%>
            </div>                                  
        </div>  
       <div class="doce columnas">
           <label id="categorias">Vuelos > Empresas > Iberia</label>
       </div>
   </header>

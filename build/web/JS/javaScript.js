function verificarUsuario(claveIngresada){
    
    var claveUsuario = claveIngresada.value;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        //Los status 200 y 4 indican que no hubo ningun problema
        if(this.status===200 && this.readyState ===4){
           //var json = JSON.parse(this.responseText);
           if(this.responseText === 'false' && claveUsuario.length!==0){
           //if(json.verificacion[0].respuesta === 'false'){
                document.getElementById("nickInvalido").hidden = false;
                document.getElementById("botonIngresar").hidden = true;
                document.getElementById("botonIngresarDis").hidden = false;
                return false;
           }else{
               document.getElementById("nickInvalido").hidden = true;
               document.getElementById("botonIngresar").hidden = false;
               document.getElementById("botonIngresarDis").hidden = true;
               return true;
            }
        }
        console.log(this);
    };
    request.open("POST","../ServUsuarios",true );
    request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    request.send("verificarUsuario="+claveUsuario);
    
}

function verificarPassword(form){
    var password = form.querySelector("input[id=contra]").value;
    password = sha1(password);
    var nickname = form.querySelector("input[id=nomUsr]").value;
    var request = new XMLHttpRequest();
    request.open("POST","/Tarea2/ServUsuarios",true );
    request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    request.send("verificarPassword="+password+"&passUser="+nickname);
    request.onreadystatechange = function(){
        //console.log(this)
        if(this.status===200 && this.readyState ===4){
            if(this.responseText === 'passOK'){
                return true;
            }else{
                alert("Contraseña incorrecta");
                return false;
            }
        }
    };
    
}

function ocultarMsjPassInc(form, nickOpass){
    if(nickOpass.id==='nomUsr'){
        form.querySelector("label[id=nickInvalido]").hidden = true;
    }else{
        form.querySelector("label[id=passwordIncorrecta]").hidden = true;        
    }
    return false;
}

function iniciarSesion(form){
    var password = form.querySelector("input[id=contra]").value;
    password = sha1(password);
    var nickname = form.querySelector("input[id=nomUsr]").value;
    var request = new XMLHttpRequest();
    request.open("POST","/Tarea2/ServUsuarios",true );
    request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    request.send("verificarPassword="+password+"&passUser="+nickname);
    request.onreadystatechange = function(){
        //console.log(this);
        if(this.status===200 && this.readyState ===4){
            if(this.responseText === 'passOK'){
                var request2 = new XMLHttpRequest();
                request2.open("POST","/Tarea2/ServUsuarios",true );
                request2.setRequestHeader("Content-type","application/x-www-form-urlencoded");
                request2.send("nomUsuario="+nickname);
                request2.onreadystatechange = function(){
                    if(this.status===200 && this.readyState ===4){
                        window.location = "/Tarea2/index.jsp";
                        return true;
                    }
                };
            }else{
                document.getElementById("passwordIncorrecta").hidden = false;
                return false;
            }
        }
    };    
}

//function volverImagen(b64){
//    var str = String(b64);
//    document.getElementById("imgGrande").src = str;
//}

//Funciones usadas en Ver Perfil
function cambiarPestania(pestania) {
    
    if(pestania.id==="mostrarRes"){
        document.getElementById("infoCliente").hidden = true;
        document.getElementById("resCliente").hidden = false;              
    }else{
        document.getElementById("infoCliente").hidden = false;
        document.getElementById("resCliente").hidden = true;
    }
    
    /*Cambia el borde de la pestanña seleccionada y la otra*/
    document.querySelector("a[class=selec]").className = "NOselec";
    pestania.className = "selec";
}

function cambiarEstadoRes(numReserva, trReserva){
    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        //Los status 200 y 4 indican que no hubo ningun problema
        if(this.status===200 && this.readyState ===4){
            trReserva.getElementsByClassName("estadoRes")[0].innerHTML = "Cancelada";
            trReserva.querySelector("button").hidden = true;
        }
        console.log(this);
    };
    request.open("GET","/Tarea2/ServUsuarios?cambiarEstadoRes="+numReserva,true );
    request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    request.send();
    
    return false;
}
//

//funciones usadas en Ver Carrito
function eliminarServicioCar(trServicio){
    var nomServ = trServicio.querySelector("a[id=nomServ]").innerHTML;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        //Los status 200 y 4 indican que no hubo ningun problema
        if(this.status===200 && this.readyState ===4){
           var tBody = trServicio.parentNode;
           tBody.removeChild(trServicio);
            if( document.getElementsByClassName("trServ").length === 0){//Si no hay mas servicios se elimina la tabla
                if(document.getElementsByClassName("trPromo").length === 0){//Si tampoco hay mas promo se elimina borra div que contiene las tablas
                    var tablaServProm = document.getElementById("PromosYServicios");
                    tablaServProm.parentNode.removeChild(tablaServProm);
                    document.querySelector("div[class=CarritoVacio]").hidden = false;//Se div con el mensaje de que el carrito esta vacio
                    document.querySelector("a[id=confirmarRes]").hidden = true;
                    document.querySelector("a[id=borrarCar]").hidden = true;
                }else{
                    var tablaServicios = tBody.parentNode;
                    tablaServicios.parentNode.removeChild(tablaServicios);
                }
           }
           document.getElementById("totalReserva").innerHTML = 'Total de reserva: $'+this.responseText;
        }
        console.log(this);
    };
    request.open("GET","/Tarea2/ServletCarrito?eliminarServicioCar="+nomServ,true );
    request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    request.send();
    
    return false;
}

function eliminarPromoCar(trPromo){
    var nomPromo = trPromo.querySelector("a[id=nomPromo]").innerHTML;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        //Los status 200 y 4 indican que no hubo ningun problema
        if(this.status===200 && this.readyState ===4){
           var tBody = trPromo.parentNode;
           tBody.removeChild(trPromo);
            if( document.getElementsByClassName("trPromo").length === 0){//Si no hay mas promos se elimina la tabla
                if(document.getElementsByClassName("trServ").length === 0){//Si tampoco hay mas servicios se elimina borra div que contiene las tablas
                    var tablaServProm = document.getElementById("PromosYServicios");
                    tablaServProm.parentNode.removeChild(tablaServProm);
                    document.querySelector("div[class=CarritoVacio]").hidden = false;//Se div con el mensaje de que el carrito esta vacio
                    document.querySelector("a[id=confirmarRes]").hidden = true;
                    document.querySelector("a[id=borrarCar]").hidden = true;
                }else{
                    var tablaPromos = tBody.parentNode;
                    tablaPromos.parentNode.removeChild(tablaPromos);
                }
            } 
           document.getElementById("totalReserva").innerHTML = 'Total de reserva: $'+this.responseText;
        }
        console.log(this);
    };
    request.open("GET","/Tarea2/ServletCarrito?eliminarPromoCar="+nomPromo,true );
    request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    request.send();
    
    return false;
}
//


//Funciones Usadas en Ver Carrito
function confirmarReserva(div){
     var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        //Los status 200 y 4 indican que no hubo ningun problema
        if(this.status===200 && this.readyState ===4){
            div.querySelector("p").hidden = false;
            div.querySelector("a[id=confirmarRes]").hidden = true;
            div.querySelector("a[id=borrarCar]").hidden = true;
            var imgsCancelar = document.getElementsByClassName("imgCancelar");
            for(var i = 0; i < imgsCancelar.length; i++){
                imgsCancelar[i].hidden = true;
            }
        }
        console.log(this);
    };
    request.open("GET","/Tarea2/ServletCarrito?confirmarReserva=true",true );
    request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    request.send();
    
    return false;
}

function borrarCarrito(div){
    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        //Los status 200 y 4 indican que no hubo ningun problema
        if(this.status===200 && this.readyState ===4){
            div.querySelector("p").innerHTML = 'El Carrito ha sido borrado correctamente';
            div.querySelector("p").hidden = false;
            div.querySelector("a[id=confirmarRes]").hidden = true;
            div.querySelector("a[id=borrarCar]").hidden = true;
            document.getElementById("PromosYServicios").hidden = true;
            document.querySelector("div[class=CarritoVacio]").hidden = false;
        }
        console.log(this);
    };
    request.open("GET","/Tarea2/ServletCarrito?borrarCarrito=true",true );
    request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    request.send();
    
    return false;
}


function cargarDatos(){
    
    
    var x = new XMLHttpRequest();
    x.onreadystatechange = function(){
        //Los status 200 y 4 indican que no hubo ningun problema
        if(this.status === 200 && this.readyState === 4){
            console.log(this);
        }
    };

    x.open("POST","/Tarea2/cargarDatos", true);
    x.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    //x.setRequestHeader("responseType","json");
    x.send();
    
    return false;
}
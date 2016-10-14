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

//function iniciarSesionUsr(form){
//    var claveUsuario = form.querySelector("input[id=nomUsr]").value;
//    var request = new XMLHttpRequest();
//    request.onreadystatechange = function(){
//        //Los status 200 y 4 indican que no hubo ningun problema
//        if(this.status===200 && this.readyState ===4){
//           //var json = JSON.parse(this.responseText);
//           if(this.responseText === 'false' && claveUsuario.length!==0){
//           //if(json.verificacion[0].respuesta === 'false'){
//                document.getElementById("nickInvalido").hidden = false;
//                document.getElementById("botonIngresar").hidden = true;
//                document.getElementById("botonIngresarDis").hidden = false;
//                return false;
//           }else{
//                //var claveUsuario = form.querySelector("input[id=nomUsr]").value;
//                var request2 = new XMLHttpRequest();
//                request2.open("POST","/Tarea2/ServUsuarios",true );
//                request2.setRequestHeader("Content-type","application/x-www-form-urlencoded");
//                request2.send("nomUsuario="+claveUsuario);
//                request.onreadystatechange = function(){
//                  console.log(this);  
//                };
//                return true;
//            }
//        }
//        console.log(this);
//    };
//    request.open("POST","/Tarea2/ServUsuarios",true );
//    request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
//    request.send("verificarUsuario="+claveUsuario);
//}


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

//funciones usadas en Ver Carrito
function eliminarServicioCar(trServicio){
    var nomServ = trServicio.querySelector("a[id=nomServ]").innerHTML;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        //Los status 200 y 4 indican que no hubo ningun problema
        if(this.status===200 && this.readyState ===4){
           trServicio.parentNode.removeChild(trServicio);
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
           trPromo.parentNode.removeChild(trPromo);
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
//
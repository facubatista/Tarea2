function agregarACarrito(o){
    
    var servicio = o.querySelector("input[name=nombreServicio]").value;
    var proveedor = o.querySelector("input[name=nombreProveedor]").value;
    var cantidad = o.querySelector("input[name=cantidad]").value;
    //var y = parseInt(x);
    //if (isNaN(y)) 
    if(cantidad === ''){
        alert('Debe ingresar una cantidad');
        return false;
    }
    if(isNaN(parseInt(cantidad))){
        alert('Debe ingresar un valor numerico');
        return false;
    }
    var x = new XMLHttpRequest();
    x.onreadystatechange = function(){
        //Los status 200 y 4 indican que no hubo ningun problema
        if(this.status===200 && this.readyState ===4){
            console.log(this);
            o.querySelector(".aOcultar").hidden = true;
            o.querySelector(".aMostrar").hidden = false;
            //if(this.responseText == )
            //document.getElementById("aOcultar").hidden = true;
            ///document.getElementById("aMostrar").hidden = false;
            
        }
    };
    x.open("POST","agregarSCarrito",true );
    x.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    //x.setRequestHeader("responseType","json");
    x.send("nombreServicio="+servicio+"&nombreProveedor="+proveedor+"&cantidad="+cantidad);
    return false;
}

function calcularPrecio(objeto, precioS){
    var cantidad = objeto.querySelector("input[name=cantidad]").value;
    var precio = parseInt(precioS);
     
    if(isNaN(parseInt(cantidad))){
        objeto.querySelector(".precio").innerHTML = 'precio: ' + precio;
    }else{
        objeto.querySelector(".precio").innerHTML = 'precio: ' + parseInt(cantidad)*precio;
    }
}

function verificarNick(nickIngresado,mostrarMensaje,botonIngresar,botonIngresarDis){
    var nickname = nickIngresado.value;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        //Los status 200 y 4 indican que no hubo ningun problema
        if(this.status===200 && this.readyState ===4){
           //var xmlDoc = this.responseXML;
           if(this.responseText === 'false'){
                mostrarMensaje.hidden = false;
                botonIngresar.hidden = true;
                botonIngresarDis.hidden = false;
           }else{
               mostrarMensaje.hidden = true;
               botonIngresar.hidden = false;
               botonIngresarDis.hidden = true;
               
           }
            console.log(this);
        }
    };
    request.open("POST","ServUsuarios",true );
    request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    request.send("verificarNick="+nickname);
    //alert(nickname);
    return false;
}
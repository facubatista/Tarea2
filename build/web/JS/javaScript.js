function agregarSACarrito(o){
    
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
           }else{
               document.getElementById("nickInvalido").hidden = true;
               document.getElementById("botonIngresar").hidden = false;
               document.getElementById("botonIngresarDis").hidden = true;
           }
        }
        console.log(this);
    };
    request.open("POST","../ServUsuarios",true );
    request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    request.send("verificarUsuario="+claveUsuario);
    //alert(nickname);
    return false;
    }

/*
function verificarPassword(form){
    var password = form.querySelector("contra").value;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        if(sha1(password)===sha1(this.responseText)){
            return true;
        }else
            return false;
    };
    request.open("POST","ServUsuarios",true );
    request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    request.send("verificarPassword=verificar");
}*/

function cambiarImagen(numero){
    
    if(parseInt(numero) === 1)
        document.getElementById("imgGrande").src = "Imag/prueba2.jpg";
    
    if(parseInt(numero) === 2)
        document.getElementById("imgGrande").src = "Imag/prueba3.jpg";
    
    if(parseInt(numero) === 3)
        document.getElementById("imgGrande").src = "Imag/prueba4.jpg";
    
    
}
function volverImagen(){
    document.getElementById("imgGrande").src = "Imag/prueba.jpg";
}
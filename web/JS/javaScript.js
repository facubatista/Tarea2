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
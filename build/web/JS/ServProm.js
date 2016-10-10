function agregarSACarrito(o){
    
    var servicio = o.querySelector("input[name=nombreServicio]").value;
    var proveedor = o.querySelector("input[name=nombreProveedor]").value;
    var cantidad = o.querySelector("input[name=cantidad]").value;
    
    var diaIni = o.querySelector("input[name=diaIni]").value;
    var mesIni = o.querySelector("select[name=mesIni]").value;
    var anioIni = o.querySelector("input[name=anioIni]").value;
    
    
    var diaFin = o.querySelector("input[id=diaFin]").value;
    var mesFin = o.querySelector("select[name=mesFin]").value;
    var anioFin = o.querySelector("input[id=anioFin]").value;
    
    switch(mesIni){
        case 'Enero': mesIni = 1; break;
        case 'Febrero': mesIni = 2; break;
        case 'Marzo': mesIni = 3; break;
        case 'Abril': mesIni = 4; break;
        case 'Mayo': mesIni = 5; break;
        case 'Junio': mesIni = 6; break;
        case 'Julio': mesIni = 7; break;
        case 'Agosto': mesIni = 8; break;
        case 'Setiembre': mesIni = 9; break;
        case 'Octubre': mesIni = 10; break;
        case 'Noviembre': mesIni = 11; break;
        case 'Diciembre': mesIni = 12; break;
    }
    
    switch(mesFin){
        case 'Enero': mesFin = 1; break;
        case 'Febrero': mesFin = 2; break;
        case 'Marzo': mesFin = 3; break;
        case 'Abril': mesFin = 4; break;
        case 'Mayo': mesFin = 5;break;
        case 'Junio': mesFin = 6; break;
        case 'Julio': mesFin = 7; break;
        case 'Agosto': mesFin = 8; break;
        case 'Setiembre': mesFin = 9; break;
        case 'Octubre': mesFin = 10; break;
        case 'Noviembre': mesFin = 11; break;
        case 'Diciembre': mesFin = 12; break;
    }
    
    //var anioFin = o.querySelector("select[name=anioFin]").value;
    
    //var y = parseInt(x);
    //if (isNaN(y))
    if(diaIni === '' || diaIni === '' || anioIni === '' || anioFin === '' || cantidad === ''){
        alert('Debe ingresar todos los campos');
        return false;
    }
    
    if(isNaN(parseInt(cantidad)) || isNaN(parseInt(diaIni)) || isNaN(parseInt(anioIni)) || isNaN(parseInt(diaFin)) || isNaN(parseInt(anioFin))){
        alert('Todos los campos deben ser numericos');
        return false;
    }
    
    if(parseInt(anioIni) > parseInt(anioFin)){
        alert('La fecha de fin debe ser despues o a lo sumo el mismo dia que de la fecha de inicio')
        return false;
    }else{
        if(parseInt(anioIni) === parseInt(anioFin)){
            if(parseInt(mesIni) > parseInt(mesFin)){
                alert('La fecha de fin debe ser despues o a lo sumo el mismo dia que de la fecha de inicio')
                return false;
            }else{
                if(parseInt(mesIni) === parseInt(mesFin)){
                    if(parseInt(diaIni) > parseInt(diaFin)){
                        alert('La fecha de fin debe ser despues o a lo sumo el mismo dia que de la fecha de inicio');
                        return false;
                    }
                }
            }
        }
    }
    
    
    
    var x = new XMLHttpRequest();
    x.onreadystatechange = function(){
        //Los status 200 y 4 indican que no hubo ningun problema
        if(this.status === 200 && this.readyState === 4){
            console.log(this);
            o.querySelector(".aOcultar").hidden = true;
            o.querySelector(".aMostrar").hidden = false;
            //if(this.responseText)
            //document.getElementById("aOcultar").hidden = true;
            ///document.getElementById("aMostrar").hidden = false;
            
        }
    };
    x.open("POST","agregarSCarrito",true );
    x.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    //x.setRequestHeader("responseType","json");
    x.send("nombreServicio="+servicio+"&nombreProveedor="+proveedor+"&cantidad="+cantidad+"&diaIni"+diaIni+"&mesIni"+mesIni+"&anioIni"+anioIni+"&diaFin"+diaFin+"&mesFin"+mesFin+"&anioFin"+anioFin);
    return false;
}

function agregarPACarrito(o){
    
    var promocion = o.querySelector("input[name=nombrePromocion]").value;
    var proveedor = o.querySelector("input[name=nombreProveedor]").value;
    var cantidad = o.querySelector("input[name=cantidad]").value;
    
    var diaIni = o.querySelector("input[name=diaIni]").value;
    var mesIni = o.querySelector("select[name=mesIni]").value;
    var anioIni = o.querySelector("input[name=anioIni]").value;
    
    
    var diaFin = o.querySelector("input[id=diaFin]").value;
    var mesFin = o.querySelector("select[name=mesFin]").value;
    var anioFin = o.querySelector("input[id=anioFin]").value;
    
    switch(mesIni){
        case 'Enero': mesIni = 1; break;
        case 'Febrero': mesIni = 2; break;
        case 'Marzo': mesIni = 3; break;
        case 'Abril': mesIni = 4; break;
        case 'Mayo': mesIni = 5; break;
        case 'Junio': mesIni = 6; break;
        case 'Julio': mesIni = 7; break;
        case 'Agosto': mesIni = 8; break;
        case 'Setiembre': mesIni = 9; break;
        case 'Octubre': mesIni = 10; break;
        case 'Noviembre': mesIni = 11; break;
        case 'Diciembre': mesIni = 12; break;
    }
    
    switch(mesFin){
        case 'Enero': mesFin = 1; break;
        case 'Febrero': mesFin = 2; break;
        case 'Marzo': mesFin = 3; break;
        case 'Abril': mesFin = 4; break;
        case 'Mayo': mesFin = 5;break;
        case 'Junio': mesFin = 6; break;
        case 'Julio': mesFin = 7; break;
        case 'Agosto': mesFin = 8; break;
        case 'Setiembre': mesFin = 9; break;
        case 'Octubre': mesFin = 10; break;
        case 'Noviembre': mesFin = 11; break;
        case 'Diciembre': mesFin = 12; break;
    }
    
    if(diaIni === '' || diaIni === '' || anioIni === '' || anioFin === '' || cantidad === ''){
        alert('Debe ingresar todos los campos');
        return false;
    }
    
    if(isNaN(parseInt(cantidad)) || isNaN(parseInt(diaIni)) || isNaN(parseInt(anioIni)) || isNaN(parseInt(diaFin)) || isNaN(parseInt(anioFin))){
        alert('Todos los campos deben ser numericos');
        return false;
    }
    
    if(parseInt(anioIni) > parseInt(anioFin)){
        alert('La fecha de fin debe ser despues o a lo sumo el mismo dia que de la fecha de inicio')
        return false;
    }else{
        if(parseInt(anioIni) === parseInt(anioFin)){
            if(parseInt(mesIni) > parseInt(mesFin)){
                alert('La fecha de fin debe ser despues o a lo sumo el mismo dia que de la fecha de inicio')
                return false;
            }else{
                if(parseInt(mesIni) === parseInt(mesFin)){
                    if(parseInt(diaIni) > parseInt(diaFin)){
                        alert('La fecha de fin debe ser despues o a lo sumo el mismo dia que de la fecha de inicio');
                        return false;
                    }
                }
            }
        }
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
    x.open("POST","agregarPCarrito",true );
    x.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    //x.setRequestHeader("responseType","json");
    x.send("nombrePromocion="+promocion+"&nombreProveedor="+proveedor+"&cantidad="+cantidad+"&diaIni"+diaIni+"&mesIni"+mesIni+"&anioIni"+anioIni+"&diaFin"+diaFin+"&mesFin"+mesFin+"&anioFin"+anioFin);
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

function cambiarImagen(img){
    document.getElementById("imgGrande").src = img.src.replace("_t", "_b");
}

function busqueda(categoria){
    
    var cat = new String(categoria);
    
    $.post('busquedaSP', {
            categoria : cat
    }, function(responseText) {
            $('#tabla').html(responseText);
    });
    
    /*$.post('busquedaSP', function(data) {
                                $("#tabla").html(data)
                            });*/
    
    //var cat = new String(categoria);
    
    /*var x = new XMLHttpRequest();
    x.onreadystatechange = function(data){
        //Los status 200 y 4 indican que no hubo ningun problema
        if(this.status === 200 && this.readyState === 4){
            //document.getElementsByTagName('table').html(result);
            $("#table").html(data);
            console.log(this);
        }
    };
    x.open("POST","busquedaSP", true);
    x.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    //x.setRequestHeader("responseType","json");
    
    x.send("cat="+cat);*/
    
    /*
    $.ajax({ 
        type: "POST",
        url: "/busquedaSP",
        data: "categoria="+cat,
        success: function(result){
                    console.log("MIERDA");
                    if(result){
                        $('#tabla').html(result);
                    }
                }
        });*/
}

/*$('#linkIberia').click(function(){
    //busqueda('Iberia');
    return false;
});*/
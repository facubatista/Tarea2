function cambiarEstRes(objeto, objeto2){
    

    var accion = objeto.querySelector("input[id=accion]").value;
    var numero = objeto.querySelector("input[id=nroRes]").value;
    var estado = objeto.querySelector("input[id=estado]").value;

//
    var x = new XMLHttpRequest();
    x.onreadystatechange = function(){
        //Los status 200 y 4 indican que no hubo ningun problema
        if(this.status===200 && this.readyState ===4){
            console.log(this);
            
            if(estado === 'Cancelada')
                objeto2.getElementsByClassName("estadoRes")[0].innerHTML = "Cancelada";
            
            
            if(estado === 'Pagada')
                objeto2.getElementsByClassName("estadoRes")[0].innerHTML = "Pagada";
            
            document.getElementById("botonPagar").hidden = true;
            document.getElementById("botonCancelar").hidden = true;
//            objeto.querySelector("input[name=boton]").hidden = true;
            
            //objeto.querySelector("button[id=botonPagar]").hidden = true;
        }
    };
    
    x.open("POST","ServletReservas", true);
    x.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    x.send("Accion="+accion+"&nroReserva="+numero+"&estado="+estado);
//    
    return false;
}
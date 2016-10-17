jQuery(document).ready(function () {
    jQuery("#email").blur(function () {
        var mail = jQuery("#email").val();
        if (mail.indexOf("@") === -1 && mail.indexOf(".com") === -1)
            document.getElementById("email").value = "";
        var mail = jQuery("#email").val();
        var request = new XMLHttpRequest();
        request.onreadystatechange = function () {
            if (this.status === 200 && this.readyState === 4) {
                if (this.responseText === 'true' && mail.length !== 0) {
                    document.getElementById("errNick").style.display = 'block';
                    document.getElementById("botonRegistrar").style.display = 'none';
                } else {
                    document.getElementById("errNick").style.display = 'none';
                    document.getElementById("botonRegistrar").style.display = 'block';
                }
            }
            console.log(this);            
        };
        request.open("POST", "/Tarea2/ServUsuarios", true);
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.send("verificarUsuario=" + mail);
        return false;
    });
    jQuery("#nickname").blur(function () {
        var nick = jQuery("#nickname").val();
        var request = new XMLHttpRequest();
        request.onreadystatechange = function () {
            if (this.status === 200 && this.readyState === 4) {
                if (this.responseText === 'true' && nick.length !== 0) {
                    document.getElementById("errNick").style.display = 'block';
                    document.getElementById("botonRegistrar").style.display = 'none';
                } else {
                    document.getElementById("errNick").style.display = 'none';
                    document.getElementById("botonRegistrar").style.display = 'block';
                }
            }
        };
        request.open("POST", "/Tarea2/ServUsuarios", true);
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.send("verificarUsuario=" + nick);
        return false;
    });
    jQuery("#recontraseña").blur(function () {
        var recontra = jQuery("#recontraseña").val();
        var contra = jQuery("#contraseña").val();
        if (contra !== recontra && contra.length !== 0) {
            document.getElementById("errContra").style.display = 'block';
            document.getElementById("botonRegistrar").style.display = 'none';
        } else {
            document.getElementById("errContra").style.display = 'none';
            document.getElementById("botonRegistrar").style.display = 'initial';
        }
    });
    jQuery("#contraseña").blur(function () {
        var recontra = jQuery("#recontraseña").val();
        var contra = jQuery("#contraseña").val();
        if (contra !== recontra && recontra.length !== 0) {
            document.getElementById("errContra").style.display = 'block';
            document.getElementById("botonRegistrar").style.display = 'none';
        } else {
            document.getElementById("errContra").style.display = 'none';
            document.getElementById("botonRegistrar").style.display = 'initial';
        }
    });
    jQuery("#dia").blur(function () {
        var dia = jQuery("#dia").val();
        if (dia === '') {
            jQuery("#dia").val('');
        }
        if (isNaN(parseInt(dia))) {
            jQuery("#dia").val('');
        } else {
            var numero = parseInt(dia);
            if (numero >= 32) {
                document.getElementById("dia").value = "31";
            }
        }
    });
    jQuery("#dia").blur(function () {
        var dia = jQuery("#dia").val();
        var mes = jQuery("#mes").val();
        var anio = jQuery("#anio").val();
        if (isNaN(parseInt(dia))) {
            jQuery("#dia").val('');
        } else {
            var numero = parseInt(dia);
            if (numero >= 30) {
                if (numero === 31 && (mes === "Abril" || mes === "Junio" || mes === "Setiembre" || mes === "Noviembre")) {
                    document.getElementById("dia").value = "30";
                } else {
                    if (numero >= 29 && (mes === "Febrero")) {
                        if (parseInt(anio) && anio !== '') {
                            var valor = parseInt(anio);
                            if (numero >= 30 && mes === "Febrero")
                                document.getElementById("dia").value = "29";
                            if (valor % 4 !== 0) {
                                document.getElementById("dia").value = "28";
                            } else {
                                if ((valor % 100 === 0)) {
                                    if ((valor % 400 !== 0)) {
                                        document.getElementById("dia").value = "28";
                                    }
                                }
                            }
                        } else {
                            document.getElementById("dia").value = "29";
                        }
                    } else {
                        document.getElementById("dia").value = "31";
                    }

                }
            }
        }
    });
    jQuery("#mes").click(function () {
        var dia = jQuery("#dia").val();
        var mes = jQuery("#mes").val();
        var anio = jQuery("#anio").val();
        if (dia !== '') {
            var numero = parseInt(dia);
            if (numero >= 30) {
                if (numero === 31 && (mes === "Abril" || mes === "Junio" || mes === "Setiembre" || mes === "Noviembre")) {
                    document.getElementById("dia").value = "30";
                }
                if (numero >= 30 && (mes === "Febrero")) {
                    if (parseInt(anio) && anio !== '') {
                        var valor = parseInt(anio);
                        document.getElementById("dia").value = "29";
                        if (valor % 4 !== 0) {
                            document.getElementById("dia").value = "28";
                        } else {
                            if ((valor % 100 === 0)) {
                                if ((valor % 400 !== 0)) {
                                    document.getElementById("dia").value = "28";
                                }
                            }
                        }
                    } else {
                        document.getElementById("dia").value = "29";
                    }
                }
            }
        }
    });
    jQuery("#anio").blur(function () {
        var dia = jQuery("#dia").val();
        var mes = jQuery("#mes").val();
        var anio = jQuery("#anio").val();
        if (anio !== '' && dia !== '') {
            if (parseInt(anio)) {
                var numero = parseInt(dia);
                var valor = parseInt(anio);
                if (numero >= 30 && mes === "Febrero")
                    document.getElementById("dia").value = "29";
                if (numero === 29 && mes === "Febrero" && (valor % 4 !== 0)) {
                    document.getElementById("dia").value = "28";
                } else {
                    if ((valor % 100 === 0)) {
                        if ((valor % 400 !== 0)) {
                            document.getElementById("dia").value = "28";
                        }
                    }
                }
            }
        }
    });

    /*var x = document.getElementById("botonRegistrar");
    x.addEventListener("click", arreglos);
    function arreglos() {
        var contrasena = document.getElementById("contraseña").value;
        contrasena = sha1(contrasena);
        var nickname = document.getElementById("nickname").value;
        var nombre = document.getElementById("nombre").value;
        var apellido = document.getElementById("apellido").value;
        var email = document.getElementById("email").value;
        var dia = document.getElementById("dia").value;
        var anio = document.getElementById("anio").value;
        var mes = document.getElementById("mes").value;
        document.getElementById("contraseña").value = contrasena;
        document.getElementById("recontraseña").value = contrasena;
        var x = new XMLHttpRequest();
        x.open("POST", "/Tarea2/ServUsuarios", true);
        x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        x.send("Registrar=true&user=" + nickname + "&name=" + nombre + "&surname=" + apellido + "&email=" + email + "&pass=" + contrasena + "&day=" + dia + "&month=" + mes + "&year=" + anio);
        var imagenValor = document.getElementById("imagen").value;
        if (imagenValor !== "") {
            var inputFileImage = document.getElementById("imagen");
            var file = inputFileImage.files[0];
            var fr = new FileReader();
            fr.onload = function (e) {
    
                var archivo = e.target.result.toString();
                x.open("POST", "/Tarea2/ServUsuarios", true);
                x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                x.send("RImagen=true&nickname="+nickname+"&archivo=" + archivo);
                request.onreadystatechange = function () {
                    if (this.status === 200 && this.readyState === 4) {
                        alert(this.responseText);
                    }
                };
                /*
                 x.open("POST", "/Tarea2/ServUsuarios", true);
                 x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                 x.send("RImagen=true&user="+ nickname +"&archivo=" + e.target.result);
                
            };
            fr.readAsDataURL(file);
        }
        x.onreadystatechange = function () {
            if (this.status === 200 && this.readyState === 4) {
                x.close();
            }
        };
        
        
        
    }
    ;*/
    
});
       
       
function pruebaServlet(){
    
    var contrasena = document.getElementById("contraseña").value;
    contrasena = sha1(contrasena);
    var nickname = document.getElementById("nickname").value;
    var nombre = document.getElementById("nombre").value;
    var apellido = document.getElementById("apellido").value;
    var email = document.getElementById("email").value;
    var dia = document.getElementById("dia").value;
    var anio = document.getElementById("anio").value;
    var mes = document.getElementById("mes").value;
    
    
    var x = new XMLHttpRequest();
    x.onreadystatechange = function(){
        //Los status 200 y 4 indican que no hubo ningun problema
        if(this.status===200 && this.readyState ===4){
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
            
            console.log(this);
        }
    };
    
    x.open("POST","/Tarea2/ServUsuarios",true );
    
    x.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    
    //x.setRequestHeader("responseType","json");
    
    x.send("Registrar=true&user=" + nickname + "&name=" + nombre + "&surname=" + apellido + "&email=" + email + "&pass=" + contrasena + "&day=" + dia + "&month=" + mes + "&year=" + anio);
    
    return false;
}
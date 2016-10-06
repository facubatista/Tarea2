jQuery(document).ready(function () {
    jQuery("#email").blur(function () {
        var mail = jQuery("#email").val();
        var request = new XMLHttpRequest();
        request.onreadystatechange = function () {
            if (this.status === 200 && this.readyState === 4) {
                if (this.responseText === 'true' && mail.length !== 0) {
                    document.getElementById("errEmail").style.display = 'block';
                    document.getElementById("botonRegistrar").disabled = true;
                } else {
                    document.getElementById("errEmail").style.display = 'none';
                    document.getElementById("botonRegistrar").disabled = false;
                }
            }
        };
        request.open("POST", "../ServUsuarios", true);
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
                    document.getElementById("botonRegistrar").disabled = true;
                } else {
                    document.getElementById("errNick").style.display = 'none';
                    document.getElementById("botonRegistrar").disabled = false;
                }
            }
        };
        request.open("POST", "../ServUsuarios", true);
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
        
            
        var x = document.getElementById("botonRegistrar");
        x.addEventListener("click", arreglos);
//arreglar
        function arreglos() {
            var contrasena = document.getElementById("contraseña").value;
            contrasena.value = sha1(contrasena);
//            var imgVal = document.getElementById("imagen").value;
//            if (imgVal !== ""){
//                alert(imgVal);
//            }
            
        }
    });
});
       
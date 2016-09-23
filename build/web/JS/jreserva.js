jQuery(document).ready(function() {
    jQuery("#email").blur(function () {
        var mail = jQuery("#email").val();
        var request = new XMLHttpRequest();
        request.onreadystatechange = function () {
            if (this.status === 200 && this.readyState === 4) {
                if (this.responseText === 'true' && mail.length !== 0) {
                    document.getElementById("errEmail").style.display = 'block';
                    document.getElementById("botonRegistrar").disabled = true;
                } else {
                    document.getElementById("errEmail").style.display = 'none';ĺl
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
});
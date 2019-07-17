$(document).ready(function () {
    cargaComboSucursales();
});
function cargaComboSucursales() {
    var data = {pAccion: "Login", pNombre: "Sucursal"};
    $("#selSucursal").find('option').remove().end();
    $.ajax({
        type: "POST", //Metodo por el que se realiza la petición 
        url: "ControlLogin", //url del servlet al que apunta la petición
        contentType: "application/json", // NOT dataType!
        data: JSON.stringify(data),
        success: function (response) {
            if (!response['error']) {
                $.each(response, function (ind) {
                    $("#selSucursal").append("<option value=" + response[ind].id + ">" + response[ind].nombre + "</option>");
                });
            }
        }
    });
}
            
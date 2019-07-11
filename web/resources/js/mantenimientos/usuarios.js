$(document).ready(function () {
    $('#example').DataTable();
    OcultarPanel(0);

});//Document.ready

$(document).on('click', "#btnCancelarForm", function (e) {
    e.preventDefault();
    OcultarPanel(0);
    //limpiarCampos();
});
$(document).on('click', "#btnAgregar", function (e) {

    $("#tituloForm").text('Agregar Usuarios');
    $("#btnSubmit").attr('value', 'add');
    $("#btnSubmit").text('Agregar');

   MostrarPanel();
   //limpiarCampos();
});

function MostrarPanel() {
    $(".Val-Table").hide("fast");
    //$(".Val-Search").slideUp("fast");
    $(".Val-Add-Pa").show("fast");
    $("#btnAgregar").addClass('disabled');
}

function OcultarPanel(accion) {
    $(".Val-Add-Pa").slideUp("fast");
   // $(".Val-Search").delay(300).slideDown("slow");
    $("#btnAgregar").removeClass('disabled');
    if (accion === 0) {
        $(".Val-Table").show("fast");
    }
}
function cargaComboSucursales() {
    var data = { pAccion: "Login", pNombre: "Sucursal" };
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


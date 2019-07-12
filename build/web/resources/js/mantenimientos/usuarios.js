var idRow;
var tabla = "";
$(document).ready(function () {

    OcultarPanel(0);
    cargarTabla();
    //$('#example').DataTable();

});//Document.ready

$(document).on('click', '#btnSubmit', function (e) {
    e.preventDefault();
    if ($(this).attr('value') == 'mod') {
        agregar();
       // swal('Atención', "Modificar Registro?", 'question');
    }
    else if ($(this).attr('value') == 'add') {
        modificar();
       // swal('Atención', "¿Agregar Registro?", 'Agregar');
    }
});

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
    cargaComboSucursales();
    //limpiarCampos();
});

$(document).on('click', '#btnModificar', function () {
    //Muestro el formulario de modificar
    MostrarPanel();
    cargaComboSucursales();

    //obtengo los datos de la tabla con la variable 'tabla' antes creada
    var data = tabla.row($(this).parent().parent().parent()).data();
    /*console.log(data["nombre"]);

    $("#txtNombre").val(data["nombre"]), 
    $("#txtApellido").val(data["apellido"]),
    $("#txtUsuario").val(data["usuario"]),
    $("#txtRol").val("rol")
*/
    $("#btnSubmit").attr('value', 'mod');
    $("#btnSubmit").text('Modificar');
  //  $("#tituloForm").parent().parent().removeClass('box-primary').addClass('box-success');
    $("#tituloForm").text('Modificar Usuarioas');;
   // idRow = data["id"];
    //escondo todo lo que tenga que ver con la tabla
});

function MostrarPanel() {
    $(".Val-Table").hide("fast");
    $(".Val-Search").hide("fast");
    $(".Val-Add-Pa").show("fast");
    $("#btnAgregar").addClass('disabled');
}

function OcultarPanel(accion) {
    $(".Val-Add-Pa").hide("fast");
    $(".Val-Search").delay(300).slideDown("slow");
    $("#btnAgregar").removeClass('disabled');
    if (accion === 0) {
        $(".Val-Table").show("fast");
    }
}
function cargaComboSucursales() {
    var data = {pAccion: "Login", pNombre: "Sucursal"};
    $("#selSucursal").find('option').remove().end();
    $.ajax({
        type: "POST", //Metodo por el que se realiza la petición 
        url: "../../ControlLogin", //url del servlet al que apunta la petición
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
function cargarTabla() {
    var data = {pAccion: "SELECT"};
    $.ajax({
        type: "POST", //Metodo por el que se realiza la petición 
        url: "../../ControlUsuario", //url del servlet al que apunta la petición
        contentType: "application/json", // NOT dataType!
        data: JSON.stringify(data),
        success: function (response) {
            if (!response['error']) {
                tabla = $('#example').DataTable({
                    data: response,
                    columns: [
                        {data: null, "defaultContent": "<div class='row ValAcc'><div class='col-xs-12 Val-UDP'><a class='btn btn-info btn-sm' id='btnModificar'> <span class='glyphicon glyphicon-wrench'></span></a> <a class='btn btn-danger btn-sm' id='btnEliminar'><span class='glyphicon glyphicon-remove'></span></a>   </div></div>"},
                        {data: 'id'},
                        {data: 'nombre'},
                        {data: 'apellido'},
                        {data: 'username'},
                        {data: 'rol'}
                    ]
                });
            }
        }
    });
}
function agregar(){
    var data = {
        pAccion: "INSERT", 
        pNombre: $("#txtNombre").val(), 
        pApellido: $("#txtApellido").val(),
        pSucursal: $("#selSucursal").val(),
        pUsuario: $("#txtUsuario").val(),
        pContra: $("#txtContra").val(),
        pRol:$("#txtRol").val()
    };
    $("#selSucursal").find('option').remove().end();
    $.ajax({
        type: "POST", //Metodo por el que se realiza la petición 
        url: "../../ControlUsuario", //url del servlet al que apunta la petición
        contentType: "application/json", // NOT dataType!
        data: JSON.stringify(data),
        success: function (response) {
            if (!response['error']) {
               
            }
        }
    });
}
function modificar(){
    var data = {
        
        pAccion: "INSERT", 
        Pid: idRow,
        pNombre: $("#txtNombre").val(), 
        pApellido: $("#txtApellido").val(),
        pSucursal: $("#selSucursal").val(),
        pUsuario: $("#txtUsuario").val(),
        pContra: $("#txtContra").val(),
        pRol:$("#txtRol").val()
    };
    $("#selSucursal").find('option').remove().end();
    $.ajax({
        type: "POST", //Metodo por el que se realiza la petición 
        url: "../../ControlLogin", //url del servlet al que apunta la petición
        contentType: "application/json", // NOT dataType!
        data: JSON.stringify(data),
        success: function (response) {
            if (!response['error']) {
               
            }
        }
    });
}




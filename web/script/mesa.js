$(document).ready(function () {
    //cargaMesas();
});//
function cargaMesas(){
    var data = {pAccion: "listaMesa"};
    $.ajax({
        type: "POST", //Metodo por el que se realiza la petición 
        url: "../CMesa.do", //url del servlet al que apunta la petición
        contentType: "application/json", // NOT dataType!
        data: JSON.stringify(data),
        success: function (response) {
            if (!response['error']) {
                $.each(response, function (ind) {
                    $("#contenMesas").append(" <div class='col-md-4'> <div class='box box-primary'> <div class='box-header with-border'><i class='fa fa-bar-chart-o'></i> <h3 class='box-title'>"+ response[ind].id + "</h3><div class='box-tools pull-right'> <button type='button' class='btn btn-box-tool' data-widget='collapse'><i class='fa fa-minus'></i> </button> </div></div> <div class='box-body' style='display: none;'>  <a class='btn btn-warning'  href='../CMesas.do?pAccion=cancela&id=+response[ind].id+'>Canselar</a> <a class='btn btn-primary pull-right'  href='../CMesas.do?pAccion=new&id=+response[ind].id+'>Nueva Cuenta</a> <a class='btn btn-info pull-right'  href='../CMesas.do?pAccion=add&id=+response[ind].id+'>Agregar</a> <div id='area-chart' style='height: 50px; padding: 0px; position: relative;' class='full-width-chart'><canvas class='flot-base' width='100' height='355'></canvas><canvas class='flot-overlay' width='575' height='338'></canvas></div> </div> </div> </div> ");
                });
            }
        }
    });
}
var pedido = [];
var nuevoPedido = []
 

$("#selMesa").change(function() {
    cargaMesa($("#selMesa").val());
  });

$("#selCategoria").change(function() {
  cargaproductos($("#selCategoria").val());
});


function cargarPedido(idMesa){


}
function agregarPedido(id,nombre,imagen){
    nuevoPedido.push[[id,nombre,imagen]];
}

function cargaMesa(idMesa) {
    var data = {pAccion: "ListarMesa", pId: idMesa};
    $("#mesas").find('tr').remove().end();
    $.ajax({
        type: "POST", 
        url: "../ControlCuenta.do", 
        contentType:"application/json; charset=utf-8", 
        dataType: "json",
        data: JSON.stringify(data),
        success: function (response) {
                $.each(response, function (ind) {
                    $("#mesas").append("<tr><td> <div class='info-box'> <span class='info-box-icon bg-green'></span> <div class='info-box-content'> <span class='info-box-number'>"+response[ind].nombre+"</span> <span class='info-box-text'>"+response[ind].estado+"</span> </div> </div> </td></tr>");
                });
        }
    });   
}

function cargaproductos(idCategoia) {
    var data = {pAccion: "listProducto", pId: idCategoia};
    $("#productos").find('tr').remove().end();
    $.ajax({
        type: "POST", //Metodo por el que se realiza la petición 
        url: "../ControlCuenta.do", //url del servlet al que apunta la petición
        contentType:"application/json; charset=utf-8", // NOT dataType!
        dataType: "json",
        data: JSON.stringify(data),
        success: function (response) {
                $.each(response, function (ind) {
                    $("#productos").append("<tr> <td> <img width='40' height='40' src='../resources/img/icons/comida/1455739559_Kitchen_Bold_Line_Color_Mix-32_icon-icons.com_53429.png'></td> <td><h4>"+response[ind].nombre+"</h4></td> <td> <div class='product-quantity pull-right'> <input type='number' value='1' min='1'> </div> </td> <td> <input type='button' onclick='addCueta(response[ind])' class='btn btn-success pull-right' value='Agregar'  /> </td> </tr>");
                });
        }
    });
   
}
function sumar(imput,cantidad){
    num = parseInt(cantidad);
    var suma = num + 1; 
    $(imput).val(suma);

}

var pedido = [];
var nuevoPedido = [];
var producto =[];
var mesaActiva = 0;
var fechaHoy;
 
window.onload = function () {
    var fecha = new Date(); //Fecha actual
    var mes = fecha.getMonth() + 1; //obteniendo mes
    var dia = fecha.getDate(); //obteniendo dia
    var ano = fecha.getFullYear(); //obteniendo año
    if (dia < 10)
        dia = '0' + dia;
    if (mes < 10)
        mes = '0' + mes 
    fechaHoy = ano +"-"+mes+"-"+dia;
}

$("#selMesa").change(function() {
    cargaMesa($("#selMesa").val());
  });

$("#selCategoria").change(function() {
  cargaproductos($("#selCategoria").val());
});

function addPedido(id){
    if(mesaActiva != 0){
        for (var i = 0; i < producto.length; i++) {
            if(producto[i][0] == id){
                nuevoPedido.push([producto[i][0],producto[i][1],producto[i][2],$("#catida"+id).val(),mesaActiva]);
            }
        }
        mostraPedido();
    }else{
        alert("SELECCIONE UNA MESA ")
    }
  
}


function mostraPedido(){
    $("#pedido").find('tr').remove().end();
    for (var i = 0; i < nuevoPedido.length; i++) {
        $("#pedido").append("<tr><td>"+nuevoPedido[i][2]+"</td><td>"+nuevoPedido[i][3]+"</td><td> "+nuevoPedido[i][1]+"</td> </tr> ");
    }
}
function insertPedido(mesa,usuario){
    var data = {pAccion: "addPedido", pMesa: mesa, pUsurio: usuario, pFecha: fechaHoy};
    $.ajax({
        type: "POST", 
        url: "../ControlCuenta.do", 
        contentType:"application/json; charset=utf-8", 
        dataType: "json",
        data: JSON.stringify(data),
        success: function (response) {
            for (var i = 0; i < nuevoPedido.length; i++) {
                console.log(nuevoPedido[i]);
                insertarPedidoDetalle(); 
               // $("#pedido").append("<tr><td>"+nuevoPedido[i][2]+"</td><td>"+nuevoPedido[i][3]+"</td><td> "+nuevoPedido[i][1]+"</td> </tr> ");
            }
             
        }
    }); 
}
function insertarPedidoDetalle(idPedido,descripcion, idProducto, estado, cantidad, total){
    
    var data = {pAccion: "addPedidoDetalle", pPedido: idPedido, pDescripcion: descripcion, pProducto: idProducto, pEstado: estado, pCantidad: cantidad, pTotoal: total};
    $.ajax({
        type: "POST", 
        url: "../ControlCuenta.do", 
        contentType:"application/json; charset=utf-8", 
        dataType: "json",
        data: JSON.stringify(data),
        success: function (response) {
               
        }
    }); 
}


function updatePedidoDetalle(idPedido,descripcion, idProducto, estado, cantidad, total){
    var data = {pAccion: "updPedidoDetalle", pPedido: idPedido, pDescripcion: descripcion, pProducto: idProducto, pEstado: estado, pCantidad: cantidad, pTotoal: total};
    $.ajax({
        type: "POST", 
        url: "../ControlCuenta.do", 
        contentType:"application/json; charset=utf-8", 
        dataType: "json",
        data: JSON.stringify(data),
        success: function (response) {
               
        }
    }); 
}



function cargaMesa(idMesa) {
    nuevoPedido = [];
    mostraPedido();
    mesaActiva = idMesa;
    $("#btnAddPedido").val(idMesa);
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
                    producto.push([response[ind].id,response[ind].nombre,response[ind].imagen]);
                    $("#productos").append("<tr> <td> <img width='40' height='40' src='../resources/img/icons/comida/1455739559_Kitchen_Bold_Line_Color_Mix-32_icon-icons.com_53429.png'></td> <td><h4>"+response[ind].nombre+"</h4></td> <td> <div class='product-quantity pull-right'> <input id='catida"+response[ind].id+"' type='number' value='1' min='1'> </div> </td> <td> <input type='button' onclick='addPedido("+response[ind].id+");' class='btn btn-success pull-right' value='Agregar'  /> </td> </tr> ");
                });
        }
    });
}
function sumar(imput,cantidad){
    num = parseInt(cantidad);
    var suma = num + 1; 
    $(imput).val(suma);

}

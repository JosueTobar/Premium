$(document).on('click', "#btnBuscarMesa", function (e) {
    buscarMesa();
   
});
function buscarPedido(idPedido,idmesa,elemet){
    console.log(idPedido);
    console.log(idmesa);
    console.log(elemet);
    var data = {pAccion: "listarPedidoA", pId: idPedido};
    $.ajax({
        type: "POST", 
        async: false,
        url: "../ControlCuenta.do", 
        contentType:"application/json; charset=utf-8", 
        dataType: "json",
        data: JSON.stringify(data),
        success: function (response) {
               $.each(response, function (ind) {
                console.log(response[ind]);
                $("#"+elemet).append("<tr><td>"+response[ind][1]+"</td><td>"+response[ind][5]+"</td></tr>");
            });
        }
    }); 
}
function buscarMesa(){
    var data = {pAccion: "listarMesaA"};
    $("#contenedorPedidos").find('div').remove().end();
    $.ajax({
        type: "POST", 
        url: "../ControlCuenta.do", 
        contentType:"application/json; charset=utf-8", 
        dataType: "json",
        data: JSON.stringify(data),
        success: function (response) {
               console.log(response);
               $.each(response, function (ind) {
                $("#contenedorPedidos").append("<div class='col-lg-3'><div class='box box-primary'><div class='box-header with-border'><h3 class='box-title' id='tituloForm'>Mesa "+response[ind][1]+" </h3> </div><div class='box-body'> <div class='contenedorP'><table class='table'> <tbody id='pedido"+ind+"'></tbody></table></div> </div> <div class='box-footer'><button class='btn btn-danger pull-right' id='btnAddPedido'>Enviar</button> <input type='text' id='txtUpdMesa"+ind+"' value='"+response[ind][0]+"' style='display: none' ></div></div></div>");
                buscarPedido(response[ind][0],response[ind][1],'pedido'+ind);
            });
        }
    }); 
}
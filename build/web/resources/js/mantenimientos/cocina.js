function buscarPedido(idPedido){
    var data = {pAccion: "listarPedidoA", pId: idPedido};
    $.ajax({
        type: "POST", 
        url: "../ControlCuenta.do", 
        contentType:"application/json; charset=utf-8", 
        dataType: "json",
        data: JSON.stringify(data),
        success: function (response) {
               console.log(response);
        }
    }); 
}
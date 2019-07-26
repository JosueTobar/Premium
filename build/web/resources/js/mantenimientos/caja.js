$(document).ready(function () { 

    buscarCuentas();

});
function buscarCuentas(){
    var data = {pAccion: "ListarCuentas"};
    $("#tablaC").find('tr').remove().end();
    $.ajax({
        type: "POST", 
        async: false,
        url: "../ControlCuenta.do", 
        contentType:"application/json; charset=utf-8", 
        dataType: "json",
        data: JSON.stringify(data),
        success: function (response) {
               $.each(response, function (ind) {
          
                $("#tablaC").append("<tr><td><a href='../pdf/factura.jsp?id="+response[ind][0]+"'> FACTURAR </a> </td> <td>"+response[ind][0]+"</td> <td>"+response[ind][1]+"</td><td>"+response[ind][2]+"</td></tr>");
            });
        }
    }); 
}
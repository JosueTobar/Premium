function cargarform(id,nombre,apellido,usuario,rol,estado){
    $("#txtApellido").val(apellido);
    $("#txtNombre").val(nombre);
    $("#txtUser").val(usuario);
    $("#selTipo").val(rol);
    $("#selEstado").val(estado);
    $("#Id").val(id);
}        
$('.input-number').on('input', function () { 
    this.value = this.value.replace(/[^0-9]/g,'');
});
       
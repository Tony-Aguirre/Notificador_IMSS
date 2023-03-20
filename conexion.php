<?php
    try{
        $conexion = mysqli_connect("localhost","root","","notificador_imss");
    }catch(\Exeption $e){
        throw $e;
    }
?>

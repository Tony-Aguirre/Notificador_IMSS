<?php
    try{
        $conexion = mysqli_connect("localhost","root","","notificador_imss");
        if($conexion){
            echo "<script> alert('Conexion exitosa.');</script>";
        }
    }catch(\Exeption $e){
        throw $e;
    }
?>

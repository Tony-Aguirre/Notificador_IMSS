<?php
    include 'conexion.php';
    $matricula=$_POST['matricula'];
    $password=$_POST['password'];
    $sentencia=$conexion->prepare("SELECT * FROM constancias WHERE matricula=? AND password=?");
    $sentencia->bind_param('ss',$matricula,$password);
    $sentencia->execute();
    $resultado = $sentencia->get_result();
    if($fila = $resultado->fetch_assoc()){
        echo json_encode($fila,JSON_UNESCAPED_UNICODE);
    }
    $sentencia->close();
    $conexion->close();
?>

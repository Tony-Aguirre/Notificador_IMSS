<?php
    include 'conexion.php';
    $matricula=$_GET['matricula'];
    $consulta = "SELECT * FROM constancias WHERE '$matricula'=matricula";
    $resultado = $conexion -> query($consulta);
    while($fila = $resultado -> fetch_array()){
        $registro[] = array_map('utf8_encode',$fila);
    }
    echo json_encode($registro);
    $resultado -> close();
?>

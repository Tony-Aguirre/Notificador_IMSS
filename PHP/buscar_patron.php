<?php
    include 'conexion.php';
    $asignacion = $_GET['asignacion'];
    $consulta = "SELECT * FROM registo_patronal WHERE '$asignacion'";
    $resultado = $conexion -> query($consulta);
    while($fila = $resultado -> fetch_array()){
        $registro[] = array_map('utf8_encode',$fila);
    }
    echo json_encode($registro);
    $resultado -> close();
?>

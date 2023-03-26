<?php
    include 'conexion.php';
    $registro_patronal = $_GET['registro_patronal'];
    $consulta = "SELECT * FROM registo_patronal WHERE '$registro_patronal'=registro_patronal";
    $resultado = $conexion -> query($consulta);
    while($fila = $resultado -> fetch_array()){
        $registro[] = array_map('utf8_encode',$fila);
    }
    echo json_encode($registro);
    $resultado -> close();

?>

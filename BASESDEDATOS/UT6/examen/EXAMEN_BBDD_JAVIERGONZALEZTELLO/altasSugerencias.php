<?php
// Recuperamos valores del formulario
include("conexion_bd.php");
session_start();
$usuario = $_SESSION['usuario'];
$sugerencia = $_POST['sugerencias'];

// echo $usuario;
// echo $sugerencia;
// $hoy = "hola"

// // consulta sql
$sql="INSERT INTO sugerencias (usuario, descripcion, fecha) VALUES ($usuario, $sugerencia, CURDATE())";
mysql_query($sql) or die(mysql_error());
mysql_close($conexion);
header("location:tienda.php");
?>






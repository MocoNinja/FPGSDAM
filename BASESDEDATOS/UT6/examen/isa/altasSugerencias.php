<?php
// Recuperamos valores del formulario
session_start();
$sug=$_GET['sugerencias'];
$usu=$_SESSION['usuario'];
print($usu);
include("conexion_bd.php");

// consulta sql
$sql="INSERT INTO sugerencias(usuario, descripcion, fecha) VALUES ('$usu', '$sug', now())";
mysql_query($sql) or die(mysql_error());

mysql_close($conexion);
header("location:tienda.php");
?>
<?php
session_start();
$us=$_SESSION['usuario'];
$pr=$_GET['ref'];

include("conexion_bd.php");

// consulta sql
$sql="INSERT INTO compras(comprador, idProducto, fecha, cantidad) VALUES ('$us', $pr, now(), 1)";
mysql_query($sql) or die(mysql_error());

mysql_close($conexion);
header("location:tienda.php");
?>








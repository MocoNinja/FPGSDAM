<?php
// Recuperamos valores del formulario

session_start();
include("conexion_bd.php");
$usu=$_SESSION['usuario'];
// consulta sql
$sql="DELETE FROM compras WHERE comprador = '$usu'";
mysql_query($sql) or die(mysql_error());

mysql_close($conexion);
header("location:verCarrito.php");
?>








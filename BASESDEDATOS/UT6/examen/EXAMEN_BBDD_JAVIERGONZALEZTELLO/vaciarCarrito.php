<?php
include("conexion_bd.php");
session_start();
$usuario = $_SESSION['usuario'];
$sql="DELETE FROM compras WHERE comprador = '$usuario'";
mysql_query($sql) or die(mysql_error());

mysql_close($conexion);
header("location:tienda.php");
?>



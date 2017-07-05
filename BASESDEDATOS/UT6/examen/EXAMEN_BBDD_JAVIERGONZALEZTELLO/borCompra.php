<?php
session_start();
if(!isset($_SESSION['usuario']))
    header("location:index.php");

// Recuperamos valores string
$id=$_GET['pro'];

include("conexion_bd.php");

// consulta sql
$sql="DELETE FROM compras WHERE idCompra=$id";
mysql_query($sql) or die("Error en la consulta $sql <br> <a href='verCarrito.php'>Pulse aqui para continuar</a>");

mysql_close($conexion);
header("location:verCarrito.php");
?>








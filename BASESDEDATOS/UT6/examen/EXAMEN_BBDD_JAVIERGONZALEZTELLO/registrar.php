<?php
include("conexion_bd.php");
session_start();
$fn=$_POST['full_name'];
$us=$_POST['user'];
$ps=MD5($_POST['pass']);
$ma=$_POST['mail'];
$ph=$_POST['phone'];
$idPais = $_POST['pais'];
$sql="INSERT INTO usuarios (usuario, password, nombreCompleto, email, telefono, idpais) VALUES ('$us', '$ps', '$fn', '$ma', '$ph', '$idPais')";
mysql_query($sql) or die(mysql_error());
mysql_close($conexion);
header("location:index.php");
?>








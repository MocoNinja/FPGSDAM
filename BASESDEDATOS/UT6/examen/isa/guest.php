<?php
session_start();
// Recuperar informacion del formulario
$usu = 'invitado';

include("conexion_bd.php");


$_SESSION['usuario'] = $usu;
header("location:tienda.php");


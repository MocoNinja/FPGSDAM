<?php
session_start();
// Recuperar informacion del formulario
$usu = $_POST['login-username'];
$cla = $_POST['login-password'];

include("conexion_bd.php");

//consulta sql
$sql="SELECT * FROM usuarios WHERE usuario='$usu'";
$registros=mysql_query($sql);
$total = mysql_num_rows($registros);
if ($total==0)
{
	header("location:index.php?error=1");
}
else
{
	$linea=mysql_fetch_array($registros);
	if($linea['password']!=$cla)
	{
		header("location:index.php?error=2");
	}
	else
	{
		$sql="UPDATE usuarios SET fechaultimoacceso=now() WHERE usuario='$usu'";
		mysql_query($sql);
		$_SESSION['usuario'] =$usu;
		header("location:tienda.php");
	}
}





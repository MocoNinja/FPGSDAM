<?php
include("conexion.php");
session_start();

$username = $_POST['username'];
$password = $_POST['password'];

$sql = "SELECT * FROM Usuarios WHERE username = '$username'";
$registros = mysqli_query($conexion,$sql);
$total = mysqli_num_rows($registros);
if($total == 0)
{
	header("location:index.php");
	$_SESSION['fallo'] = "user";
}
else
{
	while($linea=mysqli_fetch_array($registros))
	{
		if($linea['password'] == $password)
		{
			$_SESSION['username'] = $linea['username'];
			$_SESSION['nombre'] = $linea['nombre'];
			$_SESSION['rol'] = $linea['rol'];
			$_SESSION["fallo"] = "ninguno";
			header("location:principal.php");
		}
		else
		{
			header("location:index.php");
			$_SESSION['fallo'] = "pass";
		}
	}
}
?>

<?php
include("conexion.php");
$cla=$_GET['clave'];
$sql="DELETE FROM empresas WHERE nif='$cla'";
mysqli_query($conexion,$sql) or die("Error en el borrado");
mysqli_close($conexion);
header("location:verempresas.php");

?>

<?php
// Recuperamos datos del formulario
$estudio=$_POST['estudio'];
$pun=$_POST['puntualidad'];
// conectamos con la BD
include("conexion.php");
// creamos consulta
$sql="INSERT INTO estudios(estudio) VALUES('$estudio')";
// ejecutamos la consulta
mysqli_query($conexion,$sql) or die("Error en la consulta de inserci�n $sql");
// cerramos la conexion
mysqli_close($conexion);
// redirigimos a la pagina inicial
header("location:verestudios.php");
?>

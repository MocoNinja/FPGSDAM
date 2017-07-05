<?php
// Recuperamos datos del formulario
$dni=$_POST['dni'];
$clave=$_POST['clave'];
$nombre=$_POST['nombre'];
$email=$_POST['email'];
$telefono=$_POST['telefono'];
// conectamos con la BD
include("conexion.php");
// creamos consulta
$sql="INSERT INTO usuarios(dni, clave, nombre, email, telefono) VALUES('$estudio', '$clave', '$nombre', '$email', '$telefono')";
// ejecutamos la consulta
mysqli_query($conexion,$sql) or die("Error en la consulta de inserci�n $sql");
// cerramos la conexion
mysqli_close($conexion);
// redirigimos a la pagina inicial
header("location:verusuarios.php");
?>

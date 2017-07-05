<?php
// Recuperamos datos del formulario
$nif=$_POST['nif'];
$nom=$_POST['nombre'];
$tel=$_POST['telefono'];
$cor=$_POST['correo'];
$dir=$_POST['direccion'];
$dni=$_POST['dni'];
// conectamos con la BD
include("conexion.php");
// creamos consulta
$sql="INSERT INTO empresas(nif,empresa, direccion, email, telefono, dniusuario) VALUES ('$nif','$nom','$cor','$tel','$dir', '$dni')";
// ejecutamos la consulta
mysqli_query($conexion,$sql) or die("Error en la consulta de inserci�n $sql");
// cerramos la conexion
mysqli_close($conexion);
// redirigimos a la pagina inicial
header("location:formempresas.php");
?>

<?php
// Recuperamos datos del formulario
$dni=$_POST['dni'];
$nom=$_POST['nombre'];
$tel=$_POST['telefono'];
$cor=$_POST['correo'];
$est=$_POST['estudios'];
$emp=$_POST['empresa'];
// conectamos con la BD
include("conexion.php");
// creamos consulta
$sql="INSERT INTO alumnos(dni,alumno,email,telefono,nifempresa,idestudios) VALUES ('$dni','$nom','$cor','$tel','$emp',$est)";
// ejecutamos la consulta
mysqli_query($conexion,$sql) or die("Error en la consulta de inserción $sql");
// cerramos la conexion
mysqli_close($conexion);
// redirigimos a la pagina inicial
header("location:formalumnos.php");
?>

<?php
  $nombre = $_POST['nombre'];
  $antiguo = $_POST['antiguo'];

  // echo "$nombre, $apellidos, $rol, $username, $password";
  include('conexion.php');
  $sql="INSERT INTO Ubicaciones(nombre,nombreAntiguo) VALUES ('$nombre','$antiguo')";
mysqli_query($conexion,$sql) or die("Error en la consulta de inserción $sql");
// cerramos la conexion
mysqli_close($conexion);
// redirigimos a la pagina inicial
header("location:ubicaciones.php");
?>
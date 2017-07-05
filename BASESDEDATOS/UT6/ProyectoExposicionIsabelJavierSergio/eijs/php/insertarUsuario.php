<?php
  $nombre = $_POST['nombre'];
  $apellidos = $_POST['apellidos'];
  $rol = $_POST['rol'];
  $username = $_POST['username'];
  $password = $_POST['password'];

  // echo "$nombre, $apellidos, $rol, $username, $password";
  include('conexion.php');
  $sql="INSERT INTO Usuarios(nombre,apellidos,rol,username,password) VALUES ('$nombre','$apellidos','$rol','$username','$password')";
mysqli_query($conexion,$sql) or die("Error en la consulta de inserción $sql");
// cerramos la conexion
mysqli_close($conexion);
// redirigimos a la pagina inicial
header("location:usuarios.php");
?>
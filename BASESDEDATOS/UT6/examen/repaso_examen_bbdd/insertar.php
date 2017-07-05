<?php
  include('conexion.php');
  if($_SESSION['estado'] != 'login') header("location:index.html");
  $nombre = $_POST['nombre'];
  $habilidad = $_POST['habilidad'];
  $sql = "INSERT INTO gente (nombre, habilidad) VALUES ('$nombre', '$habilidad')";
  mysqli_query($conexion,$sql) or die("Error en la consulta de inserción $sql");
  mysqli_close($conexion);
  header("location:ver.php");
?>
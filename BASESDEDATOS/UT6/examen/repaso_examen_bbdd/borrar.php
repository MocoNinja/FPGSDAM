<?php
  include('conexion.php');
  if($_SESSION['estado'] != 'login') header("location:index.html");
  $id = $_GET['id'];
  $sql="DELETE FROM gente WHERE idUsuario=$id";
  mysqli_query($conexion,$sql) or die("Error en el borrado");
  mysqli_close($conexion);
  header("location:ver.php");
?>
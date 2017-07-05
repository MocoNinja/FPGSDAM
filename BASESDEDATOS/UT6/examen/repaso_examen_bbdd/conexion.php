<?php
  $conexion = mysqli_connect("localhost","root","","prueba") or die("Error en la conexion con la Base de datos");
  session_start();
  if (empty($_SESSION['estado'])) $_SESSION['estado'] = 'vacío';
?>
<?php
  include('conexion.php');
  if($_SESSION['estado'] != 'login') header("location:index.html");
  $rol = $_SESSION['rol'];
  $nombre = $_SESSION['nombre'];
  echo "Bienvenido, ".$nombre."(".$rol.")";
  echo "                                                                                            ";
  $logout = "<a href='logout.php'>Logout</a>";
  echo $logout;
  $ver = "<a href='ver.php'>Ver</a>";
  echo "<br/><br/>";
  echo $ver;
  if ($rol == 'admin'){
    $meter = "<a href='meter.php'>Meter</a>";
    echo "<br/><br/>";
    echo $meter;
  }
?>
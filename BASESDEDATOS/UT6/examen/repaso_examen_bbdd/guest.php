<?php
  include('conexion.php');
  $nombre = $_POST['nombre'];
  $password = $_POST['password'];
  // echo "Nombre: ".$nombre." Password: ".$password;
  $sql1 = "SELECT * FROM usuarios";
  $registros=mysqli_query($conexion,$sql1);
  $_SESSION['estado'] = "no existe usuario";
  while ($linea=mysqli_fetch_array($registros)){
    if ($nombre  == $linea['user']){
      if ($password == $linea['password']){
        $_SESSION['estado'] = "login";
        $_SESSION['rol'] = $linea['rol'];
        $_SESSION['nombre'] = $nombre;
        break;
      } else{
        $_SESSION['estado'] = "contraseña incorrecta";
      }
    }
  }
  mysqli_close($conexion);
  if ($_SESSION['estado'] == "login"){
    header("location:menu.php");
  }
  else{
    header("location:index.php");
  }
?>
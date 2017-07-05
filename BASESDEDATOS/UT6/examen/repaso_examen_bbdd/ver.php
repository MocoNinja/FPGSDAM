<?php
  include('conexion.php');
  if($_SESSION['estado'] != 'login') header("location:index.html");
  $rol = $_SESSION['rol'];
  $volver = "<a href='menu.php'>volver</a>";
  echo $volver;
  echo "<h2>Miembros registrados</h2>";
  echo "<table><tr><th>Nombre</th><th>Habilidad</th><th>Borrar</th></tr>";
  $sql1 = "SELECT * FROM gente";
  $registros=mysqli_query($conexion,$sql1);
  while ($linea=mysqli_fetch_array($registros)){
    $nombre = $linea['nombre'];
    $habilidad = $linea['habilidad'];
    $id = $linea['idUsuario'];
    echo "<tr><td>".$nombre."</td><td>".$habilidad."</td><td>"."<a href='borrar.php?id=".$id."'>Borrar</a>"."</td></tr>";
  }
  mysqli_close($conexion);
?>
<?php
  include('conexion.php');
  if($_SESSION['estado'] != 'login') header("location:index.html");
?>

<!DOCTYPE html>
<html>
  <head>
    <title></title>
    <meta charset="UTF-8">
  </head>
  <body>
  <form method="POST" action="insertar.php">
    <?php
      $volver = "<a href='menu.php'>volver</a>";
  echo $volver;
  ?>
    <table>
      <tr>
        <td>Nombre de usuario: </td>
        <td><input type="text" name="nombre"></td>
      </tr>
      <tr>
        <td>Contraseña: </td>
        <td>
        <select name="habilidad">
        <option value="Alto">Alto</option>
        <option value="Medio">Medio</option>
        <option value="Bajo">Bajo</option>
        </select>
        </td>
      </tr>
      <tr>
        <td><input type="submit" name="enviar" value="enviar"></td>
      </tr>
    </table>
  </form>
  </body>
</html>
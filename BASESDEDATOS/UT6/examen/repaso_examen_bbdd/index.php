<!DOCTYPE html>
<html>
  <head>
    <title>Login</title>
    <meta charset="UTF-8">
  </head>
  <body>
  <div>
    <?php
    include('conexion.php');
    $estado = $_SESSION['estado'];
    if ($estado != 'login' && $estado != 'vacío') echo $estado."<br/><br/>";
    ?>
  </div>
  <form method="POST" action="login.php">
    <table>
      <tr>
        <td>Nombre de usuario: </td>
        <td><input type="text" name="nombre"></td>
      </tr>
      <tr>
        <td>Contraseña: </td>
        <td><input type="password" name="password"></td>
      </tr>
      <tr>
        <td><input type="submit" name="enviar" value="enviar"></td>
      </tr>
    </table>
  </form>
  </body>
</html>
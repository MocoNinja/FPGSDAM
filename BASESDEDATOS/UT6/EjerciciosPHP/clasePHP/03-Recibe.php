<!DOCTYPE html>
<html lang="en">
    <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
    <?php
      // Recuperar los parámetros -> Hacen falta variables
      $cat = $_GET['cat'];
      $mod = $_GET['mod'];
      $cli = $_GET['cli'];
      echo "La categoría es $cat, el modelo es $mod y el cliente es $cli";
      // Pueden presentarse directamente los valores de los parámetros (y con el método alternativo de la concatenación con comillas ya visto)
      echo "<br>La categoría es $_GET[cat], el modelo es $_GET[mod] y el cliente es $_GET[cli]";
    ?>
    </body>
</html>
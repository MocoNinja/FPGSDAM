<html>
  <head>
    <title>Probando, bando bando bando</title>
    <style type="text/css">
      body
      {
        text-align: center;
        color: #ffeeee;
        background-color: #0043fd;
        font-family: 'Ubuntu';
        font-size: 16pt;
      }
    </style>
    <script type="text/javascript">
      var imagenes = ["img/gatito1.png","img/gatito2.png","img/gatito3.png","img/gatito4.png","img/gatito5.png"];
      function dale()
      {
        alert(imagenes.length);
      }
    </script>
  </head>
  <body>
    <h1>Bienvenido a mi página web</h1>
    <?php
      for ($a = 0; $a <= imagenes.length; $a++)
      {
        echo "<img src=imagenes[$a] />";
      }
     ?>
  </body>
</html>

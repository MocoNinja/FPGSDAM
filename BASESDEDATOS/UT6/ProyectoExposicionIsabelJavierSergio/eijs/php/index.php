<html>
  <head>
    <title>Inicio De Sesion</title>
    <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="import" href="headers.html">
  </head>
  <body class="is-loading">
  <?php
      include("conexion.php");
      $estado = $_SESSION['fallo'];
      if ($estado == "pass") $mensaje = "Contraseña incorrecta";
      else if ($estado == "user") $mensaje = "Usuario no encontrado";
      else $mensaje = "";
      echo "<p>$mensaje</p>";
    ?>
    <!-- Wrapper -->
      <div id="wrapper">

        <!-- Main -->
          <section id="main">
            <span class="avatar"><img src="img/LogoSalesianos.png" alt="" /></span>
            <h2>Inicio de Sesion</h2>
            <form name="usuarios" id="usuarios" method="post" action="login.php">
              <div class="field">
                <input type="text" name="username" id="username" placeholder="user">
              </div>
              <div class="field">
                <input type="password" name="password" id="password" placeholder="password"></td>
              </div>
              
              <ul class="actions">
                <li><input type="submit" value="Login"></li>
              </ul>
            </form>
          </section>

        <!-- Footer -->
          <footer id="footer">
          </footer>

      </div>

    <!-- Scripts -->
      <!--[if lte IE 8]><script src="assets/js/respond.min.js"></script><![endif]-->
      <script>
        if ('addEventListener' in window) {
          window.addEventListener('load', function() { document.body.className = document.body.className.replace(/\bis-loading\b/, ''); });
          document.body.className += (navigator.userAgent.match(/(MSIE|rv:11\.0)/) ? ' is-ie' : '');
        }
      </script>

  </body>
</html>
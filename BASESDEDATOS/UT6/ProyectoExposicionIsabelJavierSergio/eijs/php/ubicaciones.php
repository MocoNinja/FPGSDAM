<!DOCTYPE html>
<html>
  <head>
    <title>Gestión de usuarios</title>
    <meta charset="UTF-8">
    <link rel="import" href="headers.html">
    <script language="javascript">
   
       function meterUsuario()
      {
        // console.log(document.getElementById('insertarUsuarios').style.opacity);
        if (document.getElementById('insertarUsuarios').style.display == "none")
        {
          document.getElementById('verUsuarios').style.display = "none";
          document.getElementById('insertarUsuarios').style.display = "block";
          // document.getElementById('insertarUsuarios').style.zIndex = "block";
        } else {
          document.getElementById('verUsuarios').style.display = "block";
          document.getElementById('insertarUsuarios').style.display = "none";
        }
      }
    </script>
  </head>
  <body class="is-loading">
<div id="volverInicio"></div>
    <!-- Wrapper -->
      <div id="wrapper">

        <!-- Main -->
          <section id="main">
           
            <header>
                <h2>Ubicaciones</h2>
            </header>
            <hr />
              
              <img src="./img/add_place.png" alt="Meter usuario" id="add_usuario" width="50" onclick="meterUsuario()"> Insertar ubicación <br/>
                <?php
                  include("conexion.php");
                  if ($_SESSION['rol'] != "administrador") header("location:index.php");
                  $ubicaciones = "SELECT * FROM Ubicaciones";
                  $registros = mysqli_query($conexion,$ubicaciones) or die("Error en la consulta de inserción $ubicaciones");
                ?>
                <div id="insertarUsuarios" style="display:none;">
                 <form name="ubicacion" id="ubicacion" method="post" action="insertarUbicacion.php">
                  <table>
                    <tr>
                      <td>Nombre</td>
                      <td><input type="text" name="nombre" id="nombre"></td>
                    </tr>
                    <tr>
                      <td>Nombre Antiguo</td>
                      <td><input type="text" name="antiguo" id="antiguo"></td>
                    </tr>
                   
                  </table>
                   <div colspan="2" align="center">
                      <input type="submit" class="btn btn-lg btn-success" value="Enviar">
                    </div>
              </form>  
                </div>
                <div id="verUsuarios">
                <table class="USUARIOS">
                  <tr>
                    <th>Nombre</th>
                    <th>Nombre Antiguo</th>
                    <th>Borrar</th>
                  </tr>
                  <?php
                    while($linea=mysqli_fetch_array($registros))
                    {
                      $botonBorrar =  "<a href='borrarUbicacion.php?clave=$linea[idUbicacion]'><img src='./img/detele_place.jpg' width='30'></a>";
                      $nombre = $linea['nombre'];
                      $nombreAntiguo = $linea['nombreAntiguo'];
                      echo"<tr>
                              <td>$nombre</td>
                              <td>$nombreAntiguo</td>
                              <td>$botonBorrar</td>
                        </tr>";
                    }
                    mysqli_close($conexion);
                  ?>
                  </table>
                </div>
                <!-- movido por coherencia con otras paginas
                <div id="volverInicio"><a href="principal.php">Volver</a></div>
              -->
              <hr/>
          <footer>
              <ul class="icons">
                <a href="principal.php"><input type="button" value="Menu Principal">
              </ul>
            </footer>
          </section>

       

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
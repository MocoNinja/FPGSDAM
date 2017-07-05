<!DOCTYPE html>
<html>
  <head>
    <title>Gestión de usuarios</title>
    <meta charset="UTF-8">
    <link rel="import" href="headers.html">
    <script language="javascript">
    /*
      function meterUsuario()
      {
        // console.log(document.getElementById('insertarUsuarios').style.opacity);
        if (document.getElementById('insertarUsuarios').style.opacity == 0)
        {
          document.getElementById('verUsuarios').style.opacity = "0.1";
          document.getElementById('insertarUsuarios').style.opacity = "1";
          // document.getElementById('insertarUsuarios').style.zIndex = "1";
        } else {
          document.getElementById('verUsuarios').style.opacity = "1";
          document.getElementById('insertarUsuarios').style.opacity = "0";
        }
      }
      */
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
                <h2>Usuarios</h2>
            </header>
            <hr />
              
              <img src="./img/add_usuario.png" alt="Meter usuario" id="add_usuario" width="50" onclick="meterUsuario()"> Insertar usuario <br/>
                <?php
                  include("conexion.php");
                  if ($_SESSION['rol'] != "administrador") header("location:index.php");
                  $usuarios = "SELECT * FROM Usuarios";
                  $registros = mysqli_query($conexion,$usuarios) or die("Error en la consulta de inserción $usuarios");
                ?>
                <div id="insertarUsuarios" style="display:none;">
                 <form name="usuario" id="usuario" method="post" action="insertarUsuario.php">
                  <table>
                    <tr>
                      <td>Nombre</td>
                      <td><input type="text" name="nombre" id="nombre"></td>
                    </tr>
                    <tr>
                      <td>Apellidos</td>
                      <td><input type="text" name="apellidos" id="apellidos"></td>
                    </tr>
                    <tr>
                      <td>Rol</td>
                      <td><select name="rol" id="rol">
                        <option value="administrador">Administrador</option>
                        <option value="sat">SAT</option>
                        <option value="Profesor">Profesor</option>
                        </select>
                      </td>
                    </tr>
                    <tr>
                      <td>Username</td>
                      <td><input type="text" name="username" id="username"></td>
                    </tr>
                    <tr>
                      <td>Contraseña</td>
                      <td><input type="text" name="password" id="password"></td>
                    </tr>
                    <tr>
                      <td colspan="2"><input type="submit" name="enviar" id="enviar"></td>
                    </tr>
                  </table>
              </form>  
                </div>
                <div id="verUsuarios">
                <table class="USUARIOS">
                  <tr>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>Rol</th>
                    <th>Usuario</th>
                    <th>Contraseña</th>
                    <th>Eliminar Usuario</th>
                  </tr>
                  <?php
                    while($linea=mysqli_fetch_array($registros))
                    {
                      $botonBorrar =  "<a href='borrarUsuario.php?clave=$linea[idUsuario]'><img src='./img/usuario_borrar.png' width='30'></a>";
                      $nombre = $linea['nombre'];
                      $apellidos = $linea['apellidos'];
                      $rol = $linea['rol'];
                      $usuario = $linea['username'];
                      $password = $linea['password'];
                      echo"<tr>
                              <td>$nombre</td>
                              <td>$apellidos</td>
                              <td>$rol</td>
                              <td>$usuario</td>
                              <td>$password</td>
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
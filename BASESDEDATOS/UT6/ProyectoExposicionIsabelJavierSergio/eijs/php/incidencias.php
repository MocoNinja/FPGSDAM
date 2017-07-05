<!DOCTYPE html>
<html>
  <head>
    <title>Gestión de usuarios</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="import" href="headers.html">
    <script language="javascript">
  
      function ocultar(){
        document.getElementById('insertarIncidencias').style.display = "none";
      }
      function meterIncidencia()
      {
        // console.log(document.getElementById('insertarIncidencias').style.opacity);
        if (document.getElementById('insertarIncidencias').style.display == "none")
        {
          document.getElementById('verIncidencias').style.display = "none";
          document.getElementById('insertarIncidencias').style.display = "block";
          // document.getElementById('insertarIncidencias').style.zIndex = "1";
        } else {
          document.getElementById('verIncidencias').style.display = "block";
          document.getElementById('insertarIncidencias').style.display = "none";
        }
      }
    </script>
  </head>
<body class="is-loading" onload="ocultar()">
    <!-- Wrapper -->
      <div id="wrapper">

        <!-- Main -->
          <section id="main">
            <header>
              <h2>Incidencias</h2>
            </header>
            <hr />
              <img src="./img/report_management.png" alt="Meter usuario" id="add_report" width="50" onclick="meterIncidencia()"> Insertar incidencia <br/>
              <?php
                include("conexion.php");
                if (empty($_SESSION['rol'])) header("location:index.php");
                $incidencias = "SELECT * FROM Incidencias";
                $registros = mysqli_query($conexion,$incidencias) or die("Error en la consulta de inserción $incidencias");
              ?>
              <div id="insertarIncidencias">
               <form name="usuario" id="usuario" method="post" action="insertarIncidencia.php">
                <table>
                <tr>
                <td>Material</td>
                <td>
                <select name="idMaterial">
                  <?php
                  $sqlMateriales = "SELECT * FROM Materiales";
                  $materialesRecuperados = mysqli_query($conexion,$sqlMateriales) or die("Error en la consulta de inserción $sqlMateriales");
                  while($linea=mysqli_fetch_array($materialesRecuperados)){
                      $material = $linea['nombre'];
                      $idMaterial = $linea['idMaterial'];
                      $opcion = "<option value='".$idMaterial."'>".$material."</option>";
                      echo $opcion;
                    }
                  ?>
                </select>
                </td>
                </tr>
                  <tr>
                    <td>Nombre Incidencia</td>
                    <td><input type="text" name="incidencia" id="incidencia" required></td>
                  </tr>
                  <tr>
                    <td>Fecha Incidencia</td>
                    <td><input type="date" name="fechaIncidencia" id="fechaIncidencia" required></td>
                  </tr>
                  <?php
                    if ($_SESSION['rol'] != "profesor"){
                      echo '        
                  <tr>
                    <td>Solución Incidencia</td>
                    <td><input type="text" name="solucion" id="solucion" required></td>
                  </tr>
                  <tr>
                    <td>Fecha Solucion</td>
                    <td><input type="date" name="fechaSolucion" id="fechaSolucion" required></td>
                  </tr>';
                    }
                  ?>
                  <tr>
                    <td colspan="2"><input type="submit" name="enviar" id="enviar"></td>
                  </tr>
                </table>
            </form>  
              </div>
              <div id="verIncidencias">
              <table>
                <tr>
                  <th>Nombre de la incidencia</th>
                  <th>Fecha Incidencia</th>
                  <?php
                    if ($_SESSION['rol'] != "profesor"){
                      echo '       
                    <th>Solución Incidencia</th>
                    <th>Fecha Solucion</th>';
                    }
                  ?>
                </tr>
                <?php
                  while($linea=mysqli_fetch_array($registros))
                  {
                    //$botonBorrar = "<img src='./img/report_kill.png' onclick='borrarUsuario()' width='25'>";
                    $botonBorrar =  "<td><a href='borrarIncidencia.php?clave=$linea[idIncidencia]'><img src='./img/report_kill.png' width='30'></a></td>";
                    $incidencia = $linea['incidencia'];
                    $fechaIncidencia = $linea['fechaIncidencia'];
                    if ($_SESSION['rol'] != "profesor"){
                    $solucion = $linea['solucion'];
                    $fechaSolucion = $linea['fechaSolucion'];
                    }
                     echo"<tr><td>$incidencia</td><td>$fechaIncidencia</td>";
                  if ($_SESSION['rol'] != "profesor"){
                    echo "<td>$solucion</td><td>$fechaSolucion</td>";
                  }
                   echo " <td>$botonBorrar</td></tr>";
                  }
                 
                  ?>
                  
                  <?php
                  mysqli_close($conexion);
                ?>
                </table>
              </div>
            <hr/>
            <footer>
              <ul class="icons">
                <a href="principal.php"><input type="button" value="Menu Principal">
              </ul>
            </footer>
          </section>

        <!-- Footer -->
         

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
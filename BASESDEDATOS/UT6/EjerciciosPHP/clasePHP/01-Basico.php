<!DOCTYPE HTML PUBLIC>
<html>
    <head>
        <title>01-Basico.php</title>
    </head>
    <body>
      <h5>Ejercicio 1: Tabla</h5>
        <table>
            <tr>
                <?php
                    for ($a = 1; $a <= 10; $a++)
                    {
                        echo "<td id='$a' name='$a'>$a</td>";
                    }
                ?>
            </tr>
        </table>
        <h5>Ejercicio 2: Tabla con fotos</h5>
        <?php
            echo "<table>";
            for ($a = 1; $a <= 10; $a++)
            {
                echo "<tr>";
                echo "<td><img src='img/gatito$a.png' width='250' height='250'></td>";
                echo "</tr>";
            }
            echo "</table>";
        ?>

        <h5>Ejercicio 3: Tabla con fotos - array</h5>
        <?php
        // Otra opcion: crear un array y recorrerlo
        // Sintaxis del array:
        // $imagenes = array();
        // $imagenes[i] = "...";
            $imagenes = array();
            $imagenes[0] = "./img/gatito1.png";
            $imagenes[1] = "./img/gatito2.png";
            $imagenes[2] = "./img/gatito3.png";
            $imagenes[3] = "./img/gatito4.png";
            echo "<table>";
            for ($a = 0; $a <= 3; $a++)
            {
                echo "<tr>";
                echo "<td><img src='$imagenes[$a]'' width='250' height='250'></td>";
                echo "</tr>";
            }
            echo "</table>";
        ?>
        <h5>Ejercicio 4: Tabla anidada (propia, no clase)</h5>
        <?php
            echo "<table border='1'>";
            for ($a = 1; $a <= 5; $a++)
            {
                echo "<tr>";
                for ($b = 1; $b <= 10; $b++)
                {
                    echo "<td id='$b' name='$b'>$b</td>";
                }
                 echo "</tr>";
            }
            echo "</table>";
        ?>
        <h5>Ejercicio 5: Select</h5>
        <select name="edad" id="edad">
        <?php
            for($b = 1; $b <= 100; $b++)
            {
            echo "<option value='$b'>$b";
            }
        ?>
        </select>
        <h5>Ejercicio 6: Bucle básico</h5>
        <?php
            for($c = 1; $c <= 100; $c++)
            {
            echo "<h1>Bienvenidos a esta página $c</h1>";
            }
        ?>

    </body>
</html>

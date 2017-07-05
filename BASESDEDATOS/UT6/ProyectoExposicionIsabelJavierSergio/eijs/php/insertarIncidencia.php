<?php
// Recuperamos datos del formulario
$inci=$_POST['incidencia'];
$fecIn=$_POST['fechaIncidencia'];
if (isset($_POST['fechaSolucion'])) $fecSo=$_POST['fechaSolucion'];
if (isset($_POST['solucion'])) $solu=$_POST['solucion'];
$idMa=$_POST['idMaterial'];

// conectamos con la BD
include("conexion.php");
// creamos consulta
if (isset($_POST['fechaSolucion'])) $sql="INSERT INTO Incidencias(incidencia,fechaIncidencia,fechaSolucion,solucion,idMaterial)
 VALUES ('$inci',$fecIn,$fecSo, '$solu',$idMa)";
else $sql="INSERT INTO Incidencias(incidencia,fechaIncidencia,idMaterial)
 VALUES ('$inci',$fecIn,$idMa)";
 // ejecutamos la consulta
mysqli_query($conexion,$sql) or die("Error en la consulta de insercion $sql");

// cerramos la conexion
mysqli_close($conexion);
// redirigimos a la pagina inicial
header("location:incidencias.php");
?>
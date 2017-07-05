<?php
// Recuperamos datos del formulario
$dni=$_POST['dni'];
$fi=$_POST['fechai'];
$ff=$_POST['fechaf'];
$hi=$_POST['horai'];
$hf=$_POST['horaf'];
$tec=$_POST['tecnicas'];
$apr=$_POST['aprendizaje'];
$pla=$_POST['planificacion'];
$rec=$_POST['recambios'];
$ord=$_POST['orden'];
$org=$_POST['organizacion'];
$con=$_POST['consultas'];
$ini=$_POST['iniciativa'];
$lab=$_POST['laborales'];
$cri=$_POST['criticas'];
$res=$_POST['responsabilidad'];
$pun=$_POST['puntualidad'];
// conectamos con la BD
include("conexion.php");
// creamos consulta
$sql="INSERT INTO informes(dnialumno, fechainicio, fechafin, horainicio, horafin, tecnica, aprendizaje, planificacion, recambios, organizacion, orden, consultas, iniciativa, relacion, criticas, responsabilidad, puntualidad) VALUES('$dni', '$fi','$ff','$hi', '$hf', $tec, $apr, $pla, $rec, $org, $ord, $con, $ini, $lab, $cri, $res, $pun)";
// ejecutamos la consulta
mysqli_query($conexion,$sql) or die("Error en la consulta de inserción $sql");
// cerramos la conexion
mysqli_close($conexion);
// redirigimos a la pagina inicial
header("location:forminformes.php");
?>

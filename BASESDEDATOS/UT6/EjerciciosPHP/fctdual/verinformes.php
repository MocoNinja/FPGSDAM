<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> verinformes.php </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
</HEAD>

<BODY>
<table align="center" width="80%">
<tr >
	<td colspan="7"><img src="./imagenes/logosz.jpg" width="500"></td>
</tr>
<tr>
	<td colspan="19" align="right"><a href="forminformes.php">Volver</a></td>
</tr>
<tr style="background-color:#CCFFFF;">	<td>DNI</td><td>Alumno</td><td>Fecha I.</td><td>Fecha F.</td><td>Hora I.</td><td>Hora F.</td><td>A</td><td>B</td><td>C</td><td>D</td><td>E</td><td>F</td><td>G</td><td>H</td><td>I</td><td>J</td><td>K</td><td>L</td><td></td>
</tr>
<?php
include("conexion.php");
//creamos la consulta
$sql="SELECT  a.alumno, i.* FROM alumnos as a, informes as i  WHERE a.dni=i.dnialumno ORDER BY i.dnialumno, i.fechainicio";
//ejecutamos la consulta
$registros=mysqli_query($conexion,$sql);
//leemos el contenido de $registros
while ($linea=mysqli_fetch_array($registros))
{
	echo "<tr><td>$linea[dnialumno]</td><td>$linea[alumno]</td><td>$linea[fechainicio]</td><td>$linea[fechafin]</td><td>$linea[horainicio]</td><td>$linea[horafin]</td><td>$linea[tecnica]</td><td>$linea[aprendizaje]</td><td>$linea[planificacion]</td><td>$linea[recambios]</td><td>$linea[organizacion]</td><td>$linea[orden]</td><td>$linea[consultas]</td><td>$linea[iniciativa]</td><td>$linea[relacion]</td><td>$linea[criticas]</td><td>$linea[responsabilidad]</td><td>$linea[puntualidad]</td><td><a href='borinformes.php?clave=$linea[idinforme]'><img src='./imagenes/borrar.jpg' width='30'></a></td></tr>";
	echo "<tr><td colspan='19'><hr></td></tr>";
}
mysqli_close($conexion);
?>
</table>

</BODY>
</HTML>

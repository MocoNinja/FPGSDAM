<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> veralumnos.php </TITLE>
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
	<td colspan="7" align="right"><a href="formalumnos.php">Volver</a></td>
</tr>
<tr style="background-color:#CCFFFF;">	<td>DNI</td><td>Alumno</td><td>email</td><td>Teléfono</td><td>Empresa</td><td>Estudios</td><td></td>
</tr>
<?php
include("conexion.php");
//creamos la consulta
$sql="SELECT a.dni, a.alumno, a.email, a.telefono,em.empresa,es.estudio FROM alumnos as a, empresas as em, estudios as es WHERE a.nifempresa=em.nif AND a.idestudios=es.idestudio;";
//ejecutamos la consulta
$registros=mysqli_query($conexion,$sql);
//leemos el contenido de $registros
while ($linea=mysqli_fetch_array($registros))
{
	echo "<tr><td>$linea[dni]</td><td>$linea[alumno]</td><td>$linea[email]</td><td>$linea[telefono]</td><td>$linea[empresa]</td><td>$linea[estudio]</td><td><a href='boralumnos.php?clave=$linea[dni]'><img src='./imagenes/borrar.jpg' width='30'></a></td></tr>";
	echo "<tr><td colspan='7'><hr></td></tr>";
}
mysqli_close($conexion);
?>
</table>

</BODY>
</HTML>

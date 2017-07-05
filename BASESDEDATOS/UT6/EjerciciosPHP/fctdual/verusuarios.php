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
	<td colspan="19" align="right"><a href="formusuarios.php">Volver</a></td>
</tr>
</tr>
<?php
include("conexion.php");
//creamos la consulta
$sql="SELECT  * FROM usuarios";
//ejecutamos la consulta
$registros=mysqli_query($conexion,$sql);
//leemos el contenido de $registros
while ($linea=mysqli_fetch_array($registros))
{
	echo "
	<tr>
	<td>$linea[dni]</td>
	<td>$linea[clave]</td>
	<td>$linea[nombre]</td>
	<td>$linea[email]</td>
	<td>$linea[telefono]</td>
	<td><a href='borusuarios.php?clave=$linea[dni]'><img src='./imagenes/borrar.jpg' width='30'></a></td>
	</tr>";
	echo "<tr><td colspan='19'><hr></td></tr>";
}
mysqli_close($conexion);
?>
</table>

</BODY>
</HTML>

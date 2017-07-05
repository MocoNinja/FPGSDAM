<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> formalumnos.php </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
</HEAD>

<BODY>
<?php
session_start();
include("conexion.php");
?>
<form name="alumnos" id="alumnos" method="post" action="insalumnos.php">
<table align="center" width="50%">
<tr>
	<td colspan="2"><img src="./imagenes/logosz.jpg" width="500"></td>
</tr>
<tr>
	<td colspan="2" align="center"><h2> ALUMNOS</h2></td>
</tr>
<tr>
	<td colspan="2" align="right"><?php echo "Usuario: $_SESSION[nombreusuario]"?>&nbsp; &nbsp;  <a href="gestion.php">Volver</a>&nbsp; &nbsp;  <a href="logout.php">Logout</a></td>
</tr>
<tr>
	<td>Dni: </td>
	<td><input type="text" name="dni" id="dni" placeholder="dni">
</tr>
<tr>
	<td>Apellidos y Nombre</td>
	<td><input type="text" name="nombre" id="nombre" placeholder="Apellidos y Nombre"></td>
</tr>
<tr>
	<td>email</td>
	<td><input type="email" name="correo" id="correo" placeholder="correo electrónico"></td>
</tr>
<tr>
	<td>Teléfono</td>
	<td><input type="text" name="telefono" id="telefono" placeholder="móvil"></td>
</tr>
<tr>
	<td>Estudios </td>
	<td><select name="estudios" id="estudios">
			<option value="">
<?php
$sql="SELECT * FROM estudios";
$registros=mysqli_query($conexion,$sql);
while($linea=mysqli_fetch_array($registros))
{
	echo"<option value='$linea[idestudio]'>$linea[estudio]";
}
?>
		</select>
	</td>
</tr>
<tr>
	<td>Empresa </td>
	<td><select name="empresa" id="empresa">
			<option value="">
<?php
$sql="SELECT * FROM empresas";
$registros=mysqli_query($conexion,$sql);
while($linea=mysqli_fetch_array($registros))
{
	echo"<option value='$linea[nif]'>$linea[empresa]";
}
?>
		</select>
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="Enviar">
		<a href="veralumnos.php"><input type="button" value="Ver"></a>
	</td>
</tr>
</table>
</form>
</BODY>
</HTML>

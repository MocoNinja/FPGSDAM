<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> forminformes.php </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
</HEAD>

<BODY>
<?php
session_start();
?>
<?php
include("conexion.php");
?>
<form name="informe" id="informe" method="post" action="insusuarios.php">
<table align="center" width="50%">
<tr>
	<td colspan="2"><img src="./imagenes/logosz.jpg" width="500"></td>
</tr>
<tr><td colspan="2" align="center"><h2>USUARIOS</h2></td></tr>
<tr>
	<td colspan="2" align="right">
	<?php echo "Usuario: $_SESSION[nombreusuario]"?>&nbsp; &nbsp; <a href="logout.php">Logout</a></td></tr>
<tr>
	<td>Nombre</td>
	<td>
	<input type="text" name="nombre" value="">
	</td>
<tr>
<tr>
	<td>Clave</td>
	<td>
	<input type="text" name="clave" value="">
	</td>
<tr>
<tr>
	<td>Dni</td>
	<td>
	<input type="text" name="dni" value="">
	</td>
<tr>
<tr>
	<td>Email</td>
	<td>
	<input type="text" name="email" value="">
	</td>
<tr>
<tr>
	<td>Telefono</td>
	<td>
	<input type="text" name="telefono" value="">
	</td>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="Enviar">
		<a href="verusuarios.php"><input type="button" value="Ver"></a>
	</td>
</tr>
</table>
</form>
</BODY>
</HTML>

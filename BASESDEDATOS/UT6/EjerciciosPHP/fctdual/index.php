<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> index.php </TITLE>
</HEAD>

<BODY>
<?php
include("conexion.php");
?>
<form name="usuarios" id="usuarios" method="post" action="login.php">
<table align="center" width="40%">
<tr>
	<td colspan="2"><img src="./BBDD/imagenes/logosz.jpg" width="500"></td>
</tr>
<tr>
	<td>Dni: </td>
	<td><input type="text" name="dni" id="dni" placeholder="dni">
</tr>
<tr>
	<td>Clave:</td>
	<td><input type="password" name="clave" id="clave" placeholder="Clave"></td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="Entrar">
	</td>
</tr>
</table>
</form>
</BODY>
</HTML>

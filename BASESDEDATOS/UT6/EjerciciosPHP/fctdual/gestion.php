<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> gestion.php </TITLE>
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
<table align="center" width="40%">
<tr>
	<td colspan="5"><img src="./imagenes/logosz.jpg" width="500"></td>
</tr>
<tr>
	<td colspan="5" align="right"><?php echo "Usuario: $_SESSION[nombreusuario]"?>&nbsp; &nbsp; <a href="logout.php">Logout</a></td></tr>
<tr>
<tr>
	<td><a href="formalumnos.php"><img src="./imagenes/alumnos.png" width="80"></a></td>
	<td><a href="formempresas.php"><img src="./imagenes/empresas.jpg" width="80"></a></td>
	<td><a href="formestudios.php"><img src="./imagenes/estudios.jpg" width="80"></a></td>
	<td><a href="formusuarios.php"><img src="./imagenes/usuarios.png" width="80"></a></td>
	<td><a href="forminformes.php"><img src="./imagenes/informes.png" width="80"></a></td>
</tr>
<tr>
	<td>Alumnos</td>
	<td>Empresas</td>
	<td>Estudios</td>
	<td>Usuarios</td>
	<td>Informes</td>
</tr>
<tr>
</table>
</form>
</BODY>
</HTML>

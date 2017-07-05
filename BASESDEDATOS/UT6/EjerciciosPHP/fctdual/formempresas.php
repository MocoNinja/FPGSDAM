<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> formempresas.php </TITLE>
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
<form name="empresas" id="empresas" method="post" action="insempresas.php">
<table align="center" width="50%">
<tr>
	<td colspan="2"><img src="./imagenes/logosz.jpg" width="500"></td>
</tr>
<tr>
	<td colspan="2" align="center"><h2>EMPRESAS</h2></td>
</tr>
<tr>
	<td colspan="2" align="right"><?php echo "Usuario: $_SESSION[nombreusuario]"?>&nbsp; &nbsp;  <a href="gestion.php">Volver</a>&nbsp; &nbsp;  <a href="logout.php">Logout</a></td>
</tr>
<tr>
	<td>Nif: </td>
	<td><input type="text" name="nif" id="nif" placeholder="nif">
</tr>
<tr>
	<td>Nombre</td>
	<td><input type="text" name="nombre" id="nombre" placeholder="Nombre"></td>
</tr>
<tr>
	<td>Direccion</td>
	<td><input type="text" name="direccion" id="direccion" placeholder="direccion"></td>
</tr>
<tr>
	<td>Email</td>
	<td><input type="email" name="correo" id="correo" placeholder="correo electr�nico"></td>
</tr>
<tr>
	<td>Tel�fono</td>
	<td><input type="text" name="telefono" id="telefono" placeholder="m�vil"></td>
</tr>
<tr>
	<td>DNI Usuario </td>
	<td><select name="dniusuario" id="dniusuario">
			<option value="">
<?php
$sql="SELECT * FROM usuarios";
$registros=mysqli_query($conexion,$sql);
while($linea=mysqli_fetch_array($registros))
{
	echo"<option value='$linea[dni]'>$linea[nombre]";
}
?>
		</select>
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="Enviar">
		<a href="verempresas.php"><input type="button" value="Ver"></a>
	</td>
</tr>
</table>
</form>
</BODY>
</HTML>

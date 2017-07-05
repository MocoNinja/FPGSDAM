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
<form name="informe" id="informe" method="post" action="insinformes.php">
<table align="center" width="50%">
<tr>
	<td colspan="2"><img src="./imagenes/logosz.jpg" width="500"></td>
</tr>
<tr>
	<td colspan="2" align="right"><?php echo "Usuario: $_SESSION[nombreusuario]"?>&nbsp; &nbsp; <a href="logout.php">Logout</a></td></tr>
<tr>
	<td>Dni Alumno:</td>
	<td><select name="dni" id="dni">
			<option value="">
<?php
if ($_SESSION['administrador'])
{
	$sql="SELECT DISTINCT a.* FROM alumnos as a, empresas as e";
	$registros=mysqli_query($conexion,$sql);
}
else
{
	$sql="SELECT a.* FROM alumnos as a, empresas as e WHERE a.nifempresa=e.nif AND e.dniusuario='$_SESSION[dniusuario]'";
	$registros=mysqli_query($conexion,$sql);
}

while($linea=mysqli_fetch_array($registros))
{
	echo"<option value='$linea[dni]'>$linea[alumno]";
}
?>
		</select>
	</td>
</tr>
<tr>
	<td>Fecha Inicio: </td>
	<td><input type="date" name="fechai" id="fechai"> Fin: <input type="date" name="fechaf" id="fechaf"></td> 
</tr>
<tr>
	<td>Hora Inicio: </td>
	<td><input type="time" name="horai" id="horai"> Fin: <input type="time" name="horaf" id="horaf"></td> 
</tr>
<tr>
	<td>A.Capacidades T�cnicas</td>
	<td><select name="tecnicas" id="tecnicas">
		<option value="">
		<?php
			for($c=1;$c<=5;$c++)
			echo "<option value='$c'>$c";
		?>
		</select>
	</td>
</tr>
<tr>
	<td>B. Capacidad de Aprendizaje</td>
	<td><select name="aprendizaje" id="aprendizaje">
		<option value="">
		<?php
			for($c=1;$c<=5;$c++)
			echo "<option value='$c'>$c";
		?>
		</select>
	</td>
</tr>
<tr>
	<td>C. Planificaci�n</td>
	<td><select name="planificacion" id="planificacion">
		<option value="">
		<?php
			for($c=1;$c<=5;$c++)
			echo "<option value='$c'>$c";
		?>
		</select>
	</td>
</tr>
<tr>
	<td>D. Recambios</td>
	<td><select name="recambios" id="recambios">
		<option value="">
		<?php
			for($c=1;$c<=5;$c++)
			echo "<option value='$c'>$c";
		?>
		</select>
	</td>
</tr>
<tr>
	<td>E. Organizaci�n</td>
	<td><select name="organizacion" id="organizacion">
		<option value="">
		<?php
			for($c=1;$c<=5;$c++)
			echo "<option value='$c'>$c";
		?>
		</select>
	</td>
</tr>
</tr>
<tr>
	<td>F. Orden y Limpieza</td>
	<td><select name="orden" id="orden">
		<option value="">
		<?php
			for($c=1;$c<=5;$c++)
			echo "<option value='$c'>$c";
		?>
		</select>
	</td>
</tr>
</tr>
<tr>
	<td>G. Consultas</td>
	<td><select name="consultas" id="consultas">
		<option value="">
		<?php
			for($c=1;$c<=5;$c++)
			echo "<option value='$c'>$c";
		?>
		</select>
	</td>
</tr>
<tr>
	<td>H. Iniciativa personal e innovaci�n</td>
	<td><select name="iniciativa" id="iniciativa">
		<option value="">
		<?php
			for($c=1;$c<=5;$c++)
			echo "<option value='$c'>$c";
		?>
		</select>
	</td>
</tr>
<tr>
	<td>I. Relaciones laborales</td>
	<td><select name="laborales" id="laborales">
		<option value="">
		<?php
			for($c=1;$c<=5;$c++)
			echo "<option value='$c'>$c";
		?>
		</select>
	</td>
</tr>
<tr>
	<td>J. Asimilaci�n de las cr�ticas</td>
	<td><select name="criticas" id="criticas">
		<option value="">
		<?php
			for($c=1;$c<=5;$c++)
			echo "<option value='$c'>$c";
		?>
		</select>
	</td>
</tr>
<tr>
	<td>K. Responsabilidad</td>
	<td><select name="responsabilidad" id="responsabilidad">
		<option value="">
		<?php
			for($c=1;$c<=5;$c++)
			echo "<option value='$c'>$c";
		?>
		</select>
	</td>
</tr>
<tr>
	<td>L. Puntualidad</td>
	<td><select name="puntualidad" id="puntualidad">
		<option value="">
		<?php
			for($c=1;$c<=5;$c++)
			echo "<option value='$c'>$c";
		?>
		</select>
	</td>
</tr>


<tr>
	<td colspan="2" align="center">
		<input type="submit" value="Enviar">
		<a href="verinformes.php"><input type="button" value="Ver"></a>
	</td>
</tr>
</table>
</form>

</BODY>
</HTML>

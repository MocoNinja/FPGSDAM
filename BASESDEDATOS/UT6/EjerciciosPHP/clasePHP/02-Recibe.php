<!DOCTYPE html>
<html>
<head>
	<title>Recibir datos</title>
</head>
<body>
	<?php
	// Recuperamos los valores del formulario
	// PHP coge la referencia del name, no del id como JavaScript
	$nombre = $_POST['nombre'];
	$clave = $_POST['clave'];
	echo "<p>Hola, $nombre, con clave $clave</p>";

	// Pueden mostrarse directamente los valores del formulario
	echo "<p>Hola, $_POST[nombre], con clave $_POST[clave]</p>";
	// De varias formas
	echo "<p>Hola, ".$_POST['nombre'].", con clave ".$_POST['clave']."</p>";
	// Enfásis: ''
	echo "<a href='02-Formulario.php'>Volver</a>";
	?>
</body>
</html>
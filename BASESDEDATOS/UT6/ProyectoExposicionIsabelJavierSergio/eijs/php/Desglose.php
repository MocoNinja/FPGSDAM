<!DOCTYPE HTML>
<!--
	Identity by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Informacion</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href= ../css/main.css />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-loading">
	<?php
      include("conexion.php");
      $idMaterial=$_GET['id'];
      $material = "SELECT * FROM materiales where idMaterial = $idMaterial";
      $registros = mysqli_query($conexion,$material) or die("Error en la consulta de seleccion $material");
    ?>
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<section id="main">
						<header>
							<h1>Informacion</h1>
						</header>
						<hr />
							<table class="visualizacion">
								<tr>
									<th colspan="6">
										Nombre
									</th>
								</tr>
								<tr>
									<td colspan="6"> 
									<?php
								        while($linea=mysqli_fetch_array($registros))
								        {
								        	$nombre = $linea['nombre'];
								        	echo "$nombre";
								        
								      ?>
										<!--Nombre material-->
									</td>
								</tr>
								<tr>
									<th colspan="2">
										Marca
									</th>
									<th colspan="2">
										Modelo
									</th>
									<th colspan="2">
										Proveedor
									</th>
								</tr>
								<tr>
									<td colspan="2">
									<?php
								        	$marca = "SELECT * FROM marcas where idMarca = ".$linea['idMarca'];
								        	$registros2 = mysqli_query($conexion,$marca) or die("Error en la consulta de seleccion $marca");
								        	while($linea2=mysqli_fetch_array($registros2))
								        	{
								        		$nombreM = $linea2['Nombre'];
												echo "$nombreM";
								        	}
								        	
								      ?>
										 <!--  Marca-->
									</td>
									<td colspan="2">
									<?php
								        	$modelo = $linea['modelo'];
								        	echo "$modelo";
								      ?>
										<!--  Modelo-->
									</td>
									<td colspan="2">
										<?php
								        	$proveedor = "SELECT * FROM proveedores where idProveedor = ".$linea['idProveedor'];
								        	$registros3 = mysqli_query($conexion,$proveedor) or die("Error en la consulta de seleccion $proveedor");
								        	while($linea3=mysqli_fetch_array($registros3)){
								        		$nombreP = $linea3['nombre'];
												echo "$nombreP";
								        	}
								        	
								      	?>
										 <!-- Proveedor-->
									</td>
								</tr>
								<tr>
									<th colspan="3">
										Fecha Entrada <!-- Fecha Entrada-->
									</th>
									<th colspan="3"> <!-- Autorizador-->
										Autorizado
									</th>
								</tr>
								<tr>
									<td colspan="3">
										<?php
								        	$fecEntrada = $linea['fechaEntrada'];
								        	echo "$fecEntrada";
								      	?>  <!-- Fecha Entrada-->
									</td>
									<td colspan="3">
										<?php
								        	$autorizado = "SELECT * FROM usuarios where idUsuario = ".$linea['idAutorizador'];
								        	$registros4 = mysqli_query($conexion,$autorizado) or die("Error en la consulta de seleccion $autorizado");
								        	while($linea4=mysqli_fetch_array($registros4)){
								        		$nombreA = $linea4['nombre']." ". $linea4['apellidos'];
												echo "$nombreA";
								        	}
								        	
								      	?>
										<!-- Autorizador-->
									</td>
								</tr>
								<tr>
									<th colspan="2">
										Ubicacion
									</th>
									<th colspan="2">
										Numero Interno
									</th>
									<th colspan="2">
										Numero de Serie
									</th>
								</tr>
								<tr>
									<td colspan="2">
										<?php
								        	$ubicacion = "SELECT * FROM ubicaciones where idUbicacion = ".$linea['idUbicacion'];
								        	$registros5 = mysqli_query($conexion,$ubicacion) or die("Error en la consulta de seleccion $ubicacion");
								        	while($linea5=mysqli_fetch_array($registros5)){
								        		$nombreU = $linea5['nombre'];
												echo "$nombreU";
								        	}
								        	
								      	?>
										 <!-- Ubicacion-->
									</td>
									<td colspan="2">
										<?php
								        	$numeroInterno = $linea['numeroInterno'];
								        	if($numeroInterno == null){
								        		echo "No tiene número interno";
								        	}else{
								        		echo "$numeroInterno";	
								        	}
								        	
								      	?><!-- Numero Interno-->
									</td>
									<td colspan="2">
										<?php
								        	$numeroSerie = $linea['numeroSerie'];
								        	if($numeroSerie == null){
								        		echo "No tiene número de serie";
								        	}else{
								        		echo "$numeroSerie";
								        	}
								        	
								      	?> <!-- Numero de Serie-->
									</td>

								</tr>
								<tr>
									<th colspan="3">
										Garantia
									</th>
									<th colspan="3">
										Fecha de Baja
									</th>
								</tr>
								<tr>
									<td colspan="3">
										<?php
								        	$garantia = $linea['garantia'];
								        	if($garantia==null){
								        		echo "No tiene garantia";
								        	}else{
								        		echo "$garantia";
								        	}
	
								      	?><!-- Garantia-->
									</td>
									<td colspan="3">
										<?php
								        	$fechaBaja = $linea['fechaBaja'];
								        	if($fechaBaja==null){
								        		echo "No tiene fecha de bajas";
								        	}else{
								        		echo "$fechaBaja";
								        	}
								      	?> <!-- Fecha de Baja-->
									</td>
								</tr>
								<tr>
									<th colspan="3">
										Estado
									</th>
									<th colspan="3">
										Incidencias
									</th>
								</tr>
								<tr>
									<td colspan="3"> <!-- Revision-->
										<?php
								        	$estado = $linea['estado'];
								        	if($estado == null){
								        		echo "No tiene estado";
								        	}else{
								        		echo "$estado";
								        	}
								      	?>
									</td>
									<td colspan="3">
										 <!-- Incidencias-->
									</td>
								</tr>
								<tr>
									<th colspan="6">
										Observacion 
									</th>
								</tr>
								<tr>
									<td colspan="6"> 
										<?php
									        	$observaciones = $linea['observaciones'];
									        	if($observaciones == null){
									        		echo "No tiene observaciones";
									        	}else{
									        		echo "$observaciones";
									        	}
									        
									    ?>
										<!-- Observacion-->
									</td>
								</tr>
								<?php
										$tipo = "SELECT * FROM ordenadores where idMaterial = ".$linea['idMaterial'];
								        $registros6 = mysqli_query($conexion,$tipo) or die("Error en la consulta de seleccion $tipo");
								        while($linea6=mysqli_fetch_array($registros6)){
								        	$placa = $linea6['placa'];
								        	$procesador = $linea6['procesador'];
								        	$memoriaRAM = $linea6['memoriaRAM'];
								        	$discoDuro = $linea6['discoDuro'];
								        	$tarjetas = $linea6['tarjetas'];
								        	$identificador = $linea6['identificador'];
								        	$dominio = $linea6['dominio'];
											echo "<tr><th colspan='6'>Tipo de material</th></tr><tr><td colspan='6'>Ordenador</td></tr>";
											echo "<tr><th colspan='2'>Placa</th><th colspan='2'>Procesador</th><th colspan='2'>Memoria RAM</th></tr><tr><td colspan='2'>$placa</td><td colspan='2'>$procesador</td><td colspan='2'>$memoriaRAM</td></tr>";
											echo "<tr><th colspan='3'>Disco duro</th><th colspan='3'>Tarjetas</th></tr><tr><td colspan='3'>$discoDuro</td><td colspan='3'>$tarjetas</td></tr>";
											echo "<tr><th colspan='3'>Identificador</th><th colspan='3'>Dominio</th></tr><tr><td colspan='3'>$identificador</td><td colspan='3'>$dominio</td></tr>";
								        }
								        $tipo2 = "SELECT * FROM impresoras where idMaterial = ".$linea['idMaterial'];
								        $registros7 = mysqli_query($conexion,$tipo2) or die("Error en la consulta de seleccion $tipo2");
								        while($linea7=mysqli_fetch_array($registros7)){
								        	$consumible = $linea7['consumible'];
								        	$tipo = $linea7['tipo'];
								        	echo "<tr><th colspan='6'>Tipo de material</th></tr><tr><td colspan='6'>Impresora</td></tr>";
											echo "<tr><th colspan='3'>Consumible</th><th colspan='3'>Tipo de impresora</th></tr><tr><td colspan='3'>$consumible</td><td colspan='3'>$tipo</td></tr>";
								        }
								        $tipo3 = "SELECT * FROM monitores where idMaterial = ".$linea['idMaterial'];
								        $registros8 = mysqli_query($conexion,$tipo3) or die("Error en la consulta de seleccion $tipo3");
								        while($linea8=mysqli_fetch_array($registros8)){
								        	$tamanyo = $linea8['tamanyo'];
								        	$tipo = $linea8['tipo'];
								        	echo "<tr><th colspan='6'>Tipo de material</th></tr><tr><td colspan='6'>Monitor</td></tr>";
											echo "<tr><th colspan='3'>Tamaño</th><th colspan='3'>Tipo de monitor</th></tr><tr><td colspan='3'>$tamanyo</td><td colspan='3'>$tipo</td></tr>";
								        }
									}
								?>
							</table>
						<hr/>
						
						<footer>
							<ul class="icons">
								<a href="principal.php"><input type="button" value="Menu Principal">
							</ul>
						</footer>
					</section>

				<!-- Footer -->
					
			</div>

		<!-- Scripts -->
			<!--[if lte IE 8]><script src="assets/js/respond.min.js"></script><![endif]-->
			<script>
				if ('addEventListener' in window) {
					window.addEventListener('load', function() { document.body.className = document.body.className.replace(/\bis-loading\b/, ''); });
					document.body.className += (navigator.userAgent.match(/(MSIE|rv:11\.0)/) ? ' is-ie' : '');
				}
			</script>

	</body>
</html>
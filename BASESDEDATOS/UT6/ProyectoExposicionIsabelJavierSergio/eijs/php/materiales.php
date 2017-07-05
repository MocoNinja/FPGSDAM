<!DOCTYPE HTML PUBLIC "-//W3C//Ddiv HTML 4.0 divansitional//EN">
<HTML>
<HEAD>
	<TITLE> Materiales </TITLE>
	<META NAME="Generator" CONTENT="EditPlus">
	<META NAME="Author" CONTENT="">
	<META NAME="Keywords" CONTENT="">
	<META NAME="Description" CONTENT="">
	<META charset="UTF-8">
	<style type="text/css">
		#formOrdenador, #formImpresora, #formMonitor, #formSoftware, #formMateriales{
			display: none;
			margin-left: 50px;
		}
		.tipoMaterial{
			width: 12%;
			height: 12%;
		}
		/*main.css: 161--> quitaar mayusculas*/
	</style>
	<link rel="import" href="headers.html">
	<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>-->
	<script language="JavaScript">
		function formOrdenadorShow(){
			document.getElementById('formOrdenador').style.display= 'table-row';
			document.getElementById('formImpresora').style.display= 'none';
			document.getElementById('formMonitor').style.display= 'none';
			document.getElementById("ordenador").checked = true;
		}
		function formImpresoraShow(){
			document.getElementById('formOrdenador').style.display= 'none';
			document.getElementById('formImpresora').style.display= 'table-row';
			document.getElementById('formMonitor').style.display= 'none';
			document.getElementById("impresora").checked = true;
		}
		function formMonitorShow(){
			document.getElementById('formOrdenador').style.display= 'none';
			document.getElementById('formImpresora').style.display= 'none';
			document.getElementById('formMonitor').style.display= 'table-row';
			document.getElementById("monitor").checked = true;
		}
		function formTipoNinguno(){
			document.getElementById('formOrdenador').style.display= 'none';
			document.getElementById('formImpresora').style.display= 'none';
			document.getElementById('formMonitor').style.display= 'none';
			document.getElementById("ninguna").checked = true;
		}
		function formSoftwareShow(){
			document.getElementById('formOrdenador').style.display= 'none';
			document.getElementById('formImpresora').style.display= 'none';
			document.getElementById('formMonitor').style.display= 'none';
		}
		function mostrarFormulario() {
			$("#formMateriales").fadeToggle()
		}

	</script>
</HEAD>
<body class="is-loading">
<center>
		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Main -->
					<section id="main">
						<header>
							<h1>Insertar materiales</h1>
						</header>
						<hr />
							<?php
	include("conexion.php");
	?>
	
		<form name="material" id="material" method="post" action="insMaterial.php">
			
			<div>
				<div>Nombre </div>
				<div><input type="text" name="nombre" id="nombre" placeholder="Nombre"></div>
			</div>
			<div>
				<div>Proveedor</div>
				<div><select name="proveedor" id="proveedor">
							<option value="">
								<?php
									$sql="SELECT * FROM proveedores";
									$regisdivos=mysqli_query($conexion,$sql);
									while($linea=mysqli_fetch_array($regisdivos))
									{
										echo"<option value='$linea[idProveedor]'>$linea[nombre]";
									}
								?>
						</select>
				</div>
			</div>
			<div>
				<div>Marca</div>
				<div><select name="marca" id="marca">
							<option value="">
								<?php
									$sql="SELECT * FROM marcas";
									$regisdivos=mysqli_query($conexion,$sql);
									while($linea=mysqli_fetch_array($regisdivos))
									{
										echo"<option value='$linea[idMarca]'>$linea[Nombre]";
									}
								?>
						</select>
				</div>
			</div>
			<div>

				<div>Modelo</div>
				<div><input type="text" name="modelo" id="modelo" placeholder="Modelo"></div>
			</div>
			<div>
				<div>Número de serie </div>
				<div><input type="text" name="nSerie" id="nSerie" placeholder="Número de serie"></div>
			</div>
			<div>
				<div>Cantidad </div>
				<div><input type="number" name="cantidad" id="cantidad" placeholder="Cantidad"></div>
			</div>
			<div>
				<div>Fecha de entrada</div>
				<div><input type="date" name="fechaEntrada" id="fechaEntrada"></div>
			</div>
			<div>
				<div>Autorizado por:</div>
				<div><div><select name="autorizador" id="autorizador">
							<option value="">
								<?php
									$sql="SELECT * FROM usuarios";
									$regisdivos=mysqli_query($conexion,$sql);
									while($linea=mysqli_fetch_array($regisdivos))
									{
										echo"<option value='$linea[idUsuario]'>$linea[nombre] $linea[apellidos]";
									}
								?>
						</select>
				</div>
			</div>
			<div>
				<div>Ubicación</div>
				<div><select name="ubicacion" id="ubicacion">
							<option value="">
								<?php
									$sql="SELECT * FROM ubicaciones";
									$regisdivos=mysqli_query($conexion,$sql);
									while($linea=mysqli_fetch_array($regisdivos))
									{
										echo"<option value='$linea[idUbicacion]'>$linea[nombre]";
									}
								?>
						</select>
				</div>
			</div>
			<div>
				<div>Número interno</div>
				<div><input type="text" name="nInterno" id="nInterno" placeholder="Número interno"></div>
			</div>
			<div>
				<div>Garantía</div>
				<select name="garantia" id="garantia">
							<option value="0">No
							<option value='1'>Si
						</select>
			</div>
			<div>
				<div>Fecha de baja</div>
				<div><input type="date" name="fechaBaja" id="fechaBaja"></div>
			</div>
			<div>
				<div>Estado</div>
				<div><input type="text" name="estado" id="estado" placeholder="Estado"></div>
			</div>
			<div>
				<div>Observaciones</div>
				<div><textarea rows="4" cols="50" name="observacion" id="observacion" Value="Observaciones"></textarea></div>
			</div>
			<div>
				<div >Tipo Material</div>
				<div>
				<center>
					<input type="radio" name="tipoMaterial" id="ninguna" value="ninguna" checked><img class="tipoMaterial"  onclick="formTipoNinguno()" src="./img/no.png">
					<input type="radio" name="tipoMaterial" id="ordenador" value="ordenador"><img class="tipoMaterial" onclick="formOrdenadorShow()" src="./img/ordenador.png">
					<input type="radio" name="tipoMaterial" id="impresora" value="impresora"><img class="tipoMaterial"  onclick="formImpresoraShow()" src="./img/impresora.png">
					<input type="radio" name="tipoMaterial" id="monitor" value="monitor"> <img class="tipoMaterial"  onclick="formMonitorShow()" src="./img/monitor.png">
				</center>
				</div>
			</div><br>
			<div id="formOrdenador">
				<div>
					<div>Placa</div>
					<div><input type="text" name="placa" id="placa" placeholder="Placa"></div>
				</div>
				<div>
					<div>Procesador</div>
					<div><input type="text" name="procesador" id="procesador" placeholder="Procesador"></div>
				</div>
				<div>
					<div>Memoria RAM</div>
					<div><input type="text" name="ram" id="ram" placeholder="Memoria RAM"></div>
				</div>
				<div>
					<div>Disco duro</div>
					<div><input type="text" name="discoDuro" id="discoDuro" placeholder="Disco duro"></div>
				</div>
				<div>
					<div>Tarjetas</div>
					<div><input type="text" name="tarjeta" id="tarjeta" placeholder="Tarjeta"></div>
				</div>
				<div>
					<div>Identificador</div>
					<div><input type="text" name="identificador" id="identificador" placeholder="Identificador"></div>
				</div>
				<div>
					<div>Dominio</div>
					<div><input type="text" name="dominio" id="dominio" placeholder="Dominio"></div>
				</div>
			</div>
			

			<div id="formImpresora">
				<div>
					<div>Tipo de Impresora</div>
					<div><input type="text" name="tipoImpresora" id="tipoImpresora" placeholder="Tipo Impresora"></div>
				</div>
				<div>
					<div>Combustible</div>
					<div><input type="text" name="consumible" id="consumible" placeholder="consumible"></div>
				</div>
			</div>

			<div id="formMonitor">
				<div>
					<div>Tamaño</div>
					<div><input type="text" name="tamanyo" id="tamanyo" placeholder="Tamaño"></div>
				</div>
				<div>
					<div>Tipo de monitor</div>
					<div><input type="text" name="tipoMonitor" id="tipoMonitor" placeholder="Tipo de monitor"></div>
				</div>
			</div>
			<div>
			<div colspan="2" align="center">
				<input type="submit" class="btn btn-lg btn-success" value="Enviar">
			</div>
		
		</form>
		<hr/>
						
						<footer>
							<ul class="icons">
								<a href="principal.php"><input type="button" value="Menu Principal">
							</ul>
						</footer>

			</div>

		<!-- Scripts -->
			<!--[if lte IE 8]><script src="assets/js/respond.min.js"></script><![endif]-->
			<script>
				if ('addEventListener' in window) {
					window.addEventListener('load', function() { document.body.className = document.body.className.replace(/\bis-loading\b/, ''); });
					document.body.className += (navigator.userAgent.match(/(MSIE|rv:11\.0)/) ? ' is-ie' : '');
				}
			</script>
		</center>
	</body>
</html>

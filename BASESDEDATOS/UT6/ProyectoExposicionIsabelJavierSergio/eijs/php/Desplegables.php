<!DOCTYPE HTML>
<html>
	<head>
		<title>Base De Datos</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		
		<style>
			button.accordion {
			    background-color: #eee;
			    color: #444;
			    cursor: pointer;
			    width: 100%;
			    border: none;
			    text-align: left;
			    outline: none;
			    font-size: 15px;
			    transition: 0.4s;
			}

			button.accordion.active, button.accordion:hover {
			    background-color: #ddd; 
			}

			div.panel {
			    padding: 0 18px;
			    display: none;
			    background-color: white;
			}
		</style>
		<link rel="import" href="headers.html">
		<script languaje="Javascript">
			function accordion(cont) {
		        if (document.getElementById(cont).style.display === "block") {
		            document.getElementById(cont).style.display = "none";
		        } else {
		            document.getElementById(cont).style.display = "block";
		        }
			}
			
			
		</script>
	</head>
	
	<body class="is-loading">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
						<section id="main">
						<header>
							<h1>Base de datos</h1>
						</header>
						<hr />
							<!--AULA-->
								<?php
									include("conexion.php");
									if (empty($_SESSION['rol'])) header("location:index.php"); // No listillos allowed
								//creamos la consulta
								$sql="SELECT ub.nombre as nom, ub.idUbicacion AS idUbi , ma.nombre as mat, ma.idMaterial as id FROM ubicaciones as ub, materiales as ma WHERE ub.idUbicacion=ma.idUbicacion group by ma.idUbicacion";

								//ejecutamos la consulta
								$registros=mysqli_query($conexion,$sql);
								
								//leemos el contenido de $registros
							
								$cont = 1;
								while($linea=mysqli_fetch_array($registros)){
						        	
						      	//	$lineaM=mysqli_fetch_array($registrosM);
								
									echo "<button class='accordion' onclick='accordion($cont)'>$linea[nom]</button>
									<div class='panel' id=$cont>";
									$sqlM="SELECT ma.nombre as mat, ma.idMaterial as id FROM materiales as ma WHERE ma.idUbicacion=".$linea['idUbi'];
						         	$registrosM=mysqli_query($conexion,$sqlM);
									while($lineaM=mysqli_fetch_array($registrosM)){

										echo"<a href='Desglose.php?id=$lineaM[id]'><p>$lineaM[mat]</p></a>";
									}
									echo "</div>";
									$cont++;
											
							}
							mysqli_close($conexion);
							?>
					
						<hr />
						
						<footer>
							<ul class="icons">
								<a href="principal.php"><input type="button" value="Menu Principal">
							</ul>
						</footer>
					</section>

				<!-- Footer -->
					<footer id="footer">
						<ul class="copyright">
						</ul>
					</footer>

			</div>

		
			<script>
				if ('addEventListener' in window) {
					window.addEventListener('load', function() { document.body.className = document.body.className.replace(/\bis-loading\b/, ''); });
					document.body.className += (navigator.userAgent.match(/(MSIE|rv:11\.0)/) ? ' is-ie' : '');
				}
			</script>

	</body>
</html>
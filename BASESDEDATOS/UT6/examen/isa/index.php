<!DOCTYPE html>
<html>
	  <head>
 
    <title>SmartShop - Entrar o Registrarse</title>
    <!-- Favorites icon -->
    <link rel="shortcut icon" href="img/favicon.png">
	
	<!-- CSS Stylesheets -->
	<link rel="stylesheet" type="text/css" href="css/master.css">
	
	<!-- JS Files -->
	<script src="js/jquery.min.js"></script>
	<script src="js/h5f.js"></script>
	<script src="js/functions.js"></script>
	<!--[if IE]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	<script language="JavaScript">
	function ejecutar(accion)
	{
	if (accion == 'entrar')
		{
		document.getElementById('datos').action="login.php";
		}
	else
		{
		document.getElementById('datos').action="reset.php";
		}
	document.getElementById('datos').submit();

	}

	</script>
</head>
<body>
<?php
session_start();
include("conexion_bd.php");
?>
	<div id="container">
	
		<!-- Tabs -->
		<ul id="tabs" class="clearfix">
			<li class="activeTab" id="signInTab">
				<div class="signInTabContent">
					<span>¿Ya eres miembro?</span>
					<h1>Acceder a continuación</h1>
				</div>
				
				<span class="activeTabArrow"><!-- --></span>
			</li>
			<li class="inactiveTab" id="signUpTab">
				<div class="signUpTabContent">
					<span>¿No tienes una cuenta?</span>
					<h1>Crear una ahora</h1>
				</div>

				<span class="activeTabArrow"><!-- --></span>
			</li>
		</ul>
		
		<!-- Sign In Tab Content -->
		<div id="signIn" class="toggleTab">
		
			<form id="datos" action="" method="POST" class="cleanForm">
			
				<fieldset>
				
					<p>
						<label for="login-username">Usuario:</label>
						<input type="text" id="login-username" name="login-username" value="" autofocus required>
					</p>
					
					<p>
						<label for="login-password">Contraseña:</label>
						<input type="password" id="login-password" name="login-password" value="" required>
					</p>
					
					<div class="distanceLeft">
						<input type="checkbox" id="remember-me" name="remember-me" />
						<label for="remember-me">Recordarme en este equipo</label>
						<a href="#" onclick="ejecutar('borrar')">Borrar Usuario</a>
					</div>
					
				
					&nbsp;&nbsp;<input type="submit" onclick="ejecutar('entrar')" value="Entrar">
					
 <?php
	if(isset($_GET['error']))
	{
		$error=$_GET['error'];
		if($error ==1)
		  echo "Usuario NO EXISTE";
		if($error ==2)
		  echo "Clave INCORRECTA";
	}
 ?>
									
					<div class="formExtra">
						<p><strong>¿Problemas para entrar?</strong></p>
						<p><a href="guest.php">Entrar como invitado</a> </p>
					</div>

				</fieldset>
			
			</form>
		
		</div> <!-- end signIn -->

		<!-- Sign Up Tab Content -->
		<div id="signUp" class="clearfix toggleTab">
		
			<form action="registrar.php" method="POST" class="cleanForm" id="signUpForm">
			
				<fieldset>
				
					<p>
						<label for="full-name">Nombre completo: <span class="requiredField">*</span></label>
						<input type="text" id="full-name" name="full_name" value="" autofocus required>
						<em>&nbsp;Ingrese su nombre completo.</em>
					</p>

					<p>
						<label for="username">Usuario: <span class="requiredField">*</span></label>
						<input type="text" id="username" name="user"  value="" required>
						<em>&nbsp;Entre 3 y 20 caracteres, letras o números.</em>
					</p>
					
					<p>
						<label for="password">Contraseña: <span class="requiredField">*</span></label>
						<input type="password" id="password" name="pass" value="" pattern="^[a-zA-Z0-9]{6,12}$" required>
						<em>&nbsp;Entre 6 y 12 caracteres, alfanuméricos.</em>
					</p>

					<p>
						<label for="email">Correo electronico: <span class="requiredField">*</span></label>
						<input type="email" id="email" name="mail" value="" required />
						<em>&nbsp;Debe ser una direccion valida de correo electronico.</em>
					</p>

					<p>
						<label for="phone">Número de telefono:</label>
						<input type="tel" id="phone" name="phone" value=""/>
						<em>10 o más caracteres, números y guiones solamente.</em>
					</p>

					<p>
						<label for="pais">País:</label>
						<select name="pais" id="pais">
							<option value="">
								<?php
								$sql="SELECT * FROM paises";
								$registros=mysql_query($sql);
								while($linea=mysql_fetch_array($registros))
								{
									echo"<option value='$linea[idpais]'>$linea[pais]";
								}
								?>
						</select>
					</p>
		
					<div class="distanceLeft">
						<input type="checkbox" id="terms" name="terms" />
						<label for="terms">He leído y estoy de acuerdo con los <a href="#">Términos de Servicio.</a>.</label>
					</div>
				
					<input type="submit" value="Registrar" />

					<div class="formExtra">
						<p><strong>Nota: </strong> Los campos marcados con <span class="requiredField">*</span> son obligatorios.</p>
					</div>

				</fieldset>
			
			</form>
			
			<!-- Sidebar -->
			<div id="sidebar">
				<h3>Ventajas por registrarse</h3>
				
				<ul>
					<li>Gestiónn datos personales</li>
					<li>Gestión descargas digitales</li>
					<li>Mis favoritos</li>
					<li>Gestión Artículos</li>
				</ul>
			</div> <!-- end sidebar -->
		
		</div> <!-- end signUp -->
	
	</div> <!-- end pageContainer -->

	
</body>
</html>
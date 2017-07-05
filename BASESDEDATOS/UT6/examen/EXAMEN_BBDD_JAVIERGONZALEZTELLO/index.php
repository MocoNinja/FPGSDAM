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

	<div id="container">
	
		<!-- Tabs -->
		<ul id="tabs" class="clearfix">
			<li class="activeTab" id="signInTab">
				<div class="signInTabContent">
					<span>�Ya eres miembro?</span>
					<h1>Acceder a continuaci�n</h1>
				</div>
				
				<span class="activeTabArrow"><!-- --></span>
			</li>
			<li class="inactiveTab" id="signUpTab">
				<div class="signUpTabContent">
					<span>�No tienes una cuenta?</span>
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
						<label for="login-password">Contrase�a:</label>
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
						<p><strong>¿No dispone de cuenta?</strong></p>
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
						<em>&nbsp;Entre 3 y 20 caracteres, letras o n�meros.</em>
					</p>
					
					<p>
						<label for="password">Contrase�a: <span class="requiredField">*</span></label>
						<input type="password" id="password" name="pass" value="" pattern="^[a-zA-Z0-9]{6,12}$" required>
						<em>&nbsp;Entre 6 y 12 caracteres, alfanum�ricos.</em>
					</p>

					<p>
						<label for="email">Correo electronico: <span class="requiredField">*</span></label>
						<input type="email" id="email" name="mail" value="" required />
						<em>&nbsp;Debe ser una direccion valida de correo electronico.</em>
					</p>

					<p>
						<label for="phone">Numero de telefono:</label>
						<input type="tel" id="phone" name="phone" value=""/>
						<em>10 o mas caracteres, numeros y guiones solamente.</em>
					</p>

					<p>
						<label for="pais">Pais:</label>
						<select name="pais" id="pais">
						<!--
						No me funciona esto; lo hago a mano para que al menos salga algo
						<?php
						include("conexion.php");
						session_start();
						$sql1 = "SELECT * FROM paises";
						$registros=mysql_query($sql1);
						while ($linea=mysql_fetch_array($registros)){
						$idpais = $linea['idpais'];
						$pais = $linea['pais'];
						echo "<p>Entra</p>";
						echo "<option value='".$idpais."'>".$pais."</option>";
						}
						mysql_close($conexion);
						?>
						-->
						
						<option value="1">España</option>
						<option value="2">Francia</option>
						<option value="3">Italia</option>
						<option value="4">Inglaterra</option>
						<option value="5">Portugal</option>
						<option value="6">Peru</option>
						<option value="7">Colombia</option>
						<option value="8">India</option>
						<option value="9">China</option>

						
						</select>
					</p>
		
					<div class="distanceLeft">
						<input type="checkbox" id="terms" name="terms" />
						<label for="terms">He le�do y estoy de acuerdo con los <a href="#">T�rminos de Servicio.</a>.</label>
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
					<li>Gesti�nn datos personales</li>
					<li>Gesti�n descargas digitales</li>
					<li>Mis favoritos</li>
					<li>Gesti�n Art�culos</li>
				</ul>
			</div> <!-- end sidebar -->
		
		</div> <!-- end signUp -->
	
	</div> <!-- end pageContainer -->

	
</body>
</html>
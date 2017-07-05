<?php	//Conexion con la base 	
$conexion = mysql_connect("localhost","root","") or die("Error en la conexion");
$bd = mysql_select_db("tienda",$conexion) or die("La Base de datos no existe");?>
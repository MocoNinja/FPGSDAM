<?php
// Recuperamos datos del formulario
$nom=$_POST['nombre'];
$pro=$_POST['proveedor'];
$marca=$_POST['marca'];
$mode=$_POST['modelo'];
$nSer=$_POST['nSerie'];
$cant=$_POST['cantidad'];
$fEnt=$_POST['fechaEntrada'];
$auto=$_POST['autorizador'];
$ubi=$_POST['ubicacion'];
$nInt=$_POST['nInterno'];
$gara=$_POST['garantia'];
$fBa=$_POST['fechaBaja'];
$esta=$_POST['estado'];
$obs=$_POST['observacion'];

//Variables ordenador
$placa=$_POST['placa'];
$procesador=$_POST['procesador'];
$duro=$_POST['discoDuro'];
$ram=$_POST['ram'];
$duro=$_POST['discoDuro'];
$tarjeta=$_POST['tarjeta'];
$ident=$_POST['identificador'];
$dominio=$_POST['dominio'];

//Variables impresora
$tipo=$_POST['tipoImpresora'];
$consumible=$_POST['consumible'];

//Variables monitor
$tam=$_POST['tamanyo'];
$tMoni=$_POST['tipoMonitor'];

// conectamos con la BD
include("conexion.php");
// creamos consulta
$sql="INSERT INTO materiales(nombre,idProveedor,idMarca,modelo,numeroSerie,cantidad, fechaEntrada, idAutorizador, idUbicacion, numeroInterno, garantia, fechaBaja, estado, observaciones)
 VALUES ('$nom',$pro,$marca, '$mode','$nSer',$cant,'$fEnt',$auto,$ubi,'$nInt',$gara,'$fBa','$esta','$obs')";
 // ejecutamos la consulta
mysqli_query($conexion,$sql) or die("Error en la consulta de insercion $sql");
$idMaterial = mysqli_insert_id($conexion);

switch($_POST['tipoMaterial']) {
	case 'ordenador':
		$sql2 ="INSERT INTO ordenadores(idMaterial,placa,procesador,memoriaRAM,discoDuro,tarjetas, identificador, dominio)
		VALUES ($idMaterial, '$placa', '$procesador', '$ram', '$duro', '$tarjeta', '$ident', '$dominio')";
		
		break;
	case 'impresora':
		$sql2 ="INSERT INTO impresoras(idMaterial,tipo,consumible)
		VALUES ($idMaterial, '$tipo', '$consumible')";
		break;
	case 'monitor':
		$sql2 ="INSERT INTO monitores(idMaterial,tamanyo,tipo)
		VALUES ($idMaterial, '$tam', '$tMoni')";

		break;
	/*default:
		# code...
		break;*/
}
if($sql2!=null)
	mysqli_query($conexion,$sql2) or die("Error en la consulta de insercion $sql2");
// cerramos la conexion
mysqli_close($conexion);
// redirigimos a la pagina inicial
header("location:materiales.php");
?>
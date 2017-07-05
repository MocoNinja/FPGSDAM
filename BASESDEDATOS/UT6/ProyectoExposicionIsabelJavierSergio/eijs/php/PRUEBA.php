<?php
include("conexion.php");
$sqlMateriales = "SELECT * FROM Materiales";
$materialesRecuperados = mysqli_query($conexion,$sqlMateriales) or die("Error en la consulta de inserción $sqlMateriales");
while($linea=mysqli_fetch_array($materialesRecuperados)){
$material = $linea['nombre'];
$idMaterial = $linea['idMaterial'];
$opcion = "<option value='".$idMaterial."'>".$material."</option>";
echo $opcion;
}
?>

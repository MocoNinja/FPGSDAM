<?php
include('conexion.php');
session_destroy();
header("location:index.php");
?>
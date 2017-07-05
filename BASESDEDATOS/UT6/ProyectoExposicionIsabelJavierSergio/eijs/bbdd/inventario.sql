-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 02-06-2017 a las 10:12:10
-- Versión del servidor: 5.5.16
-- Versión de PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `inventario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `impresoras`
--

CREATE TABLE IF NOT EXISTS `impresoras` (
  `idMaterial` int(11) NOT NULL,
  `tipo` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `consumible` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idMaterial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `impresoras`
--

INSERT INTO `impresoras` (`idMaterial`, `tipo`, `consumible`) VALUES
(3, 'Tinta', 'Brother'),
(7, 'dfg', 'dfg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidencias`
--

CREATE TABLE IF NOT EXISTS `incidencias` (
  `idIncidencia` int(11) NOT NULL AUTO_INCREMENT,
  `incidencia` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `fechaIncidencia` datetime NOT NULL,
  `fechaSolucion` datetime DEFAULT NULL,
  `solucion` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `idMaterial` int(11) NOT NULL,
  PRIMARY KEY (`idIncidencia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `incidencias`
--

INSERT INTO `incidencias` (`idIncidencia`, `incidencia`, `fechaIncidencia`, `fechaSolucion`, `solucion`, `idMaterial`) VALUES
(1, 'Explosion de la PIA', '2017-05-03 00:00:00', '2017-05-20 00:00:00', 'Cambiarla', 1),
(3, 'test', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'sad', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `licencias`
--

CREATE TABLE IF NOT EXISTS `licencias` (
  `idSoftware` int(11) NOT NULL,
  `idMaterial` int(11) NOT NULL,
  PRIMARY KEY (`idSoftware`,`idMaterial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `licencias`
--

INSERT INTO `licencias` (`idSoftware`, `idMaterial`) VALUES
(1, 1),
(2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

CREATE TABLE IF NOT EXISTS `marcas` (
  `idMarca` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(35) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idMarca`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `marcas`
--

INSERT INTO `marcas` (`idMarca`, `Nombre`) VALUES
(1, 'Samsung'),
(2, 'ASUS'),
(3, 'NVIDIA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materiales`
--

CREATE TABLE IF NOT EXISTS `materiales` (
  `idMaterial` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(35) COLLATE utf8_unicode_ci NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `idMarca` int(11) NOT NULL,
  `modelo` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `numeroSerie` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fechaEntrada` datetime NOT NULL,
  `idAutorizador` int(11) NOT NULL,
  `idUbicacion` int(11) NOT NULL,
  `numeroInterno` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `garantia` tinyint(1) NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `estado` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `observaciones` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idMaterial`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `materiales`
--

INSERT INTO `materiales` (`idMaterial`, `nombre`, `idProveedor`, `idMarca`, `modelo`, `numeroSerie`, `cantidad`, `fechaEntrada`, `idAutorizador`, `idUbicacion`, `numeroInterno`, `garantia`, `fechaBaja`, `estado`, `observaciones`) VALUES
(1, 'Ordenador 1', 2, 2, 'Ordenador sencillito 1', '213ascsg123', 2, '2017-02-14 13:06:23', 3, 1, 'sd234242fw2', 1, '0000-00-00 00:00:00', 'Bien', 'Va bien'),
(2, 'Monitor 1', 2, 1, 'Monitor cutrón', '213asf324fd', 10, '2017-05-05 00:00:00', 2, 1, 'sdcswef234d2e23', 0, NULL, 'Bien', 'nada'),
(3, 'Impresora 1', 2, 3, 'sd3242weffw', '1', 23, '2017-05-11 00:00:00', 1, 1, 'wqedw342dw', 1, NULL, '', ''),
(4, 'Tornillos', 1, 1, 'Tornillos de los buenos', '2131fcw3242d', 3423423, '2017-05-09 00:00:00', 2, 1, 'sdfwef2342', 1, NULL, '', 'Que nose piefan!!!!11!'),
(5, 'dfg', 1, 2, 'dfg', 'dfg', 1, '0000-00-00 00:00:00', 1, 1, '', 0, '2017-06-02 00:00:00', 'dfg', 'fgdfg'),
(6, 'gfh', 1, 3, 'fgh', 'fgh', 3, '2017-06-02 00:00:00', 2, 1, 'gfh', 0, '2017-06-16 00:00:00', 'gfh', 'fgh'),
(7, 'imp', 1, 1, 'dfg', 'dfg', 3, '2017-07-21 00:00:00', 3, 2, 'dfg', 0, '2017-06-16 00:00:00', 'dfg', 'dfgdfg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `monitores`
--

CREATE TABLE IF NOT EXISTS `monitores` (
  `idMaterial` int(11) NOT NULL,
  `tamanyo` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `tipo` varchar(35) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idMaterial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `monitores`
--

INSERT INTO `monitores` (`idMaterial`, `tamanyo`, `tipo`) VALUES
(2, '20 pulgadas', 'Monitor de pie');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenadores`
--

CREATE TABLE IF NOT EXISTS `ordenadores` (
  `idMaterial` int(11) NOT NULL,
  `placa` varchar(35) COLLATE utf8_unicode_ci NOT NULL,
  `procesador` varchar(35) COLLATE utf8_unicode_ci NOT NULL,
  `memoriaRAM` varchar(35) COLLATE utf8_unicode_ci NOT NULL,
  `discoDuro` varchar(35) COLLATE utf8_unicode_ci NOT NULL,
  `tarjetas` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `identificador` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `dominio` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idMaterial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `ordenadores`
--

INSERT INTO `ordenadores` (`idMaterial`, `placa`, `procesador`, `memoriaRAM`, `discoDuro`, `tarjetas`, `identificador`, `dominio`) VALUES
(1, 'ASUS', 'i5 3Ghz', '8 GB DDR4', 'SSD 150 GB', 'Nvidia 1080 GTX', '23fsfdsf34sd', '1h'),
(5, 'fdg', 'fdg', 'fdg', 'fdg', 'fdg', 'fdg', 'fdg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE IF NOT EXISTS `proveedores` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(35) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`idProveedor`, `nombre`) VALUES
(1, 'Talleres Agapito'),
(2, 'M4st3rH4x0r Systems');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `software`
--

CREATE TABLE IF NOT EXISTS `software` (
  `idLicencia` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tipolicencia` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fechaCaducidad` datetime DEFAULT NULL,
  `observaciones` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idLicencia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `software`
--

INSERT INTO `software` (`idLicencia`, `descripcion`, `tipolicencia`, `cantidad`, `fechaCaducidad`, `observaciones`) VALUES
(2, 'Codeblocks', 'GNU', 100, NULL, 'Programar C/C++'),
(3, 'Windows XP', 'Propietaria', 10, '2017-05-31 00:00:00', 'El único sistema decente de Mocosoft');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicaciones`
--

CREATE TABLE IF NOT EXISTS `ubicaciones` (
  `idUbicacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `nombreAntiguo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idUbicacion`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `ubicaciones`
--

INSERT INTO `ubicaciones` (`idUbicacion`, `nombre`, `nombreAntiguo`) VALUES
(1, 'Aula 00', '00 aluA'),
(2, 'Aula 01', '10 aluA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `apellidos` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `rol` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `nombre`, `apellidos`, `rol`, `username`, `password`) VALUES
(1, 'Federico', 'Garcia Perez', 'administrador', 'fgp', 'fgp'),
(2, 'Dolores', 'Fuertes Debarriga', 'sat', 'dfd', 'dfd'),
(3, 'Lucas', 'Lucas Lucas', 'profesor', 'lll', 'lll');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-04-2017 a las 16:39:07
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `fctdual`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `dni` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `alumno` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `nifempresa` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `idestudios` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`dni`, `alumno`, `email`, `telefono`, `nifempresa`, `idestudios`) VALUES
('a1a1a1a1a', 'Picateclas', 'no@no.no', '231456745', 'AAAAAAAAA', 1),
('b2b2b2b2b', 'Noseprogramar', 'no@si.quizas', '342357434', 'BBBBBBBBB', 2),
('c3c3c3c3c', 'Birlacoches', 'asd@no.si', '342353434', 'CCCCCCCCC', 3),
('d4d4d4d4d', 'Science bititch', 'tungsteno@wolframio.W', '345755463', 'DDDDDDDDD', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--

CREATE TABLE `empresas` (
  `nif` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `empresa` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `dniusuario` varchar(9) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `empresas`
--

INSERT INTO `empresas` (`nif`, `empresa`, `direccion`, `email`, `telefono`, `dniusuario`) VALUES
('313143141', '1414141414', '1414@141.4', '14141414', '141414141', ''),
('AAAAAAAAA', 'ProgrammingBosses', '0xFFFFF0', 'picandocodigo@pc.com', '356735343', '111111111'),
('BBBBBBBBB', 'FibraGratis4Every1', 'Tus sueños', 'free111@gmail.de', '234232353', '222222222'),
('CCCCCCCCC', 'Cochelandia', 'Talleres Agapito', 'motosnosolocoches@facebook.ze', '345345735', '333333333'),
('DDDDDDDDD', 'TerminatorMaker', 'Lavase', 'skynet@gov.ne', '234224523', '444444444'),
('R5000178J', 'Salesianos', 'Zaragoza', 'salesianos@sal.edu', '234232343', 'ZZZZZZZZZ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudios`
--

CREATE TABLE `estudios` (
  `idestudio` int(11) NOT NULL,
  `estudio` varchar(60) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `estudios`
--

INSERT INTO `estudios` (`idestudio`, `estudio`) VALUES
(1, 'Programación'),
(2, 'Telecomunicaciones'),
(3, 'Automoción'),
(4, 'Science!');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informes`
--

CREATE TABLE `informes` (
  `idinforme` int(11) NOT NULL,
  `dnialumno` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `dniusuario` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `fechainicio` date NOT NULL,
  `fechafin` date NOT NULL,
  `horainicio` time NOT NULL,
  `horafin` time NOT NULL,
  `tecnica` smallint(6) NOT NULL,
  `aprendizaje` smallint(6) NOT NULL,
  `planificacion` smallint(6) NOT NULL,
  `recambios` smallint(6) NOT NULL,
  `organizacion` smallint(6) NOT NULL,
  `orden` smallint(6) NOT NULL,
  `consultas` smallint(6) NOT NULL,
  `iniciativa` smallint(6) NOT NULL,
  `relacion` smallint(6) NOT NULL,
  `criticas` smallint(6) NOT NULL,
  `responsabilidad` smallint(6) NOT NULL,
  `puntualidad` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `informes`
--

INSERT INTO `informes` (`idinforme`, `dnialumno`, `dniusuario`, `fechainicio`, `fechafin`, `horainicio`, `horafin`, `tecnica`, `aprendizaje`, `planificacion`, `recambios`, `organizacion`, `orden`, `consultas`, `iniciativa`, `relacion`, `criticas`, `responsabilidad`, `puntualidad`) VALUES
(2, 'a1a1a1a1a', '', '2017-04-13', '2017-04-19', '01:00:00', '23:59:00', 3, 5, 1, 4, 2, 2, 3, 3, 4, 2, 2, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `dni` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `clave` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `fechaultimoacceso` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`dni`, `clave`, `nombre`, `email`, `telefono`, `fechaultimoacceso`) VALUES
('111111111', '111111111', 'Ada Lovelace', 'xXxgitgudXxX@gmail.com', '345234553', '0000-00-00 00:00:00'),
('222222222', '222222222', 'Agustina de Aragón', 'chupaos.esa@gmail.com', '345123423', '0000-00-00 00:00:00'),
('333333333', '333333333', 'Napoléon Bonaparte', 'nopuedoconlosmaños@gmail.com', '345757864', '0000-00-00 00:00:00'),
('444444444', '444444444', 'Sir Isaac Newton', 'newton.putoamo@gmail.com', '238734393', '0000-00-00 00:00:00'),
('ZZZZZZZZZ', 'ZZZZZZZZZ', 'ADMIN', 'root@gmail.com', '234322335', '0000-00-00 00:00:00');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `empresas`
--
ALTER TABLE `empresas`
  ADD PRIMARY KEY (`nif`);

--
-- Indices de la tabla `estudios`
--
ALTER TABLE `estudios`
  ADD PRIMARY KEY (`idestudio`);

--
-- Indices de la tabla `informes`
--
ALTER TABLE `informes`
  ADD PRIMARY KEY (`idinforme`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estudios`
--
ALTER TABLE `estudios`
  MODIFY `idestudio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `informes`
--
ALTER TABLE `informes`
  MODIFY `idinforme` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

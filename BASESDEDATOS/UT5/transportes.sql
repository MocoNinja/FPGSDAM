-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 06, 2016 at 01:27 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `transportes`
--

-- --------------------------------------------------------

--
-- Table structure for table `categorias`
--

CREATE TABLE IF NOT EXISTS `categorias` (
  `idcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Dumping data for table `categorias`
--

INSERT INTO `categorias` (`idcategoria`, `categoria`) VALUES
(1, '9 plazas Furgoneta'),
(2, 'Carga Grande'),
(3, 'Sin Categoria'),
(4, 'Carga Pequeña'),
(5, '5 plazas Sencillo'),
(6, '5 plazas Todo Terreno'),
(7, '5 plazas Normal');

-- --------------------------------------------------------

--
-- Table structure for table `conductores`
--

CREATE TABLE IF NOT EXISTS `conductores` (
  `idVoluntario` int(11) NOT NULL,
  `horaInicio` time DEFAULT NULL,
  `horaFin` time DEFAULT NULL,
  `diasDisponibles` varchar(50) DEFAULT NULL,
  `servicios` int(11) DEFAULT '0',
  PRIMARY KEY (`idVoluntario`),
  KEY `idConductor` (`idVoluntario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `conductores`
--

INSERT INTO `conductores` (`idVoluntario`, `horaInicio`, `horaFin`, `diasDisponibles`, `servicios`) VALUES
(1, '06:00:00', '22:00:00', '15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25', 1),
(2, '09:00:00', '22:00:00', '17, 18, 19, 20, 21, 22, 23, 24, 25', 1),
(3, '06:00:00', '22:00:00', '17, 18, 19, 20, 21, 22, 23, 24, 25', 0),
(4, '05:00:00', '12:00:00', '18, 19, 20, 21, 22, 23, 24, 25', 0),
(5, '06:00:00', '14:00:00', '18, 19, 21, 22, 23, 25', 0),
(6, '06:00:00', '22:00:00', '23', 0),
(7, '14:00:00', '22:00:00', '18, 19,20, 21, 22, 23, 24, 25', 0),
(8, '06:00:00', '22:00:00', '17,18,19,20,21,22,23', 0),
(9, '12:00:00', '19:00:00', '18, 19,20, 21, 22, 23, 24, 25', 0),
(10, '06:00:00', '22:00:00', '14,15,16 ,17,18,19,20,21,22,23,24,25', 6),
(11, '06:00:00', '22:00:00', '17,18,19,20,21,22,23,24,25', 0),
(12, '06:00:00', '14:00:00', '17,18,19,20,21,22,23,24,25', 0),
(13, '06:00:00', '22:00:00', '18,19,20,21,22,23,24,25', 0),
(14, '06:00:00', '11:30:00', '17, 18, 19, 20, 21, 22', 0),
(15, '06:00:00', '22:00:00', '14,15,16,17,23,24,25,26', 1),
(16, '17:00:00', '22:00:00', '17, 18, 20, 21, 22, 23, 24, 25', 0),
(17, '06:00:00', '22:00:00', '17,18,21,22,23', 1),
(18, '08:00:00', '20:00:00', '16, 17, 18, 19, 20, 21, 22, 23, 24, 25', 1),
(19, '10:00:00', '22:00:00', '20,21', 0),
(20, '06:00:00', '22:00:00', '18, 19, 20, 21, 22, 23, 24, 25', 0),
(21, '06:00:00', '22:00:00', '18, 19, 20, 21, 22, 23, 24, 25', 0),
(22, '05:00:00', '12:00:00', '17', 0),
(23, '06:00:00', '22:00:00', '12,13,14,15,16,17,18,19,20,21,22,23,24,25', 3),
(24, '14:00:00', '22:00:00', '14, 15, 16, 17, 18, 18, 20, 21, 22, 23, 24, 25', 0),
(25, '06:00:00', '22:00:00', '12,13,14,15,16,17,18,19,20,21,22,23,24,25', 0),
(26, '06:00:00', '14:00:00', '14, 15, 16, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25', 0),
(27, '07:30:00', '16:00:00', '16, 17, 18, 19, 20, 21, 22, 23, 24, 25', 1),
(28, '14:00:00', '22:00:00', '15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25', 1),
(29, '06:00:00', '23:59:00', '15, 16, 17, 18, 19, 20, 21, 22, 23, 25', 0),
(30, '18:30:00', '22:00:00', '15,16,17,18,19,20,21,22,23', 0),
(31, '14:00:00', '22:00:00', '21', 0),
(32, '14:00:00', '22:00:00', '19,20,21,22,23', 0),
(33, '09:00:00', '22:00:00', '15,16,17,18,19,20,21,22,23,24,25', 0),
(34, '14:00:00', '22:00:00', '18,19,20,21,22,23', 0),
(35, '08:00:00', '22:00:00', '16,17,18,19,20,21,22,23, 24', 1),
(36, '06:00:00', '22:00:00', '18,19,20,21,22,23,24', 0),
(37, '14:00:00', '22:00:00', '16,17,18,19,20,21,22,23', 0),
(38, '14:00:00', '22:00:00', '18, 19,22, 23, 24, 25', 0),
(39, '14:00:00', '22:00:00', '18, 19, 20,21,22, 23, 24, 25', 0),
(40, '14:00:00', '22:00:00', '18, 19, 20,21,22, 23, 24, 25', 0),
(41, '14:00:00', '22:00:00', '16,17,18,19,20,21,22,23', 0),
(42, '06:00:00', '22:00:00', '13,14,15,16,17,18,19,20,21,22,23,24,25', 0),
(43, '06:00:00', '14:00:00', '13,14,15,16,17,18,19,20,21,22,23, 24, 25', 0),
(44, '08:00:00', '22:00:00', '13,14,15,16,17,18,19,20,21,22,23, 24, 25', 0),
(45, '05:00:00', '12:00:00', '17,18,19,20,21,22,23,24,25', 0),
(46, '14:00:00', '22:00:00', '17, 18, 25, 26', 0),
(47, '14:00:00', '22:00:00', '17,18,19,20,24,25', 0),
(48, '06:30:00', '09:30:00', '17,18,19,20,21,22,23,24,25', 0),
(49, '06:00:00', '22:00:00', '17,18,19,20,21,22,23,24,25', 0),
(50, '12:00:00', '19:00:00', '16,17,18,19,20,21,22,23,24,25', 0),
(51, '06:00:00', '07:00:00', '16,17,18,19,20,21,22,23,24,', 0),
(52, '14:00:00', '23:59:00', '18,19,20,21,22,23,24,25', 0),
(53, '14:00:00', '22:00:00', '19,20,21,22,23', 0),
(54, '06:00:00', '22:00:00', '16,17,18,19,20,21,22,23,24,25', 0),
(55, '14:00:00', '22:00:00', '16,17,18,19,20,21,22,23,24,25', 0),
(56, '06:00:00', '22:00:00', '18,19,20,21,22,23,24,25', 0),
(57, '06:00:00', '22:00:00', '14,15,16,17,18,19,20,21,22,23', 0),
(58, '06:00:00', '14:00:00', '18,19,20,21,22,23,24,25', 0),
(59, '14:00:00', '22:00:00', '14,15,16,17,18,19,20,21,22,23', 0),
(60, '08:00:00', '22:00:00', '18,19,20,21,22,23', 0),
(61, '12:00:00', '19:00:00', '16,17,18,19,20,21', 0),
(62, '08:00:00', '14:00:00', '18,19,20,21,22,23, 24,', 0),
(63, '08:00:00', '22:00:00', '17,18,19,20,21,22,23,24,25', 0),
(64, '08:00:00', '22:00:00', '18,19,20', 0),
(65, '00:00:00', '23:59:00', '17,18,19,20,21,22,23', 0),
(66, '14:00:00', '22:00:00', '17', 0),
(67, '05:00:00', '14:00:00', '18, 19, 20', 0),
(68, '08:00:00', '22:00:00', '17, 18, 19, 20, 21, 22, 23, 24', 0),
(69, '08:00:00', '22:00:00', '18, 19, 20, 21, 22', 0),
(70, '14:00:00', '22:30:00', '17, 18, 19, 20, 21, 22, 23, 24', 0),
(71, '05:00:00', '22:00:00', '17,18,19,20,21,22,23,24,25', 0),
(72, '16:00:00', '23:59:00', '19, 20, 23', 0),
(73, '14:00:00', '22:00:00', '19, 20 ,21, 22, 23', 0),
(74, '00:00:00', '23:59:00', '17, 18, 19, 20, 21, 22, 23, 24', 0);

--
-- Table structure for table `marcas`
--

CREATE TABLE IF NOT EXISTS `marcas` (
  `idmarca` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`idmarca`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `marcas`
--

INSERT INTO `marcas` (`idmarca`, `marca`) VALUES
(1, 'NISSAN'),
(2, 'FORD'),
(3, 'CITROEN');

-- --------------------------------------------------------

--
-- Table structure for table `modelos`
--

CREATE TABLE IF NOT EXISTS `modelos` (
  `idmodelo` int(11) NOT NULL AUTO_INCREMENT,
  `idmarca` int(11) NOT NULL,
  `modelo` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`idmodelo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=13 ;

--
-- Dumping data for table `modelos`
--

INSERT INTO `modelos` (`idmodelo`, `idmarca`, `modelo`) VALUES
(1, 3, 'C5'),
(2, 2, 'FOCUS'),
(3, 2, 'JUMPER'),
(4, 1, 'KUBISTAR'),
(5, 2, 'MONDEO'),
(6, 1, 'MURANO'),
(7, 1, 'NOTE'),
(8, 1, 'PATHFINDER'),
(9, 1, 'PRIMASTAR'),
(10, 1, 'PRIMERA'),
(11, 2, 'TRANSIT'),
(12, 1, 'X-TRAIL');

-- --------------------------------------------------------

--
-- Table structure for table `reservas`
--

CREATE TABLE IF NOT EXISTS `reservas` (
  `idReserva` int(11) NOT NULL AUTO_INCREMENT,
  `trayecto` varchar(50) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `horaInicio` time DEFAULT NULL,
  `horaFin` time DEFAULT NULL,
  `idVoluntario` int(11) DEFAULT NULL,
  `idVehiculo` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idReserva`),
  KEY `idConductor` (`idVoluntario`),
  KEY `idReserva` (`idReserva`),
  KEY `idVehiculo` (`idVehiculo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `reservas`
--

INSERT INTO `reservas` (`idReserva`, `trayecto`, `fecha`, `horaInicio`, `horaFin`, `idVoluntario`, `idVehiculo`) VALUES
(1, 'CATERING ASTUN-CANDANCHU', '2014-02-05', '06:00:00', '20:00:00', 10, 'PR 2'),
(2, 'CASA CULTURA', '2014-02-05', '06:00:00', '20:00:00', 23, 'PR 1'),
(3, 'BARCELONA RECOGIDA DELEGACIONES', '2014-02-07', '07:30:00', '19:00:00', 10, 'PR 4'),
(4, 'MADRID RECOGIDA DELEGACIONES', '2014-02-07', '07:30:00', '19:00:00', 23, 'PR 3'),
(5, 'ZARAGOZA RECOGIDA DELEGACIONES', '2014-02-14', '07:30:00', '19:00:00', 10, 'PR 6'),
(6, 'VALENCIA RECOGIDA DELEGACIONES', '2014-02-14', '07:30:00', '19:00:00', 23, 'PR 5'),
(7, 'VILLANUA', '2014-02-15', '14:00:00', '19:00:00', 10, 'PR 6'),
(8, 'BUSCAR ANTORCHA OLIMPICA', '2014-02-16', '14:00:00', '19:00:00', 10, 'PR 6'),
(9, 'PALACIO DE HIELO', '2014-02-17', '20:40:00', '22:00:00', 17, 'PAT 5'),
(10, 'HUESCA RECOGIDA DELEGACIONES', '2014-02-17', '15:00:00', '22:00:00', 18, 'FG 7'),
(11, 'AVITUALLAMIENTO PANTICOSA', '2014-02-17', '22:00:00', '23:59:00', 2, 'PAT 4'),
(12, 'DELEGACION ALEMANA - JACA ARENA', '2014-02-17', '21:35:00', '23:59:00', 28, 'PAT 5'),
(13, 'PISTA DE HIELO', '2014-02-17', '20:50:00', '22:00:00', 35, 'FG 8'),
(14, 'MUR - BARCELO', '2014-02-17', '20:40:00', '23:59:00', 27, 'PR 2'),
(15, 'RECOGIDA PRESIDENTE COI', '2014-02-17', '08:00:00', '10:00:00', 10, 'RENT T1'),
(16, 'PALACIO DE CONGRESOS', '2015-02-23', '13:00:00', '15:00:00', 15, 'NOT 5'),
(17, 'maria auxiliadora ctro zgza', '2015-03-12', '10:00:00', '11:00:00', 1, 'BUS 2');

--
-- Table structure for table `vehiculos`
--

CREATE TABLE IF NOT EXISTS `vehiculos` (
  `idVehiculo` varchar(15) CHARACTER SET utf8 NOT NULL,
  `matricula` varchar(8) CHARACTER SET utf8 DEFAULT NULL,
  `idmodelo` int(11) NOT NULL,
  `idcategoria` int(11) NOT NULL,
  `observaciones` longtext CHARACTER SET utf8,
  PRIMARY KEY (`idVehiculo`),
  KEY `idVehiculo` (`idVehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `vehiculos`
--

INSERT INTO `vehiculos` (`idVehiculo`, `matricula`, `idmodelo`, `idcategoria`, `observaciones`) VALUES
('BUS 1', '8822 FJF', 9, 1, ''),
('BUS 2', '4698 FLF', 9, 1, ''),
('BUS 3', '4706 FLF', 9, 1, ''),
('BUS 4', '4714 FLF', 9, 1, ''),
('BUS 5', '4723 FLF', 9, 1, ''),
('BUS 6', '4729 FLF', 9, 1, ''),
('BUS 7', '4736 FLF', 9, 1, ''),
('BUS 8', '3813 FLF', 9, 1, ''),
('FG 1', '3779 FLF', 9, 2, ''),
('FG 2', '3799 FLF', 9, 2, ''),
('FG 4', '3822 FLF', 9, 2, ''),
('FG 5', '3840 FLF', 9, 2, ''),
('FG 6', '3887 FLF', 9, 2, ''),
('FG 7', '3913 FLF', 9, 2, ''),
('FG 8', '4743 FLF', 9, 2, ''),
('FG 9', '4760 FLF', 9, 2, ''),
('FOC1', '6188 DYJ', 2, 3, ''),
('KUB1', '8824 FJF', 4, 4, ''),
('MUR 1', '4359 FHW', 6, 3, ''),
('NOT 1', '9902 FJG', 7, 5, ''),
('NOT 2', '9911 FJD', 7, 5, ''),
('NOT 3', '9923 FJG', 7, 5, ''),
('NOT 4', '0922 FJJ', 7, 5, ''),
('NOT 5', '0932 FJJ', 7, 5, ''),
('PAT 1', '2358 FJW', 8, 6, ''),
('PAT 2', '2384 FJW', 8, 6, ''),
('PAT 3', '1838 DXK', 8, 6, ''),
('PAT 4', '1850 DXK', 8, 6, ''),
('PAT 5', '1823 DXK', 8, 6, ''),
('PAT 6', '2404 FJW', 8, 6, ''),
('PR 1', '1470 FJD', 10, 7, ''),
('PR 10', '1508 FLC', 10, 7, ''),
('PR 11', '1515 FLC', 10, 7, ''),
('PR 12', '1523 FLC', 10, 7, ''),
('PR 13', '1531 FLC', 10, 7, ''),
('PR 14', '1540 FLC', 10, 7, ''),
('PR 15', '1544 FLC', 10, 7, ''),
('PR 16', '1552 FLC', 10, 7, ''),
('PR 17', '1559 FLC', 10, 7, ''),
('PR 18', '1568 FLC', 10, 7, ''),
('PR 2', '1606 FJD', 10, 7, ''),
('PR 3', '1626 FJD', 10, 7, ''),
('PR 4', '1632 FJD', 10, 7, ''),
('PR 5', '1636 FJD', 10, 7, ''),
('PR 6', '1641 FJD', 10, 7, ''),
('PR 7', '1644 FJD', 10, 7, ''),
('PR 8', '1649 FJD', 10, 7, ''),
('PR 9', '1657 FJD', 10, 7, ''),
('RENT C1', '6671 DGG', 1, 7, ''),
('RENT C2', '0218 DPN', 2, 7, ''),
('RENT C3', '8700 DKN', 5, 7, ''),
('RENT C4', '9181 DLK', 5, 7, ''),
('RENT C5', '7095 FBS', 5, 7, ''),
('RENT T1', '6855 DPD', 11, 2, ''),
('RENT T2', '6893 DPD', 11, 2, ''),
('RENT T3', '4008 DMD', 11, 2, ''),
('RENT T4', '1654 DXG', 3, 2, ''),
('RENT T5', '5235 FGJ', 11, 2, ''),
('XT 1', '4372 FHW', 12, 6, ''),
('XT 11', '1095 FJJ', 12, 6, ''),
('XT 12', '1041 FJJ', 12, 6, ''),
('XT 13', '1099 FJJ', 12, 6, ''),
('XT 2', '4377 FHW', 12, 6, ''),
('XT 3', '9861 FJG', 12, 6, ''),
('XT 4', '7513 FBJ', 12, 6, ''),
('XT 5', '7535 FBJ', 12, 6, ''),
('XT 6', '5897 DYG', 12, 6, ''),
('XT 7', '2372 FJW', 12, 6, ''),
('XT 8', '9895 FJG', 12, 6, ''),
('XT 9', '0004 FJH', 12, 6, '');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

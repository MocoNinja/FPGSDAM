-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 31-05-2017 a las 13:15:05
-- Versión del servidor: 5.5.16
-- Versión de PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `tienda`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora`
--

CREATE TABLE IF NOT EXISTS `bitacora` (
  `idBitacora` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `operacion` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`idBitacora`),
  KEY `usuario` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=62 ;

--
-- Volcado de datos para la tabla `bitacora`
--

INSERT INTO `bitacora` (`idBitacora`, `usuario`, `operacion`, `fecha`) VALUES
(1, '1h', 'ALTA', '2017-05-27 09:54:44'),
(2, '1h', 'ALTA', '2017-05-27 09:54:44'),
(3, '2e', 'ALTA', '2017-05-27 09:54:44'),
(4, '2e', 'LOGIN', '2017-05-27 09:54:44'),
(5, '2e', 'LOGIN', '2017-05-27 09:54:44'),
(6, 'admin', 'LOGIN', '2017-05-27 09:54:44'),
(7, 'admin', 'LOGIN', '2017-05-27 09:54:44'),
(8, 'alumno', 'LOGIN', '2017-05-27 09:54:44'),
(9, 'alumno', 'ALTA', '2017-05-27 09:54:44'),
(10, 'admin', 'LOGIN', '2017-05-27 09:54:44'),
(11, 'alumno', 'LOGIN', '2017-05-27 09:54:44'),
(12, 'admin', 'LOGIN', '2017-05-27 09:54:44'),
(13, 'admin', 'LOGIN', '2017-05-27 09:54:44'),
(14, 'admin', 'LOGIN', '2017-05-27 09:54:44'),
(15, 'admin', 'LOGIN', '2017-05-27 09:54:44'),
(16, 'admin', 'LOGIN', '2017-05-27 09:54:44'),
(17, 'admin', 'LOGIN', '2017-05-27 09:54:44'),
(18, 'admin', 'LOGIN', '2017-05-27 09:54:44'),
(19, 'admin', 'LOGIN', '2017-05-28 09:54:44'),
(20, 'admin', 'LOGIN', '2017-05-28 09:54:44'),
(36, 'alumno', 'LOGIN', '2017-05-28 09:59:47'),
(37, 'alumno', 'LOGIN', '2017-05-28 09:59:50'),
(40, 'test1', 'Alta', '2017-05-31 10:40:11'),
(44, '1h', 'LOGIN', '2017-05-31 10:46:10'),
(45, '2e', 'LOGIN', '2017-05-31 10:46:10'),
(46, 'admin', 'LOGIN', '2017-05-31 10:46:10'),
(47, 'alumno', 'LOGIN', '2017-05-31 10:46:10'),
(48, 'test', 'LOGIN', '2017-05-31 10:46:10'),
(49, 'test1', 'LOGIN', '2017-05-31 10:46:10'),
(50, 'admin', 'LOGIN', '2017-05-31 11:08:06'),
(51, 'prueba1', 'Alta', '2017-05-31 11:20:01'),
(52, 'admin', 'LOGIN', '2017-05-31 11:20:37'),
(53, 'admin', 'LOGIN', '2017-05-31 11:40:50'),
(54, 'admin', 'LOGIN', '2017-05-31 11:46:21'),
(55, 'admin', 'LOGIN', '2017-05-31 12:36:03'),
(56, 'admin', 'LOGIN', '2017-05-31 12:38:13'),
(57, 'ttt', 'Alta', '2017-05-31 12:49:39'),
(58, 'cxbvcvxb', 'Alta', '2017-05-31 12:50:40'),
(60, 'admin', 'LOGIN', '2017-05-31 13:04:58'),
(61, 'cxbvcvxb', 'LOGIN', '2017-05-31 13:06:09');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE IF NOT EXISTS `categorias` (
  `idcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`idcategoria`, `nombre`) VALUES
(1, 'informatica'),
(3, 'telefonia'),
(5, 'television'),
(7, 'audio y video'),
(9, 'entretenimiento'),
(11, 'fotografia'),
(12, 'Tablets');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE IF NOT EXISTS `compras` (
  `idCompra` int(11) NOT NULL AUTO_INCREMENT,
  `comprador` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `idProducto` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `cantidad` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `comprador` (`comprador`),
  KEY `idproducto` (`idProducto`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=81 ;

--
-- Volcado de datos para la tabla `compras`
--

INSERT INTO `compras` (`idCompra`, `comprador`, `idProducto`, `fecha`, `cantidad`) VALUES
(32, '2e', 5, '2013-03-07', '1'),
(55, '2e', 4, '2013-05-28', '2'),
(56, '2e', 5, '2013-05-28', '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paises`
--

CREATE TABLE IF NOT EXISTS `paises` (
  `idpais` int(11) NOT NULL AUTO_INCREMENT,
  `pais` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `bandera` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idpais`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `paises`
--

INSERT INTO `paises` (`idpais`, `pais`, `bandera`) VALUES
(1, 'España', './imagenes/paises/spain.jpg'),
(2, 'Francia', './imagenes/paises/francia.jpg'),
(3, 'Italia', './imagenes/paises/italia.jpg'),
(4, 'Inglaterra', './imagenes/paises/uk.jpg'),
(5, 'Portugal', './imagenes/paises/portugal.jpg'),
(6, 'Peru', './imagenes/paises/peru.jpg'),
(7, 'Colombia', './imagenes/paises/colombia.jpg'),
(8, 'India', './imagenes/paises/india.jpg'),
(9, 'China', './imagenes/paises/china.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `precio` float NOT NULL,
  `caracteristicas` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `imagen` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `mostrar` tinyint(1) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `unidades` int(11) NOT NULL,
  `idpais` int(11) NOT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `idcategoria` (`idCategoria`),
  KEY `idpais` (`idpais`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=34 ;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `nombre`, `precio`, `caracteristicas`, `imagen`, `mostrar`, `idCategoria`, `unidades`, `idpais`) VALUES
(4, 'Asus VS197D', 89, 'Dos cámaras, para FaceTime y grabación de vídeo en HD. Chip A5 dual-core, autonomía de 10 horas, iCloud y más de 200 prestaciones de software nuevas en iOS 5.', './pic/productos/informatica/Asus_VS197D.png', 1, 1, 3, 1),
(5, 'BQ Kepler', 179, 'El nuevo netbook Acer Aspire One 722 presenta un diseño moderno en diferentes colores que te cautivará. Cuenta con la mejor tecnología de procesador AMD Fusion y viene equipado con un disco duro interno de 320Gb', './pic/productos/informatica/BQ_Kepler.png', 1, 1, 100, 1),
(6, 'HP PS 5514', 95, 'El ASUS CG820 viene equipado con la segunda generación de procesadores Intel® Core™ y soluciones gráficas dedicadas de última generación para ofrecerte un nuevo nivel de rendimiento.', './pic/productos/informatica/HP_PS_5514.png', 1, 1, 100, 1),
(7, 'Kaspersky IS', 1199, 'El PC HPE serie h8 ha sido completamente rediseñado, con un nuevo diseño elegante a juego con su perfecto rendimiento.', './pic/productos/informatica/Kaspersky_Internet_Security.png', 1, 1, 100, 1),
(9, 'Philips 228C3LHSB/00', 174, 'Las mejores prestaciones con el mejor diseño. Acabados en blanco y pantalla super brillante para disfrutar de su procesador Intel Core i7.', './pic/productos/informatica/Philips_228C3LHSB-00.png', 1, 1, 49, 1),
(10, 'Sony VPCEJ2L1E', 649, 'Disfruta de la mejor experiencia de TrackMania 2 con la 2ª generación de Procesador Intel® Core™ i5.', './pic/productos/informatica/Sony_VPCEJ2L1E.png', 0, 1, 100, 1),
(11, 'Blackberry 9360', 299, '. El nuevo smartphone BlackBerry Curve ofrece la clásica experiencia Blackberry, con su famoso teclado Blackberry que incluye un preciso trackpadóptico y el nuevo y avanzado, aunque fácil de usar, sistema operativo Blackberry 7.', './pic/1.png', 0, 3, 4, 1),
(12, 'Motorola D403 Trio', 39, 'Motorola Dispone de Manos libres, Pantalla retroiluminada, 50 memorias alfanuméricas, identificación de llamada, Intercomunicador, modo ECO reduce el consumo del terminal y melodias polifónicas.', './pic/1.png', 0, 3, 300, 1),
(13, 'Samsung Galaxy Note', 599, '? Es el nuevo Galaxy Note, con una pantalla enorme a pesar de su diseño fino y ligero. Incluye S Pen que te permite no solo escribir sino crear y compartir tus bocetos o dibujos estés donde estés.', './pic/1.png', 0, 3, 100, 1),
(14, 'Siemens Gigaset AL 140 DUO', 27, 'El teléfono fiable para minimalistas a buen precio, opción de conectar hasta 4 terminales.', './pic/1.png', 0, 3, 100, 1),
(15, 'LG M2780D', 329, 'Este televisor es una fusión de diseño y tecnología; extremadamente fino en diseño y más ecológico.\r\n\r\nAhora podrás disfrutar de la TDT en alta definición desde tu TV monitor y sintonizar los canales de tu proveedor de cable.', './pic/1.png', 0, 3, 100, 1),
(16, 'Thomson 32HS3246C', 299, 'Este televisor Thomson también cuenta con pre-ajustes de Modo Eco diseñados para optimizar el uso de energía cuando el aparato esté encendido, de forma que puedas activarlos fácilmente cuando lo desees.', './pic/1.png', 0, 3, 100, 1),
(17, 'Panasonic TX-L32E3E', 399, 'Los televisores LED de Panasonic ofrecen una calidad de imagen insuperable gracias a su reproducción de colores más naturales y negros más intensos.', './pic/1.png', 0, 3, 100, 1),
(18, 'Samsung UE37D5000', 479, 'Los televisores LED de Samsung ofrecen una calidad de imagen insuperable gracias a su reproducción de colores más naturales y negros más intensos.', './pic/1.png', 0, 3, 26, 1),
(19, 'Samsung UE46D6000', 799, 'Los televisores LED de Samsung ofrecen una calidad de imagen insuperable gracias a su reproducción de colores más naturales y negros más intensos.', './pic/1.png', 0, 3, 100, 1),
(20, 'Sony 40HX720', 949, 'Prepárate para la evolución del entretenimiento en casa. Conéctate a Internet y transmite vídeo online que puedes ver en una gran pantalla sin moverte del sofá.', './pic/1.png', 0, 3, 100, 1),
(21, 'Apple Shuffle 2GB Azul', 49, 'La estructura principal del nuevo iPod Shuffle se ha fabricado a partir de una única plancha de aluminio y se ha pulido para que luzca en todo su esplendor.', './pic/1.png', 0, 5, 100, 1),
(22, 'Logi\nLogitech Gaga blanco<br><br>Logitech Gaga bla', 79, 'Hagas lo que hagas con el teléfono Smartphone o la tablet, donde sea, hazlo a todo volumen. Este altavoz se empareja fácilmente con teléfonos Smartphone', './pic/1.png', 0, 5, 109, 1),
(23, 'Samsung Galaxy YP-G50 XW EDC', 89, 'El Samsung Galaxy YP-G50CW es capaz de ofrecerte la mejor calidad multimedia. Una experiencia multimedia rápida y divertida que saca el máximo partido al sistema operativo Android.', './pic/1.png', 0, 5, 100, 1),
(24, 'Sennheiser HD 228 blanco', 34, 'Luce una imagen más moderna y elegante con los nuevos auriculares HD 228 que te proporcionan una excelente reproducción de graves, un cómodo ajuste y una gran facilidad de uso gracias a su cable de un solo lado.', './pic/1.png', 0, 5, 100, 1),
(25, 'Apple iPod Touch 8GB', 189, 'Ahora está disponible en blanco y en negro con iOS 5, que incluye más de 200 prestaciones nuevas. Además, gracias a iCloud, todo lo que tengas en el iPod touch se actualizará en tus otros dispositivos automáticamente.', './pic/1.png', 0, 5, 100, 1),
(26, 'Vieta Hip 200 Plata', 155, 'Columna de audio para iPod y iPhone que sigue los estándares de diseño originales de Apple y que te resultará muy fácil de usar.\r\nColumna de audio para iPod y iPhone que sigue los estándares de diseño originales de Apple', './pic/1.png', 0, 5, 100, 1),
(27, 'Formula 1 2011\r\nPS3 Formula 1 2011', 55, 'F1 2011 amplia generosamente las opciones multijugador de F1 2010. Se incluye la pantalla dividida. El juego competitivo se extiende a 16 jugadores corriendo hasta 8 pilotos de IA para completar la parrilas de 24.', './pic/1.png', 0, 5, 100, 1),
(28, 'Paramount Super 8', 16, 'Súper 8 cuenta la historia de seis amigos quienes accidentalmente graban el siniestro provocado por el descarrilamiento de una tren descubriendo que algo inimaginable escapa en ese momento.', './pic/1.png', 0, 5, 100, 1),
(29, 'PS3 Call of duty', 89, 'Pack de las tres ediciones del juego de acción más popular de los últimos años.', './pic/1.png', 0, 5, 100, 1),
(30, 'Sony El código da vinci', 4, 'Cuando el conservador del Louvre Jacques Saunière (Jean-Pierre Marielle) es asesinado, el principal sospechoso es el profesor de simbología Robert Langdon (Tom Hanks).', './pic/1.png', 0, 5, 100, 1),
(31, 'PS3 Fallout New Vegas', 900, 'Prepárate para la guerra con la llegada de Fallout New Vegas, Explora las traicioneras áreas de residuos del Gran Sureste con la seguridad y el confort de tu propia cripta:', './pic/1.png', 0, 5, 100, 1),
(32, 'Sony Music Amaia Montero', 11, 'El segundo disco de Amaia Montero en solitario salió a la venta el pasado 8 de noviembre, sé de los primeros en escucharlo.', './pic/1.png', 0, 5, 100, 1),
(33, 'Samsung Galaxy Note', 599, '? Es el nuevo Galaxy Note, con una pantalla enorme a pesar de su diseño fino y ligero. Incluye S Pen que te permite no solo escribir sino crear y compartir tus bocetos o dibujos estés donde estés.', './pic/1.png', 0, 3, 100, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sugerencias`
--

CREATE TABLE IF NOT EXISTS `sugerencias` (
  `idSugerencia` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `descripcion` text COLLATE utf8_unicode_ci NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idSugerencia`),
  KEY `usuario` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=28 ;

--
-- Volcado de datos para la tabla `sugerencias`
--

INSERT INTO `sugerencias` (`idSugerencia`, `usuario`, `descripcion`, `fecha`) VALUES
(1, 'alumno', 'Primera sugerencia a insertar en la tabla de sugerencias', '2013-05-28'),
(2, 'alumno', 'Segundo comentarios en sugerencias', '2013-05-28'),
(3, 'alumno', 'Tercer comentarios', '2013-05-28'),
(4, 'admin', 'Nueva sugerencia', '2015-05-21'),
(5, 'admin', 'Nueva sugerencia', '2015-05-21'),
(9, 'admin', 'prueba', '2015-05-21'),
(27, 'admin', 'uio', '2017-05-31');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `usuario` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `nombreCompleto` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `telefono` varchar(13) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `fechaultimoacceso` datetime NOT NULL,
  `idpais` int(11) NOT NULL,
  PRIMARY KEY (`usuario`),
  KEY `idpais` (`idpais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`usuario`, `password`, `nombreCompleto`, `email`, `telefono`, `fechaultimoacceso`, `idpais`) VALUES
('1h', '1h', 'Usuario 1H', '1h@salesianos.edu', '976306878', '2017-05-22 00:00:00', 1),
('2e', '2e', '2e', 'dan@yfdfytfc.com', '90u8097980798', '2017-05-27 10:56:36', 1),
('admin', 'admin', 'Administrador Servicios', 'admin@gmail.com', '666123456', '2017-05-31 13:04:58', 1),
('alumno', 'alumno', 'Alumno Informática', 'alumno@salesianos.edu', '976306878', '2017-05-27 10:38:17', 1),
('cxbvcvxb', 'cvb', 'cvb', 'cvb', '', '0000-00-00 00:00:00', 3),
('prueba1', 'c893bad689', 'prueba', 'isabelascaso@gmail.com', '999999999', '0000-00-00 00:00:00', 9),
('test', 'test', 'test', 'isabelascaso@gmail.com', '999666333', '2017-05-29 00:00:00', 1),
('test1', 'test', 'test1', 'test@test.com', '999888777', '2017-05-11 00:00:00', 1),
('ttt', 'ttt', 'ttt', 'ttt', 'tt', '2017-05-31 00:00:00', 3);

--
-- Disparadores `usuarios`
--
DROP TRIGGER IF EXISTS `controlAcceso`;
DELIMITER //
CREATE TRIGGER `controlAcceso` AFTER INSERT ON `usuarios`
 FOR EACH ROW begin
 INSERT INTO bitacora(usuario,operacion,fecha) VALUES ( new.usuario, "Alta",now());
end
//
DELIMITER ;
DROP TRIGGER IF EXISTS `controlLogin`;
DELIMITER //
CREATE TRIGGER `controlLogin` AFTER UPDATE ON `usuarios`
 FOR EACH ROW begin
 INSERT INTO bitacora(usuario,operacion,fecha) VALUES ( old.usuario, "LOGIN",now());
end
//
DELIMITER ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bitacora`
--
ALTER TABLE `bitacora`
  ADD CONSTRAINT `bitacora_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `compras_ibfk_1` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `compras_ibfk_2` FOREIGN KEY (`comprador`) REFERENCES `usuarios` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_2` FOREIGN KEY (`idpais`) REFERENCES `paises` (`idpais`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`idcategoria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `sugerencias`
--
ALTER TABLE `sugerencias`
  ADD CONSTRAINT `sugerencias_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`idpais`) REFERENCES `paises` (`idpais`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.19-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para barcos
CREATE DATABASE IF NOT EXISTS `barcos` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `barcos`;

-- Volcando estructura para tabla barcos.barco
CREATE TABLE IF NOT EXISTS `barco` (
  `id_barco` int(11) NOT NULL AUTO_INCREMENT,
  `modelo` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `matricula` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_barco`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla barcos.barco: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `barco` DISABLE KEYS */;
INSERT INTO `barco` (`id_barco`, `modelo`, `descripcion`, `matricula`) VALUES
	(2, 'Astillero Elan Marine/Elan E3', 'Velero de crucero / Regatas', '19654'),
	(3, 'Glastron GS 259', 'Lancha', 'ver15'),
	(4, 'Beneteau Flyer 550 Sun Deck', 'Embarcación abierta', '15640'),
	(5, 'Galeon 550 Fly', 'Embarcación cabinada', '54tert1'),
	(6, 'Quicksilver Captur 690 Arvor', 'Barco de pesca / Paseo', '47692'),
	(7, 'Sasga Yachts Minorchino 34', 'Llaut a motor', 'guapi'),
	(8, 'Salpa Gran Soleil 23', 'Neumática', 'yjyiy'),
	(9, 'Lagoon 450', 'Catamarán de Vela', '518gf25'),
	(10, 'Lagoon 630 MY', 'Catamarán a motor', '48687'),
	(11, 'Roga Estel', 'Barco de Vela Ligera', '154fr');
/*!40000 ALTER TABLE `barco` ENABLE KEYS */;

-- Volcando estructura para tabla barcos.entrada
CREATE TABLE IF NOT EXISTS `entrada` (
  `id_entrada` int(11) NOT NULL AUTO_INCREMENT,
  `id_puerto` int(11) NOT NULL,
  `id_barco` int(11) NOT NULL,
  `fecha_entrada` date NOT NULL,
  `peaje` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id_entrada`),
  KEY `FK_entradapuerto` (`id_puerto`),
  KEY `FK_entradabarco` (`id_barco`),
  CONSTRAINT `FK_entradabarco` FOREIGN KEY (`id_barco`) REFERENCES `barco` (`id_barco`),
  CONSTRAINT `FK_entradapuerto` FOREIGN KEY (`id_puerto`) REFERENCES `puerto` (`id_puerto`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla barcos.entrada: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` (`id_entrada`, `id_puerto`, `id_barco`, `fecha_entrada`, `peaje`) VALUES
	(2, 1, 2, '2017-03-12', 35),
	(3, 8, 5, '2017-03-14', 45),
	(4, 3, 10, '2017-03-10', 20),
	(5, 2, 3, '2017-03-11', 18),
	(6, 6, 6, '2017-03-14', 26),
	(8, 4, 9, '2017-03-11', 56),
	(9, 5, 8, '2017-03-13', 21),
	(10, 7, 7, '2017-03-05', 39);
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;

-- Volcando estructura para tabla barcos.puerto
CREATE TABLE IF NOT EXISTS `puerto` (
  `id_puerto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `localizacion` varchar(50) NOT NULL,
  PRIMARY KEY (`id_puerto`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla barcos.puerto: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `puerto` DISABLE KEYS */;
INSERT INTO `puerto` (`id_puerto`, `nombre`, `localizacion`) VALUES
	(1, 'Companhia Docas do Rio Grande do Norte - CODERN', 'Natal/RN-Brasil'),
	(2, 'San Sebastian Port Authority', 'San Sebastián/España'),
	(3, 'Copenhagen Malmo Port AB', 'Malmo/Suecia'),
	(4, '	Dubrovnik Port Authority', '	Dubrovnik/Croacia'),
	(5, 'Port of Gdansk Authority SA', 'Gdansk/Polonia'),
	(6, 'Portofino Ufficio Locale Marritimo', 'Genoa/Italia'),
	(7, 'Administracao dos Portos do Douro e Leixoes, SA', 'Leixoes/Portugal'),
	(8, '	Saudi Ports Authority', 'Al Jubail/Arabia Saudi'),
	(9, 'Israeli Ports and Railways Authority', 'Tel Aviv/Israel'),
	(10, 'Administracion Portuaria Integral de Quintana Roo,', 'Quintana Roo/Mexico');
/*!40000 ALTER TABLE `puerto` ENABLE KEYS */;

-- Volcando estructura para tabla barcos.salida
CREATE TABLE IF NOT EXISTS `salida` (
  `id_salida` int(11) NOT NULL AUTO_INCREMENT,
  `id_puerto` int(11) NOT NULL,
  `id_barco` int(11) NOT NULL,
  `fecha_salida` date NOT NULL,
  PRIMARY KEY (`id_salida`),
  KEY `FK_salidapuerto` (`id_puerto`),
  KEY `FK_salidabarco` (`id_barco`),
  CONSTRAINT `FK_salidabarco` FOREIGN KEY (`id_barco`) REFERENCES `barco` (`id_barco`),
  CONSTRAINT `FK_salidapuerto` FOREIGN KEY (`id_puerto`) REFERENCES `puerto` (`id_puerto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla barcos.salida: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `salida` DISABLE KEYS */;
/*!40000 ALTER TABLE `salida` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

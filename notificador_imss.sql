-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-03-2023 a las 04:10:07
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `notificador_imss`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `constancias`
--

CREATE TABLE `constancias` (
  `matricula` varchar(8) NOT NULL,
  `password` varchar(10) NOT NULL,
  `nombre` varchar(35) NOT NULL,
  `fecha` varchar(25) NOT NULL,
  `vigencia` varchar(25) NOT NULL,
  `emitida` varchar(35) NOT NULL,
  `admin` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `constancias`
--

INSERT INTO `constancias` (`matricula`, `password`, `nombre`, `fecha`, `vigencia`, `emitida`, `admin`) VALUES
('10270089', 'Marcelo', 'REAL BRICEÑO MARCELO', '03 de Enero de 2023', '30 de Junio de 2023', 'OMAR MEZA CARRAZCO', 'NO'),
('10270936', 'Ignacio', 'CORRAL CORRAL JOSE IGNACIO', '03 de Enero de 2023', '30 de Junio de 2023', 'OMAR MEZA CARRAZCO', 'NO'),
('10270998', 'Ernesto', 'GRANADOS TECOCOATZI ERNESTO ADAN', '03 de Enero de 2023', '30 de Junio de 2023', 'OMAR MEZA CARRAZCO', 'NO'),
('10271340', 'Alexis', 'TESISTECO BARRÓN ALEXIS RAFAEL', '03 de Enero de 2023', '30 de Junio de 2023', 'OMAR MEZA CARRAZCO', 'SI'),
('10271406', 'Alicia', 'TORRES VERDUGO ALICIA', '03 de Enero de 2023', '30 de Junio de 2023', 'OMAR MEZA CARRAZCO', 'NO'),
('10271587', 'Antonio', 'AGUIRRE MORAGA ANTONIO', '03 de Enero de 2023', '30 de Junio de 2023', 'OMAR MEZA CARRAZCO', 'NO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registo_patronal`
--

CREATE TABLE `registo_patronal` (
  `registro_patronal` varchar(11) NOT NULL,
  `razon_social` varchar(60) NOT NULL,
  `rfc` varchar(13) NOT NULL,
  `domicilio` varchar(70) NOT NULL,
  `credito` varchar(9) NOT NULL,
  `multa` varchar(9) NOT NULL,
  `periodo` varchar(6) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  `asignacion` varchar(8) NOT NULL,
  `citatorio` varchar(10) NOT NULL,
  `notificacion` varchar(10) NOT NULL,
  `notificador` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `registo_patronal`
--

INSERT INTO `registo_patronal` (`registro_patronal`, `razon_social`, `rfc`, `domicilio`, `credito`, `multa`, `periodo`, `fecha`, `asignacion`, `citatorio`, `notificacion`, `notificador`) VALUES
('E6110473106', 'JOSE FRANCISCO LOPEZ HOYOS', 'LOHF720319VA2', 'REFORMA CASA C 18', '232033994', '238033994', '202101', '07/03/2023', '10270089', '', '', ''),
('E6112820106', 'DANIEL IBARRA ANGEL', 'IAAD530627J92', 'CRISTOBAL COLON LOTE 9 MANZ 13 JUAREZ', '233027946', '238027946', '202101', '07/03/2023', '10270936', '', '', ''),
('E6113652102', 'CONSORCIO INDUSTRIAL Y DE NEGOCIOS EMPGUAY S DE RL', 'CIN080125IF8', 'GUILLERMO PRIETO 105 SN MODERNA', '232034004', '238034004', '202101', '07/03/2023', '10270998', '', '', ''),
('E6113734108', 'MARIA GRICELDA ARAGON PEREZ', 'AAPG740304IH0', 'IGNACIO RAMIREZ ENS OXXO SN SECTOR ORIEN', '232034005', '238034005', '202101', '07/03/2023', '10270089', '', '', ''),
('E6113897103', 'LUIS ALBERTO SMITH JIMENEZ', 'SIJL800119GJ4', 'AV 3RA L11 M319 FLORES Y PARRAS SAHUARAL', '232034008', '238034008', '202101', '07/03/2023', '10271587', '', '', ''),
('E6114143101', 'VIRGINIA VERONICA CAUZOR CABRALES', 'CACV720823135', 'JARDIN LT. 3 Y 8 MZ. 27 SN SAHUARAL', '232034017', '232034017', '202101', '07/03/2023', '10271406', '', '', ''),
('E6114452106', 'MARIA ESTHER PEREZ AVALOS', 'PEAE5808066U6', 'HEROES DE NACOZARI S/N MODERNA', 'credito', 'multa', '202101', '07/03/2023', '10271587', '', '', ''),
('E6114732101', 'ORLANDO RODRIGUEZ SALAS', 'ROSO7901306V3', '7 SEPTIMA SN ORTIZ RUBIO', '232034037', '238034037', '202101', '07/03/2023', '10270089', '', '', ''),
('E6317713106', 'CLAUDIO CESAR VELAZQUEZ OSUNA', 'VEOC630523TW0', 'LOTE 1 Y 2 MANZ 14 SN PETROLERA', '222029472', '228029472', '202101', '07/03/2023', '10270936', '', '', ''),
('E6318033108', 'ASOCIACION DE CONDOMINES DE CONDOMINIOS DE SAN CARLOS', 'ACC910524QWA', 'SAN CARLOS COUNTRY CLUB CONDOMINIOS', '22202947', '22802947', '202101', '07/03/2023', '10271587', '', '', ''),
('E6318162105', 'INVERSIONES BACOCHIBAMPO SA DE CV', 'IBA670601E79', 'CALLE 31 PUNTA DE MERO CENTRO', '223005621', '228005621', '202101', '07/03/2023', '10270089', '', '', ''),
('E6319466109', 'D Y C FERROCONSTRUCCIONES DEL NOROESTE SA DE CV', 'DCF920915ES4', 'KM 118 80 CARRETERA GUAYMAS EMPALME', '232034071', '238034071', '202101', '07/03/2023', '10270998', '', '', ''),
('E6333194109', 'ALTER ENERGY GROUP SA DE CV', 'AEG191210NJ6', 'SANCHEZ TABOADA 34 SN SAN BERNARDO', '232034311', '238034311', '202101', '07/03/2023', '10270936', '', '', '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `constancias`
--
ALTER TABLE `constancias`
  ADD PRIMARY KEY (`matricula`);

--
-- Indices de la tabla `registo_patronal`
--
ALTER TABLE `registo_patronal`
  ADD PRIMARY KEY (`registro_patronal`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

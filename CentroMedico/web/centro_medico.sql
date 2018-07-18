-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-07-2018 a las 19:57:48
-- Versión del servidor: 10.1.28-MariaDB
-- Versión de PHP: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mydb`
--
CREATE DATABASE IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `mydb`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `Cod_Cita` int(11) NOT NULL,
  `FechaHora` datetime DEFAULT NULL,
  `Descripcion` varchar(300) DEFAULT NULL,
  `Cod_Cliente` int(11) NOT NULL,
  `Cod_Secretaria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `Cod_Cliente` int(11) NOT NULL,
  `Cui` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultamedia`
--

CREATE TABLE `consultamedia` (
  `Cod_Consulta_Medic` int(11) NOT NULL,
  `Descripcion` varchar(300) DEFAULT NULL,
  `Cod_Cita` int(11) NOT NULL,
  `NoColegiado` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `Cod_Departamento` int(11) NOT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Descripcion` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`Cod_Departamento`, `Nombre`, `Descripcion`) VALUES
(1, 'Inventado', 'puesto de ejemplo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doctor`
--

CREATE TABLE `doctor` (
  `NoColegiado` varchar(45) NOT NULL,
  `Usuario` varchar(45) DEFAULT NULL,
  `Contrasena` varchar(45) DEFAULT NULL,
  `Cui` int(11) NOT NULL,
  `Cod_Especialidad` int(11) NOT NULL,
  `Cod_Puesto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE `especialidad` (
  `Cod_Especialidad` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Descripcion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamento`
--

CREATE TABLE `medicamento` (
  `Cod_Medicamento` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `Presentacion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `Cui` int(11) NOT NULL,
  `pNombre` varchar(45) DEFAULT NULL,
  `pApellido` varchar(45) DEFAULT NULL,
  `sNombre` varchar(45) DEFAULT NULL,
  `sApellido` varchar(45) DEFAULT NULL,
  `Genero` varchar(45) DEFAULT NULL,
  `FechaNacimiento` date DEFAULT NULL,
  `Direccion` varchar(200) DEFAULT NULL,
  `Telefono` int(8) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puesto`
--

CREATE TABLE `puesto` (
  `Cod_Puesto` int(11) NOT NULL,
  `NombrePuesto` varchar(100) DEFAULT NULL,
  `Hora_Inicio` date DEFAULT NULL,
  `Hora_Fin` date DEFAULT NULL,
  `Salario` decimal(10,2) DEFAULT NULL,
  `FechaAgregado` timestamp NULL DEFAULT NULL,
  `Cod_Departamento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recetas`
--

CREATE TABLE `recetas` (
  `Cod_Receta` int(11) NOT NULL,
  `Cantidad` int(10) DEFAULT NULL,
  `Descripcion` varchar(200) DEFAULT NULL,
  `FechaCreada` timestamp NULL DEFAULT NULL,
  `Cod_Medicamento` int(11) NOT NULL,
  `Cod_Consulta_Medic` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `secretaria`
--

CREATE TABLE `secretaria` (
  `Cod_Secretaria` int(11) NOT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Contrasena` varchar(50) DEFAULT NULL,
  `Cui` int(11) NOT NULL,
  `Cod_Puesto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cita`
--
ALTER TABLE `cita`
  ADD PRIMARY KEY (`Cod_Cita`),
  ADD KEY `fk_Cita_Cliente (paciente)1_idx` (`Cod_Cliente`),
  ADD KEY `fk_Cita_Empleados2_idx` (`Cod_Secretaria`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Cod_Cliente`),
  ADD KEY `fk_Cliente (paciente)_Persona1_idx` (`Cui`);

--
-- Indices de la tabla `consultamedia`
--
ALTER TABLE `consultamedia`
  ADD PRIMARY KEY (`Cod_Consulta_Medic`),
  ADD KEY `fk_ConsultaMedia_Cita1_idx` (`Cod_Cita`),
  ADD KEY `fk_ConsultaMedia_Doctor1_idx` (`NoColegiado`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`Cod_Departamento`);

--
-- Indices de la tabla `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`NoColegiado`),
  ADD KEY `fk_Doctor_Persona1_idx` (`Cui`),
  ADD KEY `fk_Doctor_Especialidad1_idx` (`Cod_Especialidad`),
  ADD KEY `fk_Doctor_Puesto1_idx` (`Cod_Puesto`);

--
-- Indices de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`Cod_Especialidad`);

--
-- Indices de la tabla `medicamento`
--
ALTER TABLE `medicamento`
  ADD PRIMARY KEY (`Cod_Medicamento`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`Cui`);

--
-- Indices de la tabla `puesto`
--
ALTER TABLE `puesto`
  ADD PRIMARY KEY (`Cod_Puesto`),
  ADD KEY `fk_Puesto_Departamento1_idx` (`Cod_Departamento`);

--
-- Indices de la tabla `recetas`
--
ALTER TABLE `recetas`
  ADD PRIMARY KEY (`Cod_Receta`),
  ADD KEY `fk_Recetas_Medicamento1_idx` (`Cod_Medicamento`),
  ADD KEY `fk_Recetas_ConsultaMedia1_idx` (`Cod_Consulta_Medic`);

--
-- Indices de la tabla `secretaria`
--
ALTER TABLE `secretaria`
  ADD PRIMARY KEY (`Cod_Secretaria`),
  ADD KEY `fk_Empleados_Persona_idx` (`Cui`),
  ADD KEY `fk_Empleados_Puesto1_idx` (`Cod_Puesto`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cita`
--
ALTER TABLE `cita`
  ADD CONSTRAINT `fk_Cita_Cliente (paciente)1` FOREIGN KEY (`Cod_Cliente`) REFERENCES `cliente` (`Cod_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Cita_Empleados2` FOREIGN KEY (`Cod_Secretaria`) REFERENCES `secretaria` (`Cod_Secretaria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_Cliente (paciente)_Persona1` FOREIGN KEY (`Cui`) REFERENCES `persona` (`Cui`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `consultamedia`
--
ALTER TABLE `consultamedia`
  ADD CONSTRAINT `fk_ConsultaMedia_Cita1` FOREIGN KEY (`Cod_Cita`) REFERENCES `cita` (`Cod_Cita`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ConsultaMedia_Doctor1` FOREIGN KEY (`NoColegiado`) REFERENCES `doctor` (`NoColegiado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `fk_Doctor_Especialidad1` FOREIGN KEY (`Cod_Especialidad`) REFERENCES `especialidad` (`Cod_Especialidad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Doctor_Persona1` FOREIGN KEY (`Cui`) REFERENCES `persona` (`Cui`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Doctor_Puesto1` FOREIGN KEY (`Cod_Puesto`) REFERENCES `puesto` (`Cod_Puesto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `puesto`
--
ALTER TABLE `puesto`
  ADD CONSTRAINT `fk_Puesto_Departamento1` FOREIGN KEY (`Cod_Departamento`) REFERENCES `departamento` (`Cod_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `recetas`
--
ALTER TABLE `recetas`
  ADD CONSTRAINT `fk_Recetas_ConsultaMedia1` FOREIGN KEY (`Cod_Consulta_Medic`) REFERENCES `consultamedia` (`Cod_Consulta_Medic`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Recetas_Medicamento1` FOREIGN KEY (`Cod_Medicamento`) REFERENCES `medicamento` (`Cod_Medicamento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `secretaria`
--
ALTER TABLE `secretaria`
  ADD CONSTRAINT `fk_Empleados_Persona` FOREIGN KEY (`Cui`) REFERENCES `persona` (`Cui`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Empleados_Puesto1` FOREIGN KEY (`Cod_Puesto`) REFERENCES `puesto` (`Cod_Puesto`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

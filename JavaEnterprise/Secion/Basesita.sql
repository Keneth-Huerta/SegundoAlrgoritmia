-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 10, 2024 at 02:28 AM
-- Server version: 10.6.18-MariaDB-0ubuntu0.22.04.1
-- PHP Version: 8.1.2-1ubuntu2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Basesita`
--

-- --------------------------------------------------------

--
-- Table structure for table `almacen`
--

CREATE TABLE `almacen` (
  `id_caja` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `almacen`
--

INSERT INTO `almacen` (`id_caja`, `cantidad`) VALUES
(1, 0),
(2, 15),
(3, 65),
(4, 26),
(5, 23),
(6, 64),
(7, 46),
(8, 52),
(9, 12);

-- --------------------------------------------------------

--
-- Table structure for table `Cajas`
--

CREATE TABLE `Cajas` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(35) NOT NULL,
  `cantidad_en_caja` int(11) NOT NULL,
  `presentacion` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Cajas`
--

INSERT INTO `Cajas` (`id`, `descripcion`, `cantidad_en_caja`, `presentacion`) VALUES
(1, 'Caja de carton reciclado', 10, 'Paquete Economico\r'),
(2, 'Caja plastica resistente', 10, 'Premium\r'),
(3, 'Caja metalica hermetica', 5, 'Alta Seguridad\r'),
(4, 'Caja de madera decorada', 8, 'Edicion Especial\r'),
(5, 'Caja de carton kraft', 20, 'Basico\r'),
(6, 'Caja con compartimentos', 15, 'Multiusos\r'),
(7, 'Caja pequena de carton', 30, 'Compacto\r'),
(8, 'Caja grande reforzada', 12, 'Extra Grande\r'),
(9, 'Caja de carton personalizada', 18, 'Personalizable\r');

-- --------------------------------------------------------

--
-- Table structure for table `Pedidos`
--

CREATE TABLE `Pedidos` (
  `id_pedido` int(11) NOT NULL,
  `fecha_pedido` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado_pedido` enum('ABIERTO','CERRADO','CANCELADO') NOT NULL DEFAULT 'ABIERTO',
  `id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Pedidos`
--

INSERT INTO `Pedidos` (`id_pedido`, `fecha_pedido`, `estado_pedido`, `id_cliente`) VALUES
(33, '2024-12-10 08:12:01', 'ABIERTO', 4);

-- --------------------------------------------------------

--
-- Table structure for table `productos_pedido`
--

CREATE TABLE `productos_pedido` (
  `id_caja_pedido` int(11) NOT NULL,
  `id_pedido` int(11) NOT NULL,
  `id_caja` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `es_administrador` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre_usuario`, `contrasena`, `es_administrador`) VALUES
(1, 'Admin', '1420', 1),
(2, 'root', '', 1),
(3, 'Dulcerito', '2345', 0),
(4, 'Keneth', '1234', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `almacen`
--
ALTER TABLE `almacen`
  ADD PRIMARY KEY (`id_caja`);

--
-- Indexes for table `Cajas`
--
ALTER TABLE `Cajas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Pedidos`
--
ALTER TABLE `Pedidos`
  ADD PRIMARY KEY (`id_pedido`);

--
-- Indexes for table `productos_pedido`
--
ALTER TABLE `productos_pedido`
  ADD PRIMARY KEY (`id_caja_pedido`),
  ADD KEY `id_caja` (`id_caja`),
  ADD KEY `id_pedido` (`id_pedido`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre_usuario` (`nombre_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `almacen`
--
ALTER TABLE `almacen`
  MODIFY `id_caja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `Pedidos`
--
ALTER TABLE `Pedidos`
  MODIFY `id_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `productos_pedido`
--
ALTER TABLE `productos_pedido`
  MODIFY `id_caja_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `almacen`
--
ALTER TABLE `almacen`
  ADD CONSTRAINT `almacen_ibfk_1` FOREIGN KEY (`id_caja`) REFERENCES `Cajas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `productos_pedido`
--
ALTER TABLE `productos_pedido`
  ADD CONSTRAINT `productos_pedido_ibfk_1` FOREIGN KEY (`id_caja`) REFERENCES `Cajas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productos_pedido_ibfk_2` FOREIGN KEY (`id_pedido`) REFERENCES `Pedidos` (`id_pedido`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

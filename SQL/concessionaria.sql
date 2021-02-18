-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 18-Fev-2021 às 10:16
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `concessionaria`
--
CREATE DATABASE IF NOT EXISTS `concessionaria` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `concessionaria`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `veiculo`
--

CREATE TABLE `veiculo` (
  `modelo` text NOT NULL,
  `marca` text NOT NULL,
  `chassi` text NOT NULL,
  `placa` text NOT NULL,
  `ano` int(10) NOT NULL,
  `cambioA` tinyint(1) NOT NULL,
  `id` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `veiculo`
--

INSERT INTO `veiculo` (`modelo`, `marca`, `chassi`, `placa`, `ano`, `cambioA`, `id`) VALUES
('ugqeruif', 'efyvwecbeu', 'wdaa', 'cbhryb', 8, 1, 1),
('mark45', 'berutoda', 'reforçado', 'pare', 2047, 1, 2),
('Eclipse é ', 'ruim', 'demais', 'bah', 3, 1, 3),
('Shevii', 'marco', 'reforçado o menino', 'bah2700', 2004, 0, 4),
('caaw', 'idva', 'vrb', 'tdsd', 3, 0, 7);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `veiculo`
--
ALTER TABLE `veiculo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `veiculo`
--
ALTER TABLE `veiculo`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

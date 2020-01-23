/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  alexandrebarao
 * Created: 23/jan/2020
 */

-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Jan 23, 2020 at 05:18 PM
-- Server version: 5.5.42
-- PHP Version: 5.6.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `basedados`
--

-- --------------------------------------------------------

--
-- Table structure for table `PESSOA`
--

CREATE TABLE `PESSOA` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(100) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
    PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `PESSOA`
--

INSERT INTO `PESSOA` (`ID`, `NOME`, `EMAIL`) VALUES
(1, 'Luis Aluno', 'l@luis.pt'),
(2, 'Sérgio', 's@sergio.pt'),
(3, 'Raquel', 'r@raquel.br'),
(4, 'Guilherme', 'g@guilherme.br'),
(5, 'Ana', 'a@ana.pt'),
(6, 'Ricardo', 'r@ricardo.br'),
(7, 'Inês', 'r@ricardo.br'),
(8, 'Claudio', 'c@claudio.pt'),
(9, 'Filipe', 'f@filipe.pt'),
(10, 'Warley', 'w@warley.pt');




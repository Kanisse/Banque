-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 17 jan. 2022 à 14:43
-- Version du serveur : 10.4.20-MariaDB
-- Version de PHP : 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `banque`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE `agence` (
  `LibelleAg` int(45) NOT NULL,
  `NomAg` varchar(100) NOT NULL,
  `AdresseAg` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `agence`
--

INSERT INTO `agence` (`LibelleAg`, `NomAg`, `AdresseAg`) VALUES
(8, 'Hay Nahda', '3 avenue majati, rue nahda, rabat'),
(9, 'Yousoufia', '4 avenue Zaer, Rabat'),
(11, 'Hay Rahma', '4 avenue mohammed 5, salé'),
(15, 'Agdal', '12 rue Jbel Ayyachi');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `NumCl` int(10) UNSIGNED NOT NULL,
  `Nom` varchar(45) NOT NULL,
  `Prenom` varchar(45) NOT NULL,
  `Adresse` varchar(45) NOT NULL,
  `Id_Agence` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`NumCl`, `Nom`, `Prenom`, `Adresse`, `Id_Agence`) VALUES
(1, 'Diallo', 'Mustapha', 'Ouakam Cité asecan', 8),
(2, 'Faye', 'Marietou', 'Gd Dakar 306', 9),
(3, 'Diallo', 'Tidiane', '12 rue nasr, rabat', 8),
(4, 'Redouani', 'Asmae', '23 villa Asmae, Temara', 11),
(5, 'Khald', 'anisse', '19 rus assni , tabriquet, salé', 15),
(6, 'Benami', 'Mohamed Mazine', '23 villa Benami, temara', 15);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `NumCp` int(10) UNSIGNED NOT NULL,
  `LibelleCp` varchar(45) NOT NULL,
  `SensCp` varchar(45) NOT NULL,
  `Solde` int(20) UNSIGNED DEFAULT NULL,
  `NumCl` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`NumCp`, `LibelleCp`, `SensCp`, `Solde`, `NumCl`) VALUES
(16235, 'Famillial compt', 'Debiteur', 300000, 2),
(24615, 'perso', 'Debiteur', 119880, 1);

-- --------------------------------------------------------

--
-- Structure de la table `login`
--

CREATE TABLE `login` (
  `Id_Users` int(10) UNSIGNED NOT NULL,
  `Nom_Users` varchar(45) NOT NULL,
  `Login_Users` varchar(45) NOT NULL,
  `Pass_Users` varchar(45) NOT NULL,
  `niveau` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `login`
--

INSERT INTO `login` (`Id_Users`, `Nom_Users`, `Login_Users`, `Pass_Users`, `niveau`) VALUES
(4, 'khald anisse', 'kanisse', '123456', 0),
(5, 'MAZINE BENAMI', 'BENMAZINE', '123456', 0);

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

CREATE TABLE `operation` (
  `NumOp` int(10) UNSIGNED NOT NULL,
  `LibelleOp` varchar(45) NOT NULL,
  `MontantOp` int(20) UNSIGNED NOT NULL,
  `SensOp` varchar(45) NOT NULL,
  `DateOp` date NOT NULL,
  `NumCp` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `operation`
--

INSERT INTO `operation` (`NumOp`, `LibelleOp`, `MontantOp`, `SensOp`, `DateOp`, `NumCp`) VALUES
(1, 'retraut espece', 120, 'Debiteur', '2011-08-08', 24615);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`LibelleAg`) USING BTREE;

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`NumCl`) USING BTREE;

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`NumCp`) USING BTREE;

--
-- Index pour la table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`Id_Users`);

--
-- Index pour la table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`NumOp`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `agence`
--
ALTER TABLE `agence`
  MODIFY `LibelleAg` int(45) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `NumCl` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `login`
--
ALTER TABLE `login`
  MODIFY `Id_Users` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `operation`
--
ALTER TABLE `operation`
  MODIFY `NumOp` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

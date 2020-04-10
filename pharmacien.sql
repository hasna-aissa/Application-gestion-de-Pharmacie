-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  Dim 27 jan. 2019 à 21:08
-- Version du serveur :  10.1.36-MariaDB
-- Version de PHP :  7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pharmacien`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `Num_Categorie` varchar(20) NOT NULL,
  `Nom_Categorie` varchar(50) NOT NULL,
  `Designation_Categorie` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`Num_Categorie`, `Nom_Categorie`, `Designation_Categorie`) VALUES
('11', 'Antibiotique', 'kjdjfshf'),
('12', 'antiphorodes', 'dffdfderfre'),
('13', 'lratines', 'dqdza'),
('14', 'Laxatifs', 'Laxatifs'),
('15', 'Les antalgiques', 'antalgiques'),
('16', 'Diurétiques', 'Diurétiques');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `Num_Facture` varchar(20) NOT NULL,
  `Date_Facture` date NOT NULL,
  `Prix_Totale` decimal(10,0) NOT NULL,
  `Remise` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `facture`
--

INSERT INTO `facture` (`Num_Facture`, `Date_Facture`, `Prix_Totale`, `Remise`) VALUES
('', '2019-01-27', '0', '0'),
('1', '2019-01-27', '604', '1'),
('jhv', '2019-01-08', '345', '2');

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `Num_Fournisseur` varchar(20) NOT NULL,
  `Nom_Fournisseur` varchar(50) NOT NULL,
  `Adresse_Fournisseur` varchar(50) NOT NULL,
  `Email_Fournisseur` varchar(30) NOT NULL,
  `Tele_Fournisseur` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`Num_Fournisseur`, `Nom_Fournisseur`, `Adresse_Fournisseur`, `Email_Fournisseur`, `Tele_Fournisseur`) VALUES
('111', 'amine rajoui', 'agadir dcheira', 'amine@gmail.com', '0666995834'),
('120', 'jihan amine', 'casablanca', 'amine.jihan@gmail.com', '0632512214'),
('121', 'emanouelle egri', 'france paris', 'emanouelle@gmail.com', '+33 251453625'),
('122', 'ahmed fana', 'fes', 'fana.ahmed@gmail.com', '06632541269'),
('123', 'nourddine', 'casablanca', 'nourddine.12@gmail.com', '0624458961'),
('124', 'youssef karim', 'casablanca', 'karim.youssef@gmail.com', '06221545641'),
('131', 'khalid alija', 'tanger', 'khalid@gmail.com', '0655487932'),
('141', 'khalid alija', 'tanger', 'khalid12.alija@gmail.com', '0666584213'),
('151', 'ahmed fanik', 'casablanca', 'fanik.ahmed45@gmail.com', '0635215645'),
('161', 'amina hirafi', 'marrakech', 'amina125hiraf@gmail.com', '05669842125'),
('171', 'arij faroui', 'agadir', 'faroui.hamid2@gmail.com', '0655213487'),
('181', 'abd rahman raji', 'fes', 'raji.abdrahman@gmail.com', '0632568541'),
('191', 'mohammed', 'agadir', 'mohammed@gmail.com', '0658742136');

-- --------------------------------------------------------

--
-- Structure de la table `lignefacture`
--

CREATE TABLE `lignefacture` (
  `Num_Medicament` varchar(20) NOT NULL,
  `Num_Facture` varchar(20) NOT NULL,
  `Qte_Commandee` int(11) NOT NULL,
  `PrixQte` decimal(10,5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `lignefacture`
--

INSERT INTO `lignefacture` (`Num_Medicament`, `Num_Facture`, `Qte_Commandee`, `PrixQte`) VALUES
('13', '1', 10, '38.00000'),
('15', '1', 11, '572.00000');

-- --------------------------------------------------------

--
-- Structure de la table `login`
--

CREATE TABLE `login` (
  `UserName` varchar(12) NOT NULL,
  `Password` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `login`
--

INSERT INTO `login` (`UserName`, `Password`) VALUES
('ahmed', '1234'),
('ahmed', '1234');

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

CREATE TABLE `medicament` (
  `Num_Medicament` varchar(20) NOT NULL,
  `Nom_Medicament` varchar(50) NOT NULL,
  `Nom_Categorie` varchar(50) NOT NULL,
  `QteEnStock` int(11) NOT NULL,
  `Date_Production` date NOT NULL,
  `Date_Expedition` date NOT NULL,
  `Prix` decimal(10,5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `medicament`
--

INSERT INTO `medicament` (`Num_Medicament`, `Nom_Medicament`, `Nom_Categorie`, `QteEnStock`, `Date_Production`, `Date_Expedition`, `Prix`) VALUES
('11', 'doliprane', 'antiphorodes', 120, '2015-02-02', '2016-12-03', '15.00000'),
('12', 'algantile', 'Laxatifs', 16, '2018-02-02', '2020-02-03', '40.00000'),
('13', 'adexe', 'lratines', 26, '2017-02-15', '2020-06-03', '38.00000'),
('14', 'renomecine', 'lratines', 40, '2017-02-11', '2018-06-03', '20.00000'),
('15', 'aldopa', 'antiphorodes', 4, '2017-03-10', '2021-08-03', '52.00000'),
('16', 'allergine', 'Antibiotique', 92, '2018-03-10', '2022-12-03', '42.00000'),
('17', 'cratine', 'Laxatifs', 65, '2017-11-10', '2019-01-01', '53.00000'),
('18', 'amarelle', 'Laxatifs', 22, '2017-11-10', '2023-01-12', '140.00000'),
('19', 'amarelle', 'Les antalgiques', 22, '2017-11-10', '2012-01-12', '125.00000');

-- --------------------------------------------------------

--
-- Structure de la table `medicament_fournit`
--

CREATE TABLE `medicament_fournit` (
  `Num_Medicament` varchar(20) NOT NULL,
  `Num_Fournisseur` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `medicament_fournit`
--

INSERT INTO `medicament_fournit` (`Num_Medicament`, `Num_Fournisseur`) VALUES
('11', '111'),
('12', '123'),
('15', '111'),
('15', '120'),
('16', '121'),
('17', '111'),
('17', '120'),
('17', '123'),
('18', '120'),
('19', '121');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`Num_Categorie`),
  ADD UNIQUE KEY `Nom_Categorie` (`Nom_Categorie`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`Num_Facture`);

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`Num_Fournisseur`);

--
-- Index pour la table `lignefacture`
--
ALTER TABLE `lignefacture`
  ADD PRIMARY KEY (`Num_Medicament`,`Num_Facture`),
  ADD KEY `MC_PK2` (`Num_Facture`);

--
-- Index pour la table `medicament`
--
ALTER TABLE `medicament`
  ADD PRIMARY KEY (`Num_Medicament`);

--
-- Index pour la table `medicament_fournit`
--
ALTER TABLE `medicament_fournit`
  ADD PRIMARY KEY (`Num_Medicament`,`Num_Fournisseur`),
  ADD KEY `MC_FK3` (`Num_Fournisseur`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `lignefacture`
--
ALTER TABLE `lignefacture`
  ADD CONSTRAINT `MC_PK1` FOREIGN KEY (`Num_Medicament`) REFERENCES `medicament` (`Num_Medicament`),
  ADD CONSTRAINT `MC_PK2` FOREIGN KEY (`Num_Facture`) REFERENCES `facture` (`Num_Facture`);

--
-- Contraintes pour la table `medicament_fournit`
--
ALTER TABLE `medicament_fournit`
  ADD CONSTRAINT `MC_FK3` FOREIGN KEY (`Num_Fournisseur`) REFERENCES `fournisseur` (`Num_Fournisseur`),
  ADD CONSTRAINT `MC_FK4` FOREIGN KEY (`Num_Medicament`) REFERENCES `medicament` (`Num_Medicament`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

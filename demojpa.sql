-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 14 nov. 2018 à 16:47
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `demojpa`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

DROP TABLE IF EXISTS `adresse`;
CREATE TABLE IF NOT EXISTS `adresse` (
  `id` int(11) NOT NULL,
  `codePostal` varchar(255) DEFAULT NULL,
  `rue` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `adresse`
--

INSERT INTO `adresse` (`id`, `codePostal`, `rue`, `ville`) VALUES
(3, '13090', '11 rue saragosse', 'Aix en provence');

-- --------------------------------------------------------

--
-- Structure de la table `connexion`
--

DROP TABLE IF EXISTS `connexion`;
CREATE TABLE IF NOT EXISTS `connexion` (
  `id` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `contact_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqymm7njlqrxq1k4svctjrqik8` (`contact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

DROP TABLE IF EXISTS `contact`;
CREATE TABLE IF NOT EXISTS `contact` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `adresse_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi11xqnegfk0x4hpqk18mc10ur` (`adresse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `contact`
--

INSERT INTO `contact` (`id`, `email`, `nom`, `prenom`, `adresse_id`) VALUES
(4, 'zecunion2@gmail.com', 'ZEC2', 'UNION2', 3);

-- --------------------------------------------------------

--
-- Structure de la table `contact_film`
--

DROP TABLE IF EXISTS `contact_film`;
CREATE TABLE IF NOT EXISTS `contact_film` (
  `contacts_id` int(11) NOT NULL,
  `films_idFilm` int(11) NOT NULL,
  PRIMARY KEY (`contacts_id`,`films_idFilm`),
  KEY `FKp0xtiokrfbpl6mr6abocextpo` (`films_idFilm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

DROP TABLE IF EXISTS `film`;
CREATE TABLE IF NOT EXISTS `film` (
  `TYPE_FILM` varchar(31) NOT NULL,
  `idFilm` int(11) NOT NULL,
  `nomFilm` varchar(255) DEFAULT NULL,
  `chaine` varchar(255) DEFAULT NULL,
  `cinema` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idFilm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `film`
--

INSERT INTO `film` (`TYPE_FILM`, `idFilm`, `nomFilm`, `chaine`, `cinema`) VALUES
('FILM', 5, 'le livre d\'elite', NULL, NULL),
('FILM', 8, 'Alien', NULL, NULL),
('FILM', 9, 'la mémoire dans la peau', NULL, NULL),
('FILM', 10, 'le livre d\'elite', NULL, NULL),
('LONG', 11, 'aladeux', NULL, 'UGC'),
('TELE', 12, 'joséphine ange gardien', 'TF1', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(13),
(13),
(13),
(13);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `connexion`
--
ALTER TABLE `connexion`
  ADD CONSTRAINT `FKqymm7njlqrxq1k4svctjrqik8` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`id`);

--
-- Contraintes pour la table `contact`
--
ALTER TABLE `contact`
  ADD CONSTRAINT `FKi11xqnegfk0x4hpqk18mc10ur` FOREIGN KEY (`adresse_id`) REFERENCES `adresse` (`id`);

--
-- Contraintes pour la table `contact_film`
--
ALTER TABLE `contact_film`
  ADD CONSTRAINT `FKp0xtiokrfbpl6mr6abocextpo` FOREIGN KEY (`films_idFilm`) REFERENCES `film` (`idFilm`),
  ADD CONSTRAINT `FKybk6ew7wkxh8v72jivbmcpwt` FOREIGN KEY (`contacts_id`) REFERENCES `contact` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

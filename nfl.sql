-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2020. Ápr 17. 16:02
-- Kiszolgáló verziója: 10.4.11-MariaDB
-- PHP verzió: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `nfl`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `players`
--

CREATE TABLE `players` (
  `Pick` int(2) NOT NULL,
  `Name` varchar(40) DEFAULT NULL,
  `College` varchar(20) DEFAULT NULL,
  `Position` varchar(3) DEFAULT NULL,
  `DateOfBirth` date DEFAULT NULL,
  `Weight` int(3) DEFAULT NULL,
  `Height` int(3) DEFAULT NULL,
  `DraftTeam` varchar(25) DEFAULT NULL,
  `Picture` blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `players`
--

INSERT INTO `players` (`Pick`, `Name`, `College`, `Position`, `DateOfBirth`, `Weight`, `Height`, `DraftTeam`, `Picture`) VALUES
(1, 'Joe Burrow', 'LSU', 'QB', '1996-12-10', 98, 193, 'Cincinnati Bengals', NULL),
(2, 'Chase Young', 'Ohio State', 'DE', '1999-04-14', 120, 196, 'Washington Redskins', NULL),
(3, 'Tua Tagovailoa', 'Alabama', 'QB', '1998-03-02', 99, 185, 'Miami Dolphins', NULL),
(4, 'Tristan Wirfs', 'Iowa', 'OT', '1999-01-24', 146, 196, 'New York Giants', NULL),
(5, 'Jeff Okudah', 'Ohio State', 'CB', '1999-07-21', 91, 185, 'Detroit Lions', NULL),
(6, 'Justin Herbert', 'Oregon', 'QB', '1998-03-10', 108, 198, 'Los Angeles Chargers', NULL),
(7, 'Derrick Brown', 'Auburn', 'DE', '1998-04-15', 111, 188, 'Carolina Panthers', NULL),
(8, 'Jedrick Wills Jr.', 'Alabama', 'OT', '1999-05-17', 142, 196, 'Arizona Cardinals', NULL),
(9, 'Isiah Simmons', 'Clemson', 'LB', '1998-07-26', 104, 193, 'Jacksonville Jaguars', NULL),
(10, 'Mekhi Becton', 'Louisville', 'OT', '1999-04-18', 167, 201, 'Cleveland Browns', NULL),
(11, 'Andrew Thomas', 'Georgia', 'OT', '1999-01-22', 145, 196, 'New York Jets', NULL),
(12, 'Jerry Jeudy', 'Alabama', 'WR', '1999-04-24', 87, 185, 'Las Vegas Raiders', NULL),
(13, 'Javon Kinlaw', 'Carolina', 'DT', '1997-10-03', 141, 198, 'Indianapolis Colts', NULL),
(14, 'Xavier McKinney', 'Alabama', 'S', '1999-02-13', 91, 185, 'Tampa Bay Buccaneers', NULL),
(15, 'Henry Ruggs', 'Alabama', 'WR', '1999-01-24', 86, 183, 'Denver Broncos', NULL),
(16, 'K\'Lavon Chaisson', 'LSU', 'DE', '1999-07-25', 113, 193, 'Atlanta Falcons', NULL),
(17, 'Grant Delpit', 'LSU', 'S', '1998-09-20', 92, 191, 'Dallas Cowboys', NULL),
(18, 'D\'Andre Swift', 'Georgia', 'RB', '1999-01-14', 98, 175, 'Miami Dolphins', NULL),
(19, 'Kenneth Murray', 'Oklahoma', 'LB', '1998-11-16', 110, 188, 'Las Vegas Raiders', NULL),
(20, 'C.J. Henderson', 'Florida', 'CB', '1998-09-30', 92, 185, 'Jacksonville Jaguars', NULL),
(21, 'CeeDee Lamb', 'Oklahoma', 'WR', '1999-04-08', 88, 189, 'Philadelphia Eagles', NULL),
(22, 'Jalen Reagor', 'TCU', 'WR', '1999-01-01', 88, 180, 'Buffalo Bills', NULL),
(23, 'Patrick Queen', 'LSU', 'LB', '1999-08-13', 104, 185, 'New England Patriots', NULL),
(24, 'Justin Jefferson', 'LSU', 'WR', '1999-01-16', 87, 191, 'New Orleans Saints', NULL),
(25, 'Justin Madubuike', 'Texas A&M', 'DT', '1997-11-17', 138, 191, 'Minnesota Vikings', NULL),
(26, 'Austin Jackson', 'USC', 'OT', '1999-05-17', 141, 198, 'Miami Dolphins', NULL),
(27, 'Shane Lemieux', 'Oregon', 'G', '2000-01-01', 140, 193, 'Seattle Seahawks', NULL),
(28, 'Jonathan Taylor', 'Wisconsin', 'RB', '1999-01-19', 97, 180, 'Baltimore Ravens', NULL),
(29, 'Yetur Gross-Matos', 'Penn State', 'DE', '1998-02-26', 120, 196, 'Tennessee Titans', NULL),
(30, 'Laviska Shenault', 'Colorado', 'WR', '1998-10-05', 100, 188, 'Green Bay Packers', NULL),
(31, 'Tyler Biadasz', 'Wisconsin', 'C', '1997-05-17', 191, 143, 'San Fransisco 49ers', NULL),
(32, 'A.J. Epenasa', 'Iowa', 'DE', '1998-09-15', 127, 198, 'Kansas City Chiefs', NULL);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `teams`
--

CREATE TABLE `teams` (
  `Name` varchar(25) NOT NULL,
  `Division` varchar(10) DEFAULT NULL,
  `HeadCoach` varchar(40) DEFAULT NULL,
  `Owner` varchar(40) DEFAULT NULL,
  `Badge` blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `teams`
--

INSERT INTO `teams` (`Name`, `Division`, `HeadCoach`, `Owner`, `Badge`) VALUES
('Arizona Cardinals', 'NFC West', 'Kliff Timothy Kingsbury', 'Michael Bidwill', NULL),
('Atlanta Falcons', 'NFC South', 'Daniel Patrick Quinn', 'Arthur M. Blank', NULL),
('Baltimore Ravens', 'AFC North', 'John W. Harbaugh', 'Steve Bisciotti', NULL),
('Buffalo Bills', 'AFC East', 'Sean McDermott', 'Terrence Pegula', NULL),
('Carolina Panthers', 'NFC South', 'Matthew Kenneth Rhule', 'David Tepper', NULL),
('Chicago Bears', 'NFC North', 'Matthew Nagy', 'Michael McCaskey', NULL),
('Cincinnati Bengals', 'AFC North', 'Zac Taylor', 'Mike Brown', NULL),
('Cleveland Browns', 'AFC North', 'Kevin Stefanski', 'Randy Lerner', NULL),
('Dallas Cowboys', 'NFC East', 'Michael John McCarthy', 'Jerry Jones', NULL),
('Denver Broncos', 'AFC West', 'Victor John Fangio', 'Pat Bowlen', NULL),
('Detroit Lions', 'NFC North', 'Matthew Edward Patricia', 'Martha Firestone Ford Sr.', NULL),
('Green Bay Packers', 'NFC North', 'Matthew LaFleur', 'Mark Murphy', NULL),
('Houston Texans', 'AFC South', 'William James O\'Brien', 'Robert C. McNair', NULL),
('Indianapolis Colts', 'AFC South', 'Frank Michael Reich Jr.', 'Jim Irsay', NULL),
('Jacksonville Jaguars', 'AFC South', 'Douglas Charles Marrone', 'Shahid Khan', NULL),
('Kansas City Chiefs', 'AFC West', 'Andrew Walter Reid', 'Clark Hunt', NULL),
('Las Vegas Raiders', 'AFC West', 'Jon David Gruden', 'Al Davis', NULL),
('Los Angeles Chargers', 'AFC West', 'Anthony Ray Lynn', 'Dean A. Spanos', NULL),
('Los Angeles Rams', 'NFC West', 'Sean McVay', 'Stanley Kroenke', NULL),
('Miami Dolphins', 'AFC East', 'Brian Flores', 'Stephen M. Ross', NULL),
('Minnesota Vikings', 'NFC North', 'Michael Zimmer', 'Zygi Wilf', NULL),
('New England Patriots', 'AFC East', 'William Stephen Belichick', 'Robert Kraft', NULL),
('New Orleans Saints', 'NFC South', 'Patrick Sean Payton', 'Tom Benson', NULL),
('New York Giants', 'NFC East', 'Joseph F. Judge', 'John Mara', NULL),
('New York Jets', 'AFC East', 'Adam Joseph Gase', 'Robert Wood Johnson IV.', NULL),
('Philadelphia Eagles', 'NFC East', 'Douglas Irving Pederson', 'Jeffrey Luire', NULL),
('Pittsburgh Steelers', 'AFC North', 'Michael Pettaway Tomlin', 'Dan Rooney', NULL),
('San Fransisco 49ers', 'NFC West', 'Kyle Michael Shanahan', 'Jed York', NULL),
('Seattle Seahawks', 'NFC West', 'Peter Clay Carroll', 'Paul Allen', NULL),
('Tampa Bay Buccaneers', 'NFC South', 'Bruce Charles Arians', 'Malcolm Glazer', NULL),
('Tennessee Titans', 'AFC South', 'Michael George Vrabel', 'Adam Strunk', NULL),
('Washington Redskins', 'NFC East', 'Ronald Eugene Rivera', 'Daniel Snyder', NULL);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `players`
--
ALTER TABLE `players`
  ADD PRIMARY KEY (`Pick`);

--
-- A tábla indexei `teams`
--
ALTER TABLE `teams`
  ADD PRIMARY KEY (`Name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

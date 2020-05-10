-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2020. Ápr 26. 20:58
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
-- Tábla szerkezet ehhez a táblához `dreamteams`
--

CREATE TABLE `dreamteams` (
  `Name` varchar(40) NOT NULL,
  `Division` varchar(10) NOT NULL,
  `HeadCoach` varchar(40) NOT NULL,
  `Owner` varchar(40) NOT NULL,
  `Player1` int(11) DEFAULT NULL,
  `Player2` int(11) DEFAULT NULL,
  `Player3` int(11) DEFAULT NULL,
  `Player4` int(11) DEFAULT NULL,
  `Player5` int(11) DEFAULT NULL,
  `Player6` int(11) DEFAULT NULL,
  `Player7` int(11) DEFAULT NULL,
  `Player8` int(11) DEFAULT NULL,
  `Player9` int(11) DEFAULT NULL,
  `Player10` int(11) DEFAULT NULL,
  `Player11` int(11) DEFAULT NULL,
  `LastPlayer` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `players`
--

CREATE TABLE `players` (
  `Pick` int(2) NOT NULL,
  `Name` varchar(40) DEFAULT NULL,
  `College` varchar(25) DEFAULT NULL,
  `Position` varchar(3) DEFAULT NULL,
  `DateOfBirth` date DEFAULT NULL,
  `Weight` int(3) DEFAULT NULL,
  `Height` int(3) DEFAULT NULL,
  `DraftTeam` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `players`
--

INSERT INTO `players` (`Pick`, `Name`, `College`, `Position`, `DateOfBirth`, `Weight`, `Height`, `DraftTeam`) VALUES
(1, 'Joe Burrow', 'LSU', 'QB', '1996-12-10', 98, 193, 'Cincinnati Bengals'),
(2, 'Chase Young', 'Ohio State', 'DE', '1999-04-14', 120, 196, 'Washington Redskins'),
(3, 'Jeff Okudah', 'Ohio State', 'CB', '1999-07-21', 91, 185, 'Detroit Lions'),
(4, 'Andrew Thomas', 'Georgia', 'OT', '1999-01-22', 145, 196, 'New York Giants'),
(5, 'Tua Tagovailoa', 'Alabama', 'QB', '1998-03-02', 99, 185, 'Miami Dolphins'),
(6, 'Justin Herbert', 'Oregon', 'QB', '1998-03-10', 108, 198, 'Los Angeles Chargers'),
(7, 'Derrick Brown', 'Auburn', 'DE', '1998-04-15', 111, 188, 'Carolina Panthers'),
(8, 'Isiah Simmons', 'Clemson', 'LB', '1998-07-26', 104, 193, 'Arizona Cardinals'),
(9, 'C.J. Henderson', 'Florida', 'CB', '1998-09-30', 92, 185, 'Jacksonville Jaguars'),
(10, 'Jedrick Wills', 'Alabama', 'OT', '1999-05-17', 142, 196, 'Cleveland Browns'),
(11, 'Mekhi Becton', 'Louisville', 'OT', '1999-04-18', 167, 201, 'New York Jets'),
(12, 'Henry Ruggs III', 'Alabama', 'WR', '1999-01-24', 86, 183, 'Las Vegas Raiders'),
(13, 'Tristan Wirfs', 'Iowa', 'OT', '1999-01-24', 146, 196, 'Tampa Bay Buccaneers'),
(14, 'Javon Kinlaw', 'Carolina', 'DT', '1997-10-03', 141, 198, 'San Fransisco 49ers'),
(15, 'Jerry Jeudy', 'Alabama', 'WR', '1999-04-24', 87, 185, 'Denver Broncos'),
(16, 'A.J. Terrell', 'Clemson', 'CB', '1998-09-23', 86, 185, 'Atlanta Falcons'),
(17, 'CeeDee Lamb', 'Oklahoma', 'WR', '1999-04-08', 88, 189, 'Dallas Cowboys'),
(18, 'Austin Jackson', 'USC', 'OT', '1999-05-17', 141, 198, 'Miami Dolphins'),
(19, 'Damon Arnette', 'Ohio State', 'CB', '1996-09-02', 88, 183, 'Las Vegas Raiders'),
(20, 'K\'Lavon Chaisson', 'LSU', 'DE', '1999-07-25', 113, 193, 'Jacksonville Jaguars'),
(21, 'Jalen Reagor', 'TCU', 'WR', '1999-01-01', 88, 180, 'Philadelphia Eagles'),
(22, 'Justin Jefferson', 'LSU', 'WR', '1999-01-16', 87, 191, 'Minnesota Vikings'),
(23, 'Kenneth Murray', 'Oklahoma', 'LB', '1998-11-16', 110, 188, 'Los Angeles Chargers'),
(24, 'Cesar Ruiz', 'Michigan', 'C', '1999-06-14', 139, 191, 'New Orleans Saints'),
(25, 'Brandon Aiyuk', 'Arizona State', 'WR', '1998-03-17', 93, 183, 'San Fransisco 49ers'),
(26, 'Jordan Love', 'Utah State', 'QB', '1998-11-02', 102, 193, 'Green Bay Packers'),
(27, 'Jordyn Brooks', 'Texas Tech', 'LB', '1997-10-21', 109, 183, 'Seattle Seahawks'),
(28, 'Patrick Queen', 'LSU', 'LB', '1999-08-13', 104, 185, 'Baltimore Ravens'),
(29, 'Isaiah Wilson', 'Georgia', 'OT', '1999-02-12', 159, 198, 'Tennessee Titans'),
(30, 'Noah Igbinoghene', 'Auburn', 'CB', '1999-11-27', 90, 178, 'Miami Dolphins'),
(31, 'Jeff Gladney', 'TCU', 'CB', '1996-12-12', 87, 178, 'Minnesota Vikings'),
(32, 'Clyde Edwards-Helarie', 'LSU', 'RB', '1999-04-11', 94, 171, 'Kansas City Chiefs'),
(33, 'Tee Higgins', 'Clemson', 'TE', '1999-01-18', 98, 193, 'Cincinnati Bengals'),
(34, 'Michael Pittman', 'USC', 'WR', '1997-10-05', 101, 193, 'Indianapolis Colts'),
(35, 'D\'Andre Swift', 'Georgia', 'RB', '1999-01-14', 98, 175, 'Detroit Lions'),
(36, 'Xavier McKinney', 'Alabama', 'S', '1999-02-13', 91, 185, 'New York Giants'),
(37, 'Kyle Dugger', 'Lenoir-Rhyne', 'S', '1996-03-22', 98, 185, 'New England Patriots'),
(38, 'Yetur Gross-Matos', 'Penn State', 'DE', '1998-02-26', 120, 196, 'Carolina Panthers'),
(39, 'Robert Hunt', 'Louisiana Lafayette', 'OT', '1996-08-25', 147, 196, 'Miami Dolphins'),
(40, 'Ross Blacklock', 'TCU', 'DT', '1998-07-09', 132, 191, 'Houston Texans'),
(41, 'Jonathan Taylor', 'Wisconsin', 'RB', '1999-01-19', 97, 180, 'Indianapolis Colts'),
(42, 'Laviska Sheanult Jr.', 'Colorado', 'WR', '1998-10-05', 103, 185, 'Jacksonville Jaguars'),
(43, 'Cole Kmet', 'Notre Dame', 'TE', '1999-03-10', 119, 198, 'Chicago Bears'),
(44, 'Grant Delpit', 'LSU', 'S', '1998-09-20', 92, 191, 'Cleveland Browns'),
(45, 'Antoine Winfield Jr.', 'Minnesota', 'S', '1998-08-16', 92, 175, 'Tampa Bay Buccaneers'),
(46, 'K.J. Hamler', 'Penn State', 'WR', '1999-07-08', 81, 175, 'Denver Broncos'),
(47, 'Marlon Davidson', 'Auburn', 'LB', '1998-05-11', 137, 191, 'Atlanta Falcons'),
(48, 'Darrell Taylor', 'Tennessee', 'LB', '1997-03-24', 121, 193, 'Seattle Seahawks'),
(49, 'Chase Claypool', 'Notre Dame', 'WR', '1998-07-07', 108, 193, 'Pittsburgh Steelers'),
(50, 'Jaylon Johnson', 'Utah', 'CB', '1999-04-19', 88, 183, 'Chicago Bears'),
(51, 'Trevon Diggs', 'Alabama', 'CB', '1997-09-20', 93, 185, 'Dallas Cowboys'),
(52, 'Cam Akers', 'Florida State', 'RB', '1999-06-22', 98, 178, 'Los Angeles Rams'),
(53, 'Jalen Hurts', 'Oklahoma', 'QB', '1998-08-07', 101, 185, 'Philadelphia Eagles'),
(54, 'A.J. Epenasa', 'Iowa', 'DE', '1998-09-15', 127, 198, 'Buffalo Bills'),
(55, 'J.K. Dobbins', 'Ohio State', 'RB', '1998-12-17', 95, 175, 'Baltimore Ravens'),
(56, 'Raekwon Davis', 'Alabama', 'DT', '1997-08-21', 141, 198, 'Miami Dolphins'),
(57, 'Van Jefferson', 'Florida', 'WR', '1996-07-26', 91, 185, 'Los Angeles Rams'),
(58, 'Ezra Cleveland', 'Boise State', 'OT', '1998-05-08', 141, 198, 'Minnesota Vikings'),
(59, 'Denzel Mims', 'Baylor', 'WR', '1997-10-10', 94, 191, 'New York Jets'),
(60, 'Josh Uche', 'Michigan', 'LB', '1998-09-18', 111, 185, 'New England Patriots'),
(61, 'Kristian Fulton', 'LSU', 'CB', '1998-09-03', 90, 183, 'Tennessee Titans'),
(62, 'A.J. Dillon', 'Boston College', 'RB', '1998-05-02', 112, 183, 'Green Bay Packers'),
(63, 'Willie Gay Jr.', 'Mississippi State', 'LB', '1998-02-15', 110, 185, 'Kansas City Chiefs'),
(64, 'Jeremy Chinn', 'Southern Illinois', 'S', '1998-02-26', 100, 191, 'Carolina Panthers'),
(65, 'Logan Wilson', 'Wyoming', 'LB', '1996-07-08', 109, 188, 'Cincinnati Bengals'),
(66, 'Antonio Gibson', 'Memphis', 'WR', '1998-06-23', 100, 188, 'Washington Redskins'),
(67, 'Julian Okwara', 'Notre Dame', 'LB', '1997-12-27', 112, 193, 'Detroit Lions'),
(68, 'Ashtyn Davis', 'California', 'S', '1996-10-10', 91, 185, 'New York Jets'),
(69, 'Damien Lewis', 'LSU', 'G', '1997-03-21', 151, 191, 'Seattle Seahawks'),
(70, 'Brandon Jones', 'Texas', 'S', '1998-04-02', 93, 183, 'Miami Dolphins'),
(71, 'Justin Madubuike', 'Texas A&M', 'DT', '1997-11-17', 138, 191, 'Baltimore Ravens'),
(72, 'Josh Jones', 'Houston', 'OT', '1997-06-22', 141, 196, 'Arizona Cardinals'),
(73, 'DaVon Hamilton', 'Ohio State', 'DT', '1997-02-01', 148, 193, 'Jacksonville Jaguars'),
(74, 'Zack Baun', 'Wisconsin', 'LB', '1996-12-30', 109, 191, 'New Orleans Saints'),
(75, 'Jonah Jackson', 'Ohio State', 'G', '1997-02-05', 141, 193, 'Detroit Lions'),
(76, 'Ke\'Shawn Vaughn', 'Vanderbilt', 'RB', '1997-05-04', 93, 178, 'Tampa Bay Buccaneers'),
(77, 'Michael Ojemudia', 'Iowa', 'CB', '1997-09-12', 91, 183, 'Denver Broncos'),
(78, 'Matt Hennessy', 'Temple', 'C', '1997-11-17', 137, 193, 'Atlanta Falcons'),
(79, 'Jabari Zuniga', 'Florida', 'LB', '1997-08-14', 115, 191, 'New York Jets'),
(80, 'Lynn Bowden', 'Kentucky', 'WR', '1997-10-14', 90, 185, 'Las Vegas Raiders'),
(81, 'Bryan Edwards', 'South Carolina', 'WR', '1998-11-13', 98, 191, 'Las Vegas Raiders'),
(82, 'Neville Gallimore', 'Oklahoma', 'DT', '1997-01-17', 137, 188, 'Dallas Cowboys'),
(83, 'Lloyd Cushenberry', 'LSU', 'C', '1997-11-22', 143, 191, 'Denver Broncos'),
(84, 'Terrell Lewis', 'Alabama', 'LB', '1998-08-25', 117, 196, 'Los Angeles Rams'),
(85, 'Julian Blackmon', 'Utah', 'S', '1998-08-24', 93, 185, 'Indianapolis Colts'),
(86, 'Zack Moss', 'Utah', 'RB', '1997-12-15', 101, 178, 'Buffalo Bills'),
(87, 'Anfernee Jennings', 'Alabama', 'LB', '1997-05-01', 114, 188, 'New England Patriots'),
(88, 'Jordan Elliot', 'Missouri', 'DT', '1997-11-23', 143, 193, 'Cleveland Browns'),
(89, 'Cameron Dantzler', 'Mississippi State', 'CB', '1998-09-03', 84, 188, 'Minnesota Vikings'),
(90, 'Jonathan Greenard', 'Florida', 'LB', '1997-05-25', 119, 193, 'Houston Texans'),
(91, 'Devin Asiasi', 'UCLA', 'TE', '1997-08-14', 118, 191, 'New England Patriots'),
(92, 'Devin Duvernay', 'Texas', 'WR', '1997-09-12', 92, 180, 'Baltimore Ravens'),
(93, 'Darrynton Evans', 'Appalachian State', 'RB', '1998-07-09', 91, 180, 'Tennessee Titans'),
(94, 'Josiah Deguara', 'Cincinnati', 'TE', '1997-02-14', 111, 191, 'Green Bay Packers'),
(95, 'McTelvin Agim', 'Arkansas', 'DT', '1997-09-25', 136, 191, 'Denver Broncos'),
(96, 'Lucas Niang', 'TCU', 'OT', '1998-08-19', 149, 201, 'Kansas City Chiefs'),
(97, 'Jacob Phillips', 'LSU', 'LB', '1999-04-01', 106, 193, 'Cleveland Browns'),
(98, 'Malik Harrison', 'Ohio State', 'LB', '1998-03-25', 112, 191, 'Baltimore Ravens'),
(99, 'Matt Peart', 'Connecticut', 'OT', '1997-06-11', 141, 196, 'New York Giants'),
(100, 'Tanner Muse', 'Clemson', 'S', '1996-09-06', 104, 188, 'Las Vegas Raiders'),
(101, 'Dalton Keene', 'Virginia Tech', 'TE', '1999-04-14', 114, 193, 'New England Patriots'),
(102, 'Alex Highsmith', 'Charlotte', 'LB', '1997-08-07', 110, 193, 'Pittsburgh Steelers'),
(103, 'Davion Taylor', 'Colorado', 'LB', '1998-08-05', 102, 185, 'Philadelphia Eagles'),
(104, 'Terrell Burgess', 'Utah', 'S', '1998-11-12', 87, 180, 'Los Angeles Rams'),
(105, 'Adam Trautman', 'Dayton', 'TE', '1997-02-05', 115, 196, 'New Orleans Saints'),
(106, 'Tyre Phillips', 'Mississippi State', 'G', '1997-01-29', 156, 196, 'Baltimore Ravens'),
(107, 'Akeem Davis-Gaither', 'Appalachian State', 'LB', '1997-09-21', 98, 188, 'Cincinnati Bengals'),
(108, 'Saahdiq Charles', 'LSU', 'OT', '1999-07-26', 134, 193, 'Washington Redskins'),
(109, 'John Simpson', 'Clemson', 'G', '1997-08-19', 150, 193, 'Las Vegas Raiders'),
(110, 'Darnay Holmes', 'UCLA', 'CB', '1998-06-23', 90, 178, 'New York Giants'),
(111, 'Solomon Kindley', 'Georgia', 'G', '1997-07-31', 152, 193, 'Miami Dolphins'),
(112, 'Joshua Kelley', 'UCLA', 'RB', '1997-11-20', 99, 180, 'Los Angeles Chargers'),
(113, 'Troy Pride', 'Notre Dame', 'CB', '1998-01-19', 88, 180, 'Carolina Panthers'),
(114, 'Leki Fotu', 'Utah', 'DT', '1998-08-23', 152, 196, 'Arizona Cardinals'),
(115, 'Harrison Bryant', 'Florida Atlantic', 'TE', '1998-04-23', 109, 196, 'Cleveland Browns'),
(116, 'Ben Bartch', 'St. John\'s (Minn.)', 'OT', '1998-07-22', 138, 198, 'Jacksonville Jaguars'),
(117, 'D.J. Wonnum', 'South Carolina', 'LB', '1997-10-31', 118, 196, 'Minnesota Vikings'),
(118, 'Albert Okwuegbunam', 'Missouri', 'TE', '1998-04-25', 116, 196, 'Denver Broncos'),
(119, 'Mykal Walker', 'Fresno State', 'LB', '1997-08-28', 104, 191, 'Atlanta Falcons'),
(120, 'La\'Mical Perine', 'Floria', 'RB', '1998-01-30', 99, 180, 'New York Jets'),
(121, 'Logan Stenberg', 'Kentucky', 'G', '1997-03-18', 146, 198, 'Detroit Lions'),
(122, 'Jacob Eason', 'Washington', 'QB', '1997-11-17', 103, 198, 'Indianapolis Colts'),
(123, 'Reggie Robinson II', 'Tulsa', 'CB', '1997-04-14', 89, 185, 'Dallas Cowboys'),
(124, 'Anthony McFarland', 'Maryland', 'RB', '1999-03-04', 90, 175, 'Pittsburgh Steelers'),
(125, 'James Morgan', 'Florida International', 'QB', '1997-02-28', 97, 193, 'New York Jets'),
(126, 'Charlie Heck', 'North Carolina', 'OT', '1996-11-20', 143, 203, 'Houston Texans'),
(127, 'K\'Von Wallace', 'Clemson', 'S', '1997-07-25', 90, 180, 'Philadelphia Eagles'),
(128, 'Gabriel Davis', 'UCF', 'WR', '1999-04-01', 96, 191, 'Buffalo Bills'),
(129, 'Cameron Clark', 'Charlotte', 'G', '1997-11-16', 133, 196, 'New York Jets'),
(130, 'James Lynch', 'Baylor', 'DE', '1999-01-20', 134, 193, 'Minnesota Vikings'),
(131, 'Rashard Lawrence', 'LSU', 'DT', '1998-09-27', 140, 188, 'Arizona Cardinals'),
(132, 'Troy Dye', 'Oregon', 'LB', '1996-09-18', 103, 193, 'Minnesota Vikings'),
(133, 'Colby Parkinson', 'Stanford', 'TE', '1999-01-08', 114, 201, 'Seattle Seahawks'),
(134, 'Jaylinn Hawkins', 'California', 'S', '1997-08-25', 95, 188, 'Atlanta Falcons'),
(135, 'Kevin Dotson', 'Louisiana-Lafayette', 'G', '1996-09-18', 141, 193, 'Pittsburgh Steelers'),
(136, 'Brycen Hopkins', 'Purdue', 'TE', '1997-03-27', 111, 196, 'Los Angeles Rams'),
(137, 'Josiah Scott', 'Michigan State', 'CB', '1999-04-05', 78, 178, 'Jacksonville Jaguars'),
(138, 'L\'Jarius Sneed', 'Louisiana Tech', 'S', '1997-01-21', 88, 185, 'Kansas City Chiefs'),
(139, 'Amik Robertson', 'Louisiana Tech', 'CB', '1989-07-06', 83, 175, 'Las Vegas Raiders'),
(140, 'Shaquille Quarterman', 'Miami (Fla.)', 'LB', '1997-10-28', 109, 185, 'Jacksonville Jaguars'),
(141, 'John Reid', 'Penn State', 'CB', '1996-05-15', 82, 178, 'Houston Texans'),
(142, 'Antonio Gandy-Golden', 'Liberty', 'WR', '1998-04-11', 100, 193, 'Washington Redskins'),
(143, 'Ben Bredeson', 'Michigan', 'G', '1998-02-20', 147, 196, 'Baltimore Ravens'),
(144, 'DeeJay Dallas', 'Miami (Fla.)', 'RB', '1998-09-16', 95, 178, 'Seattle Seahawks'),
(145, 'Jack Driscoll', 'Auburn', 'OT', '1997-04-01', 134, 196, 'Philadelphia Eagles'),
(146, 'Tyler Biadasz', 'Wisconsin', 'C', '1997-09-25', 146, 191, 'Los Angeles Rams'),
(147, 'Khalid Kareem', 'Notre Dame', 'LB', '1998-04-28', 120, 193, 'Cincinnati Bengals'),
(148, 'Alton Robinson', 'Syracuse', 'LB', '1997-07-07', 118, 191, 'Seattle Seahawks'),
(149, 'Danny Pinter', 'Ball State', 'G', '1996-06-19', 136, 193, 'Indianapolis Colts'),
(150, 'Shane Lemieux', 'Oregon', 'G', '1997-05-12', 143, 193, 'New York Giants'),
(151, 'Joe Reed', 'Virginia', 'WR', '1998-01-04', 98, 185, 'Los Angeles Chargers'),
(152, 'Kenny Robinson', 'West Virginia', 'S', '1999-01-08', 90, 188, 'Carolina Panthers'),
(153, 'Colton McKivitz', 'West Virginia', 'OT', '1996-08-09', 138, 198, 'San Fransisco 49ers'),
(154, 'Jason Strowbridge', 'North Carolina', 'DE', '1996-09-10', 129, 196, 'Miami Dolphins'),
(155, 'Trevis Gipson', 'Tulsa', 'DE', '1997-06-13', 122, 193, 'Chicago Bears'),
(156, 'Keith Ismael', 'San Diego State', 'C', '1998-07-25', 136, 191, 'Washington Redskins'),
(157, 'Daniel Thomas', 'Auburn', 'S', '1998-07-01', 95, 180, 'Jacksonville Jaguars'),
(158, 'Bryce Hall', 'Virginia', 'CB', '1997-11-05', 91, 185, 'New York Jets'),
(159, 'Justin Rohrwasser', 'Marshall', 'K', '1998-10-06', 104, 191, 'New England Patriots'),
(160, 'Nick Harris', 'Washington', 'C', '1998-11-13', 137, 185, 'Cleveland Browns'),
(161, 'Tyler Johnson', 'Minnesota', 'WR', '1998-08-25', 93, 188, 'Tampa Bay Buccaneers'),
(162, 'Khaleke Hudson', 'Michigan', 'LB', '1997-12-06', 100, 180, 'Washington Redskins'),
(163, 'Kindle Vildor', 'Georgia Southern', 'CB', '1997-12-11', 86, 180, 'Chicago Bears'),
(164, 'Curtis Weaver', 'Boise State', 'LB', '1998-08-03', 120, 191, 'Miami Dolphins'),
(165, 'Collin Johnson', 'Texas', 'WR', '1997-09-23', 100, 198, 'Jacksonville Jaguars'),
(166, 'Quintez Cephus', 'Wisconsin', 'WR', '1998-04-01', 94, 185, 'Detroit Lions'),
(167, 'Jake Fromm', 'Georgia', 'QB', '1998-07-30', 100, 188, 'Buffalo Bills'),
(168, 'John Hightower', 'Boise State', 'WR', '1996-05-31', 78, 188, 'Philadelphia Eagles'),
(169, 'Harrison Hand', 'Temple', 'CB', '1998-11-12', 87, 183, 'Minnesota Vikings'),
(170, 'Broderick Washington', 'Texas Tech', 'DT', '1999-09-12', 138, 191, 'Baltimore Ravens'),
(171, 'Isaiah Coulter', 'Rhode Island', 'WR', '1998-09-18', 86, 191, 'Houston Texans'),
(172, 'Jason Huntley', 'New Mexico State', 'RB', '1998-04-20', 88, 175, 'Detroit Lions'),
(173, 'Darnell Mooney', 'Tulane', 'WR', '1997-10-29', 79, 180, 'Chicago Bears'),
(174, 'Larrell Murchison', 'North Carolina State', 'DT', '1997-04-24', 132, 188, 'Tennessee Titans'),
(175, 'Kamal Martin', 'Minnesota', 'LB', '1999-06-02', 111, 191, 'Green Bay Packers'),
(176, 'K.J. Osborn', 'Miami (Fla.)', 'WR', '1997-06-10', 93, 183, 'Minnesota Vikings'),
(177, 'Michael Danna', 'Michigan', 'LB', '1998-05-17', 118, 188, 'Kansas City Chiefs'),
(178, 'Justin Strnad', 'Wake Forest', 'LB', '1996-08-21', 107, 191, 'Denver Broncos'),
(179, 'Bradlee Anae', 'Utah', 'LB', '1998-01-17', 120, 191, 'Dallas Cowboys'),
(180, 'Hakeem Adeniji', 'Kansas', 'G', '1997-12-08', 136, 196, 'Cincinnati Bengals'),
(181, 'Netane Muti', 'Fresno State', 'G', '1999-03-27', 139, 191, 'Denver Broncos'),
(182, 'Mike Onwenu', 'Michigan', 'G', '1997-12-10', 159, 191, 'New England Patriots'),
(183, 'Cameron Brown', 'Penn State', 'LB', '1998-04-01', 106, 196, 'New York Giants'),
(184, 'Bravvion Roy', 'Baylor', 'DT', '1997-10-18', 151, 185, 'Carolina Panthers'),
(185, 'Blake Ferguson', 'LSU', 'LS', '1997-04-21', 107, 191, 'Miami Dolphins'),
(186, 'Alohi Gilman', 'Notre Dame', 'S', '1997-09-17', 92, 178, 'Los Angeles Chargers'),
(187, 'Donovan Peoples-Jones', 'Michigan', 'WR', '1999-02-19', 94, 188, 'Cleveland Browns'),
(188, 'Tyler Bass', 'Georgia Southern', 'K', '1998-12-03', 84, 178, 'Buffalo Bills'),
(189, 'Jake Luton', 'Oregon State', 'QB', '1996-04-11', 104, 201, 'Jacksonville Jaguars'),
(190, 'Charlie Woerner', 'Georgia', 'TE', '1997-10-16', 111, 196, 'San Fransisco 49ers'),
(191, 'Braden Mann', 'Texas A&M', 'P', '1997-11-24', 88, 180, 'New York Jets'),
(192, 'Jon Runyan', 'Michigan', 'G', '1997-08-08', 146, 196, 'Green bay Packers'),
(193, 'Robert Windsor', 'Penn State', 'DT', '1997-01-15', 129, 193, 'Indianapolis Colts'),
(194, 'Khalil Davis', 'Nebraska', 'DT', '1996-08-22', 143, 188, 'Tampa Bay Buccaneers'),
(195, 'Justin Herron', 'Wake Forest', 'G', '1995-11-27', 132, 196, 'New England Patriots'),
(196, 'Shaun Bradley', 'Temple', 'LB', '1997-04-08', 104, 185, 'Philadelphia Eagles'),
(197, 'John Penisini', 'Utah', 'DT', '1997-05-31', 151, 188, 'Detroit Lions'),
(198, 'Antoine Brooks Jr.', 'Maryland', 'S', '1997-10-28', 98, 180, 'Pittsburgh Steelers'),
(199, 'Jordan Fuller', 'Ohio State', 'S', '1998-03-04', 93, 188, 'Los Angeles Rams'),
(200, 'Quez Watkins', 'Southern Mississippi', 'WR', '1998-06-09', 86, 188, 'Philadelphia Eagles'),
(201, 'James Proche', 'Southern Methodist', 'WR', '1996-09-21', 88, 183, 'Baltimore Ravens'),
(202, 'Evan Weaver', 'California', 'LB', '1998-08-11', 107, 191, 'Arizona Cardinals'),
(203, 'Blake Brandel', 'Oregon State', 'G', '1997-08-21', 139, 201, 'Minnesota Vikings'),
(204, 'Cassh Maluia', 'Wyoming', 'LB', '1998-10-03', 112, 183, 'New England Patriots'),
(205, 'Josh Metellus', 'Michigan', 'S', '1998-01-21', 95, 180, 'Minnesota Vikings'),
(206, 'Tyler Davis', 'Georgia Tech', 'TE', '1997-01-24', 113, 193, 'Jacksonville Jaguars'),
(207, 'Isaiah Hodgins', 'Oregon State', 'WR', '1998-10-21', 95, 193, 'Buffalo Bills'),
(208, 'Jake Hanson', 'Oregon', 'C', '1997-04-29', 134, 196, 'Green Bay Packers'),
(209, 'Simon Stepaniak', 'Indiana', 'G', '1997-05-15', 146, 193, 'Green Bay Packers'),
(210, 'Prince Tega Wanogho', 'Auburn', 'OT', '1997-11-22', 139, 196, 'Philadelphia Eagles'),
(211, 'Isaiah Rodgers', 'Massachusetts', 'S', '1998-07-27', 77, 178, 'Indianapolis Colts'),
(212, 'Dezmon Patmon', 'Washington State', 'WR', '1998-08-06', 103, 193, 'Indianapolis Colts'),
(213, 'Jordan Glasgow', 'Michigan', 'LB', '1996-06-28', 103, 185, 'Indianapolis Colts'),
(214, 'Freddie Swain', 'Florida', 'WR', '1998-08-04', 90, 183, 'Seattle Seahawks'),
(215, 'Markus Bailey', 'Purdue', 'LB', '1997-03-07', 109, 185, 'Cincinnati Bengals'),
(216, 'Kamren Curl', 'Arkansas', 'S', '1999-03-31', 90, 188, 'Washington Redskins'),
(217, 'Jauan Jennings', 'Tennessee', 'WR', '1997-07-10', 94, 191, 'San Fransisco 49ers'),
(218, 'Carter Coughlin', 'Minnesota', 'LB', '1998-10-01', 106, 191, 'New York Giants'),
(219, 'Geno Stone', 'Iowa', 'S', '1999-04-19', 95, 178, 'Baltimore Ravens'),
(220, 'K.J. Hill', 'Ohio State', 'WR', '1997-09-15', 88, 183, 'Los Angeles Chargers'),
(221, 'Stantley Thomas-Oliver III', 'Florida International', 'CB', '1998-06-04', 83, 188, 'Carolina Panthers'),
(222, 'Eno Benjamin', 'Arizona State', 'RB', '1999-04-13', 91, 178, 'Arizona Cardinals'),
(223, 'Chris Claybrooks', 'Memphis', 'CB', '1997-06-09', 80, 183, 'Jacksonville Jaguars'),
(224, 'Cole McDonald', 'Hawaii', 'QB', '1998-05-20', 100, 193, 'Tennessee Titans'),
(225, 'Kenny Willekes', 'Michigan State', 'DE', '1997-07-22', 114, 193, 'Minnesota Vikings'),
(226, 'Arlington Hambright', 'Colorado', 'G', '1996-01-30', 136, 196, 'Chicago Bears'),
(227, 'Lachavious Simmons', 'Tennessee State', 'G', '1996-09-12', 143, 196, 'Chicago Bears'),
(228, 'Sterling Hofrichter', 'Syracuse', 'P', '1997-04-12', 90, 175, 'Atlanta Falcons'),
(229, 'James Smith-Williams', 'North Carolina State', 'LB', '1997-06-10', 120, 193, 'Washington Redskins'),
(230, 'Dustin Woodard', 'Memphis', 'C', '1996-10-12', 129, 188, 'New England Patriots'),
(231, 'Ben DiNucci', 'James Madison', 'QB', '1996-11-24', 95, 191, 'Dallas Cowboys'),
(232, 'Carlos Davis', 'Nebraska', 'DT', '1996-08-22', 145, 188, 'Pittsburgh Steelers'),
(233, 'Casey Toohill', 'Stanford', 'LB', '1997-10-21', 112, 193, 'Philadelphia Eagles'),
(234, 'Clay Johnston', 'Baylor', 'LB', '1996-01-14', 105, 185, 'Los Angeles Rams'),
(235, 'Jashon Cornell', 'Ohio State', 'DT', '1997-03-22', 129, 191, 'Detroit Lions'),
(236, 'Vernon Scott', 'TCU', 'S', '1996-03-09', 93, 188, 'Green Bay Packers'),
(237, 'Bopete Keyes', 'Tulane', 'CB', '1997-11-09', 91, 185, 'Kansas City Chiefs'),
(238, 'T.J. Brunson', 'South Carolina', 'LB', '1997-12-03', 104, 185, 'New York Giants'),
(239, 'Dane Jackson', 'Pittsburgh', 'CB', '1996-11-29', 86, 183, 'Buffalo Bills'),
(240, 'Tommy Stevens', 'Mississippi State', 'QB', '1996-12-15', 107, 196, 'New Orleans Saints'),
(241, 'Chapelle Russel', 'Temple', 'LB', '1997-01-20', 104, 185, 'Tampa Bay Buccaneers'),
(242, 'Jonathan Garvin', 'Miami (Fla.)', 'LB', '1999-07-28', 116, 193, 'Green Bay Packers'),
(243, 'Chris Jackson', 'Marshall', 'CB', '1998-04-13', 84, 183, 'Tennessee Titans'),
(244, 'Nate Stanley', 'Iowa', 'QB', '1997-08-26', 110, 193, 'Minnesota Vikings'),
(245, 'Raymond Calais', 'Louisiana-Lafayette', 'RB', '1998-04-02', 84, 175, 'Tampa Bay Buccaneers'),
(246, 'Malcolm Perry', 'Navy', 'WR', '1996-08-24', 86, 175, 'Miami Dolphins'),
(247, 'Chris Williamson', 'Minnesota', 'CB', '1997-03-17', 93, 183, 'New York Giants'),
(248, 'Sam Sloman', 'Miami (Ohio)', 'S', '1997-09-19', 93, 173, 'Los Angeles Rams'),
(249, 'Brian Cole II', 'Mississippi State', 'S', '1997-04-03', 93, 188, 'Los Angeles Rams'),
(250, 'Tremayne Anchrum', 'Clemson', 'G', '1998-06-24', 141, 188, 'Los Angeles Rams'),
(251, 'Stephen Sullivan', 'LSU', 'TE', '1996-11-28', 110, 196, 'Seattle Seahawks'),
(252, 'Tyrie Cleveland', 'Florida', 'WR', '1997-09-20', 93, 188, 'Denver Broncos'),
(253, 'Kyle Hinton', 'Washburn', 'G', '1998-02-27', 134, 188, 'Minnesota Vikings'),
(254, 'Derrek Tuszka', 'North Dakota State', 'LB', '1998-09-29', 112, 196, 'Denver Broncos'),
(255, 'Tae Crowder', 'Georgia', 'LB', '1997-03-12', 107, 191, 'New York Giants');

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
-- A tábla indexei `dreamteams`
--
ALTER TABLE `dreamteams`
  ADD PRIMARY KEY (`Name`);

--
-- A tábla indexei `players`
--
ALTER TABLE `players`
  ADD PRIMARY KEY (`Pick`),
  ADD KEY `PDTtoTN` (`DraftTeam`);

--
-- A tábla indexei `teams`
--
ALTER TABLE `teams`
  ADD PRIMARY KEY (`Name`);

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `players`
--
ALTER TABLE `players`
  ADD CONSTRAINT `PDTtoTN` FOREIGN KEY (`DraftTeam`) REFERENCES `teams` (`Name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

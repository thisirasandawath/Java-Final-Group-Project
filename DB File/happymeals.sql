-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2023 at 06:16 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `happymeals`
--

-- --------------------------------------------------------

--
-- Table structure for table `chefs`
--

CREATE TABLE `chefs` (
  `chef_id` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone_number` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chefs`
--

INSERT INTO `chefs` (`chef_id`, `age`, `gender`, `name`, `phone_number`) VALUES
(30, 25, 'Male', 'Kaveen', '+940773255431');

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `Comment_ID` int(11) NOT NULL,
  `Parent_ID` int(11) NOT NULL,
  `Food_ID` int(11) NOT NULL,
  `Posted_By` varchar(255) NOT NULL,
  `Comment` text NOT NULL,
  `Post_Date` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`Comment_ID`, `Parent_ID`, `Food_ID`, `Posted_By`, `Comment`, `Post_Date`) VALUES
(8, 0, 1, 'kaveen', 'It\'s Good', '2023-04-02 23:29:13');

-- --------------------------------------------------------

--
-- Table structure for table `foods`
--

CREATE TABLE `foods` (
  `Food_ID` int(11) NOT NULL,
  `Category` varchar(255) NOT NULL,
  `Title` varchar(30) NOT NULL,
  `Description` text NOT NULL,
  `Price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `foods`
--

INSERT INTO `foods` (`Food_ID`, `Category`, `Title`, `Description`, `Price`) VALUES
(1, 'Burger', 'Cheese Burger', 'Prepared with beef patty, cheese, burger sauce, pickles & onion', 700),
(2, 'Burger', 'Bacon Cheese Burger', 'Prepared with beef patty, 2 slices cheese, bacon & burger sauce', 500),
(3, 'Burger', 'Double Cheese Burger', 'Prepared with 2 beef patties, double cheese, burger sauce & onion', 640),
(4, 'Burger', 'Lil Smoke', 'Prepared with beef patty, cheese, bbq sauce, burger sauce, pickles & onion', 160),
(5, 'Burger', 'Beef Smoke', 'Prepared with 2 beef patties, 2 slices cheese, bbq sauce, burger sauce & onion', 280),
(6, 'Burger', 'Juicy Burger', 'Prepared with potato juice, beef patties, double cheese & burger sauce', 960),
(7, 'Pizza', 'BBQ Chicken Pizza', 'Topped with grilled chicken, bbq sauce & mozzarella cheese', 240),
(8, 'Pizza', 'Chicken Meatball Pizza', 'Topped with chicken meatball, tomato sauce & mozzarella cheese', 960),
(9, 'Pizza', 'Chicken Tikka Pizza', 'Topped with chicken tikka, tomato sauce & mozzarella cheese', 350),
(10, 'Pizza', 'Beef Meatball Pizza', 'Prepared with frank sausage, bacon, scallion, sauce & cheddar cheese', 560),
(11, 'Pizza', 'Vegetable Pizza', 'Topped with capsicum, mushroom, sweet corn, onion & black olive', 480),
(12, 'Pizza', 'Chicken Chunky Pizza', 'Topped with black olive, tomato, capsicum & green chili', 510),
(13, 'Salad', 'Cashewnut Salad', 'Topped with cashew nout and veggies', 310),
(14, 'Salad', 'Seafood Salad', 'Topped with seafood and lots of veggies and virgin olive oil', 360),
(15, 'Salad', 'Grilled Chicken Salad', 'Topped with chicken and secret spice ', 310),
(16, 'Salad', 'Russian Salad', 'Authentic russian taste with lots of veggies and secret sauce', 370),
(17, 'Salad', 'Korean Beef Salad', 'Made with beed in korean spice and sauce', 560),
(18, 'Pasta', 'Bitch Lasagna', 'Baked casserole made with wide flat pasta and layered with fillings such as ragú.', 996),
(19, 'Pasta', 'Ovenbaked Pasta', 'Topped with black olive, chicken, capsicum & green chili', 450),
(20, 'Pasta', 'BBQ Grill Chicken Pasta', 'Topped with grilled chicken, bbq sauce & mozzarella cheese', 340),
(21, 'Pasta', 'Seafood Pasta', 'Topped with seafood & mushroom', 350),
(22, 'Pasta', 'American Mac & Cheese', 'Topped with macarony & mozzarella cheese', 560),
(23, 'Drinks', 'Lemonade', 'Taste of fresh lemon and freshness', 110),
(24, 'Drinks', 'Iced lemon Tea', 'Lemon tea but with chilled ice', 200),
(25, 'Drinks', 'Lemon lassi', 'Taste of lassi with tanginess of lemon', 170),
(26, 'Drinks', 'Milk Shake', 'Taste of heavy cream and milk', 140),
(27, 'Drinks', 'Mango Smoothie', 'Tate of mangoes infused with cream and milk', 270),
(28, 'Coffee', 'Espresso', 'Shots of pure coffee', 120),
(29, 'Coffee', 'Cappuccino', 'Shots of pure coffee induced milk', 260),
(33, 'Desert', 'Red Velvet', 'Magic of bakery in red color', 260),
(34, 'Desert', 'Choco Fudge', 'Chocolate cheese and creaminess ', 190),
(35, 'Desert', 'Oreo and Cheese', 'Crunchy oreo crust and creamy cheese feeling', 190),
(36, 'Desert', 'Blueberry Cheese Dip', 'Mix of blueberry cheesy feeling', 170),
(37, 'Sides', 'Medium French Fry', 'Delicious french fry in medium', 90),
(38, 'Sides', 'Large French Fry', 'Delicious french fry in large', 110),
(39, 'Sides', 'Chicken Fingers', 'Chicken fried in finger sized', 130),
(40, 'Sides', 'Naga Drumsticks', 'Soft spicy chicken with crunchy and sweet outer', 180);

-- --------------------------------------------------------

--
-- Table structure for table `helpers`
--

CREATE TABLE `helpers` (
  `helper_id` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone_number` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `helpers`
--

INSERT INTO `helpers` (`helper_id`, `age`, `gender`, `name`, `phone_number`) VALUES
(15, 25, 'Male', 'Kaveen', '+94077325541'),
(16, 30, 'Female', 'test helper', '+940773255431');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `Role_ID` int(11) NOT NULL,
  `User_ID` int(11) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`Role_ID`, `User_ID`, `Name`) VALUES
(14, 10, 'CUSTOMER'),
(19, 10, 'ADMIN'),
(21, 13, 'CUSTOMER'),
(22, 14, 'CUSTOMER'),
(23, 15, 'CUSTOMER'),
(24, 16, 'CUSTOMER'),
(25, 16, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `User_ID` int(11) NOT NULL,
  `Username` varchar(15) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(62) NOT NULL,
  `Phone_Number` varchar(14) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `Spent` int(11) DEFAULT NULL,
  `Enabled` tinyint(1) NOT NULL,
  `Reg_Date` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`User_ID`, `Username`, `Email`, `Password`, `Phone_Number`, `Gender`, `Spent`, `Enabled`, `Reg_Date`) VALUES
(10, 'admin', 'admin@email.com', '$2a$10$3l0p7n2pIIykRYaPsPbvt.8y60kvyNF9E7Q6e21sMi7tBRPqL8zvS', '+6478912356147', 'Male', 0, 1, '2023-04-02 19:54:50'),
(13, 'bastian', 'bastian@gmail.com', '$2a$10$Y4t79y0jSlwm32uHlWTDvuKaOTAxxMR4Law3oOE3hDwvE6W.ML0Zm', '+940771234567', 'Male', 0, 1, '2023-05-14 09:11:57'),
(14, 'thisira', 'thisira@gmail.com', '$2a$10$lo6z/GzB0/R/aW1BBn/Y9uQca7jV0JT7icEe9yXtCRgwIdbL5OG.i', '+940721234567', 'Male', 0, 1, '2023-05-14 09:12:34'),
(15, 'sachithra', 'sachithra@gmail.com', '$2a$10$j.Mcn9uPzmfKbHAfMSFaU.K5fXItA2rScJUSXMwcnz6RSj.IMb8/a', '+940751234567', 'Male', 0, 1, '2023-05-14 09:13:08'),
(16, 'piyumi', 'piyumi@gmail.com', '$2a$10$aRG67lTmnlPFlN7rSwTLROrShXGmy5aAtHEolLsUIuQs51V2KjNy.', '+940781234567', 'Female', 0, 1, '2023-05-14 09:14:26');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chefs`
--
ALTER TABLE `chefs`
  ADD PRIMARY KEY (`chef_id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`Comment_ID`),
  ADD KEY `Food_Fk` (`Food_ID`);

--
-- Indexes for table `foods`
--
ALTER TABLE `foods`
  ADD PRIMARY KEY (`Food_ID`);

--
-- Indexes for table `helpers`
--
ALTER TABLE `helpers`
  ADD PRIMARY KEY (`helper_id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`Role_ID`),
  ADD KEY `User_Fk` (`User_ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`User_ID`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chefs`
--
ALTER TABLE `chefs`
  MODIFY `chef_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `Comment_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `foods`
--
ALTER TABLE `foods`
  MODIFY `Food_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `helpers`
--
ALTER TABLE `helpers`
  MODIFY `helper_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `Role_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `User_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `Food_Fk` FOREIGN KEY (`Food_ID`) REFERENCES `foods` (`Food_ID`);

--
-- Constraints for table `roles`
--
ALTER TABLE `roles`
  ADD CONSTRAINT `User_Fk` FOREIGN KEY (`User_ID`) REFERENCES `users` (`User_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

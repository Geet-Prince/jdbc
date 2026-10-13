-- JDBC Learning - MySQL schema
-- Database: jdbcLearning
-- This file recreates the structure only (no data).
-- Run with: mysql -u root -p < schema.sql

CREATE DATABASE IF NOT EXISTS jdbcLearning
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci;

USE jdbcLearning;

DROP TABLE IF EXISTS `studentInfo`;

CREATE TABLE `studentInfo` (
  `id` INT NOT NULL,
  `sname` VARCHAR(40) NOT NULL,
  `sage` INT NOT NULL,
  `scity` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Example row used by firstJDBC_App (LaunchApp1.java):
-- INSERT INTO studentInfo (id, sname, sage, scity) VALUES (1, 'Prince', 21, 'Nalanda');

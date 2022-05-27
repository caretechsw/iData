# iData
iData is a web application based on Spring boot framework.
## Dependency
This application is using MYSQL as database and using Tomcat as HTTP web server.

## DataBase
The database is using MYSQL. For initializing the database, you can follow below query.

#### 1. create schema 'iData'
#### 2. create 3 tables from MYSQL initialisation query below

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `elder` (
  `id` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `bed_no` int(11) NOT NULL,
  `status_delete` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `temperature` (
  `dev_timestamp` varchar(100) NOT NULL,
  `elder_id` int(11) NOT NULL,
  `temperature` double NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `device_id` varchar(30) NOT NULL,
  `status_delete` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `temperature_abnormal` (
  `dev_timestamp` varchar(100) NOT NULL,
  `elder_id` int(11) NOT NULL,
  `temperature` double NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `device_id` varchar(30) NOT NULL,
  `status_delete` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `elder`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `temperature`
  ADD PRIMARY KEY (`dev_timestamp`);


ALTER TABLE `temperature_abnormal`
  ADD PRIMARY KEY (`dev_timestamp`);
COMMIT;

#### 3(optional) add testing elder
INSERT INTO `elder` (`id`, `name`, `bed_no`, `status_delete`) VALUES
(101, 'elder', 0, 1);


## About the Project
This applicaiton provides the web view and CRUD for the data synchronised with  [iData_Android](https://github.com/caretechsw/iData_android) android mobile application.

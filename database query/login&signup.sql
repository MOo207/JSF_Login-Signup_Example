-- drop database if exists `login&signup`;
create database if not exists `login&signup`;
use `login&signup`;
CREATE TABLE `users` (
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL
)
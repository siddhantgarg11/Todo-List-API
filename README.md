Assumptions:

1. Title can be duplicate.
2. Operation performed is valid.
3. Id of each To-do item is unique and not null.


Approach to code:

1.  I/O for all operations is in JASON format.
2. Database Entity is todo.
3. todo.myTodoList.dao.TodoDAOImp contains all business logic for Get, Post, Put and Delete.
4. todo.myTodoList.rest.TodoRestController contains all the mapping functions for the URL.
5. Database used is MySQL.
6. src/main/resources/application. properties contains data source URL.


Setup Script:

CREATE DATABASE  IF NOT EXISTS `mytodo`;
USE `mytodo`;
-- Table structure for table `employee`
DROP TABLE IF EXISTS `todo`;
CREATE TABLE `todo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `date` date,
  `priority` int(11),
  `state` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


Steps to run this application:

In Eclipse Ide import this project as an existing maven project.
Go on todo.myTodoList.MyTodoListApplication.java and run this file as java application.
Post operation URL: localhost:9090/api/                 Body required
Get operation URL: localhost:9090/api/                  Body required
Get operation for all data URl: localhost:9090/api/searchAll         No body required
Put Operation URl: localhost:9090/api/
Delete  Operation URl: localhost:9090/api/


Programming Language: Java
Frame works: Spring boot & Hibernate
Project Development tool: Maven
Ide: Eclipse
API Client: Postman





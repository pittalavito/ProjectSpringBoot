DROP DATABASE IF EXISTS SPRINGDB;
CREATE DATABASE SPRINGDB;
USE SPRINGDB;

CREATE TABLE JOBS(
    id integer primary key auto_increment,
    name varchar(30) not null
)Engine="InnoDB";

CREATE TABLE PERSON(
    id       integer      primary key auto_increment ,
    name     varchar(30)  not null,
    surname  varchar(30)  not null,
    job      integer      ,
    foreign key( job ) references jobs(id) on update cascade on delete set null
)Engine="InnoDB";

;INSERT INTO JOBS( name , id)
    VALUES
    ("mason" , 1),
    ("computer scientist" , 2),
    ("lawyer" , 3),
    ("doctor" , 4)
;

INSERT INTO PERSON (name ,surname, job)
    VALUES            
    ("mario"  , "rossi"   , 4),
    ("mario"   , "rossi"  , 1),
    ("salvo"  , "bianchi" , 2),
    ("andrea" , "verdi"   , 3),
    ("mara"   , "viola"   , 1),
    ("franca" ,"franchi"  , 2)
;



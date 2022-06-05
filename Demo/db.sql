DROP DATABASE IF EXISTS SPRINGDB;
CREATE DATABASE SPRINGDB;
USE SPRINGDB;

CREATE TABLE JOBS(
    id varchar(30) primary key 
)Engine="InnoDB";

CREATE TABLE PERSON(
    id       integer      primary key auto_increment ,
    name     varchar(30)  not null,
    surname  varchar(30)  not null,
    job      varchar(30)          ,
    foreign key( job ) references jobs(id) on update cascade on delete set null
)Engine="InnoDB";

;INSERT INTO JOBS( id )
    VALUES
    ("mason" ),
    ("computer scientist"),
    ("lawyer" ),
    ("doctor" )
;

INSERT INTO PERSON (name ,surname, job)
    VALUES            
    ("mario"  , "rossi"   , "mason"),
    ("mario"   , "rossi"  , "mason"),
    ("salvo"  , "bianchi" , "lawyer"),
    ("andrea" , "verdi"   , "doctor"),
    ("mara"   , "viola"   , "doctor"),
    ("franca" ,"franchi"  , "computer scientist")
;



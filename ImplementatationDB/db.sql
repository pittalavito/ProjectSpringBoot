DROP DATABASE IF EXISTS Be101L2;
CREATE DATABASE Be101L2;
USE Be101L2;

CREATE TABLE PERSON(
    id       varchar(36)  primary key default UUID(),
    name     varchar(30)  not null
)Engine="InnoDB";
   
INSERT INTO PERSON (name )
    VALUES            
    ("mario rossi"   ),
    ("salvo bianchi" ),
    ("andrea verdi"  ),
    ("mara viola"    ),
    ("franca franchi")
;
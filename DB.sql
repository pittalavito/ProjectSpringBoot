DROP DATABASE IF EXISTS SPRINGDB;
CREATE DATABASE SPRINGDB;
USE SPRINGDB;

CREATE TABLE JOBS(
    id      bigint(20)  primary key auto_increment ,
    name    varchar(36) unique not null
)Engine="InnoDB";

CREATE TABLE PERSON(
    id       bigint(20)   primary key auto_increment ,
    name     varchar(30)  not null,
    surname  varchar(30)  not null,
    id_job   bigint(20)         ,
    index idx_person_job(id_job)  , 
    -- avevo dimenticato l'importanza di questo parametro(quello sopra)
    -- in pratica dico a mysql di salvare "id_job" come indice da usare per velocizzare/ottimizzare
    -- la ricerca nel database evidentemente JPA lo richiedeva 
    foreign key( id_job ) references jobs(id) on update cascade on delete set null
)Engine="InnoDB";

;INSERT INTO JOBS( name , id)
    VALUES
    ("mason" , 1),
    ("computer scientist", 2),
    ("lawyer" , 3),
    ("doctor" , 4)
;

INSERT INTO PERSON (name ,surname, id_job)
    VALUES            
    ("mario"  , "rossi"   , 1),
    ("mario"   , "rossi"  , 1),
    ("salvo"  , "bianchi" , 2),
    ("andrea" , "verdi"   , 3),
    ("mara"   , "viola"   , 4),
    ("franca" ,"franchi"  , 3)
;



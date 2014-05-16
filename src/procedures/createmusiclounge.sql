Create database if not exists musiclounge 
Character set utf8
Collate utf8_general_ci;

Use musiclounge;

Create table if not exists person
(
idperson integer not null auto_increment,
name varchar (100),
vorname varchar(100),
titel varchar(100),
vorsatz varchar(100),
zusatz varchar(100),
geschlecht varchar(1),
gtag varchar(100),
gmonat varchar(100),
gjahr varchar(100),
ttag varchar(100),
tmonat varchar(100),
tjahr varchar(100),
Primary key (idperson)
);

create table if not exists Musiker
(
idmusiker integer not null auto_increment,
idperson integer null,
idgruppe integer(30) null,
pseudonym varchar(30) unique not null,
instrument varchar(30),
stuecksolo varchar(30),
referenz varchar(30),
Primary key (idmusiker),
foreign key (idperson) references person (idperson) on update cascade on delete cascade

);

create table if not exists gruppe
(
idgruppe integer not null auto_increment,
name varchar(30),
Mitglied nchar(255),
ehemalig nchar(255),
stueckgruppe varchar(30),
referenz varchar(30),
Primary Key (idgruppe)
);

ALTER TABLE `musiker` add foreign key (idgruppe) references gruppe (idgruppe) on update cascade on delete cascade;




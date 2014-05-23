Create database if not exists musiclounge 
Character set utf8
Collate utf8_general_ci;

Use musiclounge;

Create table if not exists person
(
idperson smallint not null auto_increment,
name varchar (100),
vorname varchar(100),
titel varchar(100),
vorsatz varchar(100),
zusatz varchar(100),
geschlecht ENUM ('m','f','ns'),
gtag varchar(100),
gmonat varchar(100),
gjahr varchar(100)not null,
ttag varchar(100),
tmonat varchar(100),
tjahr varchar(100),
primary key (idperson)
);

create table if not exists Musiker
(
idmusiker smallint not null auto_increment,
idperson smallint null,
pseudonym varchar(30),
instrument varchar(30),
stuecksolo varchar(30),
referenz varchar(30),
primary key (idmusiker),
foreign key (idperson) references person (idperson) on update cascade on delete cascade

);

create table if not exists gruppe
(
idgruppe smallint not null auto_increment,
name varchar(30),
stueckgruppe varchar(30),
referenz varchar(30),
primary key (idgruppe)


);

create table if not exists gruppehelp
(
idmusikerh smallint,
idgruppe smallint,
idehemalig smallint,

foreign key (idgruppe) 			references gruppe	 (idgruppe)

);



use musiclounge;

CREATE PROCEDURE DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `musikerErstellen` (musvorname varchar(100), musname varchar(100),
mustitel varchar(100), musvorsatz varchar(100), muszusatz varchar(100),
musgeschlecht varchar(1), musgtag varchar(100), musgmonat varchar(100), musgjahr varchar(100),
musttag varchar(100), mustmonat varchar(100), mustjahr varchar(100),
pseudonym varchar(100), instrument varchar(100), stuecksolo varchar(100),
referenz varchar(100), idperson integer)
BEGIN
declare idperson integer;
declare idmusiker integer;
insert into person (name, vorname, titel, vorsatz, zusatz,
geschlecht, gtag, gmonat, gjahr, ttag, tmonat, tjahr)
values (musname, musvorname, mustitel, musvorsatz, muszusatz,
musgeschlecht, musgtag, musgmonat, musgjahr, musttag, mustmonat, mustjahr);
select last_insert_id() into idperson;
insert into musiker (idperson, pseudonym, instrument, stuecksolo,
referenz, idmusiker)
values (idperson, pseudonym, instrument, stuecksolo,
referenz, idmusiker);

END$$
DELIMITER ;


/* Musiclounge DB anlegen mit Prozeduren und vorangelegten Interpreten*/

Create database if not exists musiclounge
Character set utf8
Collate utf8_general_ci;

Use musiclounge;

create table if not exists person
(
id_person int(11) not null auto_increment,
name varchar (100),
vorname varchar(100),
titel varchar(100),
vorsatz varchar(100),
zusatz varchar(100),
geschlecht ENUM ('m','f','ns'),
lebt ENUM ('j','n'),
gtag int(2),
gmonat int(2),
gjahr int(4),
ttag int(2),
tmonat int(2),
tjahr int(4),
primary key (id_person)
);


create table if not exists instrument
(
id_instrument int(11) not null auto_increment,
id_musiker int(11) NOT NULL,
instrument varchar(100),
primary key (id_instrument)


);

create table if not exists stuecksolo
(
id_stuecksolo int(11) not null auto_increment,
id_musiker int(11) NOT NULL,
stuecksolo varchar(100),
primary key (id_stuecksolo)

);

create table if not exists referenz
(
id_referenz int(11) not null auto_increment,
id_musiker int(11) NOT NULL,
referenz varchar(100),
primary key (id_referenz)


);

create table if not exists musiker
(
id_musiker int(11) not null auto_increment,
id_person int(11),
pseudonym varchar(100),
primary key (id_musiker),
foreign key (id_person) references person (id_person) on update cascade on delete cascade
);


create table if not exists gruppe
(
id_gruppe int(11) not null auto_increment,
grname varchar(100),
primary key (id_gruppe)
);

create table if not exists mitglied
(
id_mitglied int(11) not null auto_increment,
id_musiker int(11),
id_gruppe int(11),
aktiv ENUM('j','n'),
primary key (id_mitglied)

);Create database if not exists musiclounge
Character set utf8
Collate utf8_general_ci;

Use musiclounge;

create table if not exists person
(
id_person int(11) not null auto_increment,
name varchar (100),
vorname varchar(100),
titel varchar(100),
vorsatz varchar(100),
zusatz varchar(100),
geschlecht ENUM ('m','f','ns'),
lebt ENUM ('j','n'),
gtag int(2),
gmonat int(2),
gjahr int(4),
ttag int(2),
tmonat int(2),
tjahr int(4),
primary key (id_person)
);


create table if not exists instrument
(
id_instrument int(11) not null auto_increment,
id_musiker int(11),
instrument varchar(100),
primary key (id_instrument)


);

create table if not exists stuecksolo
(
id_stuecksolo int(11) not null auto_increment,
id_musiker int(11),
stuecksolo varchar(100),
primary key (id_stuecksolo)

);

create table if not exists referenz
(
id_referenz int(11) not null auto_increment,
id_musiker int(11),
referenz varchar(100),
primary key (id_referenz)


);

create table if not exists musiker
(
id_musiker int(11) not null auto_increment,
id_person int(11),
pseudonym varchar(100),
id_instrument int(11),
id_stuecksolo int(11),
id_referenz int(11),
primary key (id_musiker),
foreign key (id_person) references person (id_person) on update cascade on delete cascade
);


create table if not exists gruppe
(
id_gruppe int(11) not null auto_increment,
name varchar(100),
primary key (id_gruppe)

);

create table if not exists mitglied
(
id_mitglied int(11) not null auto_increment,
id_musiker int(11) NOT NULL,
id_gruppe int(11) NOT NULL,
aktiv ENUM('j','n'),
primary key (id_mitglied),
foreign key (id_musiker) references musiker (id_musiker) on update cascade on delete cascade
);

create table if not exists stueckgruppe
(
id_stueckgruppe int(11) not null auto_increment,
id_gruppe int(11),
stueckgruppe varchar(100),
primary key (id_stueckgruppe)
);

create table if not exists grreferenz
(
id_grreferenz int(11) not null auto_increment,
id_gruppe int(11),
grreferenz varchar(100),
primary key (id_grreferenz)
);

/* Prozeduren */

/* procedure : musikerErstellen */

CREATE PROCEDURE DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `musikerErstellen` (musvorname varchar(100), musname varchar(100),
mustitel varchar(100), musvorsatz varchar(100), muszusatz varchar(100),
musgeschlecht varchar(1),muslebt varchar(1), musgtag int(2), musgmonat int(2), musgjahr int(4),
musttag int(2), mustmonat int(2), mustjahr int(4),
pseudonym varchar(100), instrument varchar(100), stuecksolo varchar(100),
referenz varchar(100), id_person int(11), id_instrument int(11), id_referenz int(11), id_solostueck int(11))
BEGIN

declare id_musiker int;

/* Personen Tabelle fuellen */
insert into person (name, vorname, titel, vorsatz, zusatz,
geschlecht, lebt,  gtag, gmonat, gjahr, ttag, tmonat, tjahr)
values (musname, musvorname, mustitel, musvorsatz, muszusatz,
musgeschlecht, muslebt, musgtag, musgmonat, musgjahr, musttag, mustmonat, mustjahr);

/* Musiker Tabelle fuelen */
select last_insert_id() into id_person;
insert into musiker (id_musiker, id_person, pseudonym)
values (id_musiker, id_person, pseudonym);

/* Instrument eintragen */
select last_insert_id() into id_musiker;
insert into instrument (id_musiker, instrument )
values (id_musiker, instrument);

/* Solostueck eintragen */

insert into stuecksolo (id_musiker, stuecksolo )
values (id_musiker, stuecksolo);

/* Referenz eintragen */

insert into referenz (id_musiker, referenz)
values (id_musiker, referenz);


END$$
DELIMITER ;

/* procedure : gruppeErstellen */

use musiclounge;

CREATE PROCEDURE DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `gruppeErstellen` (grgrname varchar(100), 
id_grreferenz int(11), id_stueckgruppe int(11), grgrreferenz varchar(100), grstueckgruppe varchar(100),
id_musiker int(11), id_gruppe int(11), graktiv varchar(1))
BEGIN

declare id_mitglied int;


/* Gruppe Tabelle fuellen */
insert into gruppe (grname)
values (grgrname);

/* Mitglied Tabelle fuellen */
select last_insert_id() into id_gruppe;
insert into mitglied (id_mitglied, id_musiker, id_gruppe, aktiv)
values (id_mitglied, id_musiker, id_gruppe, graktiv);

/* grReferenz eintragen */
select id_gruppe from gruppe where grname = grgrname into id_gruppe;
insert into grreferenz (id_gruppe, grreferenz)
values (id_gruppe, grgrreferenz);

/* stueckgruppe eintragen */
select id_gruppe from gruppe where grname = grgrname into id_gruppe;
insert into stueckgruppe (id_gruppe, stueckgruppe)
values (id_gruppe, grstueckgruppe);


END$$
DELIMITER ;

/* procedure : musiker bearbeiten */

use musiclounge;

CREATE PROCEDURE DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `musikerBearbeiten` (musvorname varchar(100), musname varchar(100),
mustitel varchar(100), musvorsatz varchar(100), muszusatz varchar(100),
musgeschlecht varchar(1),muslebt varchar(1), musgtag int(2), musgmonat int(2), musgjahr int(4),
musttag int(2), mustmonat int(2), mustjahr int(4),
muspseudonym varchar(100), musinstrument varchar(100), musstuecksolo varchar(100),
musreferenz varchar(100), musid_person int(11),musid_musiker int(11), musid_instrument int(11), musid_referenz int(11), musid_solostueck int(11))

BEGIN



UPDATE person
SET
vorname = musvorname,
name = musname,
titel = mustitel,
vorsatz = musvorsatz,
zusatz = muszusatz,
geschlecht = musgeschlecht,
lebt = muslebt,
gtag = musgtag,
gmonat = musgmonat,
gjahr = musgjahr,
ttag = musttag,
tmonat = mustmonat,
tjahr = mustjahr
where person.id_person = musid_person;

UPDATE musiker
set 
pseudonym = muspseudonym
where musiker.id_person = musid_person;


update instrument
set instrument = musinstrument
where instrument.id_musiker = musid_musiker and instrument.id_instrument = musid_instrument;


update referenz
set referenz = musreferenz
where referenz.id_musiker = musid_musiker and referenz.id_referenz = musid_referenz;


update stuecksolo
set stuecksolo = musstuecksolo
where stuecksolo.id_musiker = musid_musiker and id_stuecksolo = musid_solostueck;

END$$
DELIMITER ;
/* procedure :musiker loeschen */

use musiclounge;

CREATE PROCEDURE DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `musikerLoeschen` (musid_musiker int(11), musid_person int(11))
BEGIN

/* Instrument loeschen */

DELETE FROM Instrument
WHERE id_musiker= musid_musiker;

/* Solostueck loeschen */
DELETE FROM stuecksolo
WHERE id_musiker= musid_musiker;

/* Referenz loeschen */
DELETE FROM referenz
WHERE id_musiker= musid_musiker;	
	
/* Personen Tabelle löschen */

DELETE FROM person
WHERE id_person = musid_person;

/* Musiker Tabelle wird automatisch mitgelöscht dank FK*/

END$$
DELIMITER ;

/* procedure :band bearbeiten */
use musiclounge;

CREATE PROCEDURE DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `gruppeBearbeiten` (grgrname varchar(100), 
id_grreferenz int(11), id_stueckgruppe int(11), grstueckgruppe varchar(100), grgrreferenz varchar(100),
id_musiker int(11), id_gruppe int(11), graktiv varchar(1))

BEGIN

declare musid_musiker int;	

UPDATE gruppe
SET
grname = grgrname
where gruppe.id_gruppe = id_gruppe;

UPDATE grreferenz
set 
grreferenz = grgrreferenz
where grreferenz.id_grgrreferenz = grgrreferenz;

update stueckgruppe
set stueckgruppe = grstueckgruppe
where stueckgruppe.id_stueckgruppe = id_stueckgruppe;

END$$
DELIMITER ;

/* procedure : band loeschen */

use musiclounge;

CREATE PROCEDURE DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `gruppeLoeschen` (grid_gruppe int(11))
BEGIN

/*gruppe*/

DELETE FROM gruppe
WHERE id_gruppe =  grid_gruppe;

/*mitglied loeschen*/

DELETE FROM mitglied
WHERE id_gruppe = grid_gruppe;
	

END$$
DELIMITER ;



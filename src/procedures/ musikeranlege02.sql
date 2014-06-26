use musiclounge;

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
select last_insert_id() into id_musiker;
insert into stuecksolo (id_musiker, stuecksolo )
values (id_musiker, stuecksolo);

/* Referenz eintragen */
select last_insert_id() into id_musiker;
insert into referenz (id_musiker, referenz)
values (id_musiker, referenz);


END$$
DELIMITER ;
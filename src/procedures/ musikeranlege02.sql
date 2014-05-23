/** Musiker anlegen *//
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

/** Gruppe anlegen *//
use musiclounge;

CREATE PROCEDURE DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `gruppeErstellen` (gridgruppe smallint, grname varchar(100),
grmitglied smallint, grehemalig smallint, grstueckgruppe varchar(100),
grreferenz varchar(100))
BEGIN
declare idgruppe smallint;
insert into gruppe (name,stueckgruppe, referenz)
values (grname, grstueckgruppe, grreferenz);
select last_insert_id() into idgruppe;
insert into gruppehelp (idmusikerh, idgruppe, idehemalig)
values (grmitglied, idgruppe, grehemalig);
END$$
DELIMITER ;
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

SELECT id_musiker from musiker where musiker.id_person = musid_person into musid_musiker;
update instrument
set instrument = musinstrument
where instrument.id_musiker = musid_musiker and instrument.id_instrument = musid_instrument;

update referenz
set referenz = musreferenz
where referenz.id_musiker = musid_musiker and referenz.id_referenz = musid_referenz;

update stuecksolo
set stuecksolo = musstuecksolo
where stuecksolo.id_musiker = musid_musiker and stuecksolo.id_stuecksolo = musid_solostueck;

END$$
DELIMITER ;
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
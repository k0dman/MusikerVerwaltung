use musiclounge;

CREATE PROCEDURE DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `bandBearbeiten` (grname varchar(100), 
id_grreferenz int(11), id_stueckgruppe int(11), grstueckgruppe varchar(100), grgrreferenz varchar(100),
id_musiker int(11), id_gruppe int(11), graktiv varchar(1))

BEGIN

declare musid_musiker int;	

UPDATE gruppe
SET
name = grname,
where gruppe.id_gruppe = id_gruppe;

UPDATE grreferenz
set 
grreferenz = grgrreferenz
where grreferenz.id_gruppe = id_gruppe;

update stueckgruppe
set stueckgruppe = grstueckgruppe
where stueckgruppe.id_gruppe = id_gruppe;

END$$
DELIMITER ;
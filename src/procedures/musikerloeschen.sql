use musiclounge;

CREATE PROCEDURE DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `musikerLoeschen` (musid_musiker int(11), musid_person int(11))
BEGIN



/* Instrument eintragen */

DELETE FROM Instrument
WHERE id_musiker= musid_musiker;

/* Solostueck eintragen */
DELETE FROM stuecksolo
WHERE id_musiker= musid_musiker;

/* Referenz eintragen */
DELETE FROM referenz
WHERE id_musiker= musid_musiker;	
	
/* Personen Tabelle l�schen */

DELETE FROM person
WHERE id_person = musid_person;

/* Musiker Tabelle wird automatisch mitgel�scht dank FK*/

END$$
DELIMITER ;
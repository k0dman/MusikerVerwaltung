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
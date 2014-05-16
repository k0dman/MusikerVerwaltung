DELIMITER $$
CREATE DEFINER=`maegapp`@`192.168.64.84` PROCEDURE `patientErstellen`(patVorname varchar(100), patNachname varchar(100),
patDob Date, patPatID varchar(10))
BEGIN
declare patPersID integer;
insert into person (vorname, nachname)
values (patVorname, patNachname);
select last_insert_id() into patPersID;
insert into patient (PersID, Dob, PatID)
values (patPersID, patDob, patPatID);

END$$
DELIMITER ;

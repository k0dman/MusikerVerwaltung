// Abfrage von K�nstlern sortier
SELECT idgruppe,idmusikerh as Mitglied, GROUP_CONCAT(idehemalig SEPARATOR ', ')
AS Ehemalige
FROM gruppehelp
GROUP BY idgruppe